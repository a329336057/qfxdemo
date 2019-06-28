package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Adapter.Bean.HomeThemeBean;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.MyContactsBean;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import org.w3c.dom.Text;

import java.util.List;

public class Mail_List_Adapter  extends RecyclerView.Adapter<Mail_List_Adapter.ViewHolder> {
    List<MyContactsBean> myContactsBeans;
    Context context;


    public Mail_List_Adapter(Context context,List<MyContactsBean> myContactsBeans){
        this.myContactsBeans=myContactsBeans;
        this.context=context;
    }

    @NonNull
    @Override
    public Mail_List_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mail_list_adapter,viewGroup,false);
        final Mail_List_Adapter.ViewHolder viewHolder=new Mail_List_Adapter.ViewHolder(v);
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsfas=myContactsBeans.get(viewHolder.getAdapterPosition()).phone;

                if(PhoneNumberUtils.isGlobalPhoneNumber(smsfas)){
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+smsfas));
                    intent.putExtra("sms_body", "你好啊");
                    context.startActivity(intent);
                }


            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Mail_List_Adapter.ViewHolder viewHolder, int i) {

        viewHolder.name.setText(myContactsBeans.get(i).name);
        viewHolder.phone.setText(myContactsBeans.get(i).phone);

    }

    @Override
    public int getItemCount() {
        return myContactsBeans.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        Button button;
        TextView name;
        TextView phone;
        public  ViewHolder(View v){
            super(v);
            button=v.findViewById(R.id.mail_sms);
            name=v.findViewById(R.id.mail_user);
            phone=v.findViewById(R.id.mail_phone);


        }
    }
}
