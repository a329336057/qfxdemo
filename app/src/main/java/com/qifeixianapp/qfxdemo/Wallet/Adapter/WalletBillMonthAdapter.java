package com.qifeixianapp.qfxdemo.Wallet.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Homes.Bean.HomeMuenBean;
import com.qifeixianapp.qfxdemo.Homes.adapter.HomeListPeripheraAdapter;
import com.qifeixianapp.qfxdemo.Homes.adapter.HomeMuenAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.Wallet.Bean.WalletBillBean;
import com.qifeixianapp.qfxdemo.Wallet.Bean.WalletBillDataBean;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class WalletBillMonthAdapter extends RecyclerView.Adapter<WalletBillMonthAdapter.ViewHolder> {
    List<WalletBillBean> walletBillBeans;
    List<WalletBillDataBean> walletBillDataBeans;
    Context context;
    RecyclerView recyclerView;
    public WalletBillMonthAdapter(Context context,List<WalletBillBean> walletBillBeans){
        this.walletBillBeans=walletBillBeans;
        this.context=context;

        adddata();

    }

    private void adddata() {
        walletBillDataBeans=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            WalletBillDataBean walletBillDataBean= new WalletBillDataBean();
            walletBillDataBean.setImage(R.drawable.wallet_shop);
            walletBillDataBean.setTime("2019年6月14日");
            walletBillDataBean.setMoneny("+0.58");
            walletBillDataBean.setPhone("17835621654");
            walletBillDataBean.setTitle("泰国旅游返佣");
            walletBillDataBeans.add(walletBillDataBean);
        }
    }

    @NonNull
    @Override
    public WalletBillMonthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_user_wallet_bill_adapter,viewGroup,false);
        final WalletBillMonthAdapter.ViewHolder viewHolder=new WalletBillMonthAdapter.ViewHolder(v);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(context,"点击了"+viewHolder.getAdapterPosition());

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WalletBillMonthAdapter.ViewHolder viewHolder, int i) {
        viewHolder.month.setText(walletBillBeans.get(i).getMonth());
        viewHolder.profit.setText(walletBillBeans.get(i).getProfit());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView=viewHolder.recyclerView;
        recyclerView.setLayoutManager(linearLayoutManager);
        viewHolder.recyclerView.setAdapter(new WalletBillDataAdapter(context,walletBillDataBeans));
    }

    @Override
    public int getItemCount() {
        return walletBillBeans.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView month;
        TextView profit;
        RecyclerView recyclerView;
        public  ViewHolder(View v){
            super(v);
            month=v.findViewById(R.id.wallet_month);
            profit=v.findViewById(R.id.wallet_profit);
            recyclerView=v.findViewById(R.id.wallet_bill_data);
        }
    }
}