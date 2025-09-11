package com.amjad.tosvecount.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.Hadith;

import java.util.List;

public class HadithAdapter extends RecyclerView.Adapter<HadithAdapter.HadithViewHolder>{

    private List<Hadith> hadithList;
    HadithItemClickListener listener;

    public HadithAdapter(List<Hadith> hadithList) {
        this.hadithList = hadithList;
    }

    @NonNull
    @Override
    public HadithAdapter.HadithViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_hadith, parent,false);
        return new HadithAdapter.HadithViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HadithAdapter.HadithViewHolder holder, int position) {
        Hadith hadith = hadithList.get(position);
        holder.bind(hadith);

    }

    @Override
    public int getItemCount() {
        return hadithList.size();
    }

    public class HadithViewHolder extends RecyclerView.ViewHolder {
        private TextView hadithArobi,hadithBangla,hadithName;
        public HadithViewHolder(@NonNull View itemView) {
            super(itemView);
            hadithArobi = itemView.findViewById(R.id.hadith_arobi);
            hadithBangla = itemView.findViewById(R.id.hadith_bangla);
            hadithName = itemView.findViewById(R.id.hadith_Name);
        }

        public void bind(Hadith hadith) {
            hadithArobi.setText(hadith.getHadithArobi());
            hadithBangla.setText(hadith.getHadithBangla());
            hadithName.setText(hadith.getHadithName());
        }
    }
}
