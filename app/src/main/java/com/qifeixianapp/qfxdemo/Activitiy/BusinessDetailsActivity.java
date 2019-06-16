package com.qifeixianapp.qfxdemo.Activitiy;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.qifeixianapp.qfxdemo.R;

public class BusinessDetailsActivity extends AppCompatActivity {
    ImageView mIext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_details);
        find();
    }

    private void find() {
        mIext=findViewById(R.id.merchant_datalis_exit);
        mIext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusinessDetailsActivity.this.finish();
            }
        });
    }
}
