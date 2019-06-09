package com.qifeixianapp.qfxdemo.Homes.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FrameMetricsAggregator;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Homes.Bean.HomeMuenBean;
import com.qifeixianapp.qfxdemo.Homes.adapter.HomeMuenAdapter;
import com.qifeixianapp.qfxdemo.Homes.adapter.MerchantListAdapter;
import com.qifeixianapp.qfxdemo.Homes.adapter.MyHomtTypePagerAdapter;
import com.qifeixianapp.qfxdemo.R;

import java.util.ArrayList;
import java.util.List;


public class homeFragment extends Fragment   {
    TextView tv_tabname;
    List<String> list_Title;
    List<Fragment> fragmentList;
    ViewPager viewPager;
    TabLayout tabLayout;

    RecyclerView mMuenrecyclerView;
    RecyclerView mThemereuclerview;
    List<HomeMuenBean> homeMuenBeans;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        find(v);
        recyclerViewsetting();
        return  v;
    }

    private void recyclerViewsetting() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //    mRecyclerViewList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));//横线
        mMuenrecyclerView.setLayoutManager(linearLayoutManager);
        mMuenrecyclerView.setAdapter(new HomeMuenAdapter(getContext(),homeMuenBeans));






    }

    private void find(View v) {
        mMuenrecyclerView=v.findViewById(R.id.home_muen);
        fragmentList = new ArrayList<>();
        homeMuenBeans=new ArrayList<>();
        list_Title = new ArrayList<>();
        fragmentList.add(new HometypeFragment1());
        fragmentList.add(new HomeTypeFragment2());
        list_Title.add("出行");
        list_Title.add("two");
//        viewPager=v.findViewById(R.id.home_viewpager);
//        tabLayout=v.findViewById(R.id.tablayout);
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

    }

}
