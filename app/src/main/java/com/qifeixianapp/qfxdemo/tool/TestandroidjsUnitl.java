package com.qifeixianapp.qfxdemo.tool;
import android.util.Log;
import android.webkit.JavascriptInterface;
/**
 * android原生与JavaScript交互工具类
 * Created by CYQ on 2017/9/9.
 */

public class TestandroidjsUnitl {

    /**
     * 给js发送一个字符串
     * @return
     */
    @JavascriptInterface
    public String setParameter() {
        String newsTitle = "Android与JavaScript交互";
        return newsTitle;
    }

    /**
     * 获取js返回的数据
     * @param result
     */
    @JavascriptInterface
    public void getJSReBack(String result) {
        Log.e("js", "js返回的数据：" + result);
    }
}
