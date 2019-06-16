package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.qifeixianapp.qfxdemo.Adapter.Bean.AwardListBean;
import com.qifeixianapp.qfxdemo.Adapter.Bean.OrderStateListBean;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class OderStateListAdapter  extends RecyclerView.Adapter<OderStateListAdapter.ViewHolder> {
    List<OrderStateListBean> orderStateListBeans;
    Context context;

    public OderStateListAdapter(Context context, List<OrderStateListBean> orderStateListBeans) {
        this.orderStateListBeans = orderStateListBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public OderStateListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.oder_state_list_adapter, viewGroup, false);
        final OderStateListAdapter.ViewHolder viewHolder = new OderStateListAdapter.ViewHolder(v);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(context, "点击了" + viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OderStateListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.moneny.setText(orderStateListBeans.get(i).getMoneny());
        viewHolder.ren.setText(orderStateListBeans.get(i).getRen());
        viewHolder.title.setText(orderStateListBeans.get(i).getTitle());
        viewHolder.outtime.setText(orderStateListBeans.get(i).getOuttime());
        viewHolder.ordernumber.setText(orderStateListBeans.get(i).getOrderunmber());
        Glide.with(context).load(orderStateListBeans.get(i).getIamgeurl()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return orderStateListBeans.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView ren,title,outtime,ordernumber,moneny;
        ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            ordernumber=v.findViewById(R.id.order_state_list_ordernumber);
            moneny=v.findViewById(R.id.order_state_list_moneny);
            outtime = v.findViewById(R.id.order_state_list_outtime);
            ren = v.findViewById(R.id.order_state_list_ren);
            title = v.findViewById(R.id.order_state_list_title);
            imageView = v.findViewById(R.id.order_state_list_image);


        }
    }
}
