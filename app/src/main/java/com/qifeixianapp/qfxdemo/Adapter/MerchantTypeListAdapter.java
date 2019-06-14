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
import com.qifeixianapp.qfxdemo.Adapter.Bean.MerchantListBean;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.List;

public class MerchantTypeListAdapter extends RecyclerView.Adapter<MerchantTypeListAdapter.ViewHolder> {
    List<MerchantListBean> merchantListBeans;
    Context context;
    public MerchantTypeListAdapter(Context context,List<MerchantListBean> merchantListBeans){
        this.merchantListBeans=merchantListBeans;
        this.context=context;
    }

    @NonNull
    @Override
    public MerchantTypeListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.merchant_list_adapter,viewGroup,false);
        final MerchantTypeListAdapter.ViewHolder viewHolder=new MerchantTypeListAdapter.ViewHolder(v);
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
    public void onBindViewHolder(@NonNull MerchantTypeListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.titel.setText(merchantListBeans.get(i).getTitle());
        viewHolder.Consumption.setText(merchantListBeans.get(i).getConsumption());
        viewHolder.Host.setText(merchantListBeans.get(i).getHost());
        viewHolder.image.setImageResource(merchantListBeans.get(i).getImages());
    }

    @Override
    public int getItemCount() {
        return merchantListBeans.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView titel;
        TextView Consumption;
        TextView Host;
        ImageView image;
        public  ViewHolder(View v){
            super(v);
            image=v.findViewById(R.id.merchant_list_image1);
            titel=v.findViewById(R.id.merchant_list_title);
            Consumption=v.findViewById(R.id.merchant_list_Consumption);
            Host=v.findViewById(R.id.merchant_list_host);
        }
    }
}