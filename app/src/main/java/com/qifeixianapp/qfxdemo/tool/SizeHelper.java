package com.qifeixianapp.qfxdemo.tool;

import android.content.Context;

public class SizeHelper {
    public static float dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (dp * scale);
    }

}
