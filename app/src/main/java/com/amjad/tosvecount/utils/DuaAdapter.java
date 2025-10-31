package com.amjad.tosvecount.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.tosvecount.R;
import com.amjad.tosvecount.model.DoaCategory;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DuaAdapter extends RecyclerView.Adapter<DuaAdapter.DoaViewHolder>{

    private List<DoaCategory> doaList;
    private DoaClickListener listener;

    public DuaAdapter(List<DoaCategory> doaList, DoaClickListener listener) {
        this.doaList = doaList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DuaAdapter.DoaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_doa, parent, false);
        return new DuaAdapter.DoaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DuaAdapter.DoaViewHolder holder, int position) {
        DoaCategory doa = doaList.get(position);
        holder.bind(doa);

    }

    @Override
    public int getItemCount() {
        return doaList.size();
    }

    public class DoaViewHolder extends RecyclerView.ViewHolder {
        private TextView doaCatagory;
        private ImageView doaCatagoryImg;
        public DoaViewHolder(@NonNull View itemView) {
            super(itemView);
            doaCatagory =itemView.findViewById(R.id.tv_doacatagory);
            doaCatagoryImg = itemView.findViewById(R.id.iv_doacatagoryImg);

            doaCatagory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onDoaClick(doaList.get(getAbsoluteAdapterPosition()));
                }
            });
        }

        public void bind(DoaCategory doa) {
            Picasso.get().load(doa.getDoaCatagoryImg()).into(doaCatagoryImg);
            doaCatagory.setText(doa.getDoaCatagoryName());
        }
    }
}
