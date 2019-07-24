package com.qifeixianapp.qfxdemo.Activitiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.TestandroidjsUnitl;

public class TsetAndroidActivity extends AppCompatActivity implements OnTitleBarListener {
    TitleBar titleBar;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tset_android);
        titleBar=findViewById(R.id.Testjsanzroid);
        webView=findViewById(R.id.testjsandroidwebview);
        setweb();
        
    }

    private void setweb() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //允许访问assets目录
        settings.setAllowFileAccess(true);
        //设置WebView排版算法, 实现单列显示, 不允许横向移动
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //assets下要显示的html文件路径
        String path = "https://www.qifeixian.com/web/appjiaohu.html";
        TestandroidjsUnitl javascriptSupport = new TestandroidjsUnitl();
        javascriptSupport.setParameter();
        webView.addJavascriptInterface(javascriptSupport, "newsinfo");
        webView.loadUrl(path);
    }

    @Override
    public void onLeftClick(View v) {
        finish();
    }

    @Override
    public void onTitleClick(View v) {

    }

    @Override
    public void onRightClick(View v) {

    }
}
