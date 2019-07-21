package com.qifeixianapp.qfxdemo.Activitiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.qifeixianapp.qfxdemo.R;

public class PresentationActivity extends AppCompatActivity implements OnTitleBarListener  {
    Button mPresentationButton;
    EditText mAlipayAccoutEdieText,mUsersEdieText,mMoneyEdieText;
    TextView mMoneyText,mMessageText;
    TitleBar titleBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);
        find();
    }

    private void find() {
        mAlipayAccoutEdieText=findViewById(R.id.Presentation_AlipayAccout_EdieText);
        mUsersEdieText=findViewById(R.id.Presentation_Users_EdieText);
        mMoneyEdieText=findViewById(R.id.Presentation_Money_EditText);
        titleBar=findViewById(R.id.Presentation_bar);
        mPresentationButton=findViewById(R.id.Presentation_Button);
        mMoneyText=findViewById(R.id.Presentation_Money_Text);
        mMessageText=findViewById(R.id.Presentation_Message);
        titleBar.setOnTitleBarListener(this);
        setmessage();
    }

    private void setmessage() {
        mMessageText.setText("\n" +
                " 一、提现次数:用户不限制提现次数,到账规则详见“提现周期\"规定\n" +
                "\n" +
                "二、提现金额:每笔提现最少提现0.1元 不限制额度。\n" +
                "\n" +
                "三、提现账户:个人中心所绑定的支付宝账户。\n" +
                "\n" +
                "四、提现须知:\n" +
                "1、受限于支付宝系统规则，请所有商户仔细核对提现帐号\n" +
                "3、提现周期为2000以下自动提现，2小时到账，2000以_上需审核，通过后到账\n" +
                "\n" +
                "五、提现费率\n" +
                "提现费率:提现免收手续费\n" +
                "\n" +
                "备注:如遇支付平台系统故障或网络故障,提现可能会稍有延迟，敬请谅解。\n" +
                "                        ");
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
