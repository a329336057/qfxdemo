package com.qifeixianapp.qfxdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qifeixianapp.qfxdemo.Homes.MainsHome;

public class MainActivity extends AppCompatActivity {
    Button mGetinto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGetinto=findViewById(R.id.getinto);
        ongetinto();
    }

    private void ongetinto() {
        mGetinto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, MainsHome.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });
    }
}
