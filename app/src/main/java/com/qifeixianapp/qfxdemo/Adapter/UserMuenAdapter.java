package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Adapter.Bean.HomeUserMuenBean;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.List;

public class UserMuenAdapter extends RecyclerView.Adapter<UserMuenAdapter.ViewHolder> {
    List<HomeUserMuenBean> homeUserMuenBeans;
    Context context;
    public UserMuenAdapter(Context context,List<HomeUserMuenBean> homeUserMuenBeans){
        this.homeUserMuenBeans=homeUserMuenBeans;
        this.context=context;
    }

    @NonNull
    @Override
    public UserMuenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_muen_adapter,viewGroup,false);
        final UserMuenAdapter.ViewHolder viewHolder=new UserMuenAdapter.ViewHolder(v);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(context,"点击了"+viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserMuenAdapter.ViewHolder viewHolder, int i) {
        viewHolder.titel.setText(homeUserMuenBeans.get(i).getTitle());
        viewHolder.image.setImageResource(homeUserMuenBeans.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return homeUserMuenBeans.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        TextView titel;
        ImageView image;
        public  ViewHolder(View v){
            super(v);
            image=v.findViewById(R.id.user_meun_iamge);
            titel=v.findViewById(R.id.user_meun_title);

        }
    }
}