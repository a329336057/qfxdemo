package com.qifeixianapp.qfxdemo.Activitiy;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.blankj.utilcode.util.SDCardUtils;
import com.bumptech.glide.Glide;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.RealPathFromUriUtils;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmsActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView mListView;
    private SimpleAdapter sa;
    private List<Map<String, Object>> data;
    private List<String> images;
    private Button button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        initView();

  getImage();
        query();

    }
    private void getImage() {
        File scanner5Directory = new File("/storage/emulated/0/DCIM/Camera" );
        if (scanner5Directory.isDirectory()) {
            for (File file : scanner5Directory.listFiles()) {
                String path = file.getAbsolutePath();
                if (path.endsWith(".jpg") || path.endsWith(".jpeg") || path.endsWith(".png")) {
                    images.add(path);
                }
            }
        }else {
            ToastUtils.show(SmsActivity.this,"未能读取SD卡");
        }
        String url=images.get(0);
        Glide.with(SmsActivity.this).load(url).into(imageView);

    }

    private void initView() {
        button=findViewById(R.id.Sms_btn);
        button.setOnClickListener(this);
        data=new ArrayList<>();
        images=new ArrayList<>();
        imageView=findViewById(R.id.Sms_image);
    }


    private void query() {

        //读取所有短信
        Uri uri = Uri.parse("content://sms/");
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(uri, new String[]{"_id", "address", "body", "date", "type"}, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            int _id;
            String address;
            String body;
            String date;
            int type;
            while (cursor.moveToNext()) {
                Map<String, Object> map = new HashMap<String, Object>();
                _id = cursor.getInt(0);
                address = cursor.getString(1);
                body = cursor.getString(2);
                date = cursor.getString(3);
                type = cursor.getInt(4);
                map.put("names", body);

                Log.i("test", "_id=" + _id + " address=" + address + " body=" + body + " date=" + date + " type=" + type);
                data.add(map);

            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Sms_btn:

                break;
        }
    }
}
