package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelEndSheetListBean;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelListBean;
import com.qifeixianapp.qfxdemo.R;

import java.util.List;

public class TravelEndSheetAdapter extends BaseQuickAdapter<TravelEndSheetListBean, BaseViewHolder> {
    Context context;

    public TravelEndSheetAdapter(@LayoutRes int layoutResId, @Nullable List<TravelEndSheetListBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, TravelEndSheetListBean item) {
        //可链式调用赋值
        ImageView imageView = helper.itemView.findViewById(R.id.Travel_end_sheet_list_image);
        Glide.with(context).load(item.getIamgeurl()).into(imageView);
        helper.setText(R.id.Travel_end_sheet_list_title, item.getTitle())
                .setText(R.id.Travel_end_sheet_list_moneny, item.getMoney())
                .setText(R.id.Travel_end_sheet_list_Award, item.getAward())
                .setText(R.id.Travel_end_sheet_list_day, item.getDay())
                .setText(R.id.Travel_end_sheet_list_hour, item.getHour())
                .setText(R.id.Travel_end_sheet_list_min, item.getMin())
                .setText(R.id.Travel_end_sheet_list_second, item.getSecond());
        //获取当前条目position
        //int position = helper.getLayoutPosition();

    }
}