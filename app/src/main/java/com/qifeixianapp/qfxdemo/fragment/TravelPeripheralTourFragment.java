package com.qifeixianapp.qfxdemo.fragment;

import android.annotation.SuppressLint;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qifeixianapp.qfxdemo.Activitiy.TravelSelectrActivity;
import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelListBean;
import com.qifeixianapp.qfxdemo.Adapter.TravelPeripheralApdater;

import com.qifeixianapp.qfxdemo.Bean.TravelRequestListBean;
import com.qifeixianapp.qfxdemo.Presenter.TravelRouteList.TravelRouteListPresenterImpl;
import com.qifeixianapp.qfxdemo.R;

import com.qifeixianapp.qfxdemo.View.ITravelRouteListView;

import com.qifeixianapp.qfxdemo.tool.ToastUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;



import java.util.ArrayList;
import java.util.List;

import static com.chad.library.adapter.base.BaseQuickAdapter.SCALEIN;


public class TravelPeripheralTourFragment extends Fragment implements ITravelRouteListView,View.OnClickListener{
    RelativeLayout mEmptyDataRefreshLayout,mDataRefreshLayout;   //数据显示和不显示
    Button mEmptyButton;
    private  final int PAGE_SIZE = 20;
    private RecyclerView mRecyclerView;
    private TravelPeripheralApdater mQuickAdapter; //适配器
    int currentPage=1; //当前页面 默认1
    TravelRouteListPresenterImpl travelRouteListPresenter; //请求接口
    List<TravelListBean> travelListBeans; //获取线路数量
    String tourist_type;  //旅游类型


    Integer count; //页面总数
    Dialog dialog; //加载中
    RefreshLayout refreshLayout; //加载中控件

    @SuppressLint("handler")
    private Handler handler=new Handler(){
        @Override
        public  void  handleMessage(Message message){
            if(message.what==1){

                 LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(layoutManager);
                mQuickAdapter=new TravelPeripheralApdater(R.layout.fragment_travel_peripheral_tour_list,travelListBeans,getContext());

                mQuickAdapter.openLoadAnimation();
                mRecyclerView.setAdapter(mQuickAdapter);
                mQuickAdapter.notifyDataSetChanged();
                refreshLayout.finishLoadMore();
                mQuickAdapter.openLoadAnimation(SCALEIN );
                mQuickAdapter.isFirstOnly(true);




                //判断适配器列表获取是否为空   显示空页面
                if(mQuickAdapter.getData().size()==0){
                    mEmptyDataRefreshLayout.setVisibility(View.VISIBLE);
                    mDataRefreshLayout.setVisibility(View.INVISIBLE);
                    dialog.dismiss();
                }else {
                    mEmptyDataRefreshLayout.setVisibility(View.INVISIBLE);
                    mDataRefreshLayout.setVisibility(View.VISIBLE);
                }
            }
        }
    };





