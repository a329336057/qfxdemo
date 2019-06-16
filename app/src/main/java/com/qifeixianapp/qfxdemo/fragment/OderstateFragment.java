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

import com.qifeixianapp.qfxdemo.Adapter.Bean.OrderStateListBean;
import com.qifeixianapp.qfxdemo.Adapter.OderStateListAdapter;
import com.qifeixianapp.qfxdemo.R;

import java.util.ArrayList;
import java.util.List;


public class OderstateFragment extends Fragment {

List<OrderStateListBean> listBeanList;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_oderstate, container, false);
        find(v);
        return v;
    }

    private void find(View v) {
        listBeanList=new ArrayList<>();
        recyclerView=v.findViewById(R.id.order_recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());

        for (int i = 0; i <20; i++) {
            OrderStateListBean orderStateListBean=new OrderStateListBean();
            orderStateListBean.setMoneny("2300+300");
            orderStateListBean.setIamgeurl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560683877454&di=37aa1a7f05f5500b90eb4100a50569bf&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fblog%2F201404%2F24%2F20140424153000_njnLA.jpeg");
            orderStateListBean.setOrderunmber("cq1579879798789");
            orderStateListBean.setTitle(" 昆明+大理+丽江+玉龙雪山冰川大索道双飞一动6日跟团游");
            orderStateListBean.setOuttime("出发时间：2019-5-15");
            orderStateListBean.setRen(i+"人");
            listBeanList.add(orderStateListBean);
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new OderStateListAdapter(getContext(),listBeanList));
    }

}
