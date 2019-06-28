package com.qifeixianapp.qfxdemo.Activitiy;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Adapter.Mail_List_Adapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ContactUtils;
import com.qifeixianapp.qfxdemo.tool.MyContactsBean;

import java.util.ArrayList;
import java.util.List;

public  class MailListActivity extends AppCompatActivity {
    List<MyContactsBean> myContactsBeans;
    RecyclerView recyclerView;
    TextView all;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_list);
        myContactsBeans=new ArrayList<>();
        Log.e("12",myContactsBeans.toString());
        ArrayList<MyContactsBean> allContacts = ContactUtils.getAllContacts(MailListActivity.this);
        myContactsBeans=allContacts;
        find();
    }

    private void find() {
        all=findViewById(R.id.mail_all);
        all.setText(String.valueOf(myContactsBeans.size()));
        recyclerView=findViewById(R.id.mail_list);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(MailListActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new Mail_List_Adapter(MailListActivity.this,myContactsBeans));
    }

    private static final String[] PHONES_PROJECTION = new String[] {
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Photo.PHOTO_ID, ContactsContract.CommonDataKinds.Phone.CONTACT_ID };

}
