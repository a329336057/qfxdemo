package com.qifeixianapp.qfxdemo.Activitiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.UI.CustomFullScreenPopup;
import com.qifeixianapp.qfxdemo.fragment.TravelFragment;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import static java.security.AccessController.getContext;

public class VipActivity extends AppCompatActivity {

    Button mPayVIp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip);
        find();
    }

    private void find() {
        mPayVIp=findViewById(R.id.vip_pay);
        mPayVIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(VipActivity.this,"未做支付功能");


            }
        });
    }
}
