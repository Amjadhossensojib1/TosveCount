package com.amjad.tosvecount.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.SunnahDetails;

import java.util.ArrayList;

public class SunnahDetailsAdapter extends RecyclerView.Adapter<SunnahDetailsAdapter.ViewHolder> {

    private ArrayList<SunnahDetails> detailsList;

    public SunnahDetailsAdapter(ArrayList<SunnahDetails> detailsList) {
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sunnah_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SunnahDetails details = detailsList.get(position);
        holder.title.setText(details.getTitle());
        holder.description.setText(details.getDescription());
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, description;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textTitle);
            description = itemView.findViewById(R.id.textDescription);
        }
    }
}
