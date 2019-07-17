package com.qifeixianapp.qfxdemo.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qifeixianapp.qfxdemo.Activitiy.PdfActivity;
import com.qifeixianapp.qfxdemo.Activitiy.TravelReserveActivity;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelListBean;
import com.qifeixianapp.qfxdemo.Adapter.TravelPeripheralApdater;
import com.qifeixianapp.qfxdemo.Bean.TravelRequestListBean;
import com.qifeixianapp.qfxdemo.Presenter.TravelRouteList.TravelRouteListPresenterImpl;
import com.qifeixianapp.qfxdemo.R;
import com.qifeixianapp.qfxdemo.View.ITravelRouteListView;
import com.qifeixianapp.qfxdemo.tool.ToastUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;
import static android.nfc.tech.MifareUltralight.get;
import static com.chad.library.adapter.base.BaseQuickAdapter.ALPHAIN;
import static com.chad.library.adapter.base.BaseQuickAdapter.SCALEIN;


public class TravelPeripheralTourFragment extends Fragment implements ITravelRouteListView {
    List<TravelListBean> listBeans;
    TravelRouteListPresenterImpl travelRouteListPresenter;
    RecyclerView recyclerView;
    boolean isloading=false;


    @SuppressLint("handler")
    private Handler handler=new Handler(){
        @Override
        public  void  handleMessage(Message message){
            if(message.what==1){
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                final TravelPeripheralApdater travelPeripheralApdater=new TravelPeripheralApdater(R.layout.fragment_travel_peripheral_tour_list,listBeans,getContext());
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(travelPeripheralApdater);
                travelPeripheralApdater.openLoadAnimation(SCALEIN );
                travelPeripheralApdater.isFirstOnly(true);
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_travel_peripheral_tour, container, false);
        find(v);
        travelRouteListPresenter=new TravelRouteListPresenterImpl(this);
        travelRouteListPresenter.getRouteList("http://app.qifeixian.com/index.php/","1","10","","重庆");


        return v;
    }

    private void find(View v) {
        listBeans=new ArrayList<>();
        recyclerView=v.findViewById(R.id.Travel_List_TravelPeripheralTour_RecyclerView);

//        //上拉加载
//        travelPeripheralApdater.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override public void onLoadMoreRequested() {
//                recyclerView.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (size[0] >= 100) {
//                            //数据全部加载完毕
//                            travelPeripheralApdater.loadMoreEnd();
//                        } else {
//                            if (isErr) {
//                                //成功获取更多数据（可以直接往适配器添加数据）
//                                travelPeripheralApdater.addData(10,listBeans);
//                                size[0] = travelPeripheralApdater.getData().size();
//                                //主动调用加载完成，停止加载
//                                travelPeripheralApdater.loadMoreComplete();
//                            } else {
//                                //获取更多数据失败
//                                isErr = true;
//                                ToastUtils.show(getContext(),"shibia ");
//                                //同理，加载失败也要主动调用加载失败来停止加载（而且该方法会提示加载失败）
//                                travelPeripheralApdater.loadMoreFail();
//
//                            }
//                        }
//                    }
//
//                }, 12);
//            }
//        }, recyclerView);

    }


    @Override
    public void getDataFailed(Throwable e) {
        String localizedMessage = e.getLocalizedMessage();
        Log.e("TravelRounteList",localizedMessage);
    }

    @Override
    public void getDataSuccess(TravelRequestListBean travelRequestListBean) {
        listBeans=new ArrayList<>();
        for (int i = 0; i < travelRequestListBean.getData().getList().size(); i++) {
            TravelListBean travelListBean=new TravelListBean();
            travelListBean.setTitle(travelRequestListBean.getData().getList().get(i).getName());
            travelListBean.setAward("+"+travelRequestListBean.getData().getList().get(i).getPrice_id());

            travelListBean.setMoney("￥"+travelRequestListBean.getData().getList().get(i).getPrice()+"起/人");
            listBeans.add(travelListBean);
        }

        Message message=new Message();
        message.what=1;
        handler.sendMessage(message);

        isloading=true;
    }
}
