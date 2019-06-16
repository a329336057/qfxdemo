package com.qifeixianapp.qfxdemo.Activitiy;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.support.v7.widget.Toolbar;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.qifeixianapp.qfxdemo.Adapter.Bean.OrderStateListBean;
import com.qifeixianapp.qfxdemo.Adapter.MyHomtTypePagerAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.fragment.OderstateFragment;
import com.qifeixianapp.qfxdemo.tool.AppBarStateChangeListener;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener, OnTitleBarListener {
    ViewPager viewPager;
    TabLayout tabLayout;
    List<Fragment> fragmentList;
    List<String> titleTab;
    ImageView eixt;
    TitleBar titleBar;
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        find();
    }

    private void find() {
    viewPager=findViewById(R.id.order_viewpager);
        titleBar=findViewById(R.id.order_bar);
        appBarLayout=findViewById(R.id.app_bar_topic);
        tabLayout=findViewById(R.id.order_tab);
        fragmentList=new ArrayList<>();
        titleTab=new ArrayList<>();

        titleTab.add("全部");
        titleTab.add("待预定");
        titleTab.add("待确认");
        titleTab.add("待出行");
        titleTab.add("待评价");
        titleTab.add("待退款");
        titleTab.add("已完成");
        titleTab.add("已退款");

        fragmentList.add(new OderstateFragment());
        fragmentList.add(new OderstateFragment());
        fragmentList.add(new OderstateFragment());
        fragmentList.add(new OderstateFragment());
        fragmentList.add(new OderstateFragment());
        fragmentList.add(new OderstateFragment());
        fragmentList.add(new OderstateFragment());
        fragmentList.add(new OderstateFragment());
        fragmentList.add(new OderstateFragment());
    viewPager.setAdapter(new MyHomtTypePagerAdapter(getSupportFragmentManager(),OrderActivity.this,fragmentList,titleTab));
        tabLayout.setupWithViewPager(viewPager);
       // initappBar();
        titleBar.setOnTitleBarListener(this);

    }

    private void initappBar() {
        appBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if( state == State.EXPANDED ) {

                    toolbar.setBackgroundColor(Color.argb((int) 0, 0, 0, 0));
                    //展开状态
                }else if(state == State.COLLAPSED){

                    toolbar.setBackgroundColor(Color.argb((int) 255, 255, 255, 255));
                    //折叠状态
                }else {

                    toolbar.setBackgroundColor(Color.argb((int) 0, 0, 0, 0));
                    //中间状态
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onLeftClick(View v) {
        OrderActivity.this.finish();
    }

    @Override
    public void onTitleClick(View v) {

    }

    @Override
    public void onRightClick(View v) {

    }
}
