package com.amjad.tosvecount.ui.homefragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.ui.hadithActivity.HadithActivity;
import com.amjad.tosvecount.ui.qiblaActivity.QiblaActivity;
import com.amjad.tosvecount.ui.sunnahActivity.SunnahActivity;
import com.amjad.tosvecount.ui.tasbih.TosveActivity;
import com.google.android.material.navigation.NavigationView;

import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.HijrahDate;
import org.threeten.bp.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageButton menuButton;
    private CardView qubla, cvHadith, Sunnah, tosve;

    private CardView cardPrayer;
    private TextView tvPrayerName, tvTimeRange, tvRunning, tvRemaining, tvDate, tvHijriDate;
    private ProgressBar progressTime;
    private ImageView ivPrayerIcon;

    private Handler handler;
    private Runnable timeRunnable;

    private final String[][] prayerTimes = {
            {"Fajr", "04:42 AM", "05:56 AM"},
            {"Dhuhr", "11:44 AM", "03:51 PM"},
            {"Asr", "03:52 PM", "05:28 PM"},
            {"Maghrib", "05:30 PM", "06:43 PM"},
            {"Isha", "06:44 PM", "04:41 AM"}
    };

    private final SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());

    public HomeFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        drawerLayout = view.findViewById(R.id.drawerlayout);
        menuButton = view.findViewById(R.id.button_menu);
        navigationView = view.findViewById(R.id.navigation_view);

        qubla = view.findViewById(R.id.cv_qibla);
        cvHadith = view.findViewById(R.id.cv_hadith);
        Sunnah = view.findViewById(R.id.cv_duaitem);
        tosve = view.findViewById(R.id.cv_tosve);

        cardPrayer = view.findViewById(R.id.cardPrayer);
        tvPrayerName = view.findViewById(R.id.tv_prayer_name);
        tvTimeRange = view.findViewById(R.id.tv_time_range);
        tvRunning = view.findViewById(R.id.tv_running);
        tvRemaining = view.findViewById(R.id.tv_remaining);
        progressTime = view.findViewById(R.id.progress_time);
        ivPrayerIcon = view.findViewById(R.id.iv_prayer_icon);
        tvDate = view.findViewById(R.id.tv_date);
        tvHijriDate = view.findViewById(R.id.tv_hijri_date);

        menuButton.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));
        qubla.setOnClickListener(v -> startActivity(new Intent(getActivity(), QiblaActivity.class)));
        cvHadith.setOnClickListener(v -> startActivity(new Intent(getActivity(), HadithActivity.class)));
        Sunnah.setOnClickListener(v -> startActivity(new Intent(getActivity(), SunnahActivity.class)));
        tosve.setOnClickListener(v -> startActivity(new Intent(getActivity(), TosveActivity.class)));

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                Toast.makeText(getActivity(), "Home clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_share) {
                shareApp();
            } else if (id == R.id.nav_contact_us) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "support@example.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact from App");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            } else if (id == R.id.nav_change_language) {
                Toast.makeText(getActivity(), "Change Language clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_rate_us) {
                rateApp();
            } else if (id == R.id.nav_exit && getActivity() != null) {
                getActivity().finish();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        handler = new Handler();
        timeRunnable = new Runnable() {
            @Override
            public void run() {
                updateTimeAndDate();
                updatePrayerCard();
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(timeRunnable);

        return view;
    }

    private void updatePrayerCard() {
        String currentPrayer = null;
        String nextPrayer = null;
        Date start = null, end = null;
        Calendar now = Calendar.getInstance();
        String currentTimeStr = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(now.getTime());

        try {
            Date currentTime = timeFormat.parse(currentTimeStr);

            for (int i = 0; i < prayerTimes.length; i++) {
                String[] prayer = prayerTimes[i];
                Date startTime = timeFormat.parse(prayer[1]);
                Date endTime = timeFormat.parse(prayer[2]);

                if (prayer[0].equals("Isha")) {

                    if (currentTime.after(startTime) || currentTime.before(timeFormat.parse("04:41 AM"))) {
                        currentPrayer = "Isha";
                        nextPrayer = "Fajr";
                        start = startTime;
                        end = timeFormat.parse("04:41 AM");
                        break;
                    }
                } else if (currentTime.after(startTime) && currentTime.before(endTime)) {
                    currentPrayer = prayer[0];
                    start = startTime;
                    end = endTime;
                    nextPrayer = prayerTimes[i + 1][0];
                    break;
                }
            }

            if (currentPrayer == null) {
                currentPrayer = "Isha";
                nextPrayer = "Fajr";
                start = timeFormat.parse("06:44 PM");
                end = timeFormat.parse("04:41 AM");
            }

            tvPrayerName.setText(currentPrayer);
            tvTimeRange.setText(formatTime(start) + " - " + formatTime(end));
            tvRunning.setText("Ongoing");

            long total = getTimeDiffMillis(start, end);
            long passed = getTimeDiffMillis(start, currentTime);
            if (passed < 0) passed = 0;
            int progress = (int) ((passed * 100) / total);
            if (progress > 100) progress = 100;
            progressTime.setProgress(progress);

            long remainingMinutes = (total - passed) / (1000 * 60);
            tvRemaining.setText(remainingMinutes + " min left");

            ivPrayerIcon.setImageResource(
                    currentPrayer.equals("Fajr") ? R.drawable.sunrise_icon :
                            currentPrayer.equals("Dhuhr") ? R.drawable.sunny :
                                    currentPrayer.equals("Asr") ? R.drawable.asr_icon :
                                            currentPrayer.equals("Maghrib") ? R.drawable.maghrib :
                                                    R.drawable.small_sun
            );

            updateArcTimes(currentPrayer, nextPrayer);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private long getTimeDiffMillis(Date start, Date end) {
        long diff = end.getTime() - start.getTime();
        if (diff < 0) diff += 24 * 60 * 60 * 1000; // midnight fix
        return diff;
    }

    private void updateArcTimes(String currentPrayer, String nextPrayer) {
        TextView leftTime = requireView().findViewById(R.id.tv_left_time);
        TextView rightTime = requireView().findViewById(R.id.tv_right_time);

        String leftLabel = "", rightLabel = "";

        for (String[] prayer : prayerTimes) {
            if (prayer[0].equals(currentPrayer)) leftLabel = prayer[0] + " " + prayer[1];
            if (prayer[0].equals(nextPrayer)) rightLabel = prayer[0] + " " + prayer[1];
        }

        leftTime.setText(leftLabel);
        rightTime.setText(rightLabel);
    }

    private String formatTime(Date date) {
        return new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(date);
    }

    private void updateTimeAndDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault());
        tvDate.setText(dateFormat.format(calendar.getTime()));

        try {
            HijrahDate hijriDate = HijrahDate.from(LocalDate.now());
            DateTimeFormatter hijriFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
            tvHijriDate.setText("Hijri: " + hijriDate.format(hijriFormatter));
        } catch (Exception e) {
            tvHijriDate.setText("Hijri date not supported");
        }
    }

    private void shareApp() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Check out TosveCount");
        intent.putExtra(Intent.EXTRA_TEXT, "Download TosveCount from Play Store!");
        startActivity(Intent.createChooser(intent, "Share App via"));
    }

    private void rateApp() {
        Uri uri = Uri.parse("market://details?id=" + requireActivity().getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + requireActivity().getPackageName())));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (handler != null && timeRunnable != null) {
            handler.removeCallbacks(timeRunnable);
        }
    }
}
