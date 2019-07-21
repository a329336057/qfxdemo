package com.qifeixianapp.qfxdemo.Activitiy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.Adapter.WalletBillMonthAdapter;
import com.qifeixianapp.qfxdemo.Adapter.Bean.WalletBillBean;

import java.util.ArrayList;
import java.util.List;

public class WalletActivity extends AppCompatActivity implements OnTitleBarListener,View.OnClickListener {
    RecyclerView recyclerView;
    List<WalletBillBean> walletBillBeans;
    TitleBar titleBar;
    Button mPresentationButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        find();
        recyclerViewsetting();
    }

    private void find() {
        recyclerView=findViewById(R.id.wallet_bill);
        walletBillBeans=new ArrayList<>();
        titleBar=findViewById(R.id.wallet_bar);
        mPresentationButton=findViewById(R.id.wallet_Presentation_Button);
        mPresentationButton.setOnClickListener(this);
        titleBar.setOnTitleBarListener(this);
        for (int i = 0; i <13 ; i++) {
            getinstant(i+1);
        }
    }

    private void getinstant(int month) {
        WalletBillBean walletBillBean =new WalletBillBean();
        walletBillBean.setMonth(month+"月");
        walletBillBean.setProfit("总收益：313131");
        walletBillBeans.add(walletBillBean);

    }
    private void recyclerViewsetting() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(WalletActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new WalletBillMonthAdapter(WalletActivity.this,walletBillBeans));
    }

    @Override
    public void onLeftClick(View v) {
        WalletActivity.this.finish();
    }

    @Override
    public void onTitleClick(View v) {

    }

    @Override
    public void onRightClick(View v) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.wallet_Presentation_Button:
                Intent integer =new Intent(WalletActivity.this,PresentationActivity.class);
                startActivity(integer);
                break;
        }

    }
}
