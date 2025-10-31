package com.amjad.tosvecount.ui.prayerDetialsActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amjad.tosvecount.CardDetailActivity;
import com.amjad.tosvecount.R;
import com.google.android.material.appbar.MaterialToolbar;

public class PrayerdetialsActivity extends AppCompatActivity {

    private LinearLayout cardContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayerdetials);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        cardContainer = findViewById(R.id.card_container);
        TextView tvDetail = findViewById(R.id.tv_detail);

        String prayerName = getIntent().getStringExtra("PRAYER_NAME");
        toolbar.setTitle(prayerName);
        toolbar.setNavigationOnClickListener(v -> finish());

        showPrayerDetails(prayerName, tvDetail);
    }

    private void showPrayerDetails(String prayerName, TextView tvDetail) {
        cardContainer.removeAllViews();

        switch (prayerName) {
            case "Fajr":
                addCard("2 Rakaat Sunnah", "Emphasized (Mu'akkadah)");
                addCard("2 Rakaat Fard", "Mandatory (Fard)");
                tvDetail.setText("Fajr prayer is performed before sunrise");
                break;

            case "Dhuhr":
                addCard("4 Rakaat Sunnah", "Emphasized (Mu'akkadah)");
                addCard("4 Rakaat Fard", "Mandatory");
                addCard("2 Rakaat Sunnah", "Recommended");
                addCard("2 Rakaat Nafl", "Optional");
                tvDetail.setText("Dhuhr prayer is performed at noon when the sun is in the middle of the sky");
                break;

            case "Asr":
                addCard("4 Rakaat Sunnah", "Ghair Mu'akkadah");
                addCard("4 Rakaat Fard", "Mandatory");
                tvDetail.setText("Asr prayer is performed in the afternoon");
                break;

            case "Maghrib":
                addCard("3 Rakaat Fard", "Mandatory");
                addCard("2 Rakaat Sunnah", "Recommended");
                addCard("2 Rakaat Nafl", "Optional");
                tvDetail.setText("Maghrib prayer is performed after sunset");
                break;

            case "Isha":
                addCard("4 Rakaat Sunnah", "Ghair Mu'akkadah");
                addCard("4 Rakaat Fard", "Mandatory");
                addCard("2 Rakaat Sunnah", "Recommended");
                addCard("3 Rakaat Witr", "Wajib");
                addCard("2 Rakaat Nafl", "Optional");
                tvDetail.setText("Isha prayer is the night prayer, performed before going to bed");
                break;

            case "Wudu":
                addCard("Step 1", "To Decide");
                addCard("Step 2", "Wash Hands");
                addCard("Step 3", "Clean The Face");
                addCard("Step 4", "Watering the Nose");
                addCard("Step 5", "Wash the Face");
                addCard("Step 6", "Wash Hands");
                addCard("Step 7", "Massage the Head");
                addCard("Step 8", "Wash Feet");
                tvDetail.setText("Ablution is essential for purity before prayer");
                break;
        }
    }

    private void addCard(String title, String subtitle) {
        View view = getLayoutInflater().inflate(R.layout.item_prayer_card, cardContainer, false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        TextView tvSubtitle = view.findViewById(R.id.tv_subtitle);

        tvTitle.setText(title);
        tvSubtitle.setText(subtitle);

        view.setOnClickListener(v -> {
            Intent intent = new Intent(PrayerdetialsActivity.this, CardDetailActivity.class);
            intent.putExtra("TITLE", title);
            intent.putExtra("SUBTITLE", subtitle);
            startActivity(intent);
        });


        cardContainer.addView(view);
    }
}
