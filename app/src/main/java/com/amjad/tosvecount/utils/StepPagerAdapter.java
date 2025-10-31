package com.amjad.tosvecount.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.StepModel;

import java.util.List;

public class StepPagerAdapter extends RecyclerView.Adapter<StepPagerAdapter.StepViewHolder> {

    private List<StepModel> stepList;
    private OnArrowClickListener listener;

    // ✅ Interface for arrow click handling
    public interface OnArrowClickListener {
        void onNextClick(int position);
        void onPrevClick(int position);
    }

    // ✅ Constructor with listener
    public StepPagerAdapter(List<StepModel> stepList, OnArrowClickListener listener) {
        this.stepList = stepList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_step_page, parent, false);
        return new StepViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StepViewHolder holder, int position) {
        StepModel step = stepList.get(position);
        holder.tvStepName.setText(step.getTitle());
        holder.ivStepImage.setImageResource(step.getImageRes());
        holder.tvDescription.setText(step.getDescription());
        holder.tvArabic.setText(step.getArabic());
        holder.tvCounter.setText((position + 1) + " of " + stepList.size());

        // ✅ Handle arrow clicks
        holder.btnNext.setOnClickListener(v -> {
            if (listener != null) listener.onNextClick(position);
        });

        holder.btnPrev.setOnClickListener(v -> {
            if (listener != null) listener.onPrevClick(position);
        });

        // Hide prev button on first page and next on last page
        if (position == 0) {
            holder.btnPrev.setVisibility(View.INVISIBLE);
        } else {
            holder.btnPrev.setVisibility(View.VISIBLE);
        }

        if (position == stepList.size() - 1) {
            holder.btnNext.setVisibility(View.INVISIBLE);
        } else {
            holder.btnNext.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return stepList.size();
    }

    static class StepViewHolder extends RecyclerView.ViewHolder {
        TextView tvStepName, tvDescription, tvArabic, tvCounter;
        ImageView ivStepImage, btnNext, btnPrev;

        public StepViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStepName = itemView.findViewById(R.id.tvStepName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvArabic = itemView.findViewById(R.id.tvArabic);
            ivStepImage = itemView.findViewById(R.id.ivStepImage);
            tvCounter = itemView.findViewById(R.id.tvCounter);
            btnNext = itemView.findViewById(R.id.btnNext);
            btnPrev = itemView.findViewById(R.id.btnPrev);
        }
    }
}
