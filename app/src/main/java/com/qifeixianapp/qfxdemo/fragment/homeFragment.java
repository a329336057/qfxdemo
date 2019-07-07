package com.qifeixianapp.qfxdemo.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Adapter.Bean.HomeMuenBean;
import com.qifeixianapp.qfxdemo.Adapter.Bean.HomeThemeBean;
import com.qifeixianapp.qfxdemo.Adapter.HomeMuenAdapter;
import com.qifeixianapp.qfxdemo.Adapter.HomeThemeAdapter;
import com.qifeixianapp.qfxdemo.Adapter.MyHomtTypePagerAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.GlideImageLoader;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;


public class homeFragment extends Fragment  implements OnBannerListener {

    List<String> list_Title;
    List<Fragment> fragmentList;
    ViewPager viewPager;
    TabLayout tabLayout;
    Banner banners;

    RecyclerView mMuenrecyclerView;
    RecyclerView mThemereuclerview;
    List<HomeMuenBean> homeMuenBeans;
    List<HomeThemeBean> themeBeans;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        find(v);
        bannersetting();
        recyclerViewsetting();
        return  v;
    }

    private void bannersetting() {
        banners.setImageLoader(new GlideImageLoader());
        final List<String> list=new ArrayList<>();
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552812527473&di=49786bdc1937ae4a28c4c01e709dcd10&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2017-12-05%2F5a262f421fccd.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552814100617&di=ccd90978b039c1b990ab8841f3e85460&imgtype=0&src=http%3A%2F%2Fimg2.ph.126.net%2FhZSpKs9G6jUlTS6J-e-xoA%3D%3D%2F6631417410401878349.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552814100616&di=3fd6ebe396d1001037b12fcccb374ea6&imgtype=0&src=http%3A%2F%2Fimg2.ph.126.net%2FC56h7v-DL3caFkFTxdn7dw%3D%3D%2F6630472929908798903.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552814100614&di=a925f47f0fae4b3f6aae83ebac3af526&imgtype=0&src=http%3A%2F%2Fimg2.ph.126.net%2F8qSIEmPAwjnxDLtUZVXb7A%3D%3D%2F6631720875607361156.jpg");
        banners.setImages(list)
                .setBannerAnimation(Transformer.DepthPage).setOnBannerListener(this).start();
        banners.setBannerAnimation(Transformer.Stack);
    }

    private void recyclerViewsetting() {
        GridLayoutManager MuenManager=new GridLayoutManager(getContext(),4);
        MuenManager.setOrientation(MuenManager.VERTICAL);
        //    mRecyclerViewList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));//横线
        mMuenrecyclerView.setLayoutManager(MuenManager);
        mMuenrecyclerView.setAdapter(new HomeMuenAdapter(getContext(),homeMuenBeans));

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mThemereuclerview.setLayoutManager(linearLayoutManager);
        mThemereuclerview.setAdapter(new HomeThemeAdapter(getContext(),themeBeans));
    }

    private void find(View v) {
        mMuenrecyclerView=v.findViewById(R.id.home_muen);
        mThemereuclerview=v.findViewById(R.id.home_theme);
        banners=v.findViewById(R.id.home_mbanner);
        fragmentList = new ArrayList<>();
        homeMuenBeans=new ArrayList<>();
        themeBeans=new ArrayList<>();
        list_Title = new ArrayList<>();
        fragmentList.add(new HometypeFragment1());
        fragmentList.add(new HometypeFragment1());
        fragmentList.add(new HometypeFragment1());
        fragmentList.add(new HometypeFragment1());
        list_Title.add("周边游");
        list_Title.add("国内游");
        list_Title.add("特价游");
        list_Title.add("出境游");
        viewPager=v.findViewById(R.id.home_viewpager);
        tabLayout=v.findViewById(R.id.tablayout);
        viewPager.setAdapter(new MyHomtTypePagerAdapter(this.getChildFragmentManager(),getContext(),fragmentList,list_Title));
        tabLayout.setupWithViewPager(viewPager);//此方法就是让tablayout和ViewPager联动

        HomeMuenBean homeMuenBean1=new HomeMuenBean();
        homeMuenBean1.setImages(R.drawable.wweep_code);
        homeMuenBean1.setTitle("扫码消费");
        HomeMuenBean homeMuenBean2=new HomeMuenBean();
        homeMuenBean2.setImages(R.drawable.recommended_rebate);
        homeMuenBean2.setTitle("推荐好礼");
        HomeMuenBean homeMuenBean3=new HomeMuenBean();
        homeMuenBean3.setImages(R.drawable.travel);
        homeMuenBean3.setTitle("旅游专区");
        HomeMuenBean homeMuenBean4=new HomeMuenBean();
        homeMuenBean4.setImages(R.drawable.delicious_food);
        homeMuenBean4.setTitle("周边美食");
        homeMuenBeans.add(homeMuenBean1);
        homeMuenBeans.add(homeMuenBean2);
        homeMuenBeans.add(homeMuenBean3);
        homeMuenBeans.add(homeMuenBean4);

        for (int i = 0; i <13 ; i++) {
            HomeThemeBean themeBean=new HomeThemeBean();
            themeBean.setUrl(R.drawable.sousuo);
            themeBeans.add(themeBean);
        }
    }

    @Override
    public void OnBannerClick(int position) {
        ToastUtils.show(getContext(),"点击了"+position);
    }
}
