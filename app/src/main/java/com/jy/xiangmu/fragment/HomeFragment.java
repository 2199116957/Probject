package com.jy.xiangmu.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.jy.xiangmu.R;
import com.youth.banner.Banner;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private View inflate;
    private RecyclerView mRecy;
    private Banner banner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        return inflate;

    }

    private void initView() {
       /* LinearLayout mLl = inflate.findViewById(R.id.ll);
        mLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "搜索", Toast.LENGTH_SHORT).show();
            }
        });*/
        mRecy = (RecyclerView) inflate.findViewById(R.id.recy);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        mRecy.setLayoutManager(virtualLayoutManager);
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();

        singleLayoutHelper.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        SoAdap soAdap = new SoAdap(singleLayoutHelper, getActivity());
        /* ------------Banner-----------------------------------------------------*/
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        ArrayList<BannerBean> banner = new ArrayList<>();
        banner.add(new BannerBean(R.drawable.banner1));
        banner.add(new BannerBean(R.drawable.banner2));
        banner.add(new BannerBean(R.drawable.banner3));

        BannerAdap bannerAdap = new BannerAdap(linearLayoutHelper, getActivity(), banner);

        /**------------------------------------------------------------------------*/
        /*设置栏格布局
         */
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 创建对象

        // 公共属性
        columnLayoutHelper.setItemCount(5);// 设置布局里Item个数
        columnLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        columnLayoutHelper.setPadding(80, 200, 20, 20);
        ArrayList<DaoHangBean> daoHangBeans = new ArrayList<>();
        daoHangBeans.add(new DaoHangBean("http://cdwan.cn/www/static/channel/ic_jujia.png","居家"));
        daoHangBeans.add(new DaoHangBean("http://cdwan.cn/www/static/channel/ic_canchu.png","餐厨"));
        daoHangBeans.add(new DaoHangBean("http://cdwan.cn/www/static/channel/ic_peijian.png","配件"));
        daoHangBeans.add(new DaoHangBean("http://cdwan.cn/www/static/channel/ic_dress.png","服装"));
        daoHangBeans.add(new DaoHangBean("http://cdwan.cn/www/static/channel/ic_game.png","志趣"));
        // columnLayoutHelper特有属性
        columnLayoutHelper.setWeights(new float[]{20, 20, 20,20});// 设置该行每个Item占该行总宽度的比例
        // 同上面Weigths属性讲解
        DaoHangAdap daoHangAdap = new DaoHangAdap(columnLayoutHelper,getActivity(),daoHangBeans);

        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        delegateAdapter.addAdapter(soAdap);
        delegateAdapter.addAdapter(bannerAdap);
        delegateAdapter.addAdapter(daoHangAdap);
        mRecy.setAdapter(delegateAdapter);
    }
}

