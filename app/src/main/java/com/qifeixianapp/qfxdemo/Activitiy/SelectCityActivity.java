package com.qifeixianapp.qfxdemo.Activitiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qifeixianapp.qfxdemo.Adapter.SelctCityTileAdapter;
import com.qifeixianapp.qfxdemo.Bean.CityBeans;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.SharedPreferencesUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SelectCityActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView mLocaltion;

    List<CityBeans.CityBean> cityBeans=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
        try { find(); } catch (IOException e) { e.printStackTrace(); }
    }
    InputStream inputStream=null;
    private void find() throws IOException {
        mLocaltion=findViewById(R.id.City_CityText);
        SharedPreferencesUtil.getInstance(SelectCityActivity.this,"homedata");
        SharedPreferencesUtil.getData("localtion","默认定位到重庆");
        try {
            inputStream=getAssets().open("city.json");
            inputStream = getAssets().open("city.json");
            String teachersData = convertStraemToString(inputStream);
            Gson gson = new Gson();
            CityBeans listBean = gson.fromJson(teachersData, CityBeans.class);
            cityBeans=listBean.getCity();

        } catch (IOException e) { e.printStackTrace(); }

        recyclerView=findViewById(R.id.City_RecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SelectCityActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        SelctCityTileAdapter selctCityTileAdapter=new SelctCityTileAdapter(SelectCityActivity.this,cityBeans);
        recyclerView.setAdapter(selctCityTileAdapter);

    }

    //JSON转string
    public String convertStraemToString(InputStream inputStream){

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;

        try {
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return  stringBuilder.toString();
    }

}
