package com.amjad.tosvecount.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.Audioquran;
import com.amjad.tosvecount.ui.musicplayer.MusicplayerActivity;
import com.bumptech.glide.Glide;

import java.util.List;

public class AudioquranAdapter extends RecyclerView.Adapter<AudioquranAdapter.AudioquranViewHolder> {

    private List<Audioquran> audiolist;
    private Context context;

    public AudioquranAdapter(List<Audioquran> audiolist, Context context) {
        this.audiolist = audiolist;
        this.context = context;
    }

    @NonNull
    @Override
    public AudioquranViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_quran_audio, parent, false);
        return new AudioquranViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AudioquranViewHolder holder, int position) {
        Audioquran model = audiolist.get(position);
        holder.name.setText(model.getName());
        holder.dsc.setText(model.getDsc());
        holder.time.setText(model.getTime());

        Glide.with(context)
                .load(model.getImage())
                .into(holder.image);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, MusicplayerActivity.class);
            intent.putExtra("name", model.getName());
            intent.putExtra("dsc", model.getDsc());
            intent.putExtra("time", model.getTime());

            intent.putExtra("audioName", model.getAudioName());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return audiolist.size();
    }

    public static class AudioquranViewHolder extends RecyclerView.ViewHolder {
        TextView name, dsc, time;
        ImageView image;

        public AudioquranViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_image);
            name = itemView.findViewById(R.id.tv_name);
            dsc = itemView.findViewById(R.id.tv_dsc);
            time = itemView.findViewById(R.id.tv_time);
        }
    }
}
