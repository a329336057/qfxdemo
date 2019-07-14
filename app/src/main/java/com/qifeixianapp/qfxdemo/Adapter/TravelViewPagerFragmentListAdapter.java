package com.qifeixianapp.qfxdemo.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.R;

import java.util.List;

public class TravelViewPagerFragmentListAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> fragmentList;
    private List<String> list_Title;
    public TravelViewPagerFragmentListAdapter(FragmentManager fm, Context context, List<Fragment> fragmentList, List<String> list_Title) {
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
    public  View getTabView(int position){
        View v=LayoutInflater.from(context).inflate(R.layout.travel_titlelayout_list,null);
        TextView tv = (TextView) v.findViewById(R.id.Travel_TabLayout_titles);
        tv.setText(list_Title.get(position));
        ImageView img = (ImageView) v.findViewById(R.id.Travel_TabLayout_icon);
        if(position==3){
            img.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.travel_hot_icon);
        }
        return  v;
    }
}