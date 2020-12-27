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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.jy.xiangmu.R;

import java.util.ArrayList;

public class LayLinAdapter extends DelegateAdapter.Adapter {
    private LinearLayoutHelper linearLayoutHelper;
    private Context context;
    private ArrayList<LayLinBean> list;

    public LayLinAdapter(LinearLayoutHelper linearLayoutHelper, Context context, ArrayList<LayLinBean> list) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.context = context;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_laylin, null, false);
        return new LayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LayViewHolder layViewHolder = (LayViewHolder) holder;
        LayLinBean layLinBean = list.get(position);
        layViewHolder.name.setText(layLinBean.getName());
        layViewHolder.title.setText(layLinBean.getTitle());
        layViewHolder.jin.setText(layLinBean.getRetail());
        Glide.with(context).load(layLinBean.getImage()).into(layViewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LayViewHolder extends RecyclerView.ViewHolder {
        private final TextView jin;
        private final TextView name;
        private final TextView title;
        private final ImageView image;
        public LayViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.lay_image);
            title = itemView.findViewById(R.id.lay_title);
            name = itemView.findViewById(R.id.lay_name);
            jin = itemView.findViewById(R.id.lay_jin);
        }
    }
}
