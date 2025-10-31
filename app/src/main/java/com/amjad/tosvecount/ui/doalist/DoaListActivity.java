package com.amjad.tosvecount.ui.doalist;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.DoaCategory;
import com.amjad.tosvecount.model.Doa;
import com.amjad.tosvecount.utils.BaseActivity;
import com.amjad.tosvecount.utils.DoalistAdapter;
import com.amjad.tosvecount.utils.DoalistClickListener;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class DoaListActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private ArrayList<Doa> doalist;
    private DoalistAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa_list);

        Intent intent = getIntent();
        String categoryId = intent.getStringExtra("id");
        String categoryName = intent.getStringExtra("categoryName");

        setupToolbar(R.id.toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(categoryName);

        recyclerView =findViewById(R.id.recycler_View);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        doalist = new ArrayList<>();

        if (categoryId != null) {
            addDoaToTheRecyclerView(doalist, categoryId);
        } else {
            Log.e("DoaListActivity", "categoryId is null");
        }

        adapter = new DoalistAdapter(doalist, new DoalistClickListener() {
            @Override
            public void onDoaClick(DoaCategory doa) {
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void addDoaToTheRecyclerView(ArrayList<Doa> doalist, String categoryId) {

        ArrayList<Doa> allDoas = new ArrayList<>();

        allDoas.add(new Doa("1", "ঘুম থেকে জাগ্রতির দোয়া",
                "اَلْحَمْدُ لِلَّهِ الَّذِيْ أَحْيَانَا بَعْدَ مَا أَمَاتَنَا وَإِلَيْهِ النُّشُوْرُ",
                "উচ্চারণ: আলহামদু লিল্লাহিল্লাযি আহ্ইয়ানা বা’দা মা আমাতানা ওয়া ইলাইহিন্নুশূর।",
                "English: All praise is for Allah who gave us life after having caused us to die, and to Him is the resurrection."));

        allDoas.add(new Doa("1", "বাথরুমে প্রবেশের দোয়া",
                "اللَّهُمَّ إِنِّيْ أَعُوْذُ بِكَ مِنَ الْخُبُثِ وَالْخَبَائِثِ",
                "উচ্চারণ: আল্লাহুম্মা ইন্নি আউযুবিকা মিনাল খুবুছি ওয়াল খাবায়িস।",
                "English: O Allah, I seek refuge in You from male and female evil and wicked beings."));

        allDoas.add(new Doa("1", "বাথরুম থেকে বের হওয়ার দোয়া",
                "غُفْرَانَكَ",
                "উচ্চারণ: গুফরানাকা।",
                "English: I ask You (Allah) for Your forgiveness."));

        allDoas.add(new Doa("2", "ক্ষমা প্রার্থনার দোয়া",
                "رَبَّنَا ظَلَمْنَا أَنْفُسَنَا وَإِنْ لَمْ تَغْفِرْ لَنَا وَتَرْحَمْنَا لَنَكُونَنَّ مِنَ الْخَاسِرِينَ",
                "উচ্চারণ: রব্বানা যালামনা আনফুসানা, ওয়াইল্লাম তাগফির লানা, ওয়া তারহামনা, লানাকুনান্না মিনাল খাসিরীন।",
                "English: Our Lord, we have wronged ourselves, and if You do not forgive us and have mercy upon us, we will surely be among the losers."));

        allDoas.add(new Doa("2", "দুনিয়া ও আখিরাতের কল্যাণের দোয়া",
                "رَبَّنَا آتِنَا فِي الدُّنْيَا حَسَنَةً وَفِي الْآخِرَةِ حَسَنَةً وَقِنَا عَذَابَ النَّارِ",
                "উচ্চারণ: রব্বানা আতিনা ফিদ্দুনিয়া হাসানাহ, ওয়া ফিল আখিরাতি হাসানাহ, ওয়া ক্বিনা আজাবান্নার।",
                "English: Our Lord, give us good in this world and good in the Hereafter, and protect us from the punishment of the Fire."));

        allDoas.add(new Doa("2", "হৃদয়ের প্রশান্তির দোয়া",
                "رَبِّ اشْرَحْ لِي صَدْرِي وَيَسِّرْ لِي أَمْرِي",
                "উচ্চারণ: রব্বিশরাহলি সাদরি, ওয়াইассিরলি আমরি।",
                "English: My Lord, expand for me my chest [with assurance] and ease my task for me."));

        allDoas.add(new Doa("2", "গুনাহ মাফের দোয়া",
                "رَبَّنَا اغْفِرْ لَنَا ذُنُوبَنَا وَإِسْرَافَنَا فِي أَمْرِنَا وَثَبِّتْ أَقْدَامَنَا وَانْصُرْنَا عَلَى الْقَوْمِ الْكَافِرِينَ",
                "উচ্চারণ: রব্বানাগফির লানা যুবানানা ওয়া ইসরাফানা ফি আমরিনা, ওয়া সাব্বিত আকদামানা, ওয়া আনসুরনা আলাল কওমিল কাফিরিন।",
                "English: Our Lord, forgive us our sins and the excesses in our affairs, make firm our feet, and help us against the disbelieving people."));

        allDoas.add(new Doa("3", "ঘুমানোর আগে দোয়া",
                "بِاسْمِكَ اللَّهُمَّ أَمُوتُ وَأَحْيَاُ",
                "উচ্চারণ: বিসমিকা আল্লাহুম্মা আমুতু ওয়াহিয়া।",
                "English: In Your name, O Allah, I die and I live."));

        allDoas.add(new Doa("3", "সকালে ওঠার দোয়া",
                "اللَّهُمَّ بِصُبْحِكِ أَمُوتُ وَأَحْيَاُ",
                "উচ্চারণ: আল্লাহুম্মা বিউসুবহিকি আমুতি ওয়াহিয়া।",
                "English: O Allah, by Your morning, I die and I live."));

        allDoas.add(new Doa("3", "দুনিয়া ও আখিরাতের কল্যাণের দোয়া",
                "رَبَّنَا آتِنَا فِي الدُّنْيَا حَسَنَةً وَفِي الْآخِرَةِ حَسَنَةً وَقِنَا عَذَابَ النَّارُِ",
                "উচ্চারণ: রব্বানা আতিনা ফিদ্দুনিয়া হাসানাহ, ওয়া ফিল আখিরাতি হাসানাহ, ওয়া ক্বিনা আজাবান্নার।",
                "English: Our Lord, give us good in this world and good in the Hereafter, and save us from the punishment of the Fire."));

        allDoas.add(new Doa("4", "যে দোয়া রাসূল (সা.) সবসময় পড়তেন",
                "اللهم إني أعوذ بك من منكرات الأخلاق والأعمال والأهواء والأدواءُ",
                "উচ্চারণ: আল্লাহুম্মা ইনিই আউঝু বিইক মিন মুনকারাতিল আখলাক, ওয়াল আ’মাল, ওয়াল আহওয়া, ওয়াল আদ্বা।",
                "English: O Allah, I seek refuge in You from undesirable morals, deeds, desires, and diseases."));

        allDoas.add(new Doa("4", "দিনের শুরুতে বলার দোয়া",
                "اللهم بك أصبحنا وبك أمسينا وبك نحيا وبك نموت وإليك المصير",
                "উচ্চারণ: আল্লাহুম্মা বিকা আস্বাহনা, ওয়া বিকা আমসিনা, ওয়া বিকা নুহিয়া, ওয়া বিকা নামুতু, ইলাইকা আল-মাসীর।",
                "English: O Allah, by You we enter the morning and by You we enter the evening, by You we live and by You we die, and to You is our return."));

        allDoas.add(new Doa("4", "নতুন খাবার খাওয়ার সময় দোয়া",
                "اللَّهُمَّ أَطْعِمْنَا خَيْرًا مِنْهُ",
                "উচ্চারণ: আল্লাহুম্মা আতইমনা খাইরান মিনহু।",
                "English: O Allah, feed us with better than this."));

        allDoas.add(new Doa("5", "নামাজের জন্য প্রস্তুতির দোয়া",
                "اللهم اجعلني من الذين يقيمون الصلاة ويقيمونها في وقتها",
                "উচ্চারণ: আল্লাহুম্মা ইজ'আলনি মিনাল লাজীনা ইউকিমুনাল সালাতা ওয়াইকিমুনাহা ফি ওয়াক্তিহা।",
                "English: O Allah, make me among those who establish prayer and perform it on time."));

        allDoas.add(new Doa("5", "সালাতের পর দোয়া",
                "اللهم اغفر لي ولأهلي ولمن دخل بيتي مؤمنًا ولمن دخل بيتي مسلمًاْ",
                "উচ্চারণ: আল্লাহুম্মা ঘফির লি ওয়া লি আহলি, ওয়া লিমন দাখাল বিঈতি মুমিনান, ওয়া লিমন দাখাল বিঈতি মুসলিমান।",
                "English: O Allah, forgive me and my family, and whoever enters my house as a believer or a Muslim."));

        allDoas.add(new Doa("5", "আযানের সময় দোয়া",
                "اللهم رب هذه الدعوة التامة والصلاة القائمة آت محمدًا الوسيلة والفضيلة وابعثه مقامًا محمودًا الذي وعدته",
                "উচ্চারণ: আল্লাহুম্মা রাব্বা হাযিহি দাওয়াতিত তাম্মা ওয়াস সালাতিল কায়িমা, আত মুহাম্মাদাল ওয়াসীলাতা ওয়াল ফাযীলা, ওয়াব‘সুহু মাকামান মাহমুদান আল্লাজি ওয়াদত্তাহ।",
                "English: O Allah, Lord of this perfect call and established prayer, grant Muhammad the means and virtue and raise him to the praised position You promised."));

        allDoas.add(new Doa("6", "প্রার্থনা অবস্থা থেকে রক্ষা পাওয়ার জন্য দোয়া",
                "اللهم إني أعوذ بك من شر ما عملت ومن شر ما لم أعمل",
                "উচ্চারণ: আল্লাহুম্মা ইনি আউঝু বিকা মিন শর্রি মা আমিলতু, ওয়া মিন শররি মা লাম আ’মিল।",
                "English: O Allah, I seek refuge in You from the evil of what I have done and from the evil of what I have not done."));

        allDoas.add(new Doa("6", "আল্লাহর কাছে ক্ষমা প্রার্থনার দোয়া",
                "اللهم اغفر لي ما قدمت وما أخرت وما أسررت وما أعلنت وما أسرفت وما أنت أعلم به منيٍ",
                "উচ্চারণ: আল্লাহুম্মা ঘফির লি মা কাদামতু, ওয়া মা আখখিরতু, ওয়া মা আসরর্তু, ওয়া মা আ'লান্তু, ওয়া মা আসরাফতু, ওয়া আনতা আলাম্বি মিনী।",
                "English: O Allah, forgive me for what I did before, what I delay, what I hide, what I declare, what I exceed, and what only You know about me."));

        allDoas.add(new Doa("6", "রিজকের জন্য দোয়া",
                "اللهم إني أسالك رزقًا طيبًا وعلمًا نافعًا وعملاً متقبلًا",
                "উচ্চারণ: আল্লাহুম্মা ইনি আস’আলুকা রিযকান তৈয়িবান, ওয়ালিমান নাফিয়ান, ওয়া আমালান মুত্তাকাব্বালা।",
                "English: O Allah, I ask You for good sustenance, beneficial knowledge, and accepted deeds."));


        allDoas.add(new Doa("7", "আল্লাহর কাছে সাহায্য চাওয়ার দোয়া",
                "اللهم إني أسالك برحمتك التي وسعت كل شيء أن تغفر لي",
                "উচ্চারণ: আল্লাহুম্মা ইনি আস’আলুকা বিরাহমাতিকাল লাতি ওয়াস‘আত কুল্লা শেইয়িন, আন তাঘফির লি।",
                "English: O Allah, I ask You by Your mercy which encompasses everything, that You forgive me."));

        allDoas.add(new Doa("7", "ভালো রিজক চাওয়ার দোয়া",
                "اللهم إني أسالك رزقًا طيبًا وعلمًا نافعًا وعملاً متقبلًا",
                "উচ্চারণ: আল্লাহুম্মা ইনি আস’আলুকা রিযকান তৈয়িবান, ওয়ালিমান নাফিয়ান, ওয়া আমালান মুত্তাকাব্বালা।",
                "English: O Allah, I ask You for good provision, beneficial knowledge, and accepted deeds."));

        allDoas.add(new Doa("7", "বিপদ থেকে রক্ষা চাওয়ার দোয়া",
                "اللهم إني أعوذ بك من شر ما عملت ومن شر ما لم أعمل",
                "উচ্চারণ: আল্লাহুম্মা ইনি আউঝু বিকা মিন শররি মা আমিলতু, ওয়া মিন শররি মা লাম আ’মিল।",
                "English: O Allah, I seek refuge in You from the evil of what I have done and the evil of what I have not done."));

        allDoas.add(new Doa("8", "ইবাদত বা দান করার দোয়া",
                "اللهم تقبل منا، إنك أنت السميع العليم",
                "উচ্চারণ: আল্লাহুম্মা তকাব্বাল মিন্না, ইন্নাকা আনতা আস-সামীউ আলীম।",
                "English: O Allah, accept from us; indeed, You are the All-Hearing, All-Knowing."));

        allDoas.add(new Doa("8", "তাওবা (পাপের জন্য ক্ষমা চাওয়ার দোয়া)",
                "اللهم إني أتوب إليك من جميع الذنوب والخطايا، فأغفر لي يا أرحم الراحمين",
                "উচ্চারণ: আল্লাহুম্মা ইনি আতুবু ইলাইকা মিন জামিয়ি যিনূবি ওয়া খাতায়া, ফাগফির লি ইয়া আ’রহামার রাহিমিন।",
                "English: O Allah, I repent to You from all sins and mistakes, so forgive me, O Most Merciful of the merciful."));

        allDoas.add(new Doa("8", "দান করার দোয়া (যাকাত বা অন্য কোনো দানে)",
                "اللهم اجعل هذا المال في ميزان حسناتي، ولا تجعله حجة عليّ يوم القيامة",
                "উচ্চারণ: আল্লাহুম্মা ইজ'আল হাদাহাল মালা ফি মীযান হাসানাতি, ওয়ালা তাজ'আলহু হুজ্জাতাল আলাইয়া ইয়াওমাল কিয়ামাহ।",
                "English: O Allah, make this wealth a balance for my good deeds, and do not make it a proof against me on the Day of Judgment."));

        allDoas.add(new Doa("9", "কুরআনের শিক্ষা লাভের জন্য দোয়া",
                "اللهم اجعل القرآن العظيم ربيع قلبي، ونور صدري، وجلاء حزني، وذهاب همي",
                "উচ্চারণ: আল্লাহুম্মা ইজ’আলিল কুরআনাল আযিমা রাবি’আ কলবি, ওয়া নূর সাদরি, ওয়া জালা’য়া হুজনি, ওয়া জিহাবা হাম্মি।",
                "English: O Allah, make the Great Quran the spring of my heart, the light of my chest, the remover of my sadness, and the reliever of my anxiety."));

        allDoas.add(new Doa("9", "কুরআন বুঝার ও আমল করার দোয়া",
                "اللهم اجعلني من أهل القرآن الذين هم أهلك وخاصتك",
                "উচ্চারণ: আল্লাহুম্মা ইজ’আলনি মিন আহলিল কুরআন, আল্লাজীনা হুম আহলুকা ওয়া খাসাসুক।",
                "English: O Allah, make me among the people of the Quran, those who are Your people and Your special ones."));

        allDoas.add(new Doa("9", "কুরআনের মাধ্যমে অন্তরের নরম হওয়ার দোয়া",
                "اللهم اجعل القرآن شفاءً لصدورنا ورحمةً لقلوبنا",
                "উচ্চারণ: আল্লাহুম্মা ইজ’আলিল কুরআন শিফাউল লিসুদুরিনা, ওয়া রাহমাতাল লিকুলুবিনা।",
                "English: O Allah, make the Quran a healing for our hearts and mercy for our souls."));

        allDoas.add(new Doa("10", "হৃদয়ের পবিত্রতা ও শুদ্ধতার দোয়া",
                "اللهم آتِ نَفْسِي تَقْوَاهَا، وَزَكِّهَا أَنْتَ خَيْرُ مَنْ زَكَّاهَا، أَنْتَ وَلِيُّهَا وَمَوْلَاهَا",
                "উচ্চারণ: আল্লাহুম্মা আতি নাফসি তাকওয়াহা, ওয়াযাক্কিহা আন্তা খাইরু মান যাক্কাহা, আন্তা ওলিয়্যুহা ওয়া মাওলাহা।",
                "English: O Allah, grant my soul its piety, purify it; You are best to purify it, You are its Guardian and Protector."));

        allDoas.add(new Doa("10", "আল্লাহর স্মরণের মাধ্যমে হৃদয়কে প্রশান্ত করার দোয়া",
                "أَلَا بِذِكْرِ اللَّهِ تَطْمَئِنُّ الْقُلُوبُ",
                "উচ্চারণ: আলা বিজিকরিল্লাহি তাতমাইন্নুল কুলুব।",
                "English: Verily, hearts find peace in the remembrance of Allah."));

        allDoas.add(new Doa("10", "মন্দ চিন্তা ও হিংসা দূর করার দোয়া",
                "رَبِّ اشْرَحْ لِي صَدْرِي، وَيَسِّرْ لِي أَمْرِي",
                "উচ্চারণ: রাব্বিশরাহলি সাদরি, ওয়া ইয়াসসিরলি আমরি।",
                "English: My Lord, expand for me my chest and make my task easy for me."));

        allDoas.add(new Doa("10", "অহংকার ও কৃপণতা দূর করার দোয়া",
                "رَبِّ اشْرَحْ لِي صَدْرِي، وَيَسِّرْ لِي أَمْرِيا",
                "উচ্চারণ: আল্লাহুম্মা ইন্নি আউযুবিকা মিনাল কিবরি ওয়াল বুখলি ওয়াসূই আল খুলুকি।",
                "English: O Allah, I seek refuge in You from arrogance, miserliness, and bad character."));

        allDoas.add(new Doa("11", "সকল বিপদ ও অনিষ্ট থেকে রক্ষার দোয়া",
                "اللّهُ لاَ يُكَلِّفُ نَفْسًا إِلاَّ وُسْعَهَا…",
                "উচ্চারণ: আল্লাহু লা ইউকাল্লিফু নাফসান ইল্লা উসআহা...",
                "English: Allah does not burden a soul beyond that it can bear…"));

        allDoas.add(new Doa("11", "শয়তান ও দুষ্ট আত্মাদের থেকে রক্ষার দোয়া",
                "اللَّهُ لَا إِلَٰهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ…",
                "উচ্চারণ: আল্লাহু লা ইলাহা ইল্লা হুওয়াল হাইয়্যুল কাইয়্যুম...",
                "English: There is no deity except Him, the Ever-Living, the Sustainer…"));

        allDoas.add(new Doa("11", "ভয় ও বিপদের সময় পড়ার দোয়া",
                "حَسْبُنَا اللَّهُ وَنِعْمَ الْوَكِيلُ",
                "উচ্চারণ: হাসবুনাল্লাহু ওয়া নি’মাল ওয়াকিল।",
                "English: Allah is Sufficient for us, and He is the Best Disposer of affairs."));

        allDoas.add(new Doa("12", "রাসুলুল্লাহ (সা.) রাতে ঘুম থেকে উঠে এই দোয়া পড়তেন",
                "اللَّهُمَّ اجْعَلْ طَعَامَنَا طَيِّبًا وَرِزْقَنَا حَلَالًا",
                "উচ্চারণ: লা ইলাহা ইল্লাল্লাহু ওয়াহদাহু লা শারীকালাহু, লাহুল মুলকু ওয়ালাহুল হামদু, ওয়া হুয়া আলা কুল্লি শাই’ইন কাদির। আলহামদুলিল্লাহ, সুবহানাল্লাহ, লা ইলাহা ইল্লাল্লাহ, আল্লাহু আকবার, ওয়া লা হাউলা ওয়া লা কুয়্যাতা ইল্লা বিল্লাহ।",
                "English: O Allah, make our food pure and our provision lawful."));

        allDoas.add(new Doa("12", "তাহাজ্জুদের সময় রাসুল (সা.) এই দোয়া করতেন",
                "اللهم اغفر لي ذنبي كله، دقه وجله، وأوله وآخره، وعلانيته وسره",
                "উচ্চারণ: আল্লাহুম্মাগফির লি জুনুবি কুল্লাহু, দিক্কাহু ওয়া জিল্লাহু, ওয়া আওয়ালাহু ওয়া আখিরাহু, ওয়া আলানিয়াতাহু ওয়া সিররাহু।",
                "English: O Allah, forgive me all my sins, small and large, first and last, public and hidden."));

        allDoas.add(new Doa("12", "রাসুলুল্লাহ (সা.) রাতে ঘুমানোর আগে এই দোয়াগুলো পড়তেন",
                "اللَّهُمَّ بِاسْمِكَ أَمُوتُ وَأَحْيَا",
                "উচ্চারণ: আল্লাহুম্মা বিসমিকা আমুতু ওয়া আহইয়া।",
                "English: O Allah, in Your name I die and I live."));

        allDoas.add(new Doa("13", "রাসুলুল্লাহ (সা.) রাতে নামাজের সময় এই দোয়া পড়তেন",
                "اللَّهُمَّ لَكَ الحَمْدُ، أَنْتَ نُورُ السَّمَاوَاتِ وَالأَرْضِ وَمَنْ فِيهِنَّ، وَلَكَ الحَمْدُ، أَنْتَ قَيِّمُ السَّمَاوَاتِ وَالأَرْضِ وَمَنْ فِيهِنَّ...",
                "উচ্চারণ: আল্লাহুম্মা লাকাল হামদু, আনতা নূরুস সামাওয়াতি ওয়াল আরদি ওয়া মান ফিহিন্না, ওয়ালাকাল হামদু, আনতা কাইয়্যিমুস সামাওয়াতি ওয়াল আরদি ওয়া মান ফিহিন্না...",
                "English: O Allah, to You belongs all praise. You are the Light of the heavens and the earth and all within them."));

        allDoas.add(new Doa("13", "যখন রাতের শেষ তৃতীয়াংশে নামাজে দাঁড়াবে, তখন এই দোয়া করবে। কারণ, এই সময় আল্লাহ দোয়া কবুল করেন।",
                "اللَّهُمَّ إِنِّي أَسْأَلُكَ بِأَنَّ لَكَ الْحَمْدَ، لَا إِلٰهَ إِلَّا أَنْتَ وَحْدَكَ لَا شَرِيكَ لَكَ، الْمَنَّانُ، يَا بَدِيعَ السَّمَاوَاتِ وَالأَرْضِ، يَا ذَا الْجَلَالِ وَالإِكْرَامِ، يَا حَيُّ يَا قَيُّومُاللَّهُمَّ اجْعَلْ طَعَامَنَا طَيِّبًا وَرِزْقَنَا حَلَالًا",
                "উচ্চারণ: আল্লাহুম্মা ইন্নী আসআলুকা বি'আন্না লাকাল হামদ, লা ইলাহা ইল্লা আন্তা, ওয়াহ্দাকা লা শারীকালাক, আল মান্নান, ইয়া বাদীআস সামাওয়াতি ওয়াল আরদ, ইয়া জাল জালালী ওয়াল ইকরাম, ইয়া হাইয়ু ইয়া কাইয়্যুম!",
                "English: O Allah, I ask You, for to You belongs all praise, there is no deity except You alone, the Bestower, O Originator of the heavens and the earth, O Possessor of Majesty and Honor, O Ever-Living, O Sustainer. Make our food pure and our provision lawful."));

        allDoas.add(new Doa("13", "এই দোয়া রাসুল (সা.) তাহাজ্জুদ নামাজে পড়তেন",
                "رَبَّنَا ظَلَمْنَا أَنْفُسَنَا وَإِنْ لَمْ تَغْفِرْ لَنَا وَتَرْحَمْنَا لَنَكُونَنَّ مِنَ الْخَاسِرِينَ",
                "উচ্চারণ:রাব্বানা জ্বলামনা আনফুসানা, ওয়া ইল্লাম তাগফির লানা ওয়া তারহামনা লানাকুনান্না মিনাল খাসিরীন।",
                "English: Our Lord, we have wronged ourselves. If You do not forgive us and have mercy upon us, we will surely be among the losers."));

        allDoas.add(new Doa("15", "হজের নিয়ত করার সময় এই দোয়া পড়তে হয়",
                "اللَّهُمَّ إِنِّي أُرِيدُ الْحَجَّ فَيَسِّرْهُ لِي وَتَقَبَّلْهُ مِنِّي",
                "উচ্চারণ: আল্লাহুম্মা ইন্নী উরিদুল হাজ্জা, ফাইয়াসসিরহু লি, ওয়া তাক্বাব্বালহু মিন্নি।",
                "English: O Allah, I intend to perform Hajj. Make it easy for me and accept it from me."));

        allDoas.add(new Doa("15", "হজ ও উমরার সময় সবসময় এই দোয়া পড়তে হয়",
                "لَبَّيْكَ اللَّهُمَّ لَبَّيْكَ، لَبَّيْكَ لَا شَرِيكَ لَكَ لَبَّيْكَ، إِنَّ الْحَمْدَ وَالنِّعْمَةَ لَكَ وَالْمُلْكَ، لَا شَرِيكَ لَكَ",
                "উচ্চারণ:লাব্বাইকা আল্লাহুম্মা লাব্বাইক, লাব্বাইকা লা শারীকা লাকা লাব্বাইক, ইন্নাল হামদা ওয়ান্নি’মাতা লাকা ওয়াল মুলক, লা শারীকা লাক।",
                "English: Here I am, O Allah, here I am. Here I am, You have no partner. Indeed, all praise, blessings, and sovereignty are Yours."));

        allDoas.add(new Doa("15", "মক্কায় প্রবেশ করার সময় এই দোয়া পড়া উত্তম",
                "اللَّهُمَّ هَذَا حَرَمُكَ وَأَمْنُكَ فَحَرِّمْنِي عَلَى النَّارِ، وَآمِنِّي مِنْ عَذَابِكَ يَوْمَ تَبْعَثُ عِبَادَكَ",
                "উচ্চারণ: আল্লাহুম্মা হাযা হারামুকা ওয়া আমনুক, ফাহাররিম্নি আলান naar, ওয়া আমিননী মিন 'আযাবিকা ইয়াওমা তাব'আসু ইবাদাক।",
                "English: O Allah, this is Your sacred sanctuary and Your safety. Protect me from the Fire, and grant me safety from Your punishment on the Day You resurrect Your servants."));

        allDoas.add(new Doa("14", "খতাকবিরের (নামাজ শুরুর) পর দোয়া",
                "سُبْحَانَكَ اللَّهُمَّ وَبِحَمْدِكَ وَتَبَارَكَ اسْمُكَ وَتَعَالَى جَدُّكَ وَلَا إِلَهَ غَيْرُكَ",
                "উচ্চারণ: সুবহানাকা আল্লাহুম্মা ওয়া বিহামদিকা, ওয়া তাবারাকাসমুকা, ওয়া তা‘আলা জাদ্দুক, ওয়া লা ইলাহা গাইরুক।",
                "English: Glory is to You, O Allah, and praise; blessed is Your Name, exalted is Your majesty, and there is no deity besides You."));

        allDoas.add(new Doa("14", "রুকুতে পড়ার দোয়া",
                "سُبْحَانَ رَبِّيَ الْعَظِيمِا",
                "উচ্চারণ: সুবহানা রব্বিয়াল আজিম।",
                "English: Glory is to my Lord, the Almighty."));

        allDoas.add(new Doa("14", "রুকু ও সিজদার মাঝে দোয়া",
                "رَبِّ اغْفِرْ لِي، رَبِّ اغْفِرْ لِيا",
                "উচ্চারণ: রব্বিগফিরলী, রব্বিগফিরলী।",
                "English: My Lord, forgive me, my Lord, forgive me."));

        allDoas.add(new Doa("16", "সকালে ও সন্ধ্যায় পড়ার দোয়া",
                "اللَّهُمَّ إِنِّي أَسْأَلُكَ الْعَافِيَةَ فِي الدُّنْيَا وَالْآخِرَةِا",
                "উচ্চারণ: আল্লাহুম্মা ইন্নি আসআলুকাল আফিয়াতা ফিদ্দুনিয়া ওয়াল আখিরাহ।",
                "English: O Allah, I ask You for well-being in this world and in the Hereafter."));

        allDoas.add(new Doa("16", "দুশ্চিন্তা ও কষ্ট দূর করার দোয়া",
                "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْهَمِّ وَالْحَزَنِ وَأَعُوذُ بِكَ مِنَ الْعَجْزِ وَالْكَسَلِ، وَأَعُوذُ بِكَ مِنَ الْجُبْنِ وَالْبُخْلِ، وَأَعُوذُ بِكَ مِنْ غَلَبَةِ الدَّيْنِ وَقَهْرِ الرِّجَالِ",
                "উচ্চারণ: আল্লাহুম্মা ইন্নি আউযু বিকা মিনাল হাম্মি ওয়াল হাজান, ওয়া আউযু বিকা মিনাল আজজি ওয়াল কাসাল, ওয়া আউযু বিকা মিনাল জুবনি ওয়াল বুকল, ওয়া আউযু বিকা মিন গালাবাতিদ দায়নি ওয়া কাহরির রিজাল।",
                "English: O Allah, I seek refuge in You from worry and grief, from incapacity and laziness, from cowardice and miserliness, and from the burden of debts and oppression by men."));

        allDoas.add(new Doa("16", "ঘুমানোর আগে পড়ার দোয়া",
                "بِاسْمِكَ اللَّهُمَّ أَمُوتُ وَأَحْيَا",
                "উচ্চারণ: বিসমিকা আল্লাহুম্মা আমুতু ওয়া আহইয়া।",
                "English: O Allah, in Your name I die and I live."));

        allDoas.add(new Doa("17", "কঠিন কাজে সফলতার দোয়া",
                "اللَّهُمَّ لَا سَهْلَ إِلَّا مَا جَعَلْتَهُ سَهْلًا، وَأَنْتَ تَجْعَلُ الْحَزْنَ إِذَا شِئْتَ سَهْلًا",
                "উচ্চারণ: আল্লাহুম্মা লা সাহলা ইল্লা মা জাআলতাহু সহলা, ওয়া আনতা তাজআলুল হাজনা ইজা শিত্তা সহলা।",
                "English: O Allah, there is no ease except what You make easy, and You make the difficult, if You wish, easy."));

        allDoas.add(new Doa("17", "পরীক্ষায় ও চাকরিতে সফলতার দোয়া",
                "اللَّهُمَّ إِنِّي أَسْأَلُكَ مِنْ فَضْلِكَ",
                "উচ্চারণ:আল্লাহুম্মা ইন্নি আসআলুকা মিন ফাদলিক।",
                "English: O Allah, I ask You from Your bounty."));

        allDoas.add(new Doa("17", "মনোযোগ ও ধৈর্য বৃদ্ধির দোয়া",
                "رَبَّنَا أَفْرِغْ عَلَيْنَا صَبْرًا وَثَبِّتْ أَقْدَامَنَا وَانْصُرْنَا عَلَى الْقَوْمِ الْكَافِرِينَ",
                "উচ্চারণ: রব্বানা আফরিগ আলাইনা সাবরাও, ওয়াসসাবিত আকদামানা, ওয়ানসুরনা আলাল কওমিল কাফিরিন।",
                "English: Our Lord, pour upon us patience, make firm our feet, and give us victory over the disbelieving people."));

        allDoas.add(new Doa("18", "বিপদ থেকে বাঁচার দোয়া",
                "اللَّهُمَّ اكْفِنِيهِمْ بِمَا شِئْ",
                "উচ্চারণ: আল্লাহুম্মাকফিনিহিম বিমা শিতা",
                "English: O Allah, suffice me against them by whatever means You will."));


        for (Doa doa : allDoas) {
            if (doa.getCatId().equals(categoryId)) {
                doalist.add(doa);
            }
        }
    }


}