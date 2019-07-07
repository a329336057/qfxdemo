package com.qifeixianapp.qfxdemo.UI;

import android.content.Context;
import android.support.annotation.NonNull;

import com.lxj.xpopup.impl.FullScreenPopupView;
import com.qifeixianapp.qfxdemo.R;

public class CustomFullScreenPopup extends FullScreenPopupView {
    public CustomFullScreenPopup(@NonNull Context context) {
        super(context);
    }
    @Override
    protected int getImplLayoutId() {
        return R.layout.activity_vip;
    }
    @Override
    protected void onCreate() {
        super.onCreate();
        //初始化
    }
}
