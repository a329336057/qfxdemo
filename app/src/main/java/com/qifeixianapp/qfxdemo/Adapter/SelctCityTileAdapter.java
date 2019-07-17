package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qifeixianapp.qfxdemo.Activitiy.BusinessDetailsActivity;
import com.qifeixianapp.qfxdemo.Activitiy.SelectCityActivity;
import com.qifeixianapp.qfxdemo.Adapter.Bean.MerchantListBean;
import com.qifeixianapp.qfxdemo.Bean.CityBeans;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.Collections;
import java.util.List;

public class SelctCityTileAdapter extends RecyclerView.Adapter<SelctCityTileAdapter.ViewHolder> {
    List<CityBeans.CityBean> cityBeanListt;
    Context context;
    public SelctCityTileAdapter(Context context,  List<CityBeans.CityBean>  cityBeanListt){
        this.cityBeanListt=cityBeanListt;
        this.context=context;
    }

    @NonNull
    @Override
    public SelctCityTileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city_select_list_dapter,viewGroup,false);
        final SelctCityTileAdapter.ViewHolder viewHolder=new SelctCityTileAdapter.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SelctCityTileAdapter.ViewHolder viewHolder, int i) {
        viewHolder.titel.setText(cityBeanListt.get(i).getTitle());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        viewHolder.recyclerView.setLayoutManager(linearLayoutManager);
        SelectCityListAdapter selctCityTileAdapter=new SelectCityListAdapter(context,cityBeanListt.get(i).getLists());
        viewHolder.recyclerView.setAdapter(selctCityTileAdapter);
    }

    @Override
    public int getItemCount() {
        return cityBeanListt.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView titel;
        RecyclerView recyclerView;
        public  ViewHolder(View v){
            super(v);
            recyclerView=v.findViewById(R.id.City_List_RecyclerView);
            titel=v.findViewById(R.id.City_list_title);

        }
    }
}
