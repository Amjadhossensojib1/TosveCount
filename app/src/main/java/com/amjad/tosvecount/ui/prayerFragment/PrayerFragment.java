package com.amjad.tosvecount.ui.prayerFragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amjad.tosvecount.ui.prayerDetialsActivity.PrayerdetialsActivity;
import com.amjad.tosvecount.R;

public class PrayerFragment extends Fragment {

    private CardView cvFajr, cvDhuhr, cvAsr, cvMaghrib, cvIsha, cvWodu;

    public PrayerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prayer, container, false);

        // CardView references
        cvFajr = view.findViewById(R.id.cv_fajr);
        cvDhuhr = view.findViewById(R.id.cv_dhuhr);
        cvAsr = view.findViewById(R.id.cv_asr);
        cvMaghrib = view.findViewById(R.id.cv_maghrib);
        cvIsha = view.findViewById(R.id.cv_isha);
        cvWodu = view.findViewById(R.id.cv_wudu);

        // Click Listeners for each prayer
        cvFajr.setOnClickListener(v -> openPrayerDetails("Fajr"));
        cvDhuhr.setOnClickListener(v -> openPrayerDetails("Dhuhr"));
        cvAsr.setOnClickListener(v -> openPrayerDetails("Asr"));
        cvMaghrib.setOnClickListener(v -> openPrayerDetails("Maghrib"));
        cvIsha.setOnClickListener(v -> openPrayerDetails("Isha"));
        cvWodu.setOnClickListener(v -> openPrayerDetails("Wudu"));

        return view;
    }

    private void openPrayerDetails(String prayerName) {
        Intent intent = new Intent(getActivity(), PrayerdetialsActivity.class);
        intent.putExtra("PRAYER_NAME", prayerName); // send prayer name
        startActivity(intent);
    }
}
