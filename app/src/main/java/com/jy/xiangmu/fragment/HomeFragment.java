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
import com.jy.xiangmu.Bean.HomeBean;
import com.jy.xiangmu.R;
import com.jy.xiangmu.adap.BannerAdap;
import com.jy.xiangmu.adap.DaoHangAdap;
import com.jy.xiangmu.adap.SoAdap;
import com.jy.xiangmu.adap.TitleAdap;
import com.jy.xiangmu.adap.ZhiZaoAdap;
import com.jy.xiangmu.adap.ZhiZaoAdap1;
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

        ArrayList<ZhiZaoBean> zhiZaoBeans1 = new ArrayList<>();

        zhiZaoBeans1.add(new ZhiZaoBean(R.drawable.grid1,"蔓越莓曲奇 200克","39元起"));
        zhiZaoBeans1.add(new ZhiZaoBean(R.drawable.grid2,"趣味粉彩系列笔记本","12.9元起"));
        zhiZaoBeans1.add(new ZhiZaoBean(R.drawable.grid3,"简约知性记忆棉坐垫","9.9元起"));
        zhiZaoBeans1.add(new ZhiZaoBean(R.drawable.grid4,"趣味粉彩系列记忆棉坐垫","49元起"));
        GridLayoutHelper gridLayoutHelper_b = new GridLayoutHelper(3);
        // 在构造函数设置每行的网格个数

        // 公共属性
        gridLayoutHelper_b.setItemCount(zhiZaoBeans1.size());// 设置布局里Item个数
        gridLayoutHelper_b.setPadding(5, 5, 5, 0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        gridLayoutHelper_b.setMargin(0, 00, 00, 30);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        gridLayoutHelper_b.setBgColor(Color.WHITE);// 设置背景颜色
        gridLayoutHelper_b.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比

        // gridLayoutHelper特有属性（下面会详细说明）
        gridLayoutHelper_b.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        gridLayoutHelper_b.setVGap(2);// 控制子元素之间的垂直间距
        gridLayoutHelper_b.setHGap(2);// 控制子元素之间的水平间距
        gridLayoutHelper_b.setAutoExpand(false);//是否自动填充空白区域
        gridLayoutHelper_b.setSpanCount(2);// 设置每行多少个网格
        ZhiZaoAdap1 zhiZaoAdap1 = new ZhiZaoAdap1(gridLayoutHelper_b,getActivity(), zhiZaoBeans1);
        /**------------------------------------------------------------------------*/

        TitleAdap titleAdap2 = new TitleAdap(singleLayoutHelper1,getActivity());
        titleAdap2.setName("人气推荐");

        /***************************************************************************/
        LinearLayoutHelper linearLayoutHelper1 = new LinearLayoutHelper();
        ArrayList<LayLinBean> layLinBeans = new ArrayList<>();
        layLinBeans.add(new LayLinBean(R.drawable.ll1, "双宫茧桑蚕丝被 空调被","双宫茧桑蚕丝被 空调被","￥699"));
        layLinBeans.add(new LayLinBean(R.drawable.ll2, "可水洗舒柔丝羽绒枕","双宫茧桑蚕丝被 空调被","￥59"));
        layLinBeans.add(new LayLinBean(R.drawable.ll3, "色织精梳AB纱格纹空调被","双宫茧桑蚕丝被 空调被","￥199"));

        linearLayoutHelper1.setItemCount(layLinBeans.size());// 设置布局里Item个数
        linearLayoutHelper1.setPadding(10,10,10,10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelper1.setMargin(0,0,0,30);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelper1.setBgColor(Color.WHITE);// 设置背景颜色
        linearLayoutHelper1.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        // linearLayoutHelper特有属性
        linearLayoutHelper1.setDividerHeight(2); // 设置每行Item的距离
        LayLinAdapter layLinAdapter = new LayLinAdapter(linearLayoutHelper1,getActivity(), layLinBeans);

        /***************************************************************************/

        TitleAdap titleAdap3 = new TitleAdap(singleLayoutHelper1,getActivity());
        titleAdap3.setName("标题精选");

        /***************************************************************************/
        ArrayList<TopBean> topBeans = new ArrayList<>();
        topBeans.add(new TopBean("关爱他成长的每一个足迹","https://yanxuan.nosdn.127.net/14943267735961674.jpg","专业运动品牌同厂，毛毛虫鞋买二送一"));
        topBeans.add(new TopBean("一次解决5个节日送礼难题","https://yanxuan.nosdn.127.net/14942996754171334.jpg","这些就是他们想要的礼物清单"));
        topBeans.add(new TopBean("秒杀化学洗涤剂的纯天然皂","https://yanxuan.nosdn.127.net/14943267735961674.jpg","专业运动品牌同厂，毛毛虫鞋买二送一"));
        SingleLayoutHelper singleLayoutHelper3 = new SingleLayoutHelper();// 公共属性
        singleLayoutHelper3.setItemCount(1);// 设置布局里Item个数
        singleLayoutHelper3.setBgColor(Color.WHITE);// 设置背景颜色
        singleLayoutHelper3.setPadding(10,10,10,10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        singleLayoutHelper3.setMargin(0,0,0,30);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        singleLayoutHelper3.setAspectRatio(1-5);// 设置设置布局内每行布局的宽与高的比
        RecyAdapter recyAdapter = new RecyAdapter(singleLayoutHelper3,getActivity(), topBeans);


        /*-------------------------------------------------------------------------*/
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        delegateAdapter.addAdapter(soAdap);
        delegateAdapter.addAdapter(bannerAdap);
        delegateAdapter.addAdapter(daoHangAdap);
        delegateAdapter.addAdapter(titleAdap);
        delegateAdapter.addAdapter(zhizaoAdap);
        delegateAdapter.addAdapter(titleAdap1);
        delegateAdapter.addAdapter(zhiZaoAdap1);
        delegateAdapter.addAdapter(titleAdap2);
        delegateAdapter.addAdapter(layLinAdapter);
        delegateAdapter.addAdapter(titleAdap3);
        delegateAdapter.addAdapter(recyAdapter);
        mRecy.setAdapter(delegateAdapter);
    }
}

