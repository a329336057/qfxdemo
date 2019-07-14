package com.qifeixianapp.qfxdemo.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Activitiy.MailListActivity;
import com.qifeixianapp.qfxdemo.Activitiy.MyAwardActivity;
import com.qifeixianapp.qfxdemo.Activitiy.MyDataActivity;
import com.qifeixianapp.qfxdemo.Activitiy.VipActivity;
import com.qifeixianapp.qfxdemo.Adapter.Bean.HomeUserMuenBean;
import com.qifeixianapp.qfxdemo.Adapter.UserMuenAdapter;
import com.qifeixianapp.qfxdemo.Activitiy.LoginActivity;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.Activitiy.WalletActivity;

import java.util.ArrayList;
import java.util.List;


public class UserFragment extends Fragment  {
    RecyclerView mRecyclerView;
    ImageView mbtton,mMydata;
    TextView mMywallet,mMywalletNumber,mMyAward,mMyAwards,mDayfanli,mMdayfanlis,mNickName;
    List<HomeUserMuenBean> homeUserMuenBeans;
    Button mVipButton;
RelativeLayout relativeLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_user, container, false);
        find(v);
        Onclick();
        recyclerViewSetting();
        return  v;
    }

    private void Onclick() {
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
    mMyAward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getContext(), MyAwardActivity.class);
                startActivity(intent); }
    });
    mMydata.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getContext(), MyDataActivity.class);
            startActivity(intent);
        }
    });
    mMyAwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MyAwardActivity.class);
                startActivity(intent); }
    });
    mDayfanli.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getContext(), WalletActivity.class);
            startActivity(intent);
        }
    });
    mMdayfanlis.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getContext(), WalletActivity.class);
            startActivity(intent);
        }
    });
    mNickName.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
        }
    });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MailListActivity.class);
                startActivity(intent);
            }
        });
        mVipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), VipActivity.class);
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
        mVipButton=v.findViewById(R.id.user_vip);
        relativeLayout=v.findViewById(R.id.user_MyMail);
        mNickName=v.findViewById(R.id.user_vip_name);
        mDayfanli=v.findViewById(R.id.user_dayfanli);
        mMdayfanlis=v.findViewById(R.id.user_dayfanlis);
        mMydata=v.findViewById(R.id.user_setup);
        mRecyclerView=v.findViewById(R.id.user_muen_RecyclerView);
        mbtton=v.findViewById(R.id.user_icon);
        mMywallet=v.findViewById(R.id.user_myWallet);
        mMywalletNumber=v.findViewById(R.id.user_myWalletnumber);
        mMyAward=v.findViewById(R.id.user_awards);
        mMyAwards=v.findViewById(R.id.user_awards1);
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
        homeUserMuenBean.setTitle("我的钱包");
        homeUserMuenBeans.add(homeUserMuenBean);


        HomeUserMuenBean homeUserMuenBean1=new HomeUserMuenBean();
        homeUserMuenBean1.setImage(R.drawable.user_order);
        homeUserMuenBean1.setTitle("旅游订单");
        homeUserMuenBeans.add(homeUserMuenBean1);


        HomeUserMuenBean homeUserMuenBean2=new HomeUserMuenBean();
        homeUserMuenBean2.setImage(R.drawable.user_relationship);
        homeUserMuenBean2.setTitle("我的粉丝");
        homeUserMuenBeans.add(homeUserMuenBean2);


        HomeUserMuenBean homeUserMuenBean3=new HomeUserMuenBean();

        homeUserMuenBean3.setImage(R.drawable.user_message);
        homeUserMuenBean3.setTitle("商家入驻");

        homeUserMuenBeans.add(homeUserMuenBean3);



        HomeUserMuenBean homeUserMuenBean4=new HomeUserMuenBean();
        homeUserMuenBean4.setImage(R.drawable.user_collection);
        homeUserMuenBean4.setTitle("联系客服");
        homeUserMuenBeans.add(homeUserMuenBean4);




        HomeUserMuenBean homeUserMuenBean5=new HomeUserMuenBean();
        homeUserMuenBean5.setImage(R.drawable.user_browse);
        homeUserMuenBean5.setTitle("关于起飞线");
        homeUserMuenBeans.add(homeUserMuenBean5);





    }




}
