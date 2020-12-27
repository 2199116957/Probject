package com.jy.xiangmu.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.jy.xiangmu.R;

import java.util.ArrayList;

public class RecyAdapter extends DelegateAdapter.Adapter {
    private SingleLayoutHelper singleLayoutHelper;
    private Context context;
    private ArrayList<TopBean> list;

    public RecyAdapter(SingleLayoutHelper singleLayoutHelper, Context context, ArrayList<TopBean> list) {
        this.singleLayoutHelper = singleLayoutHelper;
        this.context = context;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_recy, null, false);
        return new RecyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyViewHolder recyViewHolder = (RecyViewHolder) holder;
        recyViewHolder.recycler.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        RecyclAdapter adapter = new RecyclAdapter(context, list);
        recyViewHolder.recycler.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    private class RecyViewHolder extends RecyclerView.ViewHolder {
        private final RecyclerView recycler;
        public RecyViewHolder(View view) {
            super(view);
            recycler = itemView.findViewById(R.id.rv);
        }
    }
}
