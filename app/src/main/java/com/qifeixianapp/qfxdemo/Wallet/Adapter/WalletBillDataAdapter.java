package com.qifeixianapp.qfxdemo.Wallet.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.Wallet.Bean.WalletBillBean;
import com.qifeixianapp.qfxdemo.Wallet.Bean.WalletBillDataBean;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.List;

public class WalletBillDataAdapter extends RecyclerView.Adapter<WalletBillDataAdapter.ViewHolder> {
    List<WalletBillDataBean> walletBillDataBeans;

    Context context;

    public WalletBillDataAdapter(Context context,List<WalletBillDataBean> walletBillDataBeans){
        this.walletBillDataBeans=walletBillDataBeans;
        this.context=context;
    }

    @NonNull
    @Override
    public WalletBillDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_user_wallet_bill_data_adapter,viewGroup,false);
        final WalletBillDataAdapter.ViewHolder viewHolder=new WalletBillDataAdapter.ViewHolder(v);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WalletBillDataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(walletBillDataBeans.get(i).getTitle());
        viewHolder.phone.setText(walletBillDataBeans.get(i).getPhone());
        viewHolder.time.setText(walletBillDataBeans.get(i).getTime());
        viewHolder.moneny.setText(walletBillDataBeans.get(i).getMoneny());
        viewHolder.icon.setImageResource(walletBillDataBeans.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return walletBillDataBeans.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,phone,time,moneny;
        ImageView icon;
        public  ViewHolder(View v){
            super(v);
            title=v.findViewById(R.id.wallet_title);
            phone=v.findViewById(R.id.wallet_phone);
            time=v.findViewById(R.id.wallet_time);
            moneny=v.findViewById(R.id.wallet_moneny);
            icon=v.findViewById(R.id.wallet_iamge);
        }
    }
}