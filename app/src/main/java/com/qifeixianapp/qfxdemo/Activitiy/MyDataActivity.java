package com.qifeixianapp.qfxdemo.Activitiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.PicassoUtil;
import com.squareup.picasso.Picasso;

public class MyDataActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydata);
        imageView=findViewById(R.id.user_data_image);
        Picasso.with(MyDataActivity.this)
                .load("https://p3.ssl.qhimgs0.com/sdm/300_300_/t01cf43a844efd247f7.jpg")
                .transform(new PicassoUtil.CircleTransform())
                .into(imageView);
    }
}
