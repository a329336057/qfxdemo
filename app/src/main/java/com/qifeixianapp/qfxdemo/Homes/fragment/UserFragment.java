package com.qifeixianapp.qfxdemo.Homes.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Homes.Bean.HomeUserMuenBean;
import com.qifeixianapp.qfxdemo.Homes.adapter.MerchantMenuAdapter;
import com.qifeixianapp.qfxdemo.Homes.adapter.UserMuenAdapter;
import com.qifeixianapp.qfxdemo.Login.LoginActivity;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.Wallet.WalletActivity;

import java.util.ArrayList;
import java.util.List;


public class UserFragment extends Fragment  {
    RecyclerView mRecyclerView;
    ImageView mbtton;
    TextView mMywallet,mMywalletNumber;
    List<HomeUserMuenBean> homeUserMuenBeans;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_user, container, false);
        find(v);
        walltelclick();
        recyclerViewSetting();
        return  v;
    }

    private void walltelclick() {
    mMywalletNumber.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getContext(), WalletActivity.class);
            startActivity(intent);
        }
    });
    mMywallet.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getContext(), WalletActivity.class);
            startActivity(intent);
        }
    });
    }

    private void recyclerViewSetting() {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(new UserMuenAdapter(getContext(),homeUserMuenBeans));
    }

    private void find(View v) {
        mRecyclerView=v.findViewById(R.id.user_muen_RecyclerView);
        mbtton=v.findViewById(R.id.user_icon);
        mMywallet=v.findViewById(R.id.user_myWallet);
        mMywalletNumber=v.findViewById(R.id.user_myWalletnumber);
        homeUserMuenBeans=new ArrayList<>();
        mbtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


        HomeUserMuenBean homeUserMuenBean=new HomeUserMuenBean();
        homeUserMuenBean.setImage(R.drawable.user_wallet);
        homeUserMuenBean.setTitle("我的消费");
        homeUserMuenBeans.add(homeUserMuenBean);


        HomeUserMuenBean homeUserMuenBean1=new HomeUserMuenBean();
        homeUserMuenBean1.setImage(R.drawable.user_order);
        homeUserMuenBean1.setTitle("我的订单");
        homeUserMuenBeans.add(homeUserMuenBean1);


        HomeUserMuenBean homeUserMuenBean2=new HomeUserMuenBean();
        homeUserMuenBean2.setImage(R.drawable.user_message);
        homeUserMuenBean2.setTitle("我的消费");
        homeUserMuenBeans.add(homeUserMuenBean2);


        HomeUserMuenBean homeUserMuenBean3=new HomeUserMuenBean();
        homeUserMuenBean3.setImage(R.drawable.user_relationship);
        homeUserMuenBean3.setTitle("我的关系");
        homeUserMuenBeans.add(homeUserMuenBean3);



        HomeUserMuenBean homeUserMuenBean4=new HomeUserMuenBean();
        homeUserMuenBean4.setImage(R.drawable.user_collection);
        homeUserMuenBean4.setTitle("我的收藏");
        homeUserMuenBeans.add(homeUserMuenBean4);




        HomeUserMuenBean homeUserMuenBean5=new HomeUserMuenBean();
        homeUserMuenBean5.setImage(R.drawable.user_browse);
        homeUserMuenBean5.setTitle("我的浏览");
        homeUserMuenBeans.add(homeUserMuenBean5);




        HomeUserMuenBean homeUserMuenBean6=new HomeUserMuenBean();
        homeUserMuenBean6.setImage(R.drawable.user_vip);
        homeUserMuenBean6.setTitle("成为VIP");
        homeUserMuenBeans.add(homeUserMuenBean6);




        HomeUserMuenBean homeUserMuenBean7=new HomeUserMuenBean();
        homeUserMuenBean7.setImage(R.drawable.user_merchant);
        homeUserMuenBean7.setTitle("商家管理");
        homeUserMuenBeans.add(homeUserMuenBean7);



        HomeUserMuenBean homeUserMuenBean8=new HomeUserMuenBean();
        homeUserMuenBean8.setImage(R.drawable.user_about);
        homeUserMuenBean8.setTitle("关于起飞线");
        homeUserMuenBeans.add(homeUserMuenBean8);
    }




}
