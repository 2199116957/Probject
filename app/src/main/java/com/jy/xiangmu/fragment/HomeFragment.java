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
        singleLayoutHelper1.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper1.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper1.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        TitleAdap titleAdap = new TitleAdap(singleLayoutHelper,getActivity());
        titleAdap.setName("品牌制造商直供");
        /**------------------------------------------------------------------------*/
        /**
         设置Grid布局
         */
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
        // 在构造函数设置每行的网格个数

        ArrayList<ZhiZaoBean> zhiZaoBeans = new ArrayList<>();
        zhiZaoBeans.add(new ZhiZaoBean(R.drawable.zzs1,"CK制造商","39元起"));
        zhiZaoBeans.add(new ZhiZaoBean(R.drawable.zzs2,"MUJI制造商","12.9元起"));
        zhiZaoBeans.add(new ZhiZaoBean(R.drawable.zzx3,"WMF制造商","9.9元起"));
        zhiZaoBeans.add(new ZhiZaoBean(R.drawable.zzx4,"Coach制造商","49元起"));
        gridLayoutHelper.setItemCount(zhiZaoBeans.size());
        gridLayoutHelper.setPadding(5,5,5,0); //设置layouthelper的子元素对layouthelper边缘的距离
        gridLayoutHelper.setBgColor(Color.WHITE);//设置背景颜色
        gridLayoutHelper.setAspectRatio(3); //设置布局内每行布局的宽高比

        //gridlayouthelper特有属性
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(2);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(2);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        ZhiZaoAdap zhizaoAdap = new ZhiZaoAdap(gridLayoutHelper,getActivity(),zhiZaoBeans);

        /**------------------------------------------------------------------------*/
        SingleLayoutHelper singleLayoutHelper2 = new SingleLayoutHelper();
        singleLayoutHelper2.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper2.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper2.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比
        TitleAdap titleAdap1 = new TitleAdap(singleLayoutHelper2,getActivity());
        titleAdap1.setName("周一周四.新品发布");
        /**------------------------------------------------------------------------*/
        /*GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(2);
        // 在构造函数设置每行的网格个数

        ArrayList<ZhiZaoBean> zhiZaoBeans1 = new ArrayList<>();

        zhiZaoBeans1.add(new ZhiZaoBean(R.drawable.zzs1,"CK制造商","39元起"));
        zhiZaoBeans1.add(new ZhiZaoBean(R.drawable.zzs2,"MUJI制造商","12.9元起"));
        zhiZaoBeans1.add(new ZhiZaoBean(R.drawable.zzx3,"WMF制造商","9.9元起"));
        zhiZaoBeans1.add(new ZhiZaoBean(R.drawable.zzx4,"Coach制造商","49元起"));
        gridLayoutHelper.setItemCount(zhiZaoBeans.size());
        gridLayoutHelper.setPadding(5,5,5,0); //设置layouthelper的子元素对layouthelper边缘的距离
        gridLayoutHelper.setBgColor(Color.WHITE);//设置背景颜色
        gridLayoutHelper.setAspectRatio(3); //设置布局内每行布局的宽高比

        //gridlayouthelper特有属性
        gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper.setVGap(2);// 控制子元素之间的垂直间距
        gridLayoutHelper.setHGap(2);// 控制子元素之间的水平间距
        gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        ZhiZaoAdap1 zhizaoAdap1 = new ZhiZaoAdap1(gridLayoutHelper,getActivity(),zhiZaoBeans1);*/
        GridLayoutHelper gridLayoutHelper1 = new GridLayoutHelper(2);
        ArrayList<ZhiZaoBean> zhiZaoBeans1 = new ArrayList<>();
        zhiZaoBeans1.add(new ZhiZaoBean(R.drawable.zzs1,"CK制造商","39元起"));
//        http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png
//        http://yanxuan.nosdn.127.net/6c03ca93d8fe404faa266ea86f3f1e43.png
//        http://yanxuan.nosdn.127.net/aa49dfe878becf768eddc4c1636643a6.png
//        http://yanxuan.nosdn.127.net/8b30eeb17c831eba08b97bdcb4c46a8e.png
        /**------------------------------------------------------------------------*/
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        delegateAdapter.addAdapter(soAdap);
        delegateAdapter.addAdapter(bannerAdap);
        delegateAdapter.addAdapter(daoHangAdap);
        delegateAdapter.addAdapter(titleAdap);
        delegateAdapter.addAdapter(zhizaoAdap);
        delegateAdapter.addAdapter(titleAdap1);
//        delegateAdapter.addAdapter(zhizaoAdap1);
        mRecy.setAdapter(delegateAdapter);
    }
}

