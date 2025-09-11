package com.amjad.tosvecount.ui.audio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.Audioquran;
import com.amjad.tosvecount.utils.AudioquranAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AudioFragment extends Fragment {

    RecyclerView recyclerView;
    List<Audioquran> audiolist;
    AudioquranAdapter adapter;


    public AudioFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_audio, container, false);


        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        audiolist = new ArrayList<>();
        adapter = new AudioquranAdapter(audiolist, getContext());
        recyclerView.setAdapter(adapter);

        loadDataFromFirebase();

//        recyclerView = view.findViewById(R.id.recycler_view);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
//        recyclerView.setLayoutManager(gridLayoutManager);

//        audiolist = new ArrayList<>();
//        audiolist.add(new Audioquran("https://www.teachers.gov.bd/shared/frontend/blogs/images/2021-08-20/iFJIwbBpuA82ftSSpw7HZritLKAdwgYTe5yJNsz3.jpeg","1.Al-Fatihah","The Opening - Meccan","37 seconds"));
//        audiolist.add(new Audioquran("https://www.teachers.gov.bd/shared/frontend/blogs/images/2021-08-20/iFJIwbBpuA82ftSSpw7HZritLKAdwgYTe5yJNsz3.jpeg","2.Al-Baqarah","The Cow - Madani","1 minutes 20 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","3.Ali 'Imran","The Family of 'Imran-Madani","53 minutes 20 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","4.An-Nisa","Women-Madani","54 minutes 35 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","5.Al-Ma'idah","The Spread Table - Meccan","41 minutes 24 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","6.Al-An'am","Cattle - Meccan","47 minutes 54 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","7.Al-A'raf","The Heights - Meccan","50 minutes 6 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","8.Al-Anfal","The Spoils fo War - Meccan","19 minutes 54 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","9.At-Tawbah","Repentance - Meccan","38 minutes 31 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","10.Yunus","Jonah - Meccan","30 minutes 31 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","11.Hud","Hud - Meccan","30 minutes 38 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","12.Yusuf","Joseph - Meccan","27 minutes 9 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","13.Ar-Ra'd","Thunder - Meccan","14 minutes 50 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","14.Ibrahim","Abraham - Meccan","13 minutes 26 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","15.Al-Hijr","TheStone Valley - Meccan","11 minutes 14 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","16.An-Nahi","Bees - Meccan","30 minutes 17 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","17.Al-Isra","The Night Journey - Meccan","24 minutes 36 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","18.Al-Kahf","The Cave - Meccan","24 minutes 26 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","19.Maryam","Mary - Meccan","17 minutes 4 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","20.Taha","Ta-Ha - Meccan","23 minutes 27 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","21.Al-Anbya","The prophets - Meccan","21 minutes 47 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","22.Al-Hajj","The Prophets - Meccan","22 minutes 18 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","23.Al-Mu'minun","The Believers - Meccan","16 minutes 24 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","24.An-Nur","The Light - Meccan","19 minutes 51 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","25.Al-Furqan","The Decisive Authority - Meccan","15 minutes 55 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","26.Ash-Shu'ara","The poets - Meccan","21 minutes 21 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","27.An-Naml","The Ants - Meccan","18 minutes 53 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","28.Al-Qasas","The Whole Story - Meccan","22 minutes 46 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","29.Al-'Ankabut","The Spider - Meccan","16 minutes 51 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","30.Ar-Rum","The Romans - Meccan","15 minutes 28 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","31.Luqman","Luqman - Meccan","9 minutes 41 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","32.As-Sajdah","The prostration - Meccan","6 minutes 25 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","33.Al-Ahzab","The Enemy Alliance - Meccan","21 minutes 23 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","34.Saba","Saba - Meccan","14 minutes 11 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","35.Fatir","The Originator - Meccan","13 minutes 55 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","36.Ya-Sin","Ya-sin - Meccan","12 minutes 44 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","37.As-Saffat","Those 'Angets'Lined up in Ranks - Meccan","16 minutes 44 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","38.Sad","Sad - Meccan","14 minutes 30 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","39.Az-Zumar","The Successive'Groups - Meccan","20 minutes 46 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","40.Ghafir","The Forgiver - Meccan","21 minutes 9 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","41.Fussilat","'Verses'perfectly Explained - Meccan","14 minutes 22 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","42.Ash-Shuraa","Consultation - Meccan","14 minutes 21seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","43.Az-Zukhruf","Ornaments - Meccan","14 minutes 52 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","44.Ad-Dukhan","The Haza - Meccan","5 minutes 59 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","45.Al-Jathiyah","The Kneeling - Meccan","9 minutes 3 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","46.Al-Ahqaf","The Sand-Hills - Meccan","11 minutes 11 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","47.Muhammad","Muhammad - Meccan","9 minutes 46 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","48.Al-Fath","The Triumph - Meccan","11 minutes 18 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","49.Al-Hujurat","The Private Quarters - Meccan","6 minutes 38 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","50.Qaf","Qaf - Meccan","7 minutes 27 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","51.Adh-Dhariyat","Scattering Winds - Meccan","7 minutes 42 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","52.At-Tur","Mount Tur - Madani","6 minutes 25 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","53.An-Najm","The Stars - Mecccan","7 minutes  13 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","54.Al-Qamar","The Mone -Madani","7 minutes 15 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","55.Ar-Rahman","The Most Compassionate - Meccan","8 minutes 47 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","56.Al-Waqi'ah","The Inevitable Event - Meccan","7 minutes 58 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","57.Al-Hadid","Iron - Meccan","10 minutes 21 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","58.Al-Mujadila","The pleading Woman - Meccan","8 minutes 58 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","59.Al-Hashr","The Banishment - Meccan","8 minutes 18 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","60.Al-Mumtahanah","The Test of Faith - Meccan","7 minutes 31 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","61.As-Saf","The 'solid'Ranks - Meccan","4 minutes 26 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","62.Al-Jumu'ah","Friday Congregation - Meccan","4 minutes 6 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","63.Al-Munafiqun","The Hypocrites - Meccan","3 minutes 33 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","64.At-Taghabun","Mutual Loss and Gain - Meccan","5 minutes 7 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","65.At-Talaq","Divorce - Meccan","5 minutes 25 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","66.At-Tahrim","the Prohivition - Meccan","6 minutes 6 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","67.Al-Mulk","All Authority - Meccan","6 minutes 33 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","68.Al-Qalam","The pen - Meccan","6 minutes 5 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","69.Al-Haqqah","The Inevitable Hour - Meccan","5 minutes 22 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","70.Al-Ma'arij","Pathways of Heavently'Ascent - Meccan","23 minutes 27 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","71.Nuh","Noah - Meccan","4 minutes 35 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","72.Al-Jnn","The Jinn - Meccan","4 minutes 47 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","73.Al-Muzzammil","The wrapped one - Meccan","4 minutes 1 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","74.Al-Muzzammil","The wrappd one - Meccan","4 minutes 1 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","75.Al-Qiyamah","The 'Rising for'Judgment - Meccan","3 minutes 54 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","76.Al-Insan","Humans - Meccan","5 minutes 2 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","77.Al-Mursalat","Those ;winds' sent forth - Meccan","4 minutes 28 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","78.An-Naba","The Momentous News - Meccan","3 minutes 52 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","79.An-Nazi'at","Those'Angels'stripping out 'souls' - Meccan","4 minutes 6 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","80.'Abasa","He Frowned - Meccan","4 minutes 31 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","81.At-Takwir","Putting out'the sun' - Meccan","2 minutes 42 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","82.Al-Infitar","The sty spllitting open - Meccan","6 minutes 25 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","83.Al-Mutaffifin","Defrauders - Meccan","3 minutes 41 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","84.Al-Inshiqaq","The 'sky'Bursting open - Meccan","2 minutes 53 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","85.Al-Buruj","Constellations - Meccan","2 minutes 52 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","86.At-Tariq","The Nightlly Star - Meccan","1 minutes 58 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","87.Al-A'la","The Most High- Meccan","16 minutes 44 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","88.Al-Ghashiyah","The Overwhelming Event - Meccan","2 minutes 21 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","89.Al-Fajr","Down - Meccan","3 minutes 13 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","90.Al-balad","The city - Meccan","1 minutes 59 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","91.Ash-Shams","The Sun - Meccan","1 minutes 48 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","92.Al-Layl","The Night - Meccan","2 minutes 7 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","93.Ad-Duhaa","The Morning Sunlight - Meccan","1 minutes 26 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","94.Ask-Sharh","Uplifting the Heart - Meccan","6 minutes 59 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","95.At-tin","The Fig - Meccan","1 minutes 11 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","96.Al-'Alq","The Clinging clot - Meccan","2 minutes 37 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","97.Al-Qadr","The Night of glory - Meccan","1 minutes 6 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","98.Al-Bayyinah","The clear proof - Meccan","2 minutes 17 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","99.Al-Zalzalah","The ultimate Quake - Meccan","1 minutes 2 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","100.Al-Adiyat","The Galloping Horses - Meccan","1 minutes 18 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","101.Al-qariah","The Striking disaster - Meccan","1 minutes 17 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","102.At-Takathur","Competition for More gains - Meccan","1 minutes 3 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","103.al-Asr","The passage of time - Meccan","2 minutes 48 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","104.Al-Humazah","The Backbiters - Meccan","1 minutes 6 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","105.Al-Fil","The Elephant - Meccan","1 minutes 10 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","106.Quraysh","The people of Quraysh - Meccan","1 minutes 5 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","107.Al-Kawthar","Addundant Goodness - Meccan","1 minutes 8 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","108.Al-Kawhtar","Adundant goodnessss - Meccan","1 minutes 27 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","109.Al-Kafirun","the Disbelievers - Meccan","1 minutes 4 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","110.An-Nasr","The ultimate help - Meccan","1 minutes 7 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","111.Al-Masad","The palm fibre Rope - Meccan","1 minutes 6 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","112.Al-Lkhlas","Purity of Faith - Meccan","7 minutes 27 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","113.Al-Falaq","The Daybreak - Meccan","58 seconds"));
//        audiolist.add(new Audioquran("https://img.freepik.com/premium-vector/islamic-ramadan-kareem-greeting-card_70264-409.jpg?semt=ais_hybrid","114.An-Nas","Humankind - Meccan","1 minutes 8 seconds"));

//        adapter = new AudioquranAdapter(audiolist, new AudioQuranClickListener() {
//            @Override
//            public void onSurahClick(Audioquran audioquran, int position) {
//                Intent intent = new Intent(getContext(), MusicplayerActivity.class);
//                intent.putExtra("name",audioquran.getNameItem());
//                intent.putExtra("dsc",audioquran.getDscItem());
//                intent.putExtra("time",audioquran.getTime());
//                intent.putExtra("position", position);
//                startActivity(intent);
//            }
//        });
//        recyclerView.setAdapter(adapter);

        return view;
    }

    private void loadDataFromFirebase() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("surahs");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                audiolist.clear();
                for (DataSnapshot snap : snapshot.getChildren()) {
                    Audioquran item = snap.getValue(Audioquran.class);
                    audiolist.add(item);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}

