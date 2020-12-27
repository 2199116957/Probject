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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.jy.xiangmu.R;
import com.jy.xiangmu.adap.BannerAdap;
import com.jy.xiangmu.adap.DaoHangAdap;
import com.jy.xiangmu.adap.SoAdap;
import com.jy.xiangmu.adap.TitleAdap;
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
        columnLayoutHelper.setPadding(100, 0, 20, 0);
        columnLayoutHelper.setMargin(0,0,0,32);
        columnLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        ArrayList<DaoHangBean> daoHangBeans = new ArrayList<>();
        daoHangBeans.add(new DaoHangBean(R.drawable.ic_jujia,"居家"));
        daoHangBeans.add(new DaoHangBean(R.drawable.ic_canchu,"餐厨"));
        daoHangBeans.add(new DaoHangBean(R.drawable.ic_peijian,"配件"));
        daoHangBeans.add(new DaoHangBean(R.drawable.ic_dress,"服装"));
        daoHangBeans.add(new DaoHangBean(R.drawable.ic_game,"志趣"));
        // columnLayoutHelper特有属性
        columnLayoutHelper.setWeights(new float[]{20, 20, 20,20});// 设置该行每个Item占该行总宽度的比例
        // 同上面Weigths属性讲解
        DaoHangAdap daoHangAdap = new DaoHangAdap(columnLayoutHelper,getActivity(),daoHangBeans);

        /**------------------------------------------------------------------------*/
        SingleLayoutHelper singleLayoutHelper1 = new SingleLayoutHelper();
        columnLayoutHelper.setItemCount(1);// 设置布局里Item个数
        columnLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        TitleAdap titleAdap = new TitleAdap(singleLayoutHelper,getActivity());
        titleAdap.setName("品牌制造商直供");
        /**------------------------------------------------------------------------*/
        /**
         设置Grid布局
         */
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        // 在构造函数设置每行的网格个数

        // 公共属性
        gridLayoutHelper.setItemCount(4);// 设置布局里Item个数
        gridLayoutHelper.setPadding(0, 0, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper.setWeights(new float[]{40, 30, 30});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(20);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(3);// 设置每行多少个网格






        /**------------------------------------------------------------------------*/
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        delegateAdapter.addAdapter(soAdap);
        delegateAdapter.addAdapter(bannerAdap);
        delegateAdapter.addAdapter(daoHangAdap);
        delegateAdapter.addAdapter(titleAdap);
        mRecy.setAdapter(delegateAdapter);
    }
}

