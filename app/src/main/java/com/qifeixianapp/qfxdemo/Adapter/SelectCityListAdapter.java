package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Activitiy.MainsHome;
import com.qifeixianapp.qfxdemo.Bean.CityBeans;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.SharedPreferencesUtil;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.List;

public class SelectCityListAdapter extends RecyclerView.Adapter<SelectCityListAdapter.ViewHolder> {
    List<String> cityNameList;
    Context context;
    public SelectCityListAdapter(Context context,   List<String>  cityNameList){
        this.cityNameList=cityNameList;
        this.context=context;
    }

    @NonNull
    @Override
    public SelectCityListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city_select_list_cityname_adapter,viewGroup,false);
        final SelectCityListAdapter.ViewHolder viewHolder=new SelectCityListAdapter.ViewHolder(v);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferencesUtil.getInstance(context,"homedata");
                SharedPreferencesUtil.putData("localtion",viewHolder.titel.getText().toString());
                SharedPreferencesUtil.putData("a",viewHolder.titel.getText().toString());
                SharedPreferencesUtil.putData("b",viewHolder.titel.getText().toString());
                Intent intent=new Intent(context, MainsHome.class);
                String data = (String)SharedPreferencesUtil.getData("localtion", "sad");

                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SelectCityListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.titel.setText(cityNameList.get(i));


    }

    @Override
    public int getItemCount() {
        return cityNameList.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView titel;

        public  ViewHolder(View v){
            super(v);
            titel=v.findViewById(R.id.City_list_bills_cityName);

        }
    }
}