package com.qifeixianapp.qfxdemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelEndSheetListBean;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelListBean;
import com.qifeixianapp.qfxdemo.Adapter.TravelEndSheetAdapter;
import com.qifeixianapp.qfxdemo.Adapter.TravelPeripheralApdater;
import com.qifeixianapp.qfxdemo.R;

import java.util.ArrayList;
import java.util.List;

import static com.chad.library.adapter.base.BaseQuickAdapter.SCALEIN;


public class TravelEndSheetFragment extends Fragment {
RecyclerView recyclerView;
List<TravelEndSheetListBean> listBeans;
String time="2019-7-7 22:05:22";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_travel_end_sheet, container, false);
        find(v);
        return v;
    }

    private void find(View v) {
        listBeans=new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            TravelEndSheetListBean travelListBean=new TravelEndSheetListBean();
            travelListBean.setAward("+"+"80");
            travelListBean.setTitle("昆明+大理+丽江+玉龙雪山冰川大索道双飞一动6日跟团游");
            travelListBean.setMoney("80020"+"起/人");
            travelListBean.setIamgeurl("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1920985182,1866518500&fm=26&gp=0.jpg");
            listBeans.add(travelListBean);
        }

        recyclerView=v.findViewById(R.id.Travel_List_End_Sheet_RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        TravelEndSheetAdapter travelEndSheetFragment=new TravelEndSheetAdapter(R.layout.fragment_travel_end_sheet_list,listBeans,getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(travelEndSheetFragment);
        travelEndSheetFragment.openLoadAnimation(SCALEIN);
        travelEndSheetFragment.isFirstOnly(true);

    }


}
