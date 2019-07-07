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

import com.qifeixianapp.qfxdemo.Adapter.MyFragAdapter;
import com.qifeixianapp.qfxdemo.fragment.TravelFragment;
import com.qifeixianapp.qfxdemo.fragment.homeFragment;
import com.qifeixianapp.qfxdemo.fragment.merchantFragment;
import com.qifeixianapp.qfxdemo.fragment.UserFragment;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ContactUtils;
import com.qifeixianapp.qfxdemo.tool.MyContactsBean;

import java.util.ArrayList;
import java.util.List;

public class MainsHome extends AppCompatActivity {

    private TextView mTextMessage;
    long mExitTime =0;
    private static final String TAG = "MainActivity";
    ViewPager viewPager;
    BottomNavigationView navigation;//底部导航栏对象
    List<Fragment> listFragment;//存储页面对象


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.home);

        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        initView();//初始化
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

                    case R.id.merchant:

                        viewPager.setCurrentItem(3);
                        item.setIcon(R.drawable.icon03_h);
                        return true;
                    case R.id.My:

                        viewPager.setCurrentItem(4);
                        item.setIcon(R.drawable.icon04_h);
                        return true;
                    case R.id.Travel:

                        viewPager.setCurrentItem(2);
                        item.setIcon(R.drawable.icon02);
                        return  true;
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


}
