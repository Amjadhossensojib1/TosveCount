package com.amjad.tosvecount.ui.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.ui.dashboard.DashboardActivity;
import com.amjad.tosvecount.ui.main.MainActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {
                startActivity(new Intent(LauncherActivity.this, DashboardActivity.class));
                finish();
            }
        };
        handler.postDelayed(r, 1000);

    }
}