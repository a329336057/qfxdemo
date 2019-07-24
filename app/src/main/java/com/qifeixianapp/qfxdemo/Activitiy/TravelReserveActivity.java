package com.qifeixianapp.qfxdemo.Activitiy;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import android.support.design.widget.TabLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TraveReserveDateBean;
import com.qifeixianapp.qfxdemo.Adapter.MyHomtTypePagerAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.fragment.ResversDateFragment;
import com.qifeixianapp.qfxdemo.tool.GetTImeDay;
import com.qifeixianapp.qfxdemo.tool.MonthOfDayUnit;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TravelReserveActivity extends AppCompatActivity implements OnTitleBarListener ,View.OnClickListener {

    public static RelativeLayout mTravelBillsRelativeLayout,mTravelReserveSelectRelativeLayout;
    public static TextView mTravelDateSelect,SelectAdult,SelectChildren;
    public static TextView SelectDay; //选择的日子
    ImageView mSelectAdultadd,mSelectAdultreduce,mSelectChildrenadd,mSelectChildrenreduce; //选择项 成人和儿童
    TabLayout mTableLayout;
    TitleBar mTitleBar;
    public  static ImageView LASTITEM; //上一次选择的背景
    public static Integer SelectMoth;  //当前月份
    List<String> mTitleTable;
    List<TraveReserveDateBean> traveReserveDateBeans;
    List<Fragment> mFragmentList;
    ViewPager mViewPager;
    List<String> ListWeekTime;//获取月份得出周几数组  1日周几
    List<String> WeekList;//返回周几集合 该出发日期的周几
    List<Integer> MonthList;//月份集合
    List<Integer> DayToWeekTimeList; //1号集合
    public  static Integer lastitem=1000;
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


        TraveReserveDateBean traveReserveDateBean9=new TraveReserveDateBean();
        traveReserveDateBean9.setTravelDate("2019-12-22 09:34:18");
        traveReserveDateBean9.setAward("1314");
        traveReserveDateBean9.setMoeny("2333");
        traveReserveDateBeans.add(traveReserveDateBean9);


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
                if(!MonthList.contains(weekMonth) ) {

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
        mTravelReserveSelectRelativeLayout=findViewById(R.id.Travel_Bills_Reserve_Select_RelativeLayout);
        mSelectAdultadd=findViewById(R.id.Travel_Reserve_Adult_add_EdteText);
        mSelectAdultreduce=findViewById(R.id.Travel_Reserve_Adult_reduce_EdteText);
        mSelectChildrenadd=findViewById(R.id.Travel_Reserve_Rhildren_add_EdteText);
        mSelectChildrenreduce=findViewById(R.id.Travel_Reserve_Rhildren_reduce_EdteText);
        mTravelBillsRelativeLayout=findViewById(R.id.Travel_Reserve_Bills_RelativeLayout);
        mTravelDateSelect=findViewById(R.id.Travel_Reserve_DateSelect);
        SelectDay=findViewById(R.id.Reserve_SelectDay);
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
                int weekMonth = calendar_Date.get(android.icu.util.Calendar.MONTH) + 1; //周月
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
                        int jweekMonth = jcalendar_Date.get(android.icu.util.Calendar.MONTH)+1;
                        if(mo!=jweekMonth){
                            int year=calendar_Date.get(Calendar.YEAR);
                            int moth=MonthList.get(j);
                            int mothday= MonthOfDayUnit.getMonthOfDays(year,moth);
                            mFragmentList.add(new ResversDateFragment(DayToWeekTimeList.get(j),list,MonthList.get(j),mothday,year));
                            j++;

                            list=new ArrayList<>();
                           }
                    }else {
                        int g=i-j;
                        int year=calendar_Date.get(Calendar.YEAR);
                        int mothday= MonthOfDayUnit.getMonthOfDays(year,mo);
                        mFragmentList.add(new ResversDateFragment(DayToWeekTimeList.get(i-g),list,MonthList.get(j),mothday,year));
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Travel_Reserve_Bills_RelativeLayout:
//条件选择器
                OptionsPickerView pvOptions = new OptionsPickerBuilder(TravelReserveActivity.this, new OnOptionsSelectListener() {

                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3 ,View v) {


                    }
                }).build();
                pvOptions.setPicker(new ArrayList());
                pvOptions.setSelectOptions(20);
                pvOptions.show();
                break;
        }
    }
}
