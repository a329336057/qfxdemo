package com.qifeixianapp.qfxdemo.Activitiy;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.qifeixianapp.qfxdemo.Adapter.Bean.FansListBean;
import com.qifeixianapp.qfxdemo.Adapter.FansListAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.PicassoUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MyFansActivity extends AppCompatActivity implements OnTitleBarListener {
    ImageView mHedaimage;
    RecyclerView recyclerView;
    List<FansListBean> fansListBeans;
    TitleBar titleBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fans);
        find();
    }

    private void find() {
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(MyFansActivity.this);
        titleBar=findViewById(R.id.fans_bar);
        titleBar.setOnTitleBarListener(this);
        recyclerView=findViewById(R.id.fans_bill);
        mHedaimage=findViewById(R.id.fans_hedaimage);
        fansListBeans=new ArrayList<>();
        Picasso.with(MyFansActivity.this)
                .load("https://p3.ssl.qhimgs0.com/sdm/300_300_/t01cf43a844efd247f7.jpg")
                .transform(new PicassoUtil.CircleTransform())
                .into(mHedaimage);
        for (int i = 0; i < 40; i++) {
            FansListBean fansListBean=new FansListBean();
            fansListBean.setBusiness_income("+2154");
            fansListBean.setTime("2019-6-16 20:54:25");
            fansListBean.setUser("176****5241");
            fansListBeans.add(fansListBean);
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new FansListAdapter(MyFansActivity.this,fansListBeans));
        Calendar a=Calendar.getInstance();

    }

    @Override
    public void onLeftClick(View v) {
            MyFansActivity.this.finish();
    }

    @Override
    public void onTitleClick(View v) {

    }

    @Override
    public void onRightClick(View v) {

    }
}
