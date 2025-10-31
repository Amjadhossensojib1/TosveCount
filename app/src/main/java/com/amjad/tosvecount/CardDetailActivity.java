package com.amjad.tosvecount;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.amjad.tosvecount.model.StepModel;
import com.amjad.tosvecount.utils.StepPagerAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class CardDetailActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private ViewPager2 viewPager;
    private StepPagerAdapter adapter;
    private List<StepModel> stepList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail);

        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewPager);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        // Get the title from intent
        String title = getIntent().getStringExtra("TITLE");
        toolbar.setTitle("Fajar: " + title);

        // Load steps based on title
        stepList = getStepsForTitle(title);

        // ✅ Initialize adapter with arrow click handling
        adapter = new StepPagerAdapter(stepList, new StepPagerAdapter.OnArrowClickListener() {
            @Override
            public void onNextClick(int position) {
                if (position < stepList.size() - 1) {
                    viewPager.setCurrentItem(position + 1, true);
                }
            }

            @Override
            public void onPrevClick(int position) {
                if (position > 0) {
                    viewPager.setCurrentItem(position - 1, true);
                }
            }
        });

        // ✅ Set adapter to ViewPager
        viewPager.setAdapter(adapter);
    }

    // ✅ Step data based on title
    private List<StepModel> getStepsForTitle(String title) {
        List<StepModel> steps = new ArrayList<>();

        if (title.equals("2 Rakaat Sunnah")) {
            steps.add(new StepModel(
                    R.drawable.namazimg,
                    "Takbeer",
                    "Raise your hands palms facing towards Kaaba, up till your thumbs touch ear lobes and say Allahu Akbar.",
                    "اللّٰهُ أَكْبَرُ"
            ));
            steps.add(new StepModel(
                    R.drawable.namazimg1,
                    "Qiyam",
                    "Stand straight and recite Surah Al-Fatiha followed by another Surah.",
                    "الْـحَمْدُ لِلّٰهِ رَبِّ الْعَالَمِينَ"
            ));
            steps.add(new StepModel(
                    R.drawable.namazimg2,
                    "Ruku",
                    "Bow down saying Subhana Rabbiyal Azeem.",
                    "سُبْحَانَ رَبِّيَ الْعَظِيمِ"
            ));
        } else if (title.equals("2 Rakaat Fard")) {
            steps.add(new StepModel(
                    R.drawable.namazimg,
                    "Takbeer",
                    "Begin the prayer with Takbeer by raising your hands and saying Allahu Akbar.",
                    "اللّٰهُ أَكْبَرُ"
            ));
            steps.add(new StepModel(
                    R.drawable.namazimg1,
                    "Sujood",
                    "Prostrate on the ground saying Subhana Rabbiyal A’la.",
                    "سُبْحَانَ رَبِّيَ الْأَعْلَى"
            ));
        } else {
            steps.add(new StepModel(
                    R.drawable.namazimg,
                    "General Step",
                    "This is a default prayer detail page.",
                    "اللّٰهُ أَكْبَرُ"
            ));
        }

        return steps;
    }
}
