package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Adapter.Bean.FansListBean;
import com.qifeixianapp.qfxdemo.Adapter.Bean.HomeThemeBean;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import org.w3c.dom.Text;

import java.util.List;

public class FansListAdapter  extends RecyclerView.Adapter<FansListAdapter.ViewHolder> {
    List<FansListBean> fansListBeans;
    Context context;
    public FansListAdapter(Context context,List<FansListBean> fansListBeans){
        this.fansListBeans=fansListBeans;
        this.context=context;
    }

    @NonNull
    @Override
    public FansListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fans_list_apdapter,viewGroup,false);
        final FansListAdapter.ViewHolder viewHolder=new FansListAdapter.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FansListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.user.setText(fansListBeans.get(i).getUser());
        viewHolder.time.setText(fansListBeans.get(i).getTime());
        viewHolder.business_income.setText(fansListBeans.get(i).getBusiness_income());
        // Glide.with(context).load(homeThemeBeans.get(i).getUrl()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return fansListBeans.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView time,business_income,user;
        public  ViewHolder(View v){
            super(v);
            time=v.findViewById(R.id.fans_time);
            business_income=v.findViewById(R.id.fans_business_income);
            user=v.findViewById(R.id.fans_user);

        }
    }
}