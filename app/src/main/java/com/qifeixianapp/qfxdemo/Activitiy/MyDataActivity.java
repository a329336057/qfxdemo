package com.qifeixianapp.qfxdemo.Activitiy;

import android.app.Activity;
import android.service.autofill.UserData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
import com.qifeixianapp.qfxdemo.tool.ToastUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyDataActivity extends AppCompatActivity implements View.OnClickListener, OnTitleBarListener {

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
        mNickNameEditText=findViewById(R.id.user_data_nickname);
        mHeadImageLayout=findViewById(R.id.userdata_list_headimage);
        mNameEditText=findViewById(R.id.user_data_name);
        mPhoneLayout=findViewById(R.id.userdata_list_phone);
        mHostLayout=findViewById(R.id.userdata_list_host);
        mGenderLyaout=findViewById(R.id.userdata_list_gender);
        mOccupationLayout=findViewById(R.id.userdata_list_occupation);

        //text
        mPhoneText=findViewById(R.id.user_data_phone);
        mHostText=findViewById(R.id.user_data_host);
        mOccupationText=findViewById(R.id.user_data_occupation);
        mGenderText=findViewById(R.id.userdata_list_gendereditext);



        headimage=findViewById(R.id.user_data_image);

        mWeixinEditText=findViewById(R.id.user_data_weixin);

        titleBar=findViewById(R.id.userdata_bar);
        gendrList=new ArrayList<>();


        titleBar.setOnTitleBarListener(this);
        mPhoneLayout.setOnClickListener(this);
        mGenderLyaout.setOnClickListener(this);
        mHeadImageLayout.setOnClickListener(this);
        headimage.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.userdata_list_headimage:
                ToastUtils.show(MyDataActivity.this,"点击了他");
                break;
            case R.id.userdata_list_phone:
                ToastUtils.show(MyDataActivity.this,"进入手机设置页面 暂未做");
                break;
            case R.id.user_data_image:
                ToastUtils.show(MyDataActivity.this,"天下无双");
                break;
            case R.id.userdata_list_gender://性别选择
                gendrList.clear();
                gendrList= SelectDataUtil.GenderList();
                OptionsPickerView pickerView=new OptionsPickerBuilder(MyDataActivity.this, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        String gender=gendrList.get(options1);
                        mGenderText.setText(gender);
                    }
                }).build();
        pickerView.setPicker(gendrList);
        pickerView.setSelectOptions(20);
        pickerView.show();
                break;
                default: break;

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
