package com.qifeixianapp.qfxdemo.Activitiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.qifeixianapp.qfxdemo.Adapter.AwardListAdapter;
import com.qifeixianapp.qfxdemo.Adapter.Bean.AwardListBean;
import com.qifeixianapp.qfxdemo.Adapter.WalletBillMonthAdapter;
import com.qifeixianapp.qfxdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MyAwardActivity extends AppCompatActivity implements OnTitleBarListener {
    RecyclerView recyclerView;
    List<AwardListBean> awardListBeanList;
    TitleBar titleBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_award);
        find();
        recyclerViewsetting();
    }

    private void find() {
        awardListBeanList=new ArrayList<>();
        recyclerView=findViewById(R.id.award_list);
        titleBar=findViewById(R.id.award_bar);
        titleBar.setOnTitleBarListener(this);
        for (int i = 0; i <13 ; i++) {
            getdata();
        }

    }

    private void getdata() {
        AwardListBean awardListBean=new AwardListBean();
        awardListBean.setImage(R.drawable.wallet_shop);
        awardListBean.setTitle("下级注册返奖励金");
        awardListBean.setMoneny("+300");
        awardListBean.setTime("2019-6-14 14:20:34");
        awardListBeanList.add(awardListBean);
    }

    private void recyclerViewsetting() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MyAwardActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new AwardListAdapter(MyAwardActivity.this,awardListBeanList));
    }

    @Override
    public void onLeftClick(View v) {
        MyAwardActivity.this.finish();
    }

    @Override
    public void onTitleClick(View v) {

    }

    @Override
    public void onRightClick(View v) {

    }
}
