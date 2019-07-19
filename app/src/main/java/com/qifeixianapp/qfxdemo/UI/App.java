package com.qifeixianapp.qfxdemo.UI;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.qifeixianapp.qfxdemo.R;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.header.waveswipe.DropBounceInterpolator;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshInitializer;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

public class App extends Application {
    static {//使用static代码段可以防止内存泄漏

        //设置全局默认配置（优先级最低，会被其他设置覆盖）
        SmartRefreshLayout.setDefaultRefreshInitializer(new DefaultRefreshInitializer() {
            @Override
            public void initialize(@NonNull Context context, @NonNull RefreshLayout layout) {
                //开始设置全局的基本参数
                layout.setReboundDuration(1000);
                layout.setReboundInterpolator(new DropBounceInterpolator());
                layout.setFooterHeight(100);
                layout.setDisableContentWhenLoading(false);
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
            }
        });

        //全局设置默认的 Header
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                //开始设置全局的基本参数（这里设置的属性只跟下面的MaterialHeader绑定，其他Header不会生效，能覆盖DefaultRefreshInitializer的属性和Xml设置的属性）
                layout.setEnableHeaderTranslationContent(false);
                return new MaterialHeader(context).setColorSchemeResources(R.color.red,R.color.colorGreen,R.color.colorBlue);
            }
        });
    }
}