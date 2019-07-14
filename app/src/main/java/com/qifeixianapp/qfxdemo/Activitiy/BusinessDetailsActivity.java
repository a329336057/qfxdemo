package com.qifeixianapp.qfxdemo.Activitiy;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

public class BusinessDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView mExit,mPhoneTell;
    TextView mPhoneName;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_business_details);
        find();
    }

    private void find() {
        relativeLayout=findViewById(R.id.merchant_datalis_map);
        mExit=findViewById(R.id.merchant_datalis_exit);
        mPhoneName=findViewById(R.id.merchant_datalis_tell);
        mPhoneTell=findViewById(R.id.merchant_datalis_tellicon);
        mExit.setOnClickListener(this);
        mPhoneName.setOnClickListener(this);
        mPhoneTell.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);
    }
    public void callPhone(String str) {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + str));
        startActivity(intent);
    }
void opengaodemap(){
        try {
            double gdLatitude = 39.92848272;
            double gdLongitude = 116.39560823;
            String uri = String.format("amapuri://route/plan/?dlat=%s&dlon=%s&dname=B&dev=0&t=0",
                    gdLatitude, gdLongitude);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(uri));
            intent.setPackage("com.autonavi.minimap");
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            ToastUtils.show(BusinessDetailsActivity.this,"请安装高德地图");
        }



}

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.merchant_datalis_tellicon :  //拨打电话
           callPhone("17623882165");
           break;
        case   R.id.merchant_datalis_tell ://拨打电话
            callPhone("17623882165");
            break;
        case  R.id.merchant_datalis_exit://返回上一页
            BusinessDetailsActivity.this.finish();
            break;

        case R.id.merchant_datalis_map:
            opengaodemap();
            break;
        default:break;
    }
    }
}
