package com.qifeixianapp.qfxdemo.Wallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qifeixianapp.qfxdemo.Homes.adapter.HomeListPeripheraAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.Wallet.Adapter.WalletBillMonthAdapter;
import com.qifeixianapp.qfxdemo.Wallet.Bean.WalletBillBean;

import java.util.ArrayList;
import java.util.List;

public class WalletActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<WalletBillBean> walletBillBeans;
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
}
