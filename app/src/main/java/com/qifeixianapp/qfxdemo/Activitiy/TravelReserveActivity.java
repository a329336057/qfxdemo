package com.qifeixianapp.qfxdemo.Activitiy;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import android.support.design.widget.TabLayout;


import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TraveReserveDateBean;
import com.qifeixianapp.qfxdemo.Adapter.MyHomtTypePagerAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.fragment.ResversDateFragment;
import com.qifeixianapp.qfxdemo.tool.GetTImeDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TravelReserveActivity extends AppCompatActivity implements OnTitleBarListener {
    TabLayout mTableLayout;
    TitleBar mTitleBar;
    List<String> mTitleTable;
    List<TraveReserveDateBean> traveReserveDateBeans;
    List<Fragment> mFragmentList;
    ViewPager mViewPager;
    List<String> ListWeekTime;//获取月份得出周几数组  1日周几
    List<String> WeekList;//返回周几集合 该出发日期的周几
    List<Integer> MonthList;//月份集合
    List<Integer> DayToWeekTimeList; //1号集合

    List<TraveReserveDateBean> list=new ArrayList<>();  //传参fragment 请求 数组
    List<List<String>> MonthGoDayList; //获取每月的出发日期集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);
        instantate();
        operation();
            find();

    }

    private void instantate() {
        traveReserveDateBeans=new ArrayList<>();
        TraveReserveDateBean traveReserveDateBean=new TraveReserveDateBean();
        traveReserveDateBean.setTravelDate("2019-7-10 09:34:18");
        traveReserveDateBean.setAward("1314");
        traveReserveDateBean.setMoeny("2333");
        traveReserveDateBeans.add(traveReserveDateBean);

        TraveReserveDateBean traveReserveDateBean1=new TraveReserveDateBean();
        traveReserveDateBean1.setTravelDate("2019-7-20 09:34:18");
        traveReserveDateBean1.setAward("1314");
        traveReserveDateBean1.setMoeny("2333");
        traveReserveDateBeans.add(traveReserveDateBean1);

        TraveReserveDateBean traveReserveDateBean2=new TraveReserveDateBean();
        traveReserveDateBean2.setTravelDate("2019-8-30 09:34:18");
        traveReserveDateBean2.setAward("1314");
        traveReserveDateBean2.setMoeny("2333");
        traveReserveDateBeans.add(traveReserveDateBean2);

        TraveReserveDateBean traveReserveDateBean3=new TraveReserveDateBean();
        traveReserveDateBean3.setTravelDate("2019-9-1 09:34:18");
        traveReserveDateBean3.setAward("1314");
        traveReserveDateBean3.setMoeny("2333");
        traveReserveDateBeans.add(traveReserveDateBean3);

        TraveReserveDateBean traveReserveDateBean4=new TraveReserveDateBean();
        traveReserveDateBean4.setTravelDate("2019-9-12 09:34:18");
        traveReserveDateBean4.setAward("1314");
        traveReserveDateBean4.setMoeny("2333");
        traveReserveDateBeans.add(traveReserveDateBean4);

        TraveReserveDateBean traveReserveDateBean5=new TraveReserveDateBean();
        traveReserveDateBean5.setTravelDate("2019-10-13 09:34:18");
        traveReserveDateBean5.setAward("1314");
        traveReserveDateBean5.setMoeny("2333");
        traveReserveDateBeans.add(traveReserveDateBean5);


        TraveReserveDateBean traveReserveDateBean6=new TraveReserveDateBean();
        traveReserveDateBean6.setTravelDate("2019-10-14 09:34:18");
        traveReserveDateBean6.setAward("1314");
        traveReserveDateBean6.setMoeny("2333");
        traveReserveDateBeans.add(traveReserveDateBean6);

        TraveReserveDateBean traveReserveDateBean7=new TraveReserveDateBean();
        traveReserveDateBean7.setTravelDate("2019-10-22 09:34:18");
        traveReserveDateBean7.setAward("1314");
        traveReserveDateBean7.setMoeny("2333");
        traveReserveDateBeans.add(traveReserveDateBean7);

        TraveReserveDateBean traveReserveDateBean8=new TraveReserveDateBean();
        traveReserveDateBean8.setTravelDate("2019-11-22 09:34:18");
        traveReserveDateBean8.setAward("1314");
        traveReserveDateBean8.setMoeny("2333");
        traveReserveDateBeans.add(traveReserveDateBean8);
    }

    private void operation() {
        DayToWeekTimeList =new ArrayList<>();
        ListWeekTime=new ArrayList<>();
        MonthList=new ArrayList<>();
        WeekList=new ArrayList<>();
        mTableLayout=findViewById(R.id.Reserve_TabLayout);
        mTitleBar=findViewById(R.id.Reserve_bar);
        mFragmentList=new ArrayList<>();
        mTitleTable=new ArrayList<>();
        mTitleBar.setOnTitleBarListener(this);


        //获取月份
        for (int i = 0; i < traveReserveDateBeans.size(); i++) {
                Calendar calendar_Date=Calendar.getInstance();

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                 Date date = sdf.parse(traveReserveDateBeans.get(i).getTravelDate());
                calendar_Date.setTime(date);
                int weekMonth = calendar_Date.get(android.icu.util.Calendar.MONTH)+1;

                //判断是否是同一个月 判断是否不包含
                if(!MonthList.contains(weekMonth)) {

                    //根据日期 不包含则转化时间 单独对月份进行分组
                    calendar_Date.set(android.icu.util.Calendar.DAY_OF_MONTH,1);
                    MonthList.add(weekMonth); //获取传入数据的月份数组
                    SimpleDateFormat sdtime = new SimpleDateFormat("yyyy-MM-dd");
                    String dateStr = sdf.format(calendar_Date.getTime());
                    ListWeekTime.add(dateStr); //月份1日数组
                    Log.e("月份",calendar_Date.getTime().toString());
                }


            } catch (ParseException e) { e.printStackTrace(); }

        }
    }

    private void find()  {


        for (int i = 0; i <MonthList.size() ; i++) {
            String title=String.valueOf(MonthList.get(i));
            mTitleTable.add(title+"月");
        }
        //获取周几
        GetTImeDay getTImeDay=new GetTImeDay();
        String week = getTImeDay.getWeek();
        DayToWeekTimeList = getTImeDay.getListWeek(ListWeekTime);
        int j=0;
        for (int i = 0; i <traveReserveDateBeans.size() ; i++) {



            //获取当前月

            Calendar calendar_Date=Calendar.getInstance();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {


                Date date = sdf.parse(traveReserveDateBeans.get(i).getTravelDate());
                calendar_Date.setTime(date);
                int weekMonth = calendar_Date.get(android.icu.util.Calendar.MONTH) + 1;
                int mo=MonthList.get(j);
                if(mo==weekMonth){
                    list.add(traveReserveDateBeans.get(i));
                    Log.e("ASDASDASDSAD", MonthList.get(j)+"月有    "+traveReserveDateBeans.get(i).getTravelDate());

                    Calendar jcalendar_Date=Calendar.getInstance();
                    int size = traveReserveDateBeans.size();
                    //获取接下来的数据 下面一条是否循环结束
                    if(size!=1+i){
                        Date jdate = sdf.parse(traveReserveDateBeans.get(i+1).getTravelDate());
                        jcalendar_Date.setTime(jdate);
                        int jweekMonth = jcalendar_Date.get(android.icu.util.Calendar.MONTH) + 1;
                        if(mo!=jweekMonth){
                            mFragmentList.add(new ResversDateFragment(DayToWeekTimeList.get(j),list));
                            j++;

                            list=new ArrayList<>();
                           }
                    }else {
                        int g=i-j;
                        mFragmentList.add(new ResversDateFragment(DayToWeekTimeList.get(i-g),list));
                        list=new ArrayList<>();


                    }

                }else {
                    break;}

            } catch (ParseException e) { e.printStackTrace(); }

        }
        mViewPager=findViewById(R.id.Reserve_viewpager);
        mViewPager.setAdapter(new MyHomtTypePagerAdapter(getSupportFragmentManager(), TravelReserveActivity.this,mFragmentList,mTitleTable));
        mTableLayout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(MonthList.size());



    }

    @Override
    public void onLeftClick(View v) {
        finish();
    }

    @Override
    public void onTitleClick(View v) {

    }

    @Override
    public void onRightClick(View v) {

    }
}
