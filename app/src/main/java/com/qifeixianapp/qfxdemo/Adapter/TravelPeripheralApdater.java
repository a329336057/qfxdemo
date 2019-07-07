package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qifeixianapp.qfxdemo.Activitiy.SmsActivity;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelListBean;
import com.qifeixianapp.qfxdemo.R;

import java.util.List;

public class TravelPeripheralApdater extends BaseQuickAdapter<TravelListBean, BaseViewHolder> {
    Context context;
    public TravelPeripheralApdater(@LayoutRes int layoutResId, @Nullable List<TravelListBean> data,Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, TravelListBean item) {
        //可链式调用赋值
        ImageView imageView=helper.itemView.findViewById(R.id.Travel_perpherak_tour_list_image);
        Glide.with(context).load(item.getIamgeurl()).into(imageView);
        helper.setText(R.id.Travel_perpherak_tour_list_title, item.getTitle())
                .setText(R.id.Travel_perpherak_tour_list_moneny, item.getMoney())
                .setText(R.id.Travel_perpherak_tour_lis_Award,item.getAward());

        //获取当前条目position
        //int position = helper.getLayoutPosition();

    }
}
