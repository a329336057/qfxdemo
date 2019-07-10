package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TraveReserveDateBean;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelEndSheetListBean;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelReserverDayBean;
import com.qifeixianapp.qfxdemo.R;

import java.util.List;

public class TravelResverListAdapter extends BaseQuickAdapter<TravelReserverDayBean, BaseViewHolder> {
    Context context;

    public TravelResverListAdapter(@LayoutRes int layoutResId, @Nullable List<TravelReserverDayBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, TravelReserverDayBean item) {

        helper.setText(R.id.travel_Reserve_List_Button,item.getDay())
                .setText(R.id.travel_Reserve_List_text, item.getBills());
        //获取当前条目position
        //int position = helper.getLayoutPosition();

    }
}
