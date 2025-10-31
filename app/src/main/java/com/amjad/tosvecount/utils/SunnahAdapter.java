package com.amjad.tosvecount.utils;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.ui.sunnahDetials.SunnahdetialsActivity;
import com.amjad.tosvecount.model.Sunnah;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SunnahAdapter extends RecyclerView.Adapter<SunnahAdapter.SunnahViewHolder>{
    private List<Sunnah> sunnahList;
    SunnahItemClickListener listener;

    public SunnahAdapter(List<Sunnah> sunnahList) {
        this.sunnahList = sunnahList;
    }

    @NonNull
    @Override
    public SunnahAdapter.SunnahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_sunnah, parent,false);
        return new SunnahAdapter.SunnahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SunnahAdapter.SunnahViewHolder holder, int position) {
        Sunnah sunnah = sunnahList.get(position);
        holder.bind(sunnah);

    }

    @Override
    public int getItemCount() {
        return sunnahList.size();
    }

    public class SunnahViewHolder extends RecyclerView.ViewHolder {
        private ImageView sunnahImage;
        private TextView sunnahName;
        public SunnahViewHolder(@NonNull View itemView) {
            super(itemView);

            sunnahImage = itemView.findViewById(R.id.iv_sunnahImg);
            sunnahName = itemView.findViewById(R.id.tv_sunnahName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Sunnah selectedSunnah = sunnahList.get(position);
                        Intent intent = new Intent(itemView.getContext(), SunnahdetialsActivity.class);
                        intent.putExtra("sunnah_id", selectedSunnah.getId());
                        intent.putExtra("sunnah_name", selectedSunnah.getSunnahName());
                        itemView.getContext().startActivity(intent);
                    }
                }
            });
        }

        public void bind(Sunnah sunnah) {
            Picasso.get().load(sunnah.getSunnahImage()).into(sunnahImage);
            sunnahName.setText(sunnah.getSunnahName());

        }
    }
}
