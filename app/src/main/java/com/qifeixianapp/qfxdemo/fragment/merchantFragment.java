package com.qifeixianapp.qfxdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qifeixianapp.qfxdemo.Adapter.MerchantListAdapter;

import com.qifeixianapp.qfxdemo.Adapter.MerchantMenuAdapter;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;


public class merchantFragment extends Fragment implements OnBannerListener {
    Banner mbanner;
    List<String> mMerchantTitle;
    List<Integer> mMerchantImage;
    RecyclerView mRecyclerView;

    List<String> mMerchantTitleList;
    List<String> mMerchantTitleConsumption;
    List<String> mMerchantTitleHost;
    List<Integer> mMerchantImageList;
    RecyclerView mRecyclerViewList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_merchant, container, false);

        findid(v);
        bannersetting();
        recyclersetting();
        recyclerListsetting();
        return v;
    }

    private void recyclerListsetting() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
     //    mRecyclerViewList.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));//横线
        mRecyclerViewList.setLayoutManager(linearLayoutManager);
        mRecyclerViewList.setAdapter(new MerchantListAdapter(getContext(),mMerchantTitleList,mMerchantTitleConsumption,mMerchantTitleHost,mMerchantImageList));
    }

    /**
     * 列表设置
     */
    private void recyclersetting() {
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),4);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(new MerchantMenuAdapter(getContext(),mMerchantTitle,mMerchantImage));


    }
    private void findid(View v) {

    mbanner=v.findViewById(R.id.mbanner);
    mRecyclerViewList=v.findViewById(R.id.merchant_Home_List);
    mRecyclerView=v.findViewById(R.id.merchanthome);
    mMerchantTitleList=new ArrayList<>();
    mMerchantTitleConsumption=new ArrayList<>();
    mMerchantTitleHost=new ArrayList<>();
    mMerchantImageList=new ArrayList<>();
    mMerchantTitle=new ArrayList<>();
    mMerchantImage=new ArrayList<>();

    mMerchantImage.add(R.drawable.merhanticon_1);
    mMerchantImage.add(R.drawable.merhanticon_2);
    mMerchantImage.add(R.drawable.merhanticon_5);
    mMerchantImage.add(R.drawable.merhanticon_6);
    mMerchantImage.add(R.drawable.merhanticon_7);
    mMerchantImage.add(R.drawable.merhanticon_8);
    mMerchantImage.add(R.drawable.merhanticon_9);
    mMerchantImage.add(R.drawable.merhanticon_44);
    mMerchantTitle.add("美食餐饮");
    mMerchantTitle.add("酒店住宿");
    mMerchantTitle.add("休闲娱乐");
    mMerchantTitle.add("生活服务");
    mMerchantTitle.add("汽车服务");
    mMerchantTitle.add("丽人美发");
    mMerchantTitle.add("运动健身");
    mMerchantTitle.add("免费入住");

        for (int i = 0; i <12 ; i++) {
            mMerchantTitleList.add("千源九宫格老火锅(新华路店");
            mMerchantTitleConsumption.add("人均消费80元");
            mMerchantTitleHost.add("重庆解放碑 国贸中心对面2楼");
            mMerchantImageList.add(R.drawable.merhant1);
        }


    }

    private void bannersetting() {
        mbanner.setImageLoader(new GlideImageLoader());
        final List<String> list=new ArrayList<>();
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552812527473&di=49786bdc1937ae4a28c4c01e709dcd10&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2017-12-05%2F5a262f421fccd.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552814100617&di=ccd90978b039c1b990ab8841f3e85460&imgtype=0&src=http%3A%2F%2Fimg2.ph.126.net%2FhZSpKs9G6jUlTS6J-e-xoA%3D%3D%2F6631417410401878349.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552814100616&di=3fd6ebe396d1001037b12fcccb374ea6&imgtype=0&src=http%3A%2F%2Fimg2.ph.126.net%2FC56h7v-DL3caFkFTxdn7dw%3D%3D%2F6630472929908798903.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1552814100614&di=a925f47f0fae4b3f6aae83ebac3af526&imgtype=0&src=http%3A%2F%2Fimg2.ph.126.net%2F8qSIEmPAwjnxDLtUZVXb7A%3D%3D%2F6631720875607361156.jpg");
        mbanner.setImages(list)
                .setBannerAnimation(Transformer.DepthPage).setOnBannerListener(this).start();
        mbanner.setBannerAnimation(Transformer.Stack);
    }


    @Override
    public void OnBannerClick(int position) {

    }
}
