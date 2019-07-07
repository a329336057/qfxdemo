package com.qifeixianapp.qfxdemo.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelListBean;
import com.qifeixianapp.qfxdemo.Adapter.TravelPeripheralApdater;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;
import static android.nfc.tech.MifareUltralight.get;
import static com.chad.library.adapter.base.BaseQuickAdapter.ALPHAIN;
import static com.chad.library.adapter.base.BaseQuickAdapter.SCALEIN;


public class TravelPeripheralTourFragment extends Fragment {
    List<TravelListBean> listBeans;

    RecyclerView recyclerView;
    boolean isErr=true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_travel_peripheral_tour, container, false);
        find(v);
        return v;
    }

    private void find(View v) {
        listBeans=new ArrayList<>();

        recyclerView=v.findViewById(R.id.Travel_List_TravelPeripheralTour_RecyclerView);

        for (int i = 0; i < 10; i++) {
            TravelListBean travelListBean=new TravelListBean();
            travelListBean.setAward("+"+"80");
            travelListBean.setTitle("昆明+大理+丽江+玉龙雪山冰川大索道双飞一动6日跟团游");
            travelListBean.setMoney("80020"+"起/人");
            travelListBean.setIamgeurl("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1920985182,1866518500&fm=26&gp=0.jpg");
            listBeans.add(travelListBean);
        }

        //创建布局管理

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        final TravelPeripheralApdater travelPeripheralApdater=new TravelPeripheralApdater(R.layout.fragment_travel_peripheral_tour_list,listBeans,getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(travelPeripheralApdater);
        travelPeripheralApdater.openLoadAnimation(SCALEIN );
        travelPeripheralApdater.isFirstOnly(true);
        final int[] size = {travelPeripheralApdater.getData().size()};

        travelPeripheralApdater.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                TextView textView =view.findViewById(R.id.Travel_perpherak_tour_list_title);
                ToastUtils.show(getContext(),"点击了"+textView.getText());
            }
        });







        //上拉加载
        travelPeripheralApdater.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override public void onLoadMoreRequested() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (size[0] >= 100) {
                            //数据全部加载完毕
                            travelPeripheralApdater.loadMoreEnd();
                        } else {
                            if (isErr) {
                                //成功获取更多数据（可以直接往适配器添加数据）
                                travelPeripheralApdater.addData(10,listBeans);
                                size[0] = travelPeripheralApdater.getData().size();
                                //主动调用加载完成，停止加载
                                travelPeripheralApdater.loadMoreComplete();
                            } else {
                                //获取更多数据失败
                                isErr = true;
                                ToastUtils.show(getContext(),"shibia ");
                                //同理，加载失败也要主动调用加载失败来停止加载（而且该方法会提示加载失败）
                                travelPeripheralApdater.loadMoreFail();

                            }
                        }
                    }

                }, 12);
            }
        }, recyclerView);








    }


}
