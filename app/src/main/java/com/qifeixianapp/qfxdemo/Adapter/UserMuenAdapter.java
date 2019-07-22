package com.qifeixianapp.qfxdemo.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Activitiy.MailListActivity;
import com.qifeixianapp.qfxdemo.Activitiy.MyFansActivity;
import com.qifeixianapp.qfxdemo.Activitiy.OrderActivity;
import com.qifeixianapp.qfxdemo.Activitiy.TravelSelectrActivity;
import com.qifeixianapp.qfxdemo.Activitiy.TsetAndroidActivity;
import com.qifeixianapp.qfxdemo.Activitiy.WalletActivity;
import com.qifeixianapp.qfxdemo.Adapter.Bean.HomeUserMuenBean;
import com.qifeixianapp.qfxdemo.R;

import java.util.List;

public class UserMuenAdapter extends RecyclerView.Adapter<UserMuenAdapter.ViewHolder> {
    List<HomeUserMuenBean> homeUserMuenBeans;
    Context context;
    private ProgressDialog progressDialog;
    public UserMuenAdapter(Context context,List<HomeUserMuenBean> homeUserMuenBeans){
        this.homeUserMuenBeans=homeUserMuenBeans;
        this.context=context;
        progressDialog=new ProgressDialog(context);
    }

    @NonNull
    @Override
    public UserMuenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_muen_adapter,viewGroup,false);
        final UserMuenAdapter.ViewHolder viewHolder=new UserMuenAdapter.ViewHolder(v);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(viewHolder.getAdapterPosition()==0){
                        Intent intent=new Intent(context, WalletActivity.class);
                        context.startActivity(intent);
                    }
                    if (viewHolder.getAdapterPosition()==1){
                        Intent intent=new Intent(context, OrderActivity.class);
                        context.startActivity(intent);
                    }
                    if (viewHolder.getAdapterPosition()==2){
                        progressDialog.setMessage("正载入中……");
                        progressDialog.setCanceledOnTouchOutside(true);
                        progressDialog.show();
                        Intent intent=new Intent(context, MyFansActivity.class);
                        context.startActivity(intent);
                        progressDialog.dismiss();
                    }
                    if(viewHolder.getAdapterPosition()==3){

                        Intent intent=new Intent(context, TsetAndroidActivity.class);
                        context.startActivity(intent);

                    }
                    if(viewHolder.getAdapterPosition()==4){
                    Intent intent=new Intent(context, TravelSelectrActivity.class);
                    context.startActivity(intent);

                }
//                if(viewHolder.getAdapterPosition()==5){
//                        Intent intent=new Intent(context, SmsActivity.class);
//                        context.startActivity(intent);
//                }

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