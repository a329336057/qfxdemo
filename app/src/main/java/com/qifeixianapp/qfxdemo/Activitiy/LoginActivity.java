package com.qifeixianapp.qfxdemo.Activitiy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

public class LoginActivity extends AppCompatActivity {
    Button mVerification;
    TextView mTextPhone;
    boolean isLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        find();

        mTextPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(mTextPhone.length()>=11){
                    mVerification.setBackgroundResource(R.drawable.login_verificantion_true);
                    mVerification.setTextColor(Color.parseColor("#1F1E1E"));
                    mVerification.setText("下一步，接收验证码");
                    isLogin=true;

                }else {
                    mVerification.setBackgroundResource(R.drawable.login_verification);
                    mVerification.setTextColor(Color.parseColor("#767575"));
                    mVerification.setText("下一步，接收验证码");
                    isLogin=false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isLogin){
                    Intent intent=new Intent(LoginActivity.this, VerificationActivity.class);
                    startActivity(intent);
                }else {
                    ToastUtils.show(LoginActivity.this,"请填写完整的手机号哦 飞飞");
                }
            }
        });
    }


    private void find() {
        mVerification=findViewById(R.id.login_verification);
        mTextPhone=findViewById(R.id.login_phone);
    }

}
