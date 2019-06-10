package com.qifeixianapp.qfxdemo.Homes.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Homes.Bean.HomeMuenBean;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.List;

public class HomeMuenAdapter  extends RecyclerView.Adapter<HomeMuenAdapter.ViewHolder> {
    List<HomeMuenBean> homeMuenBeans;
    Context context;
    public HomeMuenAdapter(Context context,List<HomeMuenBean> homeMuenBeans){
        this.homeMuenBeans=homeMuenBeans;
        this.context=context;
    }

    @NonNull
    @Override
    public HomeMuenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_home_muen_adapter,viewGroup,false);
        final HomeMuenAdapter.ViewHolder viewHolder=new HomeMuenAdapter.ViewHolder(v);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(context,"点击了"+viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeMuenAdapter.ViewHolder viewHolder, int i) {
        viewHolder.titel.setText(homeMuenBeans.get(i).getTitle());
        viewHolder.image.setImageResource(homeMuenBeans.get(i).getImages());
    }

    @Override
    public int getItemCount() {
        return homeMuenBeans.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView titel;
        ImageView image;
        public  ViewHolder(View v){
            super(v);
            image=v.findViewById(R.id.home_Muen_image);
            titel=v.findViewById(R.id.home_Muen_title);

        }
    }
}