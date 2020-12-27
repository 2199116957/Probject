package com.jy.xiangmu.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.jy.xiangmu.R;

import java.util.ArrayList;

class RecyclAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<TopBean> list;

    public RecyclAdapter(Context context, ArrayList<TopBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_itemm, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder holder1 = (ViewHolder) holder;
        holder1.title.setText(list.get(position).getTitle());
        holder1.name.setText(list.get(position).getSubtitle());
        holder1.jin.setText("¥69元起");
        Glide.with(holder1.image).load(list.get(position).getItem_pic_url()).into(holder1.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final ImageView image;
        private final TextView jin;
        private final TextView name;
        public ViewHolder(View view) {
            super(view);
            title = itemView.findViewById(R.id.itemm_title);
            image = itemView.findViewById(R.id.itemm_image);
            jin = itemView.findViewById(R.id.itemm_jin);
            name = itemView.findViewById(R.id.itemm_name);
        }
    }
}
