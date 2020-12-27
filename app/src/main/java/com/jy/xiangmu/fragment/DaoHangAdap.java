package com.jy.xiangmu.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.bumptech.glide.Glide;
import com.jy.xiangmu.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

class DaoHangAdap extends DelegateAdapter.Adapter {
    private ColumnLayoutHelper columnLayoutHelper;
    private Context context;
    private ArrayList<DaoHangBean> list;

    public DaoHangAdap(ColumnLayoutHelper columnLayoutHelper, Context context, ArrayList<DaoHangBean> list) {
        this.columnLayoutHelper = columnLayoutHelper;
        this.context = context;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_dao_home, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.desc.setText(list.get(position).getDesc());
        Glide.with(context).load(list.get(position).getImages()).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder  extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView imageView;
        public TextView desc;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView=rootView;
            this.imageView = rootView.findViewById(R.id.image);
            this.desc = rootView.findViewById(R.id.desc);
        }
    }
}
