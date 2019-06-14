package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Activitiy.BusinessDetailsActivity;
import com.qifeixianapp.qfxdemo.Adapter.Bean.HomeListperipheraBean;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.List;

public class HomeListPeripheraAdapter extends RecyclerView.Adapter<HomeListPeripheraAdapter.ViewHolder> {
    List<HomeListperipheraBean> homeListperipheraBeans;
    Context context;
    public HomeListPeripheraAdapter(Context context, List<HomeListperipheraBean> homeListperipheraBeans){
        this.homeListperipheraBeans=homeListperipheraBeans;
        this.context=context;
    }

    @NonNull
    @Override
    public HomeListPeripheraAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_home_list_recyclerview_adapter,viewGroup,false);
        final HomeListPeripheraAdapter.ViewHolder viewHolder=new HomeListPeripheraAdapter.ViewHolder(v);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(context,"点击了"+viewHolder.getAdapterPosition());
                Intent intent=new Intent(context, BusinessDetailsActivity.class);
                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeListPeripheraAdapter.ViewHolder viewHolder, int i) {
        viewHolder.id.setText(homeListperipheraBeans.get(i).getLv_id());
        viewHolder.image.setImageResource(homeListperipheraBeans.get(i).getLv_image());
        viewHolder.head.setImageResource(homeListperipheraBeans.get(i).getLv_head_portrait());
        viewHolder.placedeparture.setText(homeListperipheraBeans.get(i).getPlacedeparture());
        viewHolder.evaluate.setText(homeListperipheraBeans.get(i).getLv_evaluate());
        viewHolder.money.setText(homeListperipheraBeans.get(i).getLv_moneny());
        viewHolder.title.setText(homeListperipheraBeans.get(i).getLv_title());

    }

    @Override
    public int getItemCount() {
        return homeListperipheraBeans.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView title;
        ImageView image;
        TextView evaluate;
        ImageView head;
        TextView money;
        TextView placedeparture;
        public  ViewHolder(View v){
            super(v);
            head=v.findViewById(R.id.home_lvyou_list_head);
            title=v.findViewById(R.id.home_lvyou_list_title);
            image=v.findViewById(R.id.home_lvyou_list_back_back);
            money=v.findViewById(R.id.home_lvyou_list_money);
            id=v.findViewById(R.id.home_lvyou_list_id);
            placedeparture=v.findViewById(R.id.home_lvyou_list_placedeparture);
            evaluate=v.findViewById(R.id.home_lvyou_list_evaluate);

        }
    }
}
