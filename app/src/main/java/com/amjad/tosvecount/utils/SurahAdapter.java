package com.amjad.tosvecount.utils;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.tosvecount.ui.quranActivity.QuranActivity;
import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.Surah;

import java.util.List;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.SurahViewHolder>{

    private List<Surah> surahList;
    private SurahlistClickListener listener;

    public SurahAdapter(List<Surah> surahList) {
        this.surahList = surahList;
    }

    @NonNull
    @Override
    public SurahAdapter.SurahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_surah, parent, false);
        return new SurahAdapter.SurahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SurahAdapter.SurahViewHolder holder, int position) {
        Surah surahlist = surahList.get(position);
        holder.bind(surahlist);
    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }

    public class SurahViewHolder extends RecyclerView.ViewHolder {
        private TextView suarhNumber,surahName,surahDsc,surahNamearobi,surahAyahs;
        public SurahViewHolder(@NonNull View itemView) {
            super(itemView);
            suarhNumber = itemView.findViewById(R.id.tvSurahNumber);
            surahName = itemView.findViewById(R.id.tvSurahName);
            surahDsc = itemView.findViewById(R.id.tvSurahDsc);
            surahNamearobi = itemView.findViewById(R.id.tvArabicName);
            surahAyahs = itemView.findViewById(R.id.tvAyahCount);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Surah selectedSurah = surahList.get(position);
                        Intent intent = new Intent(itemView.getContext(), QuranActivity.class);

                        // Surah ডেটা পাঠানো
                        intent.putExtra("surahNumber", selectedSurah.getSurahNumber());
                        intent.putExtra("surahName", selectedSurah.getSurahName());
                        intent.putExtra("surahDsc", selectedSurah.getSurahDsc());
                        intent.putExtra("surahNameArobi", selectedSurah.getSurahNameArobi());
                        intent.putExtra("surahAyahs", selectedSurah.getSurahAyahs());

                        itemView.getContext().startActivity(intent);
                    }
                }
            });
        }
        public void bind(Surah surahlist) {
            suarhNumber.setText(surahlist.getSurahNumber());
            surahName.setText(surahlist.getSurahName());
            surahDsc.setText(surahlist.getSurahDsc());
            surahNamearobi.setText(surahlist.getSurahNameArobi());
            surahAyahs.setText(surahlist.getSurahAyahs());

        }
    }
}
