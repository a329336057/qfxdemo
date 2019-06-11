package com.qifeixianapp.qfxdemo.Homes.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qifeixianapp.qfxdemo.Homes.Bean.HomeListperipheraBean;
import com.qifeixianapp.qfxdemo.Homes.adapter.HomeListPeripheraAdapter;
import com.qifeixianapp.qfxdemo.Homes.adapter.HomeThemeAdapter;
import com.qifeixianapp.qfxdemo.R;

import java.util.ArrayList;
import java.util.List;


public class HometypeFragment1 extends Fragment {
    List<HomeListperipheraBean> homeListperipheraBeans;
    RecyclerView mRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_hometype_fragment1, container, false);
        findid(v);
        recyclerViewsetting();
        return v;
    }

    private void recyclerViewsetting() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(new HomeListPeripheraAdapter(getContext(),homeListperipheraBeans));
    }

    private void findid(View v) {
        homeListperipheraBeans=new ArrayList<>();
        mRecyclerView=v.findViewById(R.id.home_list_recyclerview);

        for (int i = 0; i <12 ; i++) {
            HomeListperipheraBean homeListperipheraBean=new HomeListperipheraBean();
            homeListperipheraBean.setLv_evaluate("“好玩， 能够欣赏三峡美景，而且一路都是丛山峻岭”");
            homeListperipheraBean.setLv_head_portrait(R.drawable.head_portrait);
            homeListperipheraBean.setLv_id("跟团游 线路号:1254000");
            homeListperipheraBean.setLv_title("【山水间的非凡体验】重庆-长江4日4日轮船游，包吃 包住。体验长江三峡美景。");
            homeListperipheraBean.setLv_image(R.drawable.sousuo);
            homeListperipheraBean.setLv_moneny("￥1280+230");

            homeListperipheraBean.setPlacedeparture("重庆出发");
            homeListperipheraBeans.add(homeListperipheraBean);
        }


    }


}
