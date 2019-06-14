package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyHomtTypePagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> fragmentList;
    private List<String> list_Title;
    public MyHomtTypePagerAdapter(FragmentManager fm, Context context, List<Fragment> fragmentList, List<String> list_Title) {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
        this.list_Title = list_Title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }
    @Override
    public int getCount() {
        return list_Title.size();
    }
    /**
     * //此方法用来显示tab上的名字
     * @param position
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return list_Title.get(position);
}
}
