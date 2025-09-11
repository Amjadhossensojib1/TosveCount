package com.amjad.tosvecount.ui.homefragment;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.amjad.tosvecount.ui.hadithActivity.HadithActivity;
import com.amjad.tosvecount.ui.qiblaActivity.QiblaActivity;
import com.amjad.tosvecount.R;
import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.HijrahDate;
import org.threeten.bp.format.DateTimeFormatter;

public class HomeFragment extends Fragment {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private ImageButton menuButton;

    private CardView qubla,cvHadith;

    private TextView tvTime, tvDate, tvHijriDate;
    private Handler handler;
    private Runnable timeRunnable;

    public HomeFragment() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        drawerLayout = view.findViewById(R.id.drawerlayout);
        menuButton = view.findViewById(R.id.button_menu);

        qubla = view.findViewById(R.id.cv_qibla);
        cvHadith = view.findViewById(R.id.cv_hadith);

        navigationView = view.findViewById(R.id.navigation_view);

        // Bind views
        tvTime = view.findViewById(R.id.tv_time);
        tvDate = view.findViewById(R.id.tv_date);
        tvHijriDate = view.findViewById(R.id.tv_hijri_date);


        // Start updating time every second
        handler = new Handler();
        timeRunnable = new Runnable() {
            @Override
            public void run() {
                updateTimeAndDate();
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(timeRunnable);

        qubla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), QiblaActivity.class);
                startActivity(intent);
            }
        });

        cvHadith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HadithActivity.class);
                startActivity(intent);
            }
        });
        menuButton.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));



        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                Toast.makeText(getActivity(), "Home clicked", Toast.LENGTH_SHORT).show();

            }else if (id == R.id.nav_share) {
                Toast.makeText(getActivity(), "Share clicked", Toast.LENGTH_SHORT).show();
                shareApp();

            } else if (id == R.id.nav_contact_us) {
                Toast.makeText(getActivity(), "Contact Us clicked", Toast.LENGTH_SHORT).show();

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "support@example.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact from App");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

            } else if (id == R.id.nav_change_language) {
                Toast.makeText(getActivity(), "Change Language clicked", Toast.LENGTH_SHORT).show();

            }else if (id == R.id.nav_rate_us) {
                Toast.makeText(getActivity(), "Rate clicked", Toast.LENGTH_SHORT).show();
                rateApp();

            } else if (id == R.id.nav_exit) {
                if (getActivity() != null) {
                    getActivity().finish();
                }
            } else {
                return false;
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });

        return view;
    }

    private void shareApp() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Check out Recipe Run");
        intent.putExtra(Intent.EXTRA_TEXT, "Download the app from Play Store now!");
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

    private void updateTimeAndDate() {
        Calendar calendar = Calendar.getInstance();

        // Time format
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a", Locale.getDefault());
        String currentTime = timeFormat.format(calendar.getTime());
        tvTime.setText(currentTime);

        // Date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(calendar.getTime());
        tvDate.setText(currentDate);

        // Hijri date format using ThreeTenBP
        try {
            HijrahDate hijriDate = HijrahDate.from(LocalDate.now());
            DateTimeFormatter hijriFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
            String hijriDateStr = hijriDate.format(hijriFormatter);
            tvHijriDate.setText("Hijri: " + hijriDateStr);
        } catch (Exception e) {
            tvHijriDate.setText("Hijri date not supported");
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
