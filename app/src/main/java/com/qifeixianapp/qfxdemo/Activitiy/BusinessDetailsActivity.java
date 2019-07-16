package com.qifeixianapp.qfxdemo.Activitiy;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.DataUitl;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;
import com.tencent.mm.opensdk.utils.Log;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.editorpage.ShareActivity;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;


public class BusinessDetailsActivity extends AppCompatActivity implements View.OnClickListener, UMShareListener {
    ImageView mExit,mPhoneTell;
    TextView mPhoneName;
    RelativeLayout relativeLayout;
    ImageView mSharicon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UMConfigure.init(this,"5d2d8e6a0cafb2ab00000657","umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.activity_business_details);
        find();
    }

    private void find() {

        PlatformConfig.setWeixin(DataUitl.AppID,DataUitl.AppSecret);
        relativeLayout=findViewById(R.id.merchant_datalis_map);
        mExit=findViewById(R.id.merchant_datalis_exit);
        mPhoneName=findViewById(R.id.merchant_datalis_tell);
        mPhoneTell=findViewById(R.id.merchant_datalis_tellicon);
        mSharicon=findViewById(R.id.merchant_datalis_shareicon);
        mExit.setOnClickListener(this);
        mPhoneName.setOnClickListener(this);
        mPhoneTell.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);
        mSharicon.setOnClickListener(this);
    }
    public void callPhone(String str) {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + str));
        startActivity(intent);
    }
void opengaodemap(){
        try {
            double gdLatitude = 39.92848272;
            double gdLongitude = 116.39560823;
            String uri = String.format("amapuri://route/plan/?dlat=%s&dlon=%s&dname=B&dev=0&t=0",
                    gdLatitude, gdLongitude);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse(uri));
            intent.setPackage("com.autonavi.minimap");
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            ToastUtils.show(BusinessDetailsActivity.this,"请安装高德地图");
        }



}

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.merchant_datalis_tellicon :  //拨打电话
           callPhone("17623882165");
           break;
        case   R.id.merchant_datalis_tell ://拨打电话
            callPhone("17623882165");
            break;
        case  R.id.merchant_datalis_exit://返回上一页
            BusinessDetailsActivity.this.finish();
            break;

        case R.id.merchant_datalis_map:
            opengaodemap();
            break;
        case R.id.merchant_datalis_shareicon:
            UMWeb web = new UMWeb("http://www.baidu.com");
            web.setTitle("This is music title");//标题
            web.setThumb(new UMImage(this,R.drawable.maps));  //缩略图
            web.setDescription("my description");//描述
            new ShareAction(BusinessDetailsActivity.this)
                    .setDisplayList(SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_FAVORITE,SHARE_MEDIA.WEIXIN_CIRCLE)
                    .withMedia(web)
                    .setCallback(this)
                    .open();
            break;
        default:break;
    }
    }


    /**
     * @descrption 分享开始的回调
     * @param platform 平台类型
     */
    @Override
    public void onStart(SHARE_MEDIA platform) {
        ToastUtils.show(BusinessDetailsActivity.this,"sad阿萨德撒");
    }
    /**
     * @descrption 分享成功的回调
     * @param platform 平台类型
     */
    @Override
    public void onResult(SHARE_MEDIA platform) {
        Log.e("分享","分享此");
        ToastUtils.show(BusinessDetailsActivity.this,"分享成功");
    }
    /**
     * @descrption 分享失败的回调
     * @param platform 平台类型
     * @param t 错误原因
     */
    @Override
    public void onError(SHARE_MEDIA platform, Throwable t) {

    }
    /**
     * @descrption 分享取消的回调
     * @param platform 平台类型
     */
    @Override
    public void onCancel(SHARE_MEDIA platform) {

    }
}
