package com.qifeixianapp.qfxdemo.Activitiy;

import android.app.Activity;
import android.content.Intent;
import android.service.autofill.UserData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.PicassoUtil;
import com.qifeixianapp.qfxdemo.tool.SelectDataUtil;
import com.qifeixianapp.qfxdemo.tool.SharedPreferencesUtil;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyDataActivity extends AppCompatActivity implements View.OnClickListener, OnTitleBarListener {
    Button mSwitchingButton;
    private ImageView headimage;
    RelativeLayout mOccupationLayout,mHeadImageLayout,mPhoneLayout,mHostLayout,mGenderLyaout;
    TextView mHostText,mGenderText,mOccupationText,mPhoneText;
    EditText mWeixinEditText,mNickNameEditText,mNameEditText;
    TitleBar titleBar;
    List<String> gendrList;
    List<String> OccupationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydata);
        find();
        Picasso.with(MyDataActivity.this)
                .load("https://p3.ssl.qhimgs0.com/sdm/300_300_/t01cf43a844efd247f7.jpg")
                .transform(new PicassoUtil.CircleTransform())
                .into(headimage);

    }

    private void find() {
        mSwitchingButton=findViewById(R.id.userdata_switching_user_button);
        mNickNameEditText=findViewById(R.id.user_data_nickname);
        mHeadImageLayout=findViewById(R.id.userdata_list_headimage);
        mNameEditText=findViewById(R.id.user_data_name);
        mPhoneLayout=findViewById(R.id.userdata_list_phone);//text
        mPhoneText=findViewById(R.id.user_data_phone);
        headimage=findViewById(R.id.user_data_image);
        mWeixinEditText=findViewById(R.id.user_data_weixin);
        titleBar=findViewById(R.id.userdata_bar);
        gendrList=new ArrayList<>();
        titleBar.setOnTitleBarListener(this);
        mPhoneLayout.setOnClickListener(this);
        mHeadImageLayout.setOnClickListener(this);
        headimage.setOnClickListener(this);
        mSwitchingButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.userdata_list_headimage:
                Intent uploadintent=new Intent(MyDataActivity.this,UpLoadHeadImageActivity.class);
                startActivity(uploadintent);
                break;
            case R.id.userdata_list_phone:
                ToastUtils.show(MyDataActivity.this,"进入手机设置页面 暂未做");
                break;
            case R.id.user_data_image:
                ToastUtils.show(MyDataActivity.this,"天下无双");
                break;
                default: break;
            case R.id.userdata_switching_user_button:
                Intent intent=new Intent(MyDataActivity.this,LoginActivity.class);
                startActivity(intent);
        }
    }

    @Override
    public void onLeftClick(View v) {
        MyDataActivity.this.finish();
    }

    @Override
    public void onTitleClick(View v) {

    }

    @Override
    public void onRightClick(View v) {

    }
}