        public TravelPeripheralTourFragment(String tourist_type){
        super();
        this.tourist_type=tourist_type;

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_travel_peripheral_tour, container, false);
        find(v);
        return v;
    }


    private void find(View v) {
        mEmptyDataRefreshLayout=v.findViewById(R.id.Travel_List_emptydata_layout);
        mDataRefreshLayout=v.findViewById(R.id.Travel_List_data_layout);
        mEmptyButton=v.findViewById(R.id.Travel_List_emptydata_Button);
        travelListBeans=new ArrayList<>();
        mRecyclerView=v.findViewById(R.id.Travel_List_TravelPeripheralTour_RecyclerView);
        refreshLayout = (RefreshLayout)v.findViewById(R.id.refreshLayout);
        mEmptyButton.setOnClickListener(this);
        travelRouteListPresenter=new TravelRouteListPresenterImpl(this);
        travelRouteListPresenter.getRouteList("http://app.qifeixian.com/index.php/",String.valueOf(currentPage),String.valueOf(PAGE_SIZE),"",tourist_type,"重庆市");

        dialog = new Dialog(getContext(),R.style.progress_dialog);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView msg =dialog.findViewById(R.id.id_tv_loadingmsg);
        msg.setText("卖力加载中");
        dialog.show();
        refreshLayout.setEnableOverScrollBounce(false);
        refreshLayout.finishLoadMore(false);


        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                int a=1;
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {

                travelRouteListPresenter.getRouteList("http://app.qifeixian.com/index.php/",String.valueOf(currentPage),String.valueOf(PAGE_SIZE),"",tourist_type,"重庆市");

                refreshlayout.setEnableScrollContentWhenLoaded(false);


            }
        });


        }


    @Override
    public void getDataFailed(Throwable e) {
        e.getMessage();

        mEmptyDataRefreshLayout.setVisibility(View.VISIBLE);
        mDataRefreshLayout.setVisibility(View.INVISIBLE);
        dialog.dismiss();
    }

    @Override
    public void getDataSuccess(TravelRequestListBean travelRequestListBean) {
//        travelListBeans=new ArrayList<>();
//        if (travelRequestListBean != null && firstload==true){
//            for (int i = 0; i < travelRequestListBean.getData().getList().size(); i++) {
//                TravelListBean travelListBean=new TravelListBean();
//                travelListBean.setTitle(travelRequestListBean.getData().getList().get(i).getName());
//                travelListBean.setAward("+"+travelRequestListBean.getData().getList().get(i).getPrice_id());
//                travelListBean.setMoney("￥"+travelRequestListBean.getData().getList().get(i).getPrice()+"起/人");
//                travelListBeans.add(travelListBean);
//            }
//            Toast.makeText(getContext(),"没有更多数据了",Toast.LENGTH_SHORT).show();
//            mQuickAdapter.addData(travelListBeans);
//            mQuickAdapter.loadMoreComplete();
//            lastPage = currentPage;
//        }
//
//


            for (int i = 0; i < travelRequestListBean.getData().getList().size(); i++) {
                TravelListBean travelListBean=new TravelListBean();
                travelListBean.setTitle(travelRequestListBean.getData().getList().get(i).getName());
                travelListBean.setAward("+"+travelRequestListBean.getData().getList().get(i).getPrice_id());
                travelListBean.setMoney("￥"+travelRequestListBean.getData().getList().get(i).getPrice()+"起/人");
                travelListBeans.add(travelListBean);


        }
        count=Integer.parseInt(travelRequestListBean.getData().getNums());
        if(Integer.parseInt(travelRequestListBean.getData().getNums())!=0 && travelRequestListBean!=null){
            currentPage++;
        }
        dialog.dismiss();
            Message message=new Message();
            message.what=1;
            handler.sendMessage(message);





    }

    @Override
    public void onClick(View v) {
        travelRouteListPresenter.getRouteList("http://app.qifeixian.com/index.php/",String.valueOf(currentPage),String.valueOf(PAGE_SIZE),"",tourist_type,"重庆市");
        dialog = new Dialog(getContext(),R.style.progress_dialog);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView msg =dialog.findViewById(R.id.id_tv_loadingmsg);
        msg.setText("卖力加载中");
        dialog.show();
        }
}







//
//    private void find(View v) {
//        listBeans=new ArrayList<>();
//        recyclerView=v.findViewById(R.id.Travel_List_TravelPeripheralTour_RecyclerView);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        travelPeripheralApdater=new TravelPeripheralApdater(R.layout.fragment_travel_peripheral_tour_list,listBeans,getContext());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(travelPeripheralApdater);
//        travelPeripheralApdater.openLoadAnimation(SCALEIN );
//        travelPeripheralApdater.isFirstOnly(true);
//        travelPeripheralApdater.setOnLoadMoreListener(this,recyclerView);
//        travelRouteListPresenter.getRouteList("http://app.qifeixian.com/index.php/",String.valueOf(Page),String.valueOf(limit),"",tourist_type,"重庆");
//        //上拉加载
//
//    }




//    List<TravelListBean> listBeans;
//    TravelRouteListPresenterImpl travelRouteListPresenter;
//    TravelPeripheralApdater travelPeripheralApdater;
//    RecyclerView recyclerView;
//    boolean isloading=false;
//    String tourist_type;
//    boolean isErr;
//     static int  NUMS;
//     static int Page=1;
//     static int limit=5;
//     static int count;
//    public TravelPeripheralTourFragment(String tourist_type){
//        super();
//        this.tourist_type=tourist_type;
//
//    }
//
//
//    @SuppressLint("handler")
//    private Handler handler=new Handler(){
//        @Override
//        public  void  handleMessage(Message message){
//            if(message.what==1){
//
//
//            }
//        }
//    };