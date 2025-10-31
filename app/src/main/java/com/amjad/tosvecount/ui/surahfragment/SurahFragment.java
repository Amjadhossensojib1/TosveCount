package com.amjad.tosvecount.ui.surahfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.Surah;
import com.amjad.tosvecount.utils.SurahAdapter;

import java.util.ArrayList;

public class SurahFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Surah> surahlist;
    private SurahAdapter adapter;


    public SurahFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_surah, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        surahlist = new ArrayList<>();
        surahlist.add(new Surah("1","Al-Fatihah","The Opener","الفاتحة","7 Ayahs"));
        surahlist.add(new Surah("2","Al-Baqarah","The Cow","الفاتحة","286 Ayahs"));
        surahlist.add(new Surah("3","Ali 'Imran","Family of Imran","آلِ عِمْرَان","200 Ayahs"));
        surahlist.add(new Surah("4","An-Nisa","The Women","النساء","176 Ayahs"));
        surahlist.add(new Surah("5","Al-Maidah","The Table Spread","المائدة","120 Ayahs"));
        surahlist.add(new Surah("6","Al-An'am","The Cattle","الأنعام","165Ayahs"));
        surahlist.add(new Surah("7","Al-A'raf","The Heights","الأعراف","206 Ayahs"));
        surahlist.add(new Surah("8","Al-Anfal","The Spoils of War","الأنفال","75 Ayahs"));
        surahlist.add(new Surah("9","At-Tawbah","The Repentance","التوبة","129 Ayahs"));
        surahlist.add(new Surah("10","Yunus","Jonah","يونس","109 Ayahs"));
        surahlist.add(new Surah("11","Hud","Hud","هود","123 Ayahs"));
        surahlist.add(new Surah("12","Yusuf","Joseph","يوسف","111 Ayahs"));
        surahlist.add(new Surah("13","Ar-Ra'd","The Thunder","الرعد","43 Ayahs"));
        surahlist.add(new Surah("14","Ibrahim","Abraham","إبراهيم","52 Ayahs"));
        surahlist.add(new Surah("15","Al-Hijr","The Rocky Tract","الحجر","99 Ayahs"));
        surahlist.add(new Surah("16","An-Nahl","The Bee","النحل","128 Ayahs"));
        surahlist.add(new Surah("17","Al-Isra","The Night Journey","الإسراء","111 Ayahs"));
        surahlist.add(new Surah("18","Al-Kahf","The Cave","الكهف","110 Ayahs"));
        surahlist.add(new Surah("19","Maryam","Mary","مريم","98 Ayahs"));
        surahlist.add(new Surah("20","Ta-Ha","Ta-Ha","طه","135 Ayahs"));
        surahlist.add(new Surah("21","Al-Anbiya","The Prophets","الأنبياء","112 Ayahs"));
        surahlist.add(new Surah("22","Al-Hajj","The Pilgrimage","الحج","78 Ayahs"));
        surahlist.add(new Surah("23","Al-Mu’minun","The Believers","المؤمنون","118 Ayahs"));
        surahlist.add(new Surah("24","An-Nur","The Light","النور","64 Ayahs"));
        surahlist.add(new Surah("25","Al-Furqan","The Criterion","الفرقان","77 Ayahs"));
        surahlist.add(new Surah("26","Ash-Shu’ara","The Poets","الشعراء","227 Ayahs"));
        surahlist.add(new Surah("27","An-Naml","The Ant","النمل","93 Ayahs"));
        surahlist.add(new Surah("28","Al-Qasas","The Stories","القصص","88 Ayahs"));
        surahlist.add(new Surah("29","Al-Ankabut","The Spider","العنكبوت","69 Ayahs"));
        surahlist.add(new Surah("30","Ar-Rum","The Romans","الروم","60 Ayahs"));
        surahlist.add(new Surah("31","Luqman","Luqman","لقمان","34 Ayahs"));
        surahlist.add(new Surah("32","As-Sajda","The Prostration","السجدة","30 Ayahs"));
        surahlist.add(new Surah("33","Al-Ahzab","The Confederates","الأحزاب","73 Ayahs"));
        surahlist.add(new Surah("34","Saba","Sheba","سبإ","54 Ayahs"));
        surahlist.add(new Surah("35","Fatir","The Originator","فاطر","45 Ayahs"));
        surahlist.add(new Surah("36","Ya-Sin","Ya-Sin","يس","83 Ayahs"));
        surahlist.add(new Surah("37","As-Saffat","Those who set the Ranks","الصافات","182 Ayahs"));
        surahlist.add(new Surah("38","Sad","Sad","ص","88 Ayahs"));
        surahlist.add(new Surah("39","Az-Zumar","The Groups","الزمر","75 Ayahs"));
        surahlist.add(new Surah("40","Ghafir","The Forgiver","غافر","85 Ayahs"));
        surahlist.add(new Surah("41","Fussilat","Explained in Detail","فصلت","54 Ayahs"));
        surahlist.add(new Surah("42","Ash-Shura","Consultation","الشورى","53 Ayahs"));
        surahlist.add(new Surah("43","Az-Zukhruf","Gold Adornments","الزخرف","89 Ayahs"));
        surahlist.add(new Surah("44","Ad-Dukhan","The Smoke","الدخان","59 Ayahs"));
        surahlist.add(new Surah("45","Al-Jathiya","The Crouching","الجاثية","37 Ayahs"));
        surahlist.add(new Surah("46","Al-Ahqaf","The Wind-Curved Sandhills","الأحقاف","35 Ayahs"));
        surahlist.add(new Surah("47","Muhammad","Muhammad","محمد","38 Ayahs"));
        surahlist.add(new Surah("48","Al-Fath","The Victory","الفتح","29 Ayahs"));
        surahlist.add(new Surah("49","Al-Hujurat","The Rooms","الحجرات","18 Ayahs"));
        surahlist.add(new Surah("50","Qaf","Qaf","ق","45 Ayahs"));
        surahlist.add(new Surah("51","Adh-Dhariyat","The Winnowing Winds","الذاريات","60 Ayahs"));
        surahlist.add(new Surah("52","At-Tur","The Mount","الطور","49 Ayahs"));
        surahlist.add(new Surah("53","An-Najm","The Star","النجم","62 Ayahs"));
        surahlist.add(new Surah("54","Al-Qamar","The Moon","القمر","55 Ayahs"));
        surahlist.add(new Surah("55","Ar-Rahman","The Beneficent","الرحمن","78 Ayahs"));
        surahlist.add(new Surah("56","Al-Waqi’a","The Inevitable","الواقعة","96 Ayahs"));
        surahlist.add(new Surah("57","Al-Hadid","The Iron","الحديد","29 Ayahs"));
        surahlist.add(new Surah("58","Al-Mujadila","The Pleading Woman","المجادلة","22 Ayahs"));
        surahlist.add(new Surah("59","Al-Hashr","The Exile","الحشر","24 Ayahs"));
        surahlist.add(new Surah("60","Al-Mumtahina","The Woman to be Examined","الممتحنة","13 Ayahs"));
        surahlist.add(new Surah("61","As-Saff","The Ranks","الصف","14 Ayahs"));
        surahlist.add(new Surah("62","Al-Jumu’a","Friday","الجمعة","11 Ayahs"));
        surahlist.add(new Surah("63","Al-Munafiqun","The Hypocrites","المنافقون","11 Ayahs"));
        surahlist.add(new Surah("64","At-Taghabun","Mutual Disillusion","التغابن","18 Ayahs"));
        surahlist.add(new Surah("65","At-Talaq","Divorce","الطلاق","12 Ayahs"));
        surahlist.add(new Surah("66","At-Tahrim","The Prohibition","التحريم","12 Ayahs"));
        surahlist.add(new Surah("67","Al-Mulk","The Sovereignty","الملك","30 Ayahs"));
        surahlist.add(new Surah("68","Al-Qalam","The Pen","القلم","52 Ayahs"));
        surahlist.add(new Surah("69","Al-Haqqah","The Inevitable","الحاقة","52 Ayahs"));
        surahlist.add(new Surah("70","Al-Ma’arij","The Ascending Stairways","المعارج","44 Ayahs"));
        surahlist.add(new Surah("71","Nuh","Noah","نوح","28 Ayahs"));
        surahlist.add(new Surah("72","Al-Jinn","The Jinn","الجن","28 Ayahs"));
        surahlist.add(new Surah("73","Al-Muzzammil","The Enshrouded One","المزمل","20 Ayahs"));
        surahlist.add(new Surah("74","Al-Muddaththir","The Cloaked One","المدثر","56 Ayahs"));
        surahlist.add(new Surah("75","Al-Qiyamah","The Resurrection","القيامة","40 Ayahs"));
        surahlist.add(new Surah("76","Al-Insan","Man","الإنسان","31 Ayahs"));
        surahlist.add(new Surah("77","Al-Mursalat","The Emissaries","المرسلات","50 Ayahs"));
        surahlist.add(new Surah("78","An-Naba","The Tidings","النبأ","40 Ayahs"));
        surahlist.add(new Surah("79","An-Nazi’at","Those who drag forth","النازعات","46 Ayahs"));
        surahlist.add(new Surah("80","Abasa","He frowned","عبس","42 Ayahs"));
        surahlist.add(new Surah("81","At-Takwir","The Overthrowing","التكوير","29 Ayahs"));
        surahlist.add(new Surah("82","Al-Infitar","The Cleaving","الإنفطار","19 Ayahs"));
        surahlist.add(new Surah("83","Al-Mutaffifin","Defrauding","المطففين","36 Ayahs"));
        surahlist.add(new Surah("84","Al-Inshiqaq","The Splitting Open","الإنشقاق","25 Ayahs"));
        surahlist.add(new Surah("85","Al-Buruj","The Mansions of the Stars","البروج","22 Ayahs"));
        surahlist.add(new Surah("86","At-Tariq","The Morning Star","الطارق","17 Ayahs"));
        surahlist.add(new Surah("87","Al-A’la","The Most High","الأعلى","19 Ayahs"));
        surahlist.add(new Surah("88","Al-Ghashiyah","The Overwhelming","الغاشية","26 Ayahs"));
        surahlist.add(new Surah("89","Al-Fajr","The Dawn","الفجر","30 Ayahs"));
        surahlist.add(new Surah("90","Al-Balad","The City","البلد","20 Ayahs"));
        surahlist.add(new Surah("91","Ash-Shams","The Sun","الشمس","15 Ayahs"));
        surahlist.add(new Surah("92","Al-Layl","The Night","الليل","21 Ayahs"));
        surahlist.add(new Surah("93","Ad-Duhaa","The Morning Hours","الضحى","11 Ayahs"));
        surahlist.add(new Surah("94","Ash-Sharh","The Relief","الشرح","8 Ayahs"));
        surahlist.add(new Surah("95","At-Tin","The Fig","التين","8 Ayahs"));
        surahlist.add(new Surah("96","Al-‘Alaq","The Clot","العلق","19 Ayahs"));
        surahlist.add(new Surah("97","Al-Qadr","The Power","القدر","5 Ayahs"));
        surahlist.add(new Surah("98","Al-Bayyina","The Clear Proof","البينة","8 Ayahs"));
        surahlist.add(new Surah("99","Az-Zalzalah","The Earthquake","الزلزلة","8 Ayahs"));
        surahlist.add(new Surah("100","Al-‘Adiyat","The Courser","العاديات","11 Ayahs"));
        surahlist.add(new Surah("101","Al-Qari’ah","The Calamity","القارعة","11 Ayahs"));
        surahlist.add(new Surah("102","At-Takathur","Competition","التكاثر","8 Ayahs"));
        surahlist.add(new Surah("103","Al-‘Asr","The Declining Day","العصر","3 Ayahs"));
        surahlist.add(new Surah("104","Al-Humazah","The Traducer","الهمزة","9 Ayahs"));
        surahlist.add(new Surah("105","Al-Fil","The Elephant","الفيل","5 Ayahs"));
        surahlist.add(new Surah("106","Quraysh","Quraysh","قريش","4 Ayahs"));
        surahlist.add(new Surah("107","Al-Ma’un","Small Kindnesses","الماعون","7 Ayahs"));
        surahlist.add(new Surah("108","Al-Kawthar","Abundance","الكوثر","3 Ayahs"));
        surahlist.add(new Surah("109","Al-Kafirun","The Disbelievers","الكافرون","6 Ayahs"));
        surahlist.add(new Surah("110","An-Nasr","Divine Support","النصر","3 Ayahs"));
        surahlist.add(new Surah("111","Al-Masad","The Palm Fiber","المسد","5 Ayahs"));
        surahlist.add(new Surah("112","Al-Ikhlas","Sincerity","الإخلاص","4 Ayahs"));
        surahlist.add(new Surah("113","Al-Falaq","The Daybreak","الفلق","5 Ayahs"));
        surahlist.add(new Surah("114","An-Nas","Mankind","الناس","6 Ayahs"));

        adapter = new SurahAdapter(surahlist);
        recyclerView.setAdapter(adapter);

        return view;
    }
}