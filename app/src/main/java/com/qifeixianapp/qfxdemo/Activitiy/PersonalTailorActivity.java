package com.qifeixianapp.qfxdemo.Activitiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

public class PersonalTailorActivity extends AppCompatActivity {
    CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_tailor);
       calendarView = (CalendarView) findViewById(R.id.vp_calendar);
        //calendarView 监听事件

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange( CalendarView view, int year, int month, int dayOfMonth) {
                //显示用户选择的日期
                ToastUtils.show(PersonalTailorActivity.this,String.valueOf(dayOfMonth));
            }
        });
    }
}
