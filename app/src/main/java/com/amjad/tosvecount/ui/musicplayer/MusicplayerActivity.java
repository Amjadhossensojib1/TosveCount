package com.amjad.tosvecount.ui.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amjad.tosvecount.R;
import com.google.android.material.appbar.MaterialToolbar;

public class MusicplayerActivity extends AppCompatActivity {

    private ImageView playButton;
    private TextView suraName, suraDsc, suraTime, currentPosition, audioLength;
    private MaterialToolbar toolbar;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Handler handler;
    private Runnable updateSeekBarRunnable;
    private boolean isPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicplayer);

        initViews();

        String name = getIntent().getStringExtra("name");
        String dsc = getIntent().getStringExtra("dsc");
        String time = getIntent().getStringExtra("time");
        String audioName = getIntent().getStringExtra("audioName");

        int rawResId = getResources().getIdentifier(audioName.toLowerCase().trim(), "raw", getPackageName());

        if (rawResId != 0) {
            loadMediaFromRaw(rawResId);
        } else {
            Toast.makeText(this, "Audio file not found " + audioName, Toast.LENGTH_LONG).show();
        }


        toolbar.setTitle(name);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> {
            releasePlayer();
            onBackPressed();
        });

        suraName.setText(name);
        suraDsc.setText(dsc);
        suraTime.setText(time);

        handler = new Handler();

        if (audioName != null && !audioName.trim().isEmpty()) {

            if (rawResId != 0) {
                loadMediaFromRaw(rawResId);
            } else {
                Toast.makeText(this, "Raw audio file not found " + audioName, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Audio file name not found", Toast.LENGTH_SHORT).show();
        }

        setupPlayButton();
        setupSeekBar();
    }

    private void initViews() {
        playButton = findViewById(R.id.playButton);
        suraName = findViewById(R.id.sura_name);
        suraDsc = findViewById(R.id.sura_dsc);
        suraTime = findViewById(R.id.sura_time);
        currentPosition = findViewById(R.id.current_position);
        audioLength = findViewById(R.id.audio_length);
        seekBar = findViewById(R.id.audio_seekbar);
        toolbar = findViewById(R.id.toolbar);
    }

    private void setupPlayButton() {
        playButton.setOnClickListener(v -> {
            if (mediaPlayer == null) return;

            if (isPlaying) {
                mediaPlayer.pause();
                playButton.setImageResource(R.drawable.ic_of);
            } else {
                mediaPlayer.start();
                playButton.setImageResource(R.drawable.ic_play);
                startSeekBarUpdater();
            }
            isPlaying = !isPlaying;
        });
    }

    private void setupSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && mediaPlayer != null) {
                    mediaPlayer.seekTo(progress);
                    currentPosition.setText(formatDuration(progress));
                }
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    isPlaying = false;
                    playButton.setImageResource(R.drawable.ic_of);
                }
            }

            @Override public void onStopTrackingTouch(SeekBar seekBar) {
                if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    isPlaying = true;
                    playButton.setImageResource(R.drawable.ic_play);
                    startSeekBarUpdater();
                }
            }
        });
    }

    private void loadMediaFromRaw(int rawResId) {
        releasePlayer();

        try {
            mediaPlayer = MediaPlayer.create(this, rawResId);
            if (mediaPlayer != null) {
                seekBar.setMax(mediaPlayer.getDuration());
                audioLength.setText(formatDuration(mediaPlayer.getDuration()));
                mediaPlayer.start();
                isPlaying = true;
                playButton.setImageResource(R.drawable.ic_play);
                startSeekBarUpdater();

                mediaPlayer.setOnCompletionListener(mp -> {
                    playButton.setImageResource(R.drawable.ic_of);
                    isPlaying = false;
                    seekBar.setProgress(0);
                    currentPosition.setText(formatDuration(0));
                });
            } else {
                Toast.makeText(this, "Unable to turn on audio", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {

        }
    }

    private void startSeekBarUpdater() {
        if (updateSeekBarRunnable != null) {
            handler.removeCallbacks(updateSeekBarRunnable);
        }

        updateSeekBarRunnable = new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    int current = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress(current);
                    currentPosition.setText(formatDuration(current));
                    handler.postDelayed(this, 500);
                }
            }
        };
        handler.post(updateSeekBarRunnable);
    }

    private String formatDuration(int millis) {
        int minutes = (millis / 1000) / 60;
        int seconds = (millis / 1000) % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    private void releasePlayer() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }

        if (handler != null && updateSeekBarRunnable != null) {
            handler.removeCallbacks(updateSeekBarRunnable);
            updateSeekBarRunnable = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasePlayer();
    }
}
