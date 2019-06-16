package com.qifeixianapp.qfxdemo.Activitiy;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int recLen = 5;//跳过倒计时提示5秒
    RelativeLayout relativeLayout;
    private TextView tv;
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;

        //设置当前窗体为全屏显示
        getWindow().setFlags(flag, flag);
        setContentView(R.layout.activity_main);

        timer.schedule(task,1000,1000);

        handler=new Handler();
        handler.postDelayed(runnable=new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainsHome.class);
                startActivity(intent);
                finish();
            }
        },5000);
        find();

    }

    private void find() {

        tv=findViewById(R.id.main_count_down);
        relativeLayout = findViewById(R.id.main_countdown_back);//跳过
        relativeLayout.setOnClickListener(this);//跳过监听
    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() { // UI thread
                @Override
                public void run() {
                    recLen--;
                    tv.setText("点击跳过 " + recLen);
                    if (recLen < 0) {
                        timer.cancel();
                        tv.setVisibility(View.GONE);//倒计时到0隐藏字体
                    }
                }
            });
        }
    };


//        mGetinto.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, MainsHome.class);
//                startActivity(intent);
//                MainActivity.this.finish();
//            }
//        });


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_countdown_back:
                //从闪屏界面跳转到首界面
                Intent intent = new Intent(MainActivity.this, MainsHome.class);
                startActivity(intent);
                finish();
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
                break;
            default:
                break;
        }
    }


}

