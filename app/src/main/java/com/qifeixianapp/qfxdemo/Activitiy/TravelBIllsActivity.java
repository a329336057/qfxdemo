package com.qifeixianapp.qfxdemo.Activitiy;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Bean.TravelBillsBean;
import com.qifeixianapp.qfxdemo.Presenter.TravelBills.ITravelBillsPresenter;
import com.qifeixianapp.qfxdemo.Presenter.TravelBills.TraveBillsPrsenterImpl;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.View.ITravelBillsView;
import com.qifeixianapp.qfxdemo.tool.DataUitl;
import com.qifeixianapp.qfxdemo.tool.GlideImageLoader;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class TravelBIllsActivity extends AppCompatActivity implements View.OnClickListener,ITravelBillsView{
    Button mTravel_ReserveButton,mTravelNetworkButton;
    TextView mTravelBillsTitle,mFB,mMoney,mNetworkText;
    RelativeLayout mDataRelativeLayout,mLoadingRelativeLayout;
    List<String> TravelLocationGODateTime;
    WebView mProductWebView,mIncludesWebView,mReminderWebView,mLineTripWebView;
    ImageView mEixtButton;
    String Route_id,price_id;
    Banner mBanner;
    RecyclerView mLocationGoRecyclerView;
    TraveBillsPrsenterImpl travelBillsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_bills);
        find();
    }

    private void find() {
        travelBillsPresenter=new TraveBillsPrsenterImpl(this);
        TravelLocationGODateTime=new ArrayList<>();
        mProductWebView=findViewById(R.id.Travel_Bills_Product_WebView); //产品特点
        mIncludesWebView=findViewById(R.id.Travel_Bills_Includes_WebView); //费用包含
        mReminderWebView=findViewById(R.id.Travel_Bills_Reminder_WebView); //用户须知
        mLineTripWebView=findViewById(R.id.Travel_Bills_LineTrip_WebView); //线路行程
        mTravel_ReserveButton=findViewById(R.id.Travel_Bills_Reserve_Button);
        mDataRelativeLayout=findViewById(R.id.Travel_Bills_data_RelativeLayout);
        mNetworkText=findViewById(R.id.Travel_Bills_Network_text);
        mTravelNetworkButton=findViewById(R.id.Travel_Bills_Network_Button);
        mLoadingRelativeLayout=findViewById(R.id.Travel_Bills_Loading);
        mTravelBillsTitle=findViewById(R.id.Travel_Bills_Title);
        mFB=findViewById(R.id.Travel_Bills_FB);
        mMoney=findViewById(R.id.Travel_Bills_Money);
        mEixtButton=findViewById(R.id.Travel_Bills_Exit);
        mDataRelativeLayout.setVisibility(View.INVISIBLE);
        mLoadingRelativeLayout.setVisibility(View.VISIBLE);
        mLocationGoRecyclerView=findViewById(R.id.Travel_Bills_LocationGg_RecyclerView);
        mEixtButton.setOnClickListener(this);
        mTravel_ReserveButton.setOnClickListener(this);
        mBanner=findViewById(R.id.Travel_Bills_Banner);
        settingBnaner();
        loaddata();
    }

    private void loaddata() {
        Intent intent=getIntent();
         Route_id=intent.getStringExtra("route_id");
         price_id=intent.getStringExtra("price_id");
        ToastUtils.show(TravelBIllsActivity.this,Route_id+" 以及 "+price_id);
        travelBillsPresenter.getRouteDetail(DataUitl.IP,Route_id,price_id);
    }

    private void settingBnaner() {
        List<String> url=new ArrayList<>();
        List<String> titel=new ArrayList<>();
        url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563694244956&di=0626572c746d5c93d4e5bb25de1782a9&imgtype=0&src=http%3A%2F%2Fimg1.cache.netease.com%2Fcatchpic%2F8%2F8D%2F8DB991E2392FA6287414E996F98BF8A9.jpg");
        url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563694282201&di=793eb88901c4fdbde9f0bc9b22bfe8d7&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2Fcce33d84fe09501ef414d1eb309c648232d0f1d654592-ldUiuJ_fw658");
        url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563694282198&di=39487a55cd38b298826d4d15675d8ac2&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20171114%2F5da29b8e4218498091899306ce333785.jpeg");
        url.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563694282231&di=0302c1a2dca9c9706bc0a086e0bcd00e&imgtype=0&src=http%3A%2F%2Fimg1.qunarzz.com%2Fp%2Ftts2%2F201211%2F09%2F58468b004b3d708493835fbb.jpg");
        titel.add("马尔代夫");
        titel.add("我去日期为他人");
        titel.add("天堂堡");
        titel.add("wrq qr1qr");
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.setImages(url)
                .setBannerTitles(titel)
                .setBannerAnimation(Transformer.Stack)
                .setDelayTime(6000)
                .start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Travel_Bills_Reserve_Button:
                Intent intent=new Intent(TravelBIllsActivity.this,TravelReserveActivity.class);
                startActivity(intent);
                break;
            case R.id.Travel_Bills_Exit:
                 finish();
                break;
            case R.id.Travel_Bills_Network_Button:
                travelBillsPresenter.getRouteDetail(DataUitl.IP,Route_id,price_id);
                break;
        }
    }

    @Override
    public void getDataFailed(Throwable e) {
        mNetworkText.setText("检查网络异常");
        mTravelNetworkButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void getDataSuccess(TravelBillsBean travelBillsBean) {
        if(travelBillsBean.getCode()==1){
            List<String>tripList=new ArrayList<>();
            mTravelBillsTitle.setText(travelBillsBean.getData().getRoute_info().getName());
            mFB.setText("+"+travelBillsBean.getData().getRoute_info().getIntegral_deductible());
            mMoney.setText("￥"+travelBillsBean.getData().getRoute_info().getPrice());
            //对页面赋值
            mIncludesWebView.loadData(getHtmlData(travelBillsBean.getData().getRoute_info().getCost_includes()),"text/html;charset=utf-8","utf-8");
            mReminderWebView.loadData(getHtmlData(travelBillsBean.getData().getRoute_info().getReminder()),"text/html;charset=utf-8","utf-8");
            mProductWebView.loadData(getHtmlData(travelBillsBean.getData().getRoute_info().getProduct_characteristic()),"text/html;charset=utf-8","utf-8");
            for (int i = 0; i < travelBillsBean.getData().getRoute_trip().size(); i++) {
                tripList.add(travelBillsBean.getData().getRoute_trip().get(i).getContent());
            }

            mLineTripWebView.loadData(getHtmlDataList(tripList),"text/html;charset=utf-8","utf-8");
            if(travelBillsBean.getData().getRoute_info().getCost_includes()==""){
                ToastUtils.show(TravelBIllsActivity.this,"没有Characteristic");
            }
     
            mDataRelativeLayout.setVisibility(View.VISIBLE);
            mLoadingRelativeLayout.setVisibility(View.INVISIBLE);
        }else {
            mNetworkText.setText("检查网络异常");
            mTravelNetworkButton.setVisibility(View.VISIBLE);
        }

}
    String getHtmlData(String bodyHTML){
        String head = "<head>" +
                "<style>html{padding:15px;} body{word-wrap:break-word;font-size:9px;padding:0px;margin:0px} " +
                "p{padding:0px;margin:0px;font-size:13px;color:#222222;line-height:1.3;} img{padding:0px,margin:0px;max-width:100%; width:auto; height:auto;}</style>" +
                "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }
    String getHtmlDataList(List<String> bodyTrip){
        String bodyHTML="";
        for (int i = 0; i < bodyTrip.size(); i++) {
            bodyHTML+=bodyTrip.get(i);
        }
        String head = "<head>" +
                "<style>html{padding:15px;} body{word-wrap:break-word;font-size:9px;padding:0px;margin:0px} " +
                "p{padding:0px;margin:0px;font-size:13px;color:#222222;line-height:1.3;} img{padding:0px,margin:0px;max-width:100%; width:auto; height:auto;}</style>" +
                "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }
}
