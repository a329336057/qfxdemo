package com.qifeixianapp.qfxdemo.Activitiy;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int recLen = 5;//跳过倒计时提示5秒
    RelativeLayout relativeLayout;
    private TextView tv;
    Timer timer = new Timer();
    private Handler handler;
    private Runnable runnable;
    public static final int   REQ_CODE_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;

//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.LOCATION_HARDWARE}, 6);
//
//        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.READ_CONTACTS,Manifest.permission.READ_SMS,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE, },
                    6);//自定义的code
        }

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

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        switch (requestCode) {
            case 6:
                if (grantResults != null && permissions != null) {
                    for (int i = 0; i < grantResults.length; i++) {
                        Log.d("123", "grantResults[" + i + "]:" + grantResults[i]);
                        Log.d("2131231", "permissions[" + i + "]:" + permissions[i]);
                    }
                }

                break;
        }
    }
}

