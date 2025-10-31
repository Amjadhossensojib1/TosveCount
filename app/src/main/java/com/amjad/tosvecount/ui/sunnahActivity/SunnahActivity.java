package com.amjad.tosvecount.ui.sunnahActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.Sunnah;
import com.amjad.tosvecount.model.Surah;
import com.amjad.tosvecount.utils.BaseActivity;
import com.amjad.tosvecount.utils.SunnahAdapter;
import com.amjad.tosvecount.utils.SurahAdapter;

import java.util.ArrayList;

public class SunnahActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private ArrayList<Sunnah> sunnahlist;
    private SunnahAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunnah);

        setupToolbar(R.id.material_toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        sunnahlist = new ArrayList<>();
        sunnahlist.add(new Sunnah("1","https://cdn-icons-png.flaticon.com/128/4815/4815757.png","prayer"));
        sunnahlist.add(new Sunnah("2","https://cdn-icons-png.flaticon.com/128/10324/10324895.png","Entering the mosque"));
        sunnahlist.add(new Sunnah("3","https://cdn-icons-png.flaticon.com/128/618/618966.png","Leaving the mosque"));
        sunnahlist.add(new Sunnah("4","https://cdn-icons-png.flaticon.com/128/7031/7031371.png","Toilet / Istinja"));
        sunnahlist.add(new Sunnah("5","https://cdn-icons-png.flaticon.com/128/2755/2755820.png","Ouzo"));
        sunnahlist.add(new Sunnah("6","https://cdn-icons-png.flaticon.com/128/5921/5921725.png","shower"));
        sunnahlist.add(new Sunnah("7","https://cdn-icons-png.flaticon.com/128/4269/4269356.png","Tayammum"));
        sunnahlist.add(new Sunnah("8","https://cdn-icons-png.flaticon.com/128/3696/3696764.png","To sleep"));
        sunnahlist.add(new Sunnah("9","https://cdn-icons-png.flaticon.com/128/2593/2593782.png","Wake up"));
        sunnahlist.add(new Sunnah("10","https://cdn-icons-png.flaticon.com/128/11264/11264363.png","Eat food"));
        sunnahlist.add(new Sunnah("11","https://cdn-icons-png.flaticon.com/128/1702/1702126.png","To drink"));
        sunnahlist.add(new Sunnah("12","https://cdn-icons-png.flaticon.com/128/4780/4780045.png","Sahri"));
        sunnahlist.add(new Sunnah("13","https://cdn-icons-png.flaticon.com/128/2918/2918221.png","Iftar"));
        sunnahlist.add(new Sunnah("14","https://cdn-icons-png.flaticon.com/128/4358/4358636.png","Ramadan"));
        sunnahlist.add(new Sunnah("15","https://cdn-icons-png.flaticon.com/128/7321/7321013.png","Sunnah and etiquette of Eid day"));
        sunnahlist.add(new Sunnah("16","https://cdn-icons-png.flaticon.com/128/15101/15101459.png","Mustahabb on Eid day"));
        sunnahlist.add(new Sunnah("17","https://cdn-icons-png.flaticon.com/128/4815/4815768.png","Sacrifice"));
        sunnahlist.add(new Sunnah("18","https://cdn-icons-png.flaticon.com/128/7321/7321039.png","Fasting etiquette"));
        sunnahlist.add(new Sunnah("19","https://cdn-icons-png.flaticon.com/128/6860/6860906.png","wearing clothes"));
        sunnahlist.add(new Sunnah("20","https://cdn-icons-png.flaticon.com/128/13972/13972408.png","Tour"));
        sunnahlist.add(new Sunnah("21","https://cdn-icons-png.flaticon.com/128/3074/3074284.png","Marriage"));
        sunnahlist.add(new Sunnah("22","https://cdn-icons-png.flaticon.com/128/5783/5783327.png","Time of Death"));
        sunnahlist.add(new Sunnah("23","https://cdn-icons-png.flaticon.com/128/8586/8586901.png","Friday"));
        sunnahlist.add(new Sunnah("24","https://cdn-icons-png.flaticon.com/128/5003/5003209.png","Prayer"));
        sunnahlist.add(new Sunnah("25","https://cdn-icons-png.flaticon.com/128/13542/13542533.png","Call to Prayer"));
        sunnahlist.add(new Sunnah("26","https://cdn-icons-png.flaticon.com/128/4358/4358993.png","Iqamat"));
        sunnahlist.add(new Sunnah("27","https://cdn-icons-png.flaticon.com/128/6770/6770573.png","Discussion"));
        sunnahlist.add(new Sunnah("28","https://cdn-icons-png.flaticon.com/128/15089/15089597.png","The natural birth of the prophets"));
        sunnahlist.add(new Sunnah("29","https://cdn-icons-png.flaticon.com/128/4527/4527685.png","Child's birth"));
        sunnahlist.add(new Sunnah("30","https://cdn-icons-png.flaticon.com/128/4643/4643711.png","Hair and Beard"));
        sunnahlist.add(new Sunnah("31","https://cdn-icons-png.flaticon.com/128/2163/2163350.png","Walk In"));
        sunnahlist.add(new Sunnah("32","https://cdn-icons-png.flaticon.com/128/619/619153.png","Get out of the loop"));


        adapter = new SunnahAdapter(sunnahlist);
        recyclerView.setAdapter(adapter);


    }
}