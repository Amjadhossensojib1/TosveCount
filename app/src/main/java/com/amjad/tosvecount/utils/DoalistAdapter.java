package com.amjad.tosvecount.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.Doa;

import java.util.List;

public class DoalistAdapter extends RecyclerView.Adapter<DoalistAdapter.DoalistViewHolder>{

    private List<Doa> doaList;
    private DoalistClickListener listener;

    public DoalistAdapter(List<Doa> doaList, DoalistClickListener listener) {
        this.doaList = doaList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DoalistAdapter.DoalistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_doalist, parent, false);
        return new DoalistAdapter.DoalistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoalistAdapter.DoalistViewHolder holder, int position) {
        Doa doalist = doaList.get(position);
        holder.bind(doalist);

    }

    @Override
    public int getItemCount() {
        return doaList.size();
    }

    public class DoalistViewHolder extends RecyclerView.ViewHolder {
        private TextView doaName,doaArabic,doaBangla,doaEnglish;
        public DoalistViewHolder(@NonNull View itemView) {
            super(itemView);
            doaName = itemView.findViewById(R.id.doa_name);
            doaArabic = itemView.findViewById(R.id.doa_arobe);
            doaBangla = itemView.findViewById(R.id.doa_banglaa);
            doaEnglish = itemView.findViewById(R.id.doa_english);
        }

        public void bind(Doa doalist) {
            doaName.setText(doalist.getDoaName());
            doaArabic.setText(doalist.getDoaArabic());
            doaBangla.setText(doalist.getDoaBangla());
            doaEnglish.setText(doalist.getDoaEnglish());

        }
    }
}
