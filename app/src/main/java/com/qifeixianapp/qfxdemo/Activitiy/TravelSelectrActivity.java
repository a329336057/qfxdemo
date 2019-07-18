package com.qifeixianapp.qfxdemo.Activitiy;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelListBean;
import com.qifeixianapp.qfxdemo.Adapter.TravelPeripheralApdater;
import com.qifeixianapp.qfxdemo.Bean.TravelRequestListBean;
import com.qifeixianapp.qfxdemo.Presenter.TravelRouteList.TravelRouteListPresenterImpl;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.View.ITravelRouteListView;
import com.qifeixianapp.qfxdemo.tool.SizeHelper;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import static com.chad.library.adapter.base.BaseQuickAdapter.SCALEIN;

public class TravelSelectrActivity extends AppCompatActivity implements ITravelRouteListView {
    EditText mSelectEditText;
    ImageView mExit;

    TravelRouteListPresenterImpl travelRouteListPresenter;
    RecyclerView mRecyclerView;
    List<TravelListBean> listBeans;
    Dialog dialog;
    RelativeLayout mRelativeLayout;
    @SuppressLint("handler")
    private Handler handler=new Handler(){
        @Override
        public  void  handleMessage(Message message){
            if(message.what==1){
                LinearLayoutManager layoutManager = new LinearLayoutManager(TravelSelectrActivity.this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                final TravelPeripheralApdater travelPeripheralApdater=new TravelPeripheralApdater(R.layout.fragment_travel_peripheral_tour_list,listBeans,TravelSelectrActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setAdapter(travelPeripheralApdater);
                travelPeripheralApdater.openLoadAnimation(SCALEIN );
                travelPeripheralApdater.isFirstOnly(true);
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_select);
        find();
    }

    private void find() {
        mRelativeLayout=findViewById(R.id.Travel_Select_emptydata_layout);
        travelRouteListPresenter=new TravelRouteListPresenterImpl(this);
        mSelectEditText=findViewById(R.id.travel_select_Edittext);
        mRecyclerView=findViewById(R.id.Travel_Select_RecyclerView);
        mExit=findViewById(R.id.Travel_Select_exit);
        mSelectEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEARCH){
                    dialog = new Dialog(TravelSelectrActivity.this,R.style.progress_dialog);
                    dialog.setContentView(R.layout.dialog);
                    dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                    TextView msg =dialog.findViewById(R.id.id_tv_loadingmsg);
                    msg.setText("卖力加载中");
                    dialog.show();

                    SizeHelper.hideKeyboard(mSelectEditText);
                    String selectText = mSelectEditText.getText().toString();
                    travelRouteListPresenter.getRouteList("http://app.qifeixian.com/index.php/","1","10",selectText,"1.1","重庆");
                    mRecyclerView.setVisibility(View.VISIBLE);
                    mRelativeLayout.setVisibility(View.INVISIBLE);

                    return  true;
                }
                return  false;
            }
        });


        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
    }



    @Override
    public void getDataFailed(Throwable e) {
        ToastUtils.show(TravelSelectrActivity.this,e.getLocalizedMessage());
        dialog.dismiss();
    }

    @Override
    public void getDataSuccess(TravelRequestListBean travelRequestListBean) {
        dialog.dismiss();
        if(travelRequestListBean.getCode()==1){
            if(travelRequestListBean.getData().getList().size()==0){
                mRelativeLayout.setVisibility(View.VISIBLE);
                mRecyclerView.setVisibility(View.INVISIBLE);
            }
            listBeans=new ArrayList<>();

            for (int i = 0; i < travelRequestListBean.getData().getList().size(); i++) {
                TravelListBean travelListBean=new TravelListBean();
                travelListBean.setTitle(travelRequestListBean.getData().getList().get(i).getName());
                travelListBean.setAward("+"+travelRequestListBean.getData().getList().get(i).getPrice_id());

                travelListBean.setMoney("￥"+travelRequestListBean.getData().getList().get(i).getPrice()+"起/人");
                listBeans.add(travelListBean);
            }
            Message message=new Message();
            message.what=1;
            handler.sendMessage(message);
        }else {
            ToastUtils.show(TravelSelectrActivity.this,"服务器刚刚开小差了 请稍后再试");
        }
    }
}
