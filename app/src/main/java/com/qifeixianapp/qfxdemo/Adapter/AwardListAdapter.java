package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Adapter.Bean.AwardListBean;
import com.qifeixianapp.qfxdemo.Adapter.Bean.HomeMuenBean;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.List;

public class AwardListAdapter  extends RecyclerView.Adapter<AwardListAdapter.ViewHolder> {
    List<AwardListBean> awardListBeans;
    Context context;

    public AwardListAdapter(Context context, List<AwardListBean> awardListBeans) {
        this.awardListBeans = awardListBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public AwardListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.award_list_adapter, viewGroup, false);
        final AwardListAdapter.ViewHolder viewHolder = new AwardListAdapter.ViewHolder(v);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(context, "点击了" + viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AwardListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.titel.setText(awardListBeans.get(i).getTitle());
        viewHolder.image.setImageResource(awardListBeans.get(i).getImage());
        viewHolder.time.setText(awardListBeans.get(i).getTime());
        viewHolder.moneny.setText(awardListBeans.get(i).getMoneny());
    }

    @Override
    public int getItemCount() {
        return awardListBeans.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titel, time, moneny;
        ImageView image;

        public ViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.award_list_iamge);
            titel = v.findViewById(R.id.award_list_title);
            time = v.findViewById(R.id.award_list_time);
            moneny = v.findViewById(R.id.award_list_moneny);

        }
    }
}
