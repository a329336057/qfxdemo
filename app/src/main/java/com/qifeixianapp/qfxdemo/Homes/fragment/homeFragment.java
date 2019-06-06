package com.qifeixianapp.qfxdemo.Homes.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FrameMetricsAggregator;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        find(v);

        return  v;
    }

    private void find(View v) {
        fragmentList = new ArrayList<>();
        list_Title = new ArrayList<>();
        fragmentList.add(new HometypeFragment1());
        fragmentList.add(new HomeTypeFragment2());
        list_Title.add("出行");
        list_Title.add("two");
        viewPager=v.findViewById(R.id.home_viewpager);
        tabLayout=v.findViewById(R.id.tablayout);
        viewPager.setAdapter(new MyHomtTypePagerAdapter(this.getChildFragmentManager(),getContext(),fragmentList,list_Title));
        tabLayout.setupWithViewPager(viewPager);//此方法就是让tablayout和ViewPager联动
    }

}
