package com.qifeixianapp.qfxdemo.Activitiy;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.qifeixianapp.qfxdemo.Adapter.MyFragAdapter;
import com.qifeixianapp.qfxdemo.fragment.TravelFragment;
import com.qifeixianapp.qfxdemo.fragment.homeFragment;
import com.qifeixianapp.qfxdemo.fragment.merchantFragment;
import com.qifeixianapp.qfxdemo.fragment.UserFragment;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ContactUtils;
import com.qifeixianapp.qfxdemo.tool.MyContactsBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainsHome extends AppCompatActivity  implements AMapLocationListener{

    private TextView mTextMessage;
    long mExitTime =0;
    private static final String TAG = "MainActivity";
    ViewPager viewPager;
    BottomNavigationView navigation;//底部导航栏对象
    List<Fragment> listFragment;//存储页面对象



    //声明AMapLocationClient类对象，定位发起端
    private AMapLocationClient mLocationClient = null;
    //声明mLocationOption对象，定位参数
    public AMapLocationClientOption mLocationOption = null;
    //声明mListener对象，定位监听器
    //标识，用于判断是否只显示一次定位信息和用户重新定位
    private boolean isFirstLoc = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.home);
        location();
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        initView();//初始化
    }

    private void location() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(this);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为Hight_Accuracy高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
    }


    private void initView() {

        //向ViewPager添加各页面
        listFragment = new ArrayList<>();
        listFragment.add(new homeFragment());
        listFragment.add(new TravelFragment());
        listFragment.add(new merchantFragment());
        listFragment.add(new UserFragment());



        MyFragAdapter myAdapter = new MyFragAdapter(getSupportFragmentManager(), this, listFragment);
        viewPager.setAdapter(myAdapter);

        //导航栏点击事件和ViewPager滑动事件,让两个控件相互关联
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //这里设置为：当点击到某子项，ViewPager就滑动到对应位置
                switch (item.getItemId()) {
                    case R.id.homeblack:
                        viewPager.setCurrentItem(0);
                        item.setIcon(R.drawable.icon01_h);
                        return true;
                    case R.id.Travel:
                        viewPager.setCurrentItem(1);
                        item.setIcon(R.drawable.icon02);
                        return  true;
                    case R.id.merchant:
                        viewPager.setCurrentItem(2);
                        item.setIcon(R.drawable.icon03_h);
                        return true;
                    case R.id.My:

                        viewPager.setCurrentItem(3);
                        item.setIcon(R.drawable.icon04_h);
                        return true;

                    default:
                        break;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //注意这个方法滑动时会调用多次，下面是参数解释：
                //position当前所处页面索引,滑动调用的最后一次绝对是滑动停止所在页面
                //positionOffset:表示从位置的页面偏移的[0,1]的值。
                //positionOffsetPixels:以像素为单位的值，表示与位置的偏移
            }

            @Override
            public void onPageSelected(int position) {
                //该方法只在滑动停止时调用，position滑动停止所在页面位置
//                当滑动到某一位置，导航栏对应位置被按下
                navigation.getMenu().getItem(position).setChecked(true);
                //这里使用navigation.setSelectedItemId(position);无效，
                //setSelectedItemId(position)的官网原句：Set the selected
                // menu item ID. This behaves the same as tapping on an item
                //未找到原因
            }

            @Override
            public void onPageScrollStateChanged(int state) {
//这个方法在滑动是调用三次，分别对应下面三种状态
// 这个方法对于发现用户何时开始拖动，
// 何时寻呼机自动调整到当前页面，或何时完全停止/空闲非常有用。
//                state表示新的滑动状态，有三个值：
//                SCROLL_STATE_IDLE：开始滑动（空闲状态->滑动），实际值为0
//                SCROLL_STATE_DRAGGING：正在被拖动，实际值为1
//                SCROLL_STATE_SETTLING：拖动结束,实际值为2
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //与上次点击返回键时刻作差
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                //大于2000ms则认为是误操作，使用Toast进行提示
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //并记录下本次点击“返回键”的时刻，以便下次进行判断
                mExitTime = System.currentTimeMillis();
            } else {
                //小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
                System.exit(0);
            }
            return true;

        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if(aMapLocation!=null){
            if(aMapLocation.getErrorCode()==0){
                int locationType = aMapLocation.getLocationType();
                double la= aMapLocation.getLatitude();//获取纬度
                double lo= aMapLocation.getLongitude();//获取经度
                aMapLocation.getAccuracy();//获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(aMapLocation.getTime());
                df.format(date);//定位时间
                aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                Log.e("国家信息",aMapLocation.getCountry());//国家信息
                Log.e("省信息",aMapLocation.getProvince());//省信息
                Log.e( "城市信息",aMapLocation.getCity());//城市信息
                Log.e("城区信息",aMapLocation.getDistrict());//城区信息
                Log.e("街道信息",aMapLocation.getStreet());//街道信息
                Log.e("街道门牌号信息",aMapLocation.getStreetNum());//街道门牌号信息
                Log.e("城市编码",aMapLocation.getCityCode());//城市编码
                Log.e("地区编码",aMapLocation.getAdCode());//地区编码

            }else {
                Log.e("错误",aMapLocation.getErrorInfo());
            }
        }else {
            Log.e("错误","没有开启定位");
        }
    }
}
