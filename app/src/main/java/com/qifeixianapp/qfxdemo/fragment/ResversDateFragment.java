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
import com.qifeixianapp.qfxdemo.Activitiy.TravelReserveActivity;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TraveReserveDateBean;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelReserverDayBean;
import com.qifeixianapp.qfxdemo.Adapter.TravelResverListAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.GetTImeDay;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ResversDateFragment extends Fragment implements BaseQuickAdapter.OnItemClickListener {
    TextView t;
    Integer OnDayMonth;
    int j=0;
    ImageView selectDay;

    List<TravelReserverDayBean> travelReserverDayBeanList;
    List<TraveReserveDateBean> traveReserveDateBeans;
    RecyclerView mTravelReserveList;
    Integer MothlistItem; //获取月份
    Integer mothday;//该月有多少天
    List<Integer> GoDaysList;
    Integer Year;
    //获取当前的 年份、月份、以及当前月份日期、该日期下的出发日期属性等
    public ResversDateFragment(Integer OnDayMonth,List<TraveReserveDateBean> traveReserveDateBeans,Integer MothlistItem,Integer mothday,Integer year) {
        super();
        this.OnDayMonth=OnDayMonth;
        this.traveReserveDateBeans=traveReserveDateBeans;
        this.MothlistItem=MothlistItem;
        this.mothday=mothday;
        this.Year=year;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View v=inflater.inflate(R.layout.fragment_resvers_date, container, false);
      find(v);
      return v;
    }

    private void find(View v) {
        GoDaysList=new ArrayList<>();
        t=v.findViewById(R.id.texts);

        t.setText(String.valueOf(OnDayMonth));
        for (int i = 0; i <traveReserveDateBeans.size() ; i++) {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date jdate = null;
            Calendar jcalendar_Date=Calendar.getInstance();
            try { jdate = sdf.parse(traveReserveDateBeans.get(i).getTravelDate()); } catch (ParseException e) { e.printStackTrace(); }
            jcalendar_Date.setTime(jdate);
            GoDaysList.add(jcalendar_Date.get(android.icu.util.Calendar.DAY_OF_MONTH));
        }
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

        int g=0;
        for (int i = 0; i <42; i++) {
            TravelReserverDayBean travelReserverDayBean =new TravelReserverDayBean();
            if(OnDayMonth<=i){
                    j++;
                    travelReserverDayBean.setDay(String.valueOf(j));
                    travelReserverDayBean.setBills("");
                    if(j>mothday){
                        break;
                    }
            if(GoDaysList.contains(j)){
                travelReserverDayBean.setBills(traveReserveDateBeans.get(g).getAward());
                g++;
            }
            }else {
                travelReserverDayBean.setDay("");
                travelReserverDayBean.setBills("");
            }

            travelReserverDayBeanList.add(travelReserverDayBean);
        }
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        int item=position;
        //判断当前选择的点击不是同一个item  或从未选择则触发背景显示  且不是同一月份
        if(position!= TravelReserveActivity.lastitem ||TravelReserveActivity.lastitem==1000 || TravelReserveActivity.SelectMoth!=MothlistItem){

            TextView textView=view.findViewById(R.id.travel_Reserve_List_text);
            TextView day=view.findViewById(R.id.travel_Reserve_List_Button);
                 //判断附属抵扣是否为空
                if(textView.getText()!=""){
                    //判断是否不在日期内
                    if(TravelReserveActivity.LASTITEM!=null){
                        TravelReserveActivity.LASTITEM.setVisibility(View.INVISIBLE);
                    }

                    //在日期内则显示
                    TravelReserveActivity.SelectDay.setText("出发日期:"+Year+"年"+MothlistItem+"月"+day.getText()+"日出发");
                    selectDay=view.findViewById(R.id.travel_Reserve_List_back);
                    selectDay.setVisibility(View.VISIBLE);

                    TravelReserveActivity.lastitem=position;
                    TravelReserveActivity.LASTITEM=selectDay;
                }

        }




    }
    @Override
        public void setUserVisibleHint(boolean isVisibleToUser) {
     // TODO Auto-generated method stub
         if (isVisibleToUser) {
        //fragment可见时加载数据，用一个方法来实现
            } else {
                //不可见时不执行操作
                }
                super.setUserVisibleHint(isVisibleToUser);
        }
}
