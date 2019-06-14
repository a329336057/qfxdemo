package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qifeixianapp.qfxdemo.Adapter.Bean.HomeThemeBean;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.List;

public class HomeThemeAdapter extends RecyclerView.Adapter<HomeThemeAdapter.ViewHolder> {
    List<HomeThemeBean> homeThemeBeans;
    Context context;
    public HomeThemeAdapter(Context context,List<HomeThemeBean> homeThemeBeans){
        this.homeThemeBeans=homeThemeBeans;
        this.context=context;
    }

    @NonNull
    @Override
    public HomeThemeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_home_theme_adapter,viewGroup,false);
        final HomeThemeAdapter.ViewHolder viewHolder=new HomeThemeAdapter.ViewHolder(v);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(context,"点击了"+viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeThemeAdapter.ViewHolder viewHolder, int i) {

        viewHolder.image.setImageResource(homeThemeBeans.get(i).getUrl());
       // Glide.with(context).load(homeThemeBeans.get(i).getUrl()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return homeThemeBeans.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        public  ViewHolder(View v){
            super(v);
            image=v.findViewById(R.id.home_theme_image);

        }
    }
}
