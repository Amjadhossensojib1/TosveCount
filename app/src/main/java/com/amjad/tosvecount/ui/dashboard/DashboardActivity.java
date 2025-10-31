package com.amjad.tosvecount.ui.dashboard;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.ui.surahfragment.SurahFragment;
import com.amjad.tosvecount.ui.audio.AudioFragment;
import com.amjad.tosvecount.ui.doa.DoaFragment;
import com.jakewharton.threetenabp.AndroidThreeTen;
import com.amjad.tosvecount.ui.homefragment.HomeFragment;
import com.amjad.tosvecount.ui.prayerFragment.PrayerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidThreeTen.init(this);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
    HomeFragment homeFragment = new HomeFragment();
    PrayerFragment tosveFragment = new PrayerFragment();
    AudioFragment audioFragment = new AudioFragment();
    DoaFragment doyaFragment = new DoaFragment();
    SurahFragment readqurnaFragment = new SurahFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home){
            loadFragment(homeFragment);
            return true;
        } if (id == R.id.tosve){
            loadFragment(tosveFragment);
            return true;
        }else if (id == R.id.audio) {
            loadFragment(audioFragment);
            return true;
        }else if (id == R.id.doya) {
            loadFragment(doyaFragment);
            return true;
        }else if (id == R.id.quran) {
            loadFragment(readqurnaFragment);
            return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit();
    }
}