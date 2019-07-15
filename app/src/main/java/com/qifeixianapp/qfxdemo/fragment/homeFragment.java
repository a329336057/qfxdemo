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


public class homeFragment extends Fragment   {

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

            return  v;
        }


}
