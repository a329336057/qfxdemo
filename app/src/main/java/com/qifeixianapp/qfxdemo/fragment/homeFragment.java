package com.qifeixianapp.qfxdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Activitiy.SelectCityActivity;
import com.qifeixianapp.qfxdemo.Adapter.Bean.HomeMuenBean;
import com.qifeixianapp.qfxdemo.Adapter.Bean.HomeThemeBean;
import com.qifeixianapp.qfxdemo.Adapter.HomeMuenAdapter;
import com.qifeixianapp.qfxdemo.Adapter.HomeThemeAdapter;
import com.qifeixianapp.qfxdemo.Adapter.MyHomtTypePagerAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.GlideImageLoader;
import com.qifeixianapp.qfxdemo.tool.SharedPreferencesUtil;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class homeFragment extends Fragment  implements View.OnClickListener {

        LinearLayout home_Location;
        TextView mLocaltionText;
        LinearLayout mSelectLinearLayout;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            SharedPreferencesUtil.getInstance(getContext(),"homedata");
            View v= inflater.inflate(R.layout.fragment_home, container, false);
            find(v);
            return  v;
        }

        private void find(View v) {
            home_Location=v.findViewById(R.id.home_Location);
            mLocaltionText = v.findViewById(R.id.home_localtion);
            mSelectLinearLayout = v.findViewById(R.id.home_select);
            String localtion = String.valueOf(SharedPreferencesUtil.getData("localtion", "重庆"));
            mLocaltionText.setText(localtion);
            home_Location.setOnClickListener(this);


        }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_Location:
                Intent intent=new Intent(getContext(), SelectCityActivity.class);
                getActivity().startActivity(intent);
                break;
        }

    }
}
