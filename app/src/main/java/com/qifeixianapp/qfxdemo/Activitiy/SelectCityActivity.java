package com.qifeixianapp.qfxdemo.Activitiy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.qifeixianapp.qfxdemo.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

public class SelectCityActivity extends AppCompatActivity {
    String[] A=new String[]{"阿坝","阿拉善","阿里","安康","安庆","鞍山","安顺","安阳","澳门"};
    String[] B=new String[]{"北京","白银","保定","宝鸡","保山","包头","巴中","北海","蚌埠","本溪","毕节","滨州","百色","亳州"};
    String[] C=new String[]{"重庆","成都","长沙","长春","沧州","常德","昌都","长治","常州","巢湖","潮州","承德", "郴州","赤峰","池州","崇左","楚雄","滁州","朝阳"};
    String[] D=new String[]{"大连","东莞","大理","丹东","大庆","大同","大兴安岭","德宏","德阳","德州","定西","迪庆","东营"};
    String[] E=new String[]{"鄂尔多斯","恩施","鄂州"};
    String[] F=new String[]{"福州","防城港","佛山","抚顺","抚州","阜新","阜阳"};
    String[] G=new String[]{"广州","桂林","贵阳","甘南","赣州","甘孜","广安","广元","贵港","果洛"};
    String[] H=new String[]{"杭州","哈尔滨","合肥","海口","呼和浩特","海北","海东","海南","海西","邯郸","汉中","鹤壁","河池","鹤岗","黑河","衡水","衡阳","河源","贺州","红河","淮安","淮北","怀化","淮南","黄冈","黄南","黄山","黄石","惠州","葫芦岛","呼伦贝尔","湖州","菏泽"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_city);
    }

}
