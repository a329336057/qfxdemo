package com.qifeixianapp.qfxdemo.Activitiy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.MyCountDownTimerUnit;

public class VerificationActivity extends AppCompatActivity {
    private EditText editText;
    private TextView[] textViews;
    private  static  int MAX=6;
    private  String InputCouent;
    private  TextView Resend;
    Button mVerification_confrim;
    Boolean isrsend=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        find();
        rensend();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                InputCouent = editText.getText().toString();
                for (int i = 0; i < MAX; i++) {
                    if(i<InputCouent.length()){
                        textViews[i].setText(String.valueOf(InputCouent.charAt(i)));
                        textViews[i].setTextColor(Color.parseColor("#000000"));
                    }else {
                        textViews[i].setText("");
                    }


                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void rensend() {
        Resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isrsend){
                    final MyCountDownTimerUnit myCountDownTimer = new MyCountDownTimerUnit(Resend,69,1);
                    Resend.setTextColor(Color.parseColor("#FEFEFE"));
                    myCountDownTimer.start();

                }else {

                }
            }
        });
        mVerification_confrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VerificationActivity.this, MainsHome.class);
                startActivity(intent);
            }
        });



    }

    private void find() {
        textViews = new TextView[MAX];
        //new倒计时对象,总共的时间,每隔多少秒更新一次时间
        Resend=findViewById(R.id.Verification_resend);
        mVerification_confrim=findViewById(R.id.Verification_confrim);
        textViews[0] = (TextView) findViewById(R.id.Verification_code1);
        textViews[1] = (TextView) findViewById(R.id.Verification_code2);
        textViews[2] = (TextView) findViewById(R.id.Verification_code3);
        textViews[3] = (TextView) findViewById(R.id.Verification_code4);
        textViews[4] = (TextView) findViewById(R.id.Verification_code5);
        textViews[5] = (TextView) findViewById(R.id.Verification_code6);
        editText = (EditText) findViewById(R.id.Verification_inputtext);
        editText.setCursorVisible(false);//隐藏光标

    }

}
