package com.qifeixianapp.qfxdemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.hjq.bar.TitleBar;
import com.lxj.xpopup.XPopup;
import com.qifeixianapp.qfxdemo.Adapter.TravelViewPagerFragmentListAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.UI.CustomFullScreenPopup;

import java.util.ArrayList;
import java.util.List;


public class TravelFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    List<Fragment> fragmentList;
    List<String> titleTab;
    ImageView eixt;
    RelativeLayout mSelectTravel;
    AppBarLayout appBarLayout;
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_travel, container, false);
        find(v);
        return v;
    }

    private void find(View v) {
        mSelectTravel=v.findViewById(R.id.Travek_dislog);
        titleTab=new ArrayList<>();
        titleTab.add("周边游");
        titleTab.add("国内游");
        titleTab.add("境外游");
        titleTab.add("临期尾单");
        titleTab.add("私人订制");
        fragmentList=new ArrayList<>();
        viewPager=v.findViewById(R.id.Travel_Viewpager);
        tabLayout=v.findViewById(R.id.Travel_TabLayout);
        TravelPeripheralTourFragment travelPeripheralTourFragment=new TravelPeripheralTourFragment();
        fragmentList.add(new TravelPeripheralTourFragment());
        fragmentList.add(new TravelPeripheralTourFragment());
        fragmentList.add(new TravelPeripheralTourFragment());
        fragmentList.add(new TravelEndSheetFragment());
        fragmentList.add(new TravelPeripheralTourFragment());
        TravelViewPagerFragmentListAdapter travelViewPagerFragmentListAdapter=new TravelViewPagerFragmentListAdapter(getChildFragmentManager(),getContext(),fragmentList,titleTab);
        viewPager.setAdapter(travelViewPagerFragmentListAdapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tab=tabLayout.getTabAt(i);
                tab.setCustomView(travelViewPagerFragmentListAdapter.getTabView(i));
        }
        mSelectTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //自定义的弹窗需要用asCustom来显示，之前的asImageViewer这些方法当然不能用了。
                CustomFullScreenPopup viewerPopup = new CustomFullScreenPopup(getContext());
                new XPopup.Builder(getContext())
                        .asCustom(viewerPopup)
                        .show();

            }
        });


    }


}