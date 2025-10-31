package com.amjad.tosvecount.ui.hadithActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.Hadith;
import com.amjad.tosvecount.utils.HadithAdapter;

import java.util.ArrayList;

public class HadithActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Hadith> hadithList;
    private HadithAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadith);

        recyclerView =findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        hadithList = new ArrayList<>();
        hadithList.add(new Hadith(
                "الْمُسْلِمُ أَخُو الْمُسْلِمِ",
                "একজন মুসলিম অপর মুসলিমের ভাই।",
                "A Muslim is the brother of another Muslim.",
                "— সহীহ বুখারী"
        ));

        hadithList.add(new Hadith(
                "أَفْشُوا السَّلَامَ بَيْنَكُمْ",
                "তোমরা পরস্পরের মধ্যে সালাম প্রচার করো।",
                "Spread the greeting of peace among yourselves.",
                "— সহীহ মুসলিম"
        ));

        hadithList.add(new Hadith(
                "تَبَسُّمُكَ فِي وَجْهِ أَخِيكَ لَكَ صَدَقَةٌ",
                "তোমার ভাইয়ের সাথে হাসিমুখে সাক্ষাৎ করা সদকা।",
                "Your smile in the face of your brother is charity.",
                "— তিরমিযী"
        ));

        hadithList.add(new Hadith(
                "مَنْ كَانَ يُؤْمِنُ بِاللَّهِ وَالْيَوْمِ الْآخِرِ فَلَا يُؤْذِي جَارَهُ",
                "যে ব্যক্তি আল্লাহ ও আখেরাতের প্রতি ঈমান রাখে, সে যেন তার প্রতিবেশীকে কষ্ট না দেয়।",
                "Whoever believes in Allah and the Last Day should not harm his neighbor.",
                "— সহীহ বুখারী"
        ));

        hadithList.add(new Hadith(
                "الْإِثْمُ مَا حَاكَ فِي صَدْرِكَ وَكَرِهْتَ أَنْ يَطَّلِعَ عَلَيْهِ النَّاسُ",
                "পাপ হলো যা তোমার অন্তরে খচখচ সৃষ্টি করে এবং তুমি চাও না মানুষ তা জানুক।",
                "Sin is what troubles your soul and you dislike that people should come to know of it.",
                "— সহীহ মুসলিম"
        ));

        hadithList.add(new Hadith(
                "إِنَّ الرِّفْقَ لَا يَكُونُ فِي شَيْءٍ إِلَّا زَانَهُ",
                "যেখানে কোমলতা থাকে, সেখানে সৌন্দর্য আসে।",
                "Gentleness is not found in anything except that it beautifies it.",
                "— সহীহ মুসলিম"
        ));

        hadithList.add(new Hadith(
                "خَيْرُ النَّاسِ أَنْفَعُهُمْ لِلنَّاسِ",
                "সর্বশ্রেষ্ঠ মানুষ সে, যে মানুষের জন্য সবচেয়ে উপকারী।",
                "The best of people are those who are most beneficial to others.",
                "— সহীহ বুখারী"
        ));

        hadithList.add(new Hadith(
                "يَا مَعْشَرَ الشَّبَابِ مَنِ اسْتَطَاعَ مِنْكُمُ الْبَاءَةَ فَلْيَتَزَوَّجْ",
                "হে তরুণগণ! তোমাদের মধ্যে যার সামর্থ্য আছে, সে যেন বিবাহ করে।",
                "O young men! Whoever among you is able to marry, let him marry.",
                "— সহীহ বুখারী"
        ));

        hadithList.add(new Hadith(
                "لَيْسَ الْغِنَى عَنْ كَثْرَةِ الْعَرَضِ، وَلَكِنَّ الْغِنَى غِنَى النَّفْسِ",
                "ধন-সম্পদ বেশি থাকার নাম ধনী নয়, বরং ধনী হলো সে, যে আল্লাহ প্রদত্তে সন্তুষ্ট থাকে।",
                "Wealth is not in having many possessions, but true wealth is contentment of the soul.",
                "— সহীহ বুখারী"
        ));


        adapter = new HadithAdapter(hadithList);
        recyclerView.setAdapter(adapter);




    }
}