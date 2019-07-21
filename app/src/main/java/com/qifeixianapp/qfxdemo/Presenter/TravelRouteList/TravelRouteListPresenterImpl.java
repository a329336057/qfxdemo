package com.qifeixianapp.qfxdemo.Presenter.TravelRouteList;

import com.qifeixianapp.qfxdemo.Bean.TravelRequestListBean;
import com.qifeixianapp.qfxdemo.Model.TravelRouteListModel.TravelRouteListModel;
import com.qifeixianapp.qfxdemo.View.ITravelRouteListView;
import com.qifeixianapp.qfxdemo.tool.AndroidScheduler;

import rx.Subscriber;
import rx.schedulers.Schedulers;

public class TravelRouteListPresenterImpl  implements com.qifeixianapp.qfxdemo.Presenter.TravelRouteList.ITravelRouteListPresenter {

    private TravelRouteListModel travelRouteListModel;
    private ITravelRouteListView view;

    public TravelRouteListPresenterImpl(ITravelRouteListView view){
        travelRouteListModel  =travelRouteListModel.getInstance();
        this.view=view;
    }
    @Override
    public void getRouteList(String baseUrl, String page,String limit,String name,String tourist_type,String start_city) {
        travelRouteListModel.getRouteList(baseUrl,page,limit,name,tourist_type,start_city)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidScheduler.mainThread(),false,100)
                .subscribe(new Subscriber<TravelRequestListBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.getDataFailed(e);
                    }

                    @Override
                    public void onNext(TravelRequestListBean travelRequestListBean) {
                        view.getDataSuccess(travelRequestListBean);
                    }

                });
    }
}
