package com.qifeixianapp.qfxdemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hjq.bar.TitleBar;
import com.lxj.xpopup.XPopup;
import com.qifeixianapp.qfxdemo.Activitiy.TravelSelectrActivity;
import com.qifeixianapp.qfxdemo.Adapter.TravelViewPagerFragmentListAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.UI.CustomFullScreenPopup;
import com.qifeixianapp.qfxdemo.tool.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;


public class TravelFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    List<Fragment> fragmentList;
    List<String> titleTab;
    TextView mTravellocalText;
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
        SharedPreferencesUtil.getInstance(getContext(),"homedata");
        mSelectTravel=v.findViewById(R.id.Travel_Select);
        titleTab=new ArrayList<>();
        titleTab.add("周边游");
        titleTab.add("国内游");
        titleTab.add("境外游");
        titleTab.add("临期尾单");
        titleTab.add("私人订制");
        fragmentList=new ArrayList<>();
        viewPager=v.findViewById(R.id.Travel_Viewpager);
        tabLayout=v.findViewById(R.id.Travel_TabLayout);
        mTravellocalText=v.findViewById(R.id.Travel_local_map_text);
        mTravellocalText.setText((String)SharedPreferencesUtil.getData("localtion","重庆"));
        TravelPeripheralTourFragment fragment1 = new TravelPeripheralTourFragment();
        TravelPeripheralTourFragment fragment2 = new TravelPeripheralTourFragment();
        TravelPeripheralTourFragment fragment3 = new TravelPeripheralTourFragment();
        Bundle bundle=new Bundle();
        bundle.putString("tourist_type","1.1");
        fragment1.setArguments(bundle);


        Bundle bundle2=new Bundle();
        bundle2.putString("tourist_type","1.2");
        fragment2.setArguments(bundle2);


        Bundle bundle3=new Bundle();
        bundle3.putString("tourist_type","1.3");
        fragment3.setArguments(bundle3);


        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(new TravelEndSheetFragment());
        fragmentList.add(new PersonalTailorFragment());
        TravelViewPagerFragmentListAdapter travelViewPagerFragmentListAdapter=new TravelViewPagerFragmentListAdapter(getChildFragmentManager(),getContext(),fragmentList,titleTab);
        viewPager.setOffscreenPageLimit(100);

        viewPager.setAdapter(travelViewPagerFragmentListAdapter);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
                TabLayout.Tab tab=tabLayout.getTabAt(i);
                tab.setCustomView(travelViewPagerFragmentListAdapter.getTabView(i));
        }
//        mSelectTravel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //自定义的弹窗需要用asCustom来显示，之前的asImageViewer这些方法当然不能用了。
//                CustomFullScreenPopup viewerPopup = new CustomFullScreenPopup(getContext());
//                new XPopup.Builder(getContext())
//                        .asCustom(viewerPopup)
//                        .show();
//
//            }
//        });

        mSelectTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), TravelSelectrActivity.class);
                getContext().startActivity(intent);
            }
        });
    }


}
