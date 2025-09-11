package com.amjad.tosvecount.ui.doa;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.DoaCategory;
import com.amjad.tosvecount.ui.doalist.DoaListActivity;
import com.amjad.tosvecount.utils.DoaAdapter;
import com.amjad.tosvecount.utils.DoaClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DoaFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<DoaCategory> doalist;
    private DoaAdapter adapter;
    private TextSwitcher textSwitcher;

    private Map<Integer, String[]> weeklyMessages = new HashMap<>();
    private int index = 0;
    private Handler handler = new Handler();
    private Runnable runnable;

    public DoaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doa, container, false);

        // TextSwitcher সেটআপ
        textSwitcher = view.findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(() -> {
            TextView textView = new TextView(requireContext());
            textView.setTextSize(20);
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.CENTER);
            textView.setLineSpacing(8f, 1.2f);
            textView.setTextDirection(TextView.TEXT_DIRECTION_ANY_RTL);
            return textView;
        });

        // সপ্তাহের দিন অনুযায়ী ১০টি করে দোয়া যোগ করা
        weeklyMessages.put(0, new String[]{ // রবিবার
                "﴿اللَّهُمَّ اهْدِنِي﴾\nহে আল্লাহ! আমাকে হেদায়েত দান করুন।",

                "﴿رَبِّ زِدْنِي عِلْمًا﴾\nহে আমার রব! আমাকে জ্ঞানে বৃদ্ধি দান করুন।",

                "﴿اللَّهُمَّ اغْفِرْ لِي﴾\nহে আল্লাহ! আমাকে ক্ষমা করুন।",

                "﴿رَبَّنَا لَا تُزِغْ قُلُوبَنَا﴾\nহে আমাদের পালনকর্তা! আমাদের হৃদয় বিচ্যুত করো না।",

                "﴿اللَّهُمَّ اجْعَلْنِي مِنَ التَّوَّابِينَ﴾\nহে আল্লাহ! আমাকে তওবাকারীদের মধ্যে রাখ।",

                "﴿رَبِّ أَسْأَلُكَ الْجَنَّةَ﴾\nহে আমার রব! আমি জান্নাত প্রার্থনা করি।",

                "﴿اللَّهُمَّ ارْزُقْنِي صَبْرًا﴾\nহে আল্লাহ! আমাকে ধৈর্য দান কর।",

                "﴿رَبِّ اغْفِرْ وَارْحَمْ﴾\nহে আমার রব! আমাকে ক্ষমা কর এবং দয়া কর।",

                "﴿اللَّهُمَّ إِنِّي أَسْأَلُكَ الْعَفْوَ﴾\nহে আল্লাহ! আমি তোমার ক্ষমা প্রার্থনা করি।",

                "﴿رَبِّ هَبْ لِي حُكْمًا﴾\nহে আমার রব! আমাকে বিচারবুদ্ধি দান কর।"


        });

        weeklyMessages.put(1, new String[]{ // সোমবার
                "﴿رَبِّ اغْفِرْ لِي وَلِوَالِدَيَّ﴾\nহে আমার রব! আমাকে ও আমার মা-বাবাকে ক্ষমা কর।",

                "﴿اللَّهُمَّ اغْفِرْ لِي ذُنُوبِي كُلَّهَا﴾\nহে আল্লাহ! আমার সব গুনাহ ক্ষমা কর।",

                "﴿رَبَّنَا ظَلَمْنَا أَنفُسَنَا﴾\nহে আমাদের পালনকর্তা! আমরা নিজেদের প্রতি অন্যায় করেছি।",

                "﴿رَبِّ أَعُوذُ بِكَ مِنْ هَمَزَاتِ الشَّيَاطِينِ﴾\nহে আমার রব! আমি তোমার কাছে শয়তানের ফিসফিস থেকে আশ্রয় চাই।",

                "﴿اللَّهُمَّ اغْفِرْ لِمَنْ أَسَاءَ إِلَيَّ﴾\nহে আল্লাহ! যিনি আমার প্রতি অন্যায় করেছেন তাকে ক্ষমা কর।",

                "﴿رَبِّ تَقَبَّلْ تَوْبَتِي﴾\nহে আমার রব! আমার তওবা কবুল কর।",

                "﴿اللَّهُمَّ اجْعَلْنِي مِنَ التَّوَّابِينَ وَاجْعَلْنِي مِنَ الْمُتَطَهِّرِينَ﴾\nহে আল্লাহ! আমাকে তওবাকারীদের ও পবিত্রদের মধ্যে রাখ।",

                "﴿اللَّهُمَّ اغْسِلْ خَطَايَايَ بِالثَّلْجِ وَالْمَاءِ وَالْبَرَدِ﴾\nহে আল্লাহ! আমার গুনাহ বরফ, পানি ও শীতল হাওয়া দিয়ে ধুয়ে নাও।",

                "﴿رَبِّ اجْعَلْنِي نَجِيًّا مِنَ النَّارِ﴾\nহে আমার রব! আমাকে আগুন থেকে রক্ষা কর।",

                "﴿اللَّهُمَّ لاَ تَحْرِمْنِي عَفْوَكَ وَرَحْمَتَكَ﴾\nহে আল্লাহ! আমাকে তোমার ক্ষমা ও রহমত থেকে বঞ্চিত করো না।"
        });

        weeklyMessages.put(2, new String[]{ // মঙ্গলবার
                "﴿رَبِّ ارْزُقْنِي رِزْقًا طَيِّبًا﴾\nহে আমার রব! আমাকে সুপাচ্য রিজিক দাও।",

                "﴿اللَّهُمَّ بَارِكْ لِي فِيمَا رَزَقْتَنِي﴾\nহে আল্লাহ! আপনি আমাকে যা দিয়েছেন তাতে বরকত দাও।",

                "﴿اللَّهُمَّ اكْفِنِي بِحَلَالِكَ عَنْ حَرَامِكَ﴾\nহে আল্লাহ! আপনার হালালের মাধ্যমে হারাম থেকে আমাকে রক্ষা কর।",

                "﴿رَبِّ اجْعَلْ لِي نَصِيبًا مِنَ الرِّزْقِ﴾\nহে আমার রব! আমাকে রিজিকের অংশ দাও।",

                "﴿اللَّهُمَّ اجْعَلْنِي غَنِيًّا بِفَضْلِكَ﴾\nহে আল্লাহ! আমাকে আপনার فضل দ্বারা ধনী কর।",

                "﴿رَبِّ أَسْأَلُكَ رِزْقًا وَاسِعًا﴾\nহে আমার রব! আমি তোমার কাছে বিস্তৃত রিজিক প্রার্থনা করছি।",

                "﴿اللَّهُمَّ اغْنِنِي مِنْ فَضْلِكَ﴾\nহে আল্লাহ! আমাকে আপনার অনুগ্রহে পরিপূর্ণ কর।",

                "﴿اللَّهُمَّ يَسِّرْ لِي أَمْرِي﴾\nহে আল্লাহ! আমার কাজ সহজ কর।",

                "﴿اللَّهُمَّ اجْعَلْ رِزْقِي بَرَكَةً﴾\nহে আল্লাহ! আমার রিজিক বরকতময় কর।",

                "﴿اللَّهُمَّ أَرْزُقْنِي مِنْ غَيْرِ حِسَابٍ﴾\nহে আল্লাহ! আমাকে অমিত রিজিক দাও।"
        });

        weeklyMessages.put(3, new String[]{ // বুধবার
                "﴿اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْبَرَصِ﴾\nহে আল্লাহ! আমি কুষ্ঠ রোগ থেকে তোমার কাছে আশ্রয় চাই।",

                "﴿اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْجُنُونِ﴾\nহে আল্লাহ! আমি পাগলামি থেকে তোমার কাছে আশ্রয় চাই।",

                "﴿اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْجُذَامِ﴾\nহে আল্লাহ! আমি সংক্রামক রোগ থেকে তোমার কাছে আশ্রয় চাই।",

                "﴿اللَّهُمَّ اشْفِنِي شِفَاءً لَا يُغَادِرُ سَقَمًا﴾\nহে আল্লাহ! আমাকে এমন রোগমুক্তি দাও যা আবার ফিরবে না।",

                "﴿اللَّهُمَّ عَافِنِي فِي بَدَنِي﴾\nহে আল্লাহ! আমার শরীরকে সুস্থ রাখ।",

                "﴿اللَّهُمَّ عَافِنِي فِي سَمْعِي﴾\nহে আল্লাহ! আমার শ্রবণ ক্ষমতাকে সুস্থ রাখ।",

                "﴿اللَّهُمَّ عَافِنِي فِي بَصَرِي﴾\nহে আল্লাহ! আমার দৃষ্টিশক্তি সুস্থ রাখ।",

                "﴿رَبِّ أَعُوذُ بِكَ مِنَ الْوَبَإِ﴾\nহে আমার রব! আমি মহামারি থেকে তোমার কাছে আশ্রয় চাই।",

                "﴿اللَّهُمَّ احْفَظْنِي مِنْ كُلِّ شَرٍّ﴾\nহে আল্লাহ! আমাকে সব খারাপ থেকে রক্ষা কর।",

                "﴿اللَّهُمَّ قِنِي شَرَّ الْفِتَنِ﴾\nহে আল্লাহ! আমাকে সব ফিতনা থেকে রক্ষা কর।"
        });

        weeklyMessages.put(4, new String[]{ // বৃহস্পতিবার
                "﴿اللَّهُمَّ اجْعَلْنِي مِنْ أَهْلِ الْجَنَّةِ﴾\nহে আল্লাহ! আমাকে জান্নাতবাসীর অন্তর্ভুক্ত কর।",

                "﴿رَبَّنَا آتِنَا فِي الدُّنْيَا حَسَنَةً﴾\nহে আমাদের পালনকর্তা! দুনিয়াতে আমাদের কল্যাণ দাও।",

                "﴿رَبَّنَا آتِنَا فِي الْآخِرَةِ حَسَنَةً﴾\nহে আমাদের পালনকর্তা! আখিরাতে আমাদের কল্যাণ দাও।",

                "﴿وَقِنَا عَذَابَ النَّارِ﴾\nআমাদেরকে আগুনের শাস্তি থেকে রক্ষা কর।",

                "﴿اللَّهُمَّ اجْعَلْ قَبْرِي رَوْضَةً مِنْ رِيَاضِ الْجَنَّةِ﴾\nহে আল্লাহ! আমার কবরকে জান্নাতের বাগানে পরিণত কর।",

                "﴿اللَّهُمَّ اجْمَعْنِي مَعَ أَحِبَّائِي فِي الْجَنَّةِ﴾\nহে আল্লাহ! আমাকে আমার প্রিয়জনদের সাথে জান্নাতে মিলিয়ে দাও।",

                "﴿اللَّهُمَّ أَدْخِلْنِي الْفِرْدَوْسَ الأَعْلَى﴾\nহে আল্লাহ! আমাকে সর্বোচ্চ জান্নাতে প্রবেশ করাও।",

                "﴿اللَّهُمَّ ثَبِّتْنِي عِنْدَ الْمَسْأَلَةِ﴾\nহে আল্লাহ! প্রশ্নের সময় আমাকে দৃঢ় রাখ।",

                "﴿اللَّهُمَّ يَسِّرْ لِي سَكَرَاتِ الْمَوْتِ﴾\nহে আল্লাহ! মৃত্যুর বেদনাগুলো সহজ কর।",

                "﴿اللَّهُمَّ اجْعَلْ آخِرَتِي خَيْرًا مِنْ دُنْيَايَ﴾\nহে আল্লাহ! আমার আখিরাত আমার দুনিয়ার চেয়ে উত্তম কর।"
        });

        weeklyMessages.put(5, new String[]{ // শুক্রবার
                "﴿اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْهَمِّ وَالْحَزَنِ﴾\nহে আল্লাহ! আমি দুশ্চিন্তা ও দুঃখ থেকে তোমার কাছে আশ্রয় চাই।",

                "﴿اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْعَجْزِ وَالْكَسَلِ﴾\nহে আল্লাহ! আমি অক্ষমতা ও অলসতা থেকে তোমার কাছে আশ্রয় চাই।",

                "﴿اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْجُبْنِ وَالْبُخْلِ﴾\nহে আল্লাহ! আমি কাপুরুষতা ও কৃপণতা থেকে তোমার কাছে আশ্রয় চাই।",

                "﴿اللَّهُمَّ اجْعَلْ لِي مِنْ كُلِّ هَمٍّ فَرَجًا﴾\nহে আল্লাহ! প্রতিটি দুশ্চিন্তা থেকে আমাকে মুক্তি দাও।",

                "﴿اللَّهُمَّ فَرِّجْ كُرْبِي﴾\nহে আল্লাহ! আমার কষ্ট দূর কর।",

                "﴿اللَّهُمَّ يَسِّرْ أَمْرِي﴾\nহে আল্লাহ! আমার কাজ সহজ কর।",

                "﴿اللَّهُمَّ اجْعَلْ قَلْبِي مُطْمَئِنًّا﴾\nহে আল্লাহ! আমার অন্তর শান্ত কর।",

                "﴿اللَّهُمَّ بَدِّدْ حُزْنِي﴾\nহে আল্লাহ! আমার দুঃখ দূর কর।",

                "﴿اللَّهُمَّ اجْعَلْ لِي مِنْ كُلِّ ضِيقٍ مَخْرَجًا﴾\nহে আল্লাহ! প্রতিটি সংকট থেকে আমাকে উদ্ধার কর।",

                "﴿اللَّهُمَّ ارْزُقْنِي الصَّبْرَ﴾\nহে আল্লাহ! আমাকে ধৈর্য দান কর।"
        });

        weeklyMessages.put(6, new String[]{ // শনিবার
                "﴿بِسْمِ اللَّهِ الَّذِي لَا يَضُرُّ مَعَ اسْمِهِ شَيْءٌ﴾\nআল্লাহর নামে, যাঁর নামে কিছুই ক্ষতি করতে পারে না।",

                "﴿اللَّهُمَّ احْفَظْنِي وَأَهْلِي﴾\nহে আল্লাহ! আমাকে ও আমার পরিবারকে রক্ষা কর।",

                "﴿اللَّهُمَّ احْفَظْنِي مِنْ كُلِّ شَرٍّ﴾\nহে আল্লাহ! সব অনিষ্ট থেকে আমাকে রক্ষা কর।",

                "﴿اللَّهُمَّ اجْعَلْنِي فِي حِفْظِكَ﴾\nহে আল্লাহ! আমাকে তোমার হেফাজতে রাখ।",

                "﴿اللَّهُمَّ قِنِي شَرَّ الشَّيْطَانِ﴾\nহে আল্লাহ! আমাকে শয়তানের অনিষ্ট থেকে রক্ষা কর।",

                "﴿اللَّهُمَّ قِنِي شَرَّ الْإِنْسِ وَالْجِنِّ﴾\nহে আল্লাহ! মানুষ ও জিনের অনিষ্ট থেকে রক্ষা কর।",

                "﴿اللَّهُمَّ اجْعَلْنِي فِي أَمَانِكَ﴾\nহে আল্লাহ! আমাকে তোমার নিরাপত্তায় রাখ।",

                "﴿اللَّهُمَّ اكْفِنِي شَرَّ أَعْدَائِي﴾\nহে আল্লাহ! আমার শত্রুদের অনিষ্ট থেকে আমাকে রক্ষা কর।",

                "﴿اللَّهُمَّ احْفَظْ دِينِي وَإِيْمَانِي﴾\nহে আল্লাহ! আমার ধর্ম ও ঈমানকে রক্ষা কর।",

                "﴿اللَّهُمَّ اجْعَلْنِي فِي عِنَايَتِكَ﴾\nহে আল্লাহ! আমাকে তোমার তত্ত্বাবধানে রাখ।"
        });

        // আজকের দিন বের করা
        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_WEEK); // রবিবার=1 ... শনিবার=7
        int dayIndex = today - 1; // রবিবার=0 ... শনিবার=6

        final String[] messages = weeklyMessages.get(dayIndex);
        if (messages == null || messages.length == 0) {
            textSwitcher.setText("আজকের জন্য কোন দোয়া পাওয়া যায়নি।");
        } else {
            index = 0;
            runnable = new Runnable() {
                @Override
                public void run() {
                    if (textSwitcher != null) {
                        textSwitcher.setText(messages[index]);
                        index = (index + 1) % messages.length;
                        handler.postDelayed(this, 5000);
                    }
                }
            };
            textSwitcher.setText(messages[0]);
            handler.postDelayed(runnable, 5000);
        }

        // RecyclerView setup
        recyclerView = view.findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        doalist = new ArrayList<>();
        doalist.add(new DoaCategory("1", "Daily prayer", "https://cdn-icons-png.flaticon.com/128/17155/17155652.png"));
        doalist.add(new DoaCategory("2", "Prayer from Al Quran", "https://static.vecteezy.com/system/resources/thumbnails/018/872/217/small/3d-render-illustration-of-al-quran-with-moon-and-star-icon-for-decoration-greeting-card-of-ramadan-and-eid-al-fitr-free-png.png"));
        doalist.add(new DoaCategory("3", "Daily Practice", "https://cdn-icons-png.flaticon.com/128/5173/5173667.png"));
        doalist.add(new DoaCategory("4", "Other Daily Prayer", "https://cdn-icons-png.flaticon.com/128/18459/18459702.png"));
        doalist.add(new DoaCategory("5", "Prayer related Dua", "https://cdn-icons-png.flaticon.com/128/2320/2320051.png"));
        doalist.add(new DoaCategory("6", "Prayer of the Prophet", "https://cdn-icons-png.flaticon.com/128/2652/2652688.png"));
        doalist.add(new DoaCategory("7", "Asking Prayer", "https://cdn-icons-png.flaticon.com/128/10911/10911449.png"));
        doalist.add(new DoaCategory("8", "Prayer of worship", "https://cdn-icons-png.flaticon.com/128/7827/7827412.png"));
        doalist.add(new DoaCategory("9", "Dua of Quran recitation", "https://cdn-icons-png.flaticon.com/128/5173/5173667.png"));
        doalist.add(new DoaCategory("10", "Prayer for purity of heart", "https://cdn-icons-png.flaticon.com/128/10127/10127009.png"));
        doalist.add(new DoaCategory("11", "Protection Prayer", "https://cdn-icons-png.flaticon.com/128/10741/10741215.png"));
        doalist.add(new DoaCategory("12", "Waking Night Prayer", "https://cdn-icons-png.flaticon.com/128/15387/15387066.png"));
        doalist.add(new DoaCategory("13", "Night Prayer", "https://cdn-icons-png.flaticon.com/128/384/384420.png"));
        doalist.add(new DoaCategory("14", "Shalat Prayer", "https://cdn-icons-png.flaticon.com/128/10741/10741226.png"));
        doalist.add(new DoaCategory("15", "Hajj", "https://cdn-icons-png.flaticon.com/128/804/804317.png"));
        doalist.add(new DoaCategory("16", "Prayer from Kutubussittah", "https://cdn-icons-png.flaticon.com/128/16839/16839492.png"));
        doalist.add(new DoaCategory("17", "Dua for exam and job", "https://cdn-icons-png.flaticon.com/128/16083/16083942.png"));
        doalist.add(new DoaCategory("18", "Other Prayer", "https://cdn-icons-png.flaticon.com/128/10171/10171370.png"));

        adapter = new DoaAdapter(doalist, new DoaClickListener() {
            @Override
            public void onDoaClick(DoaCategory doaCategory) {
                Intent intent = new Intent(getContext(), DoaListActivity.class);
                intent.putExtra("id", doaCategory.getId());
                intent.putExtra("categoryName", doaCategory.getDoaCatagoryName());
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(runnable);
    }
}
