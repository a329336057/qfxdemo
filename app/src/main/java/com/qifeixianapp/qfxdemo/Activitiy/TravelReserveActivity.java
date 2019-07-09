package com.qifeixianapp.qfxdemo.Activitiy;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import android.support.design.widget.TabLayout;


import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.qifeixianapp.qfxdemo.Adapter.MyHomtTypePagerAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.fragment.ResversDateFragment;

import java.util.ArrayList;
import java.util.List;

public class TravelReserveActivity extends AppCompatActivity implements OnTitleBarListener {
    TabLayout mTableLayout;
    TitleBar mTitleBar;
    List<String> mTitleTable;
    List<Fragment> mFragmentList;
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
        find();
    }

    private void find() {
        mTableLayout=findViewById(R.id.Reserve_TabLayout);
        mTitleBar=findViewById(R.id.Reserve_bar);
        mFragmentList=new ArrayList<>();
        mTitleTable=new ArrayList<>();
        mTitleBar.setOnTitleBarListener(this);
        mTitleTable.add("5月");
        mTitleTable.add("6月");
        mTitleTable.add("7月");
        mTitleTable.add("8月");
        mTitleTable.add("9月");
        mViewPager=findViewById(R.id.Reserve_viewpager);
        mFragmentList.add(new ResversDateFragment());
        mFragmentList.add(new ResversDateFragment());
        mFragmentList.add(new ResversDateFragment());
        mFragmentList.add(new ResversDateFragment());
        mFragmentList.add(new ResversDateFragment());
        mViewPager.setAdapter(new MyHomtTypePagerAdapter(getSupportFragmentManager(),TravelReserveActivity.this,mFragmentList,mTitleTable));
        mTableLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onLeftClick(View v) {
        finish();
    }

    @Override
    public void onTitleClick(View v) {

    }

    @Override
    public void onRightClick(View v) {

    }
}
