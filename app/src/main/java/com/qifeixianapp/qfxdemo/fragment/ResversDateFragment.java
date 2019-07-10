package com.qifeixianapp.qfxdemo.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TraveReserveDateBean;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelReserverDayBean;
import com.qifeixianapp.qfxdemo.Adapter.TravelResverListAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.GetTImeDay;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ResversDateFragment extends Fragment implements BaseQuickAdapter.OnItemClickListener {
    TextView t;
    Integer OnDayMonth;
    String d="";
    ImageView selectDay;
    ImageView tops;
    List<TravelReserverDayBean> travelReserverDayBeanList;
    List<TraveReserveDateBean> traveReserveDateBeans;
    RecyclerView mTravelReserveList;
    public ResversDateFragment(Integer OnDayMonth,List<TraveReserveDateBean> traveReserveDateBeans) {
        super();
        this.OnDayMonth=OnDayMonth;
        this.traveReserveDateBeans=traveReserveDateBeans;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v=inflater.inflate(R.layout.fragment_resvers_date, container, false);
      find(v);
      return v;
    }

    private void find(View v) {

        t=v.findViewById(R.id.texts);

        t.setText(String.valueOf(OnDayMonth));
        getinstant();
       mTravelReserveList=v.findViewById(R.id.travel_Reserve_List);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),7);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
       mTravelReserveList.setLayoutManager(gridLayoutManager);
        TravelResverListAdapter travelResverListAdapter=new TravelResverListAdapter(R.layout.travel_reser_datelist_adapter,travelReserverDayBeanList,getContext());
       mTravelReserveList.setAdapter(travelResverListAdapter);
       travelResverListAdapter.setOnItemClickListener(this);
       
    }

    private void getinstant() {
        
        travelReserverDayBeanList=new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            TravelReserverDayBean travelReserverDayBean =new TravelReserverDayBean();

            travelReserverDayBean.setDay(String.valueOf(i));
            travelReserverDayBean.setBills("1351");
            travelReserverDayBeanList.add(travelReserverDayBean);
        }
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        tops = view.findViewById(R.id.travel_Reserve_List_back);
        tops.setVisibility(View.INVISIBLE);

        selectDay.setVisibility(View.VISIBLE);
    }
}
