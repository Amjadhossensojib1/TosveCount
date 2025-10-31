package com.amjad.tosvecount.ui.sunnahDetials;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.SunnahDetails;
import com.amjad.tosvecount.utils.SunnahDetailsAdapter;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class SunnahdetialsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SunnahDetailsAdapter adapter;
    ArrayList<SunnahDetails> detailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunnahdetials);

        String sunnahId = getIntent().getStringExtra("sunnah_id");
        String sunnahName = getIntent().getStringExtra("sunnah_name");

        // Toolbar সেট করা
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(sunnahName);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

        recyclerView = findViewById(R.id.recyclerViewDetails);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        detailsList = new ArrayList<>();
        loadDetails(sunnahName);

        adapter = new SunnahDetailsAdapter(detailsList);
        recyclerView.setAdapter(adapter);
    }

    private void loadDetails(String sunnahName) {
        switch (sunnahName) {
            case "prayer":
                detailsList.add(new SunnahDetails("নামাজের আগে", "অজু করে পবিত্র হওয়া।"));
                detailsList.add(new SunnahDetails("মসজিদে যাওয়া", "ডান পা দিয়ে প্রবেশ করা।"));
                detailsList.add(new SunnahDetails("সুন্নাত", "ফরজ নামাজের আগে ও পরে সুন্নাত আদায়।"));
                detailsList.add(new SunnahDetails("নামাজ চলাকালে", "খুশু খুযু সহকারে নামাজ আদায়।"));
                detailsList.add(new SunnahDetails("তিলাওয়াত", "কিরাত ধীরে ও সুন্দরভাবে পড়া।"));
                detailsList.add(new SunnahDetails("তাসবিহ", "সেজদায় সুবহানারাব্বিয়াল আ'লা বলা।"));
                detailsList.add(new SunnahDetails("নামাজ শেষে", "তাসবিহ, দোয়া ও ইস্তিগফার পড়া।"));
                detailsList.add(new SunnahDetails("মসজিদ থেকে বের হওয়ার সময়", "বের হওয়ার দোয়া পড়া।"));
                break;

            case "Entering the mosque":
                detailsList.add(new SunnahDetails("ডান পা আগে", "ডান পা দিয়ে প্রবেশ করা।"));
                detailsList.add(new SunnahDetails("দোয়া পড়া", "মসজিদে প্রবেশের দোয়া পড়া।"));
                detailsList.add(new SunnahDetails("তাহিয়্যাতুল মসজিদ", "দুই রাকাত নামাজ আদায় করা।"));
                detailsList.add(new SunnahDetails("শান্ত থাকা", "শব্দ ও কোলাহল থেকে বিরত থাকা।"));
                detailsList.add(new SunnahDetails("সালাম", "অন্য মুসল্লিদের সালাম দেওয়া।"));
                break;

            case "Leaving the mosque":
                detailsList.add(new SunnahDetails("বাম পা আগে", "বাম পা দিয়ে বের হওয়া।"));
                detailsList.add(new SunnahDetails("দোয়া পড়া", "বের হওয়ার দোয়া পড়া।"));
                detailsList.add(new SunnahDetails("সালাম", "মসজিদে থাকা মুসল্লিদের সালাম দিয়ে বের হওয়া।"));
                detailsList.add(new SunnahDetails("ধীরে হাঁটা", "শান্তভাবে বাইরে যাওয়া।"));
                break;

            case "Toilet / Istinja":
                detailsList.add(new SunnahDetails("প্রবেশের সময়", "বাম পা দিয়ে প্রবেশ করা।"));
                detailsList.add(new SunnahDetails("দোয়া", "টয়লেটে প্রবেশের দোয়া পড়া।"));
                detailsList.add(new SunnahDetails("ডান হাত ব্যবহার না করা", "ডান হাতে ইস্তিঞ্জা না করা।"));
                detailsList.add(new SunnahDetails("কিবলার দিকে না হওয়া", "প্রস্রাব/পায়খানার সময় কিবলার দিকে না বসা।"));
                detailsList.add(new SunnahDetails("বের হওয়ার সময়", "বের হওয়ার দোয়া পড়া।"));
                break;

            case "Ouzo":
                detailsList.add(new SunnahDetails("অজুর শুরু", "বিসমিল্লাহ পড়া।"));
                detailsList.add(new SunnahDetails("ডান দিক আগে", "ডান দিক থেকে শুরু করা।"));
                detailsList.add(new SunnahDetails("তিনবার ধোয়া", "প্রত্যেক অঙ্গ তিনবার ধোয়া।"));
                detailsList.add(new SunnahDetails("মিসওয়াক", "অজুর আগে দাঁত পরিষ্কার করা।"));
                detailsList.add(new SunnahDetails("অজুর পর", "শাহাদাত পড়া ও দোয়া করা।"));
                break;

            case "shower":
                detailsList.add(new SunnahDetails("নিয়ত করা", "গোসলের আগে নিয়ত করা।"));
                detailsList.add(new SunnahDetails("বিসমিল্লাহ", "শুরু করার সময় বিসমিল্লাহ পড়া।"));
                detailsList.add(new SunnahDetails("ডান দিক আগে", "ডান দিক থেকে পানি ঢালা।"));
                detailsList.add(new SunnahDetails("পুরো শরীর ধোয়া", "শরীরে পানি পৌঁছানো।"));
                detailsList.add(new SunnahDetails("অজু করা", "গোসলের মধ্যে অজু করা।"));
                break;

            case "Tayammum":
                detailsList.add(new SunnahDetails("নিয়ত করা", "তাহারতের নিয়ত করা।"));
                detailsList.add(new SunnahDetails("বিসমিল্লাহ", "শুরুতে বিসমিল্লাহ পড়া।"));
                detailsList.add(new SunnahDetails("পরিষ্কার মাটি", "পরিষ্কার মাটি বা ধূলায় হাত মারা।"));
                detailsList.add(new SunnahDetails("মুখ মুছা", "প্রথমে মুখ মুছা।"));
                detailsList.add(new SunnahDetails("হাত মুছা", "তারপর হাত মুছা।"));
                break;

            case "To sleep":
                detailsList.add(new SunnahDetails("ওজু করে ঘুমানো", "পবিত্র হয়ে ঘুমানো।"));
                detailsList.add(new SunnahDetails("ডান কাতে শোয়া", "ডান কাতে শুয়ে থাকা।"));
                detailsList.add(new SunnahDetails("আয়াতুল কুরসি পড়া", "ঘুমানোর আগে আয়াতুল কুরসি পড়া।"));
                detailsList.add(new SunnahDetails("তিন কুল পড়া", "কুল তিনটি পড়ে শরীরে ফুঁ দেয়া।"));
                detailsList.add(new SunnahDetails("দোয়া", "ঘুমানোর দোয়া পড়া।"));
                break;

            case "Wake up":
                detailsList.add(new SunnahDetails("আলহামদুলিল্লাহ পড়া", "জাগার পর দোয়া পড়া।"));
                detailsList.add(new SunnahDetails("চোখ মুছা", "ঘুম ভাঙার পর চোখ মুছা।"));
                detailsList.add(new SunnahDetails("মিসওয়াক করা", "দাঁত মাজার কাঠি ব্যবহার করা।"));
                detailsList.add(new SunnahDetails("অজু করা", "পবিত্র হওয়ার জন্য অজু করা।"));
                detailsList.add(new SunnahDetails("ফজর নামাজ", "সময় হলে ফজরের নামাজ আদায়।"));
                break;

            case "Eat food":
                detailsList.add(new SunnahDetails("বিসমিল্লাহ", "খাওয়ার আগে বিসমিল্লাহ বলা।"));
                detailsList.add(new SunnahDetails("ডান হাতে খাওয়া", "ডান হাতে খাবার খাওয়া।"));
                detailsList.add(new SunnahDetails("সামনের দিক থেকে খাওয়া", "নিজের সামনে থেকে খাওয়া।"));
                detailsList.add(new SunnahDetails("মধ্যমভাবে খাওয়া", "অতিরিক্ত না খাওয়া।"));
                detailsList.add(new SunnahDetails("হাত ধোয়া", "খাওয়ার আগে ও পরে হাত ধোয়া।"));
                detailsList.add(new SunnahDetails("আলহামদুলিল্লাহ", "খাওয়ার শেষে শুকরিয়া আদায়।"));
                break;

            case "To drink":
                detailsList.add(new SunnahDetails("বিসমিল্লাহ", "পানি খাওয়ার আগে বিসমিল্লাহ।"));
                detailsList.add(new SunnahDetails("বসে খাওয়া", "বসে পানি খাওয়া।"));
                detailsList.add(new SunnahDetails("তিনবারে খাওয়া", "তিনবারে পানি পান করা।"));
                detailsList.add(new SunnahDetails("ডান হাতে খাওয়া", "ডান হাতে পানি খাওয়া।"));
                detailsList.add(new SunnahDetails("আলহামদুলিল্লাহ", "শেষে শুকরিয়া আদায়।"));
                break;

            case "Sahri":
                detailsList.add(new SunnahDetails("দেরিতে খাওয়া", "ফজরের আগে শেষ সময়ে সাহরি খাওয়া।"));
                detailsList.add(new SunnahDetails("খেজুর খাওয়া", "সাহরিতে খেজুর খাওয়া।"));
                detailsList.add(new SunnahDetails("বিসমিল্লাহ", "খাওয়ার আগে বিসমিল্লাহ বলা।"));
                detailsList.add(new SunnahDetails("ডান হাতে খাওয়া", "ডান হাতে খাবার খাওয়া।"));
                break;

            case "Iftar":
                detailsList.add(new SunnahDetails("তাড়াতাড়ি করা", "আযান হওয়ার সাথে সাথে ইফতার করা।"));
                detailsList.add(new SunnahDetails("খেজুর", "খেজুর দিয়ে ইফতার শুরু করা।"));
                detailsList.add(new SunnahDetails("পানি", "পানি দিয়ে ইফতার করা।"));
                detailsList.add(new SunnahDetails("দোয়া", "ইফতারের দোয়া পড়া।"));
                break;

            case "Ramadan":
                detailsList.add(new SunnahDetails("তারাবিহ", "রাতের নামাজ পড়া।"));
                detailsList.add(new SunnahDetails("কুরআন তিলাওয়াত", "অধিক কুরআন পড়া।"));
                detailsList.add(new SunnahDetails("সদকা", "দান-খয়রাত বৃদ্ধি করা।"));
                detailsList.add(new SunnahDetails("ইতিকাফ", "শেষ দশকে ইতিকাফ করা।"));
                break;

            case "Friday":
                detailsList.add(new SunnahDetails("গোসল", "জুমার দিনে গোসল করা।"));
                detailsList.add(new SunnahDetails("সুরা কাহাফ", "সুরা কাহাফ তিলাওয়াত করা।"));
                detailsList.add(new SunnahDetails("সুগন্ধি", "সুগন্ধি ব্যবহার করা।"));
                detailsList.add(new SunnahDetails("জুমার দোয়া", "জুমার দিনে দোয়া কবুল হয়।"));
                detailsList.add(new SunnahDetails("দরুদ", "রাসূল ﷺ এর উপর দরুদ পাঠ করা।"));
                break;
            case "Sunnah and etiquette of Eid day":
                detailsList.add(new SunnahDetails("গোসল", "ঈদের নামাজের আগে গোসল করা।"));
                detailsList.add(new SunnahDetails("সুগন্ধি", "সুগন্ধি ব্যবহার করা।"));
                detailsList.add(new SunnahDetails("নতুন পোশাক", "পরিষ্কার বা নতুন পোশাক পরা।"));
                detailsList.add(new SunnahDetails("তাকবির", "ঈদের দিনে তাকবির পাঠ করা।"));
                detailsList.add(new SunnahDetails("ঈদের নামাজ", "ঈদের জামায়াতে নামাজ পড়া।"));
                detailsList.add(new SunnahDetails("ভিন্ন রাস্তা", "এক রাস্তা দিয়ে যাওয়া ও অন্য রাস্তা দিয়ে ফেরা।"));
                break;

            case "Mustahabb on Eid day":
                detailsList.add(new SunnahDetails("খেজুর খাওয়া", "ঈদের নামাজে যাওয়ার আগে বেজোড় খেজুর খাওয়া।"));
                detailsList.add(new SunnahDetails("তাকবির", "ঈদের দিনে তাকবির পাঠ করা।"));
                detailsList.add(new SunnahDetails("শুভেচ্ছা", "মুসলমানরা একে অপরকে ঈদের শুভেচ্ছা জানানো।"));
                detailsList.add(new SunnahDetails("দান", "গরিব-দুঃখীকে সাহায্য করা।"));
                break;

            case "Sacrifice":
                detailsList.add(new SunnahDetails("সুস্থ পশু", "কোরবানির জন্য সুস্থ পশু নির্বাচন করা।"));
                detailsList.add(new SunnahDetails("তীক্ষ্ণ ছুরি", "ছুরি ধারালো করা।"));
                detailsList.add(new SunnahDetails("কিবলার দিকে", "পশুকে কিবলামুখী করা।"));
                detailsList.add(new SunnahDetails("বিসমিল্লাহ বলা", "যবেহ করার সময় বিসমিল্লাহ আল্লাহু আকবর বলা।"));
                detailsList.add(new SunnahDetails("মাংস বণ্টন", "তিনভাগে ভাগ করা: পরিবার, আত্মীয়, গরিব।"));
                break;

            case "Fasting etiquette":
                detailsList.add(new SunnahDetails("সাহরি খাওয়া", "ফজরের আগে সাহরি করা।"));
                detailsList.add(new SunnahDetails("তাড়াতাড়ি ইফতার", "মাগরিব হলে দ্রুত ইফতার করা।"));
                detailsList.add(new SunnahDetails("অশ্লীলতা থেকে বাঁচা", "মিথ্যা, গীবত ও ঝগড়া থেকে বিরত থাকা।"));
                detailsList.add(new SunnahDetails("কুরআন পড়া", "অধিক কুরআন তিলাওয়াত করা।"));
                detailsList.add(new SunnahDetails("সদকা করা", "দান-খয়রাত বৃদ্ধি করা।"));
                break;

            case "wearing clothes":
                detailsList.add(new SunnahDetails("ডান হাত আগে", "ডান হাত দিয়ে পোশাক পরা।"));
                detailsList.add(new SunnahDetails("বিসমিল্লাহ", "পোশাক পরার সময় বিসমিল্লাহ বলা।"));
                detailsList.add(new SunnahDetails("দোয়া", "নতুন পোশাকের দোয়া পড়া।"));
                detailsList.add(new SunnahDetails("শালীন পোশাক", "শালীন ও পর্দা অনুযায়ী পোশাক পরা।"));
                detailsList.add(new SunnahDetails("কৃতজ্ঞতা", "আল্লাহর শুকরিয়া আদায় করা।"));
                break;

            case "Tour":
                detailsList.add(new SunnahDetails("নিয়ত করা", "ভ্রমণের আগে নিয়ত ঠিক করা।"));
                detailsList.add(new SunnahDetails("দোয়া পড়া", "ভ্রমণের দোয়া পড়া।"));
                detailsList.add(new SunnahDetails("আযান-ইকামত", "ভ্রমণে নামাজ পড়লে আযান ও ইকামত দেওয়া।"));
                detailsList.add(new SunnahDetails("সংক্ষেপ নামাজ", "ভ্রমণে নামাজ কসর করা।"));
                detailsList.add(new SunnahDetails("আল্লাহকে স্মরণ", "ভ্রমণের সময় যিকির করা।"));
                break;

            case "Marriage":
                detailsList.add(new SunnahDetails("নিকাহ", "নিকাহ শরীয়তসম্মতভাবে করা।"));
                detailsList.add(new SunnahDetails("খুতবা", "নিকাহের সময় খুতবা দেওয়া।"));
                detailsList.add(new SunnahDetails("মাহর", "স্ত্রীকে মাহর প্রদান করা।"));
                detailsList.add(new SunnahDetails("ওয়ালিমা", "বিয়ের পর ওয়ালিমা করা।"));
                break;

            case "Time of Death":
                detailsList.add(new SunnahDetails("ইন্না লিল্লাহ পড়া", "মৃত্যুর সংবাদ শোনার পর ইন্না লিল্লাহ বলা।"));
                detailsList.add(new SunnahDetails("শাহাদাত", "মৃত ব্যক্তিকে শাহাদাত পাঠ করানো।"));
                detailsList.add(new SunnahDetails("দোয়া", "তার জন্য মাগফিরাত কামনা করা।"));
                detailsList.add(new SunnahDetails("দাফন", "যথাশীঘ্র জানাযা ও দাফন করা।"));
                break;

            case "Call to Prayer":
                detailsList.add(new SunnahDetails("আযান", "সময়ে আযান দেওয়া।"));
                detailsList.add(new SunnahDetails("উচ্চস্বরে", "স্পষ্ট ও সুন্দর কণ্ঠে আযান দেওয়া।"));
                detailsList.add(new SunnahDetails("মুখ কিবলামুখী", "কিবলামুখী হয়ে আযান দেওয়া।"));
                detailsList.add(new SunnahDetails("শব্দ টেনে পড়া", "আযান সুন্দরভাবে টেনে দেওয়া।"));
                break;

            case "Iqamat":
                detailsList.add(new SunnahDetails("কিবলামুখী", "কিবলামুখী হয়ে ইকামত দেওয়া।"));
                detailsList.add(new SunnahDetails("দ্রুত বলা", "আযানের চেয়ে একটু দ্রুত বলা।"));
                detailsList.add(new SunnahDetails("ডান হাতে আঙুলে কান না দেওয়া", "ইকামতে আযানের মতো কান ধরা নেই।"));
                detailsList.add(new SunnahDetails("সোজা দাঁড়ানো", "ইকামতদাতা সোজা হয়ে দাঁড়ানো।"));
                break;

            case "Discussion":
                detailsList.add(new SunnahDetails("সৎ পরামর্শ", "সৎ কাজে উপদেশ দেওয়া।"));
                detailsList.add(new SunnahDetails("ভালো কথা", "ভালো কথা বলা।"));
                detailsList.add(new SunnahDetails("অশ্লীলতা এড়ানো", "অশ্লীল কথা থেকে বিরত থাকা।"));
                detailsList.add(new SunnahDetails("ধর্মীয় আলোচনা", "ইলমি আলোচনা করা।"));
                break;

            case "The natural birth of the prophets":
                detailsList.add(new SunnahDetails("আল্লাহর ইচ্ছা", "নবীদের জন্ম আল্লাহর বিশেষ কুদরতে।"));
                detailsList.add(new SunnahDetails("বিশুদ্ধ বংশ", "তাদের বংশ পবিত্র রাখা হয়েছে।"));
                detailsList.add(new SunnahDetails("শিশুকাল থেকে সুরক্ষা", "শিরক ও গুনাহ থেকে সুরক্ষা।"));
                break;

            case "Child's birth":
                detailsList.add(new SunnahDetails("আযান", "শিশুর কানে আযান দেওয়া।"));
                detailsList.add(new SunnahDetails("তাহনিক", "খেজুর দিয়ে শিশুর মুখে মিষ্টি লাগানো।"));
                detailsList.add(new SunnahDetails("আকিকা", "সপ্তম দিনে আকিকা করা।"));
                detailsList.add(new SunnahDetails("চুল কাটা", "সপ্তম দিনে মাথার চুল মুণ্ডন।"));
                detailsList.add(new SunnahDetails("সদকা", "চুলের ওজন অনুযায়ী সদকা দেওয়া।"));
                break;

            case "Hair and Beard":
                detailsList.add(new SunnahDetails("দাড়ি রাখা", "দাড়ি বড় রাখা।"));
                detailsList.add(new SunnahDetails("গোঁফ ছাঁটা", "গোঁফ ছোট করা।"));
                detailsList.add(new SunnahDetails("চুল আঁচড়ানো", "চুল আঁচড়ানো ও পরিষ্কার রাখা।"));
                detailsList.add(new SunnahDetails("তেল ব্যবহার", "চুলে তেল দেওয়া।"));
                break;

            case "Walk In":
                detailsList.add(new SunnahDetails("ডান পা আগে", "কোনো ঘরে ঢোকার সময় ডান পা আগে রাখা।"));
                detailsList.add(new SunnahDetails("বিসমিল্লাহ", "প্রবেশের সময় বিসমিল্লাহ বলা।"));
                detailsList.add(new SunnahDetails("সালাম দেওয়া", "ঘরে প্রবেশ করলে সালাম দেওয়া।"));
                break;

            case "Get out of the loop":
                detailsList.add(new SunnahDetails("বাম পা আগে", "ঘর থেকে বের হওয়ার সময় বাম পা আগে রাখা।"));
                detailsList.add(new SunnahDetails("দোয়া", "বের হওয়ার সময় দোয়া পড়া।"));
                detailsList.add(new SunnahDetails("সালাম", "ঘর থেকে বের হওয়ার সময় সালাম দেওয়া।"));
                break;

            default:
                detailsList.add(new SunnahDetails("Info", "এই ক্যাটাগরির বিস্তারিত এখনো যোগ হয়নি।"));
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}