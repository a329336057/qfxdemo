package com.qifeixianapp.qfxdemo.Activitiy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qifeixianapp.qfxdemo.Adapter.MerchantTypeListAdapter;
import com.qifeixianapp.qfxdemo.Adapter.Bean.MerchantListBean;
import com.qifeixianapp.qfxdemo.R;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class MerchantListctivity  extends AppCompatActivity {
    List<MerchantListBean> merchantListBeans;
    RecyclerView mMerchantRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_listctivity);
        find();
        recyclerListsetting();


    }

    private void recyclerListsetting() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MerchantListctivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //    mRecyclerViewList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));//横线
        mMerchantRecyclerView.setLayoutManager(linearLayoutManager);
        mMerchantRecyclerView.setItemAnimator(new SlideInLeftAnimator());
        mMerchantRecyclerView.setAdapter(new MerchantTypeListAdapter(MerchantListctivity.this,merchantListBeans));
    }

    private void find() {
        mMerchantRecyclerView=findViewById(R.id.merchant_list_recyclerview);
        merchantListBeans=new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            MerchantListBean merchantListBean=new MerchantListBean();
            merchantListBean.setConsumption("人均消费18元");
            merchantListBean.setHost("重庆 石油路 龙湖时代天街");
            merchantListBean.setImages(R.drawable.merhant2);
            merchantListBean.setTitle("有一家好店");
            merchantListBeans.add(merchantListBean);
        }
    }
}
