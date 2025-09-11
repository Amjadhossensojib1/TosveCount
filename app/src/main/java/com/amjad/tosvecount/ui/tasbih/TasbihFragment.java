package com.amjad.tosvecount.ui.tasbih;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.amjad.tosvecount.R;
import java.util.Locale;

public class TasbihFragment extends Fragment {
    private TextView textView;
    private Button rbutton;
    private ImageView imageView,speakButton;
    private TextToSpeech textToSpeech;
    private MediaPlayer mediaPlayer;
    private int count = 0;
    private int phase = 0;

    private final String[] dhikrArray = {"Subhanallah", "Alhamdulillah", "Allahu Akbar"};

    public TasbihFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = requireActivity().getWindow();
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//            window.setStatusBarColor(android.graphics.Color.TRANSPARENT);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasbih, container, false);

        textView = view.findViewById(R.id.textview);
        rbutton = view.findViewById(R.id.rbutton);
        speakButton = view.findViewById(R.id.image_view);
        imageView = view.findViewById(R.id.image_view);

        textToSpeech = new TextToSpeech(getContext(), status -> {
            if (status != TextToSpeech.ERROR) {
                textToSpeech.setLanguage(Locale.ENGLISH);
            }
        });

        mediaPlayer = MediaPlayer.create(getContext(), R.raw.sound);

        imageView.setOnClickListener(view1 -> {
            playSound();
            updateCounter();
        });

        rbutton.setOnClickListener(view12 -> resetCounter());

        speakButton.setOnClickListener(view13 -> speakDhikr());

        return view;
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
