package com.amjad.tosvecount.ui.tasbih;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amjad.tosvecount.R;

import java.util.Locale;

public class TosveActivity extends AppCompatActivity {
    private TextView textView;
    private Button rbutton;
    private ImageView imageView,speakButton;
    private TextToSpeech textToSpeech;
    private MediaPlayer mediaPlayer;
    private int count = 0;
    private int phase = 0;

    private final String[] dhikrArray = {"Subhanallah", "Alhamdulillah", "Allahu Akbar"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tosve);

        textView = findViewById(R.id.textview);
        rbutton = findViewById(R.id.rbutton);
        speakButton = findViewById(R.id.image_view);
        imageView = findViewById(R.id.image_view);

        textToSpeech = new TextToSpeech(this, status -> {
            if (status != TextToSpeech.ERROR) {
                textToSpeech.setLanguage(Locale.ENGLISH);
            }
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.sound);

        imageView.setOnClickListener(view1 -> {
            playSound();
            updateCounter();
        });

        rbutton.setOnClickListener(view12 -> resetCounter());

        speakButton.setOnClickListener(view13 -> speakDhikr());

    }
    private void playSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    private void updateCounter() {
        count++;
        textView.setText(String.valueOf(count));

        if (count >= 99) {
            resetCounter();
        }
    }

    private void resetCounter() {
        count = 0;
        phase = 0;
        textView.setText("0");
    }

    private void speakDhikr() {
        if (textToSpeech != null) {
            textToSpeech.speak(dhikrArray[phase], TextToSpeech.QUEUE_FLUSH, null, null);
            count++;

            if (count % 33 == 0) {
                phase++;
            }

            if (phase >= dhikrArray.length) {
                resetCounter();
            }

            textView.setText(String.valueOf(count));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}