package com.jy.xiangmu.adap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.jy.xiangmu.R;
import com.jy.xiangmu.fragment.BannerBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class BannerAdap extends DelegateAdapter.Adapter {
    private LinearLayoutHelper linearLayoutHelper;
    private Context context;
    private ArrayList<BannerBean> images;

    public BannerAdap(LinearLayoutHelper linearLayoutHelper, Context context, ArrayList<BannerBean> images) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.context = context;
        this.images = images;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.banner_home, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.mBanner.setImages(images)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        BannerBean bannerBean= (BannerBean) path;
                        Glide.with(context).load(bannerBean.getImage()).into(imageView);
                    }
                }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ViewHolder  extends RecyclerView.ViewHolder{
        public View rootView;
        public Banner mBanner;
        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView=rootView;
            this.mBanner = (Banner) rootView.findViewById(R.id.banner);
        }
    }
}
