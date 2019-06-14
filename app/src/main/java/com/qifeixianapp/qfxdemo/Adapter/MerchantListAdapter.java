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
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.List;

public class MerchantListAdapter  extends RecyclerView.Adapter<MerchantListAdapter.ViewHolder> {
        List<Integer> images;
        List<String> titel;
        List<String> Consumption;
        List<String> Host;
        Context context;
public MerchantListAdapter(Context context,List<String> titel,List<String> Consumption,List<String> Host,List<Integer> images){
        this.titel=titel;
        this.images=images;
        this.Consumption=Consumption;
        this.Host=Host;
        this.context=context;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.merchant_homelist_adapter,viewGroup,false);
final ViewHolder viewHolder=new ViewHolder(v);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        ToastUtils.show(context,"点击了"+viewHolder.getItemId());
      Intent intent=new Intent(context, BusinessDetailsActivity.class);
      context.startActivity(intent);

        }
        });
        return viewHolder;
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.titel.setText(titel.get(i));
        viewHolder.Consumption.setText(Consumption.get(i));
        viewHolder.Host.setText(Host.get(i));
        viewHolder.image.setImageResource(images.get(i));
        }

@Override
public int getItemCount() {
        return titel.size();
        }

static  class ViewHolder extends RecyclerView.ViewHolder{
    TextView titel;
    TextView Consumption;
    TextView Host;
    ImageView image;
    public  ViewHolder(View v){
        super(v);
        image=v.findViewById(R.id.merchant_home_image1);
        titel=v.findViewById(R.id.merchant_home_list_title);
        Consumption=v.findViewById(R.id.merchant_home_list_Consumption);
        Host=v.findViewById(R.id.merchant_home_list_host);
    }
}
}

