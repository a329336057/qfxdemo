package com.qifeixianapp.qfxdemo.Presenter.TravelBills;

import com.qifeixianapp.qfxdemo.Bean.TravelBillsBean;
import com.qifeixianapp.qfxdemo.Model.TravelBillsModel.TravelBillsModel;
import com.qifeixianapp.qfxdemo.View.ITravelBillsView;
import com.qifeixianapp.qfxdemo.tool.AndroidScheduler;

import rx.Subscriber;

import rx.schedulers.Schedulers;

public class TraveBillsPrsenterImpl implements ITravelBillsPresenter{
    private TravelBillsModel travelBillsModel;
    private ITravelBillsView view;

    public TraveBillsPrsenterImpl(ITravelBillsView view){
        travelBillsModel  =travelBillsModel.getInstance();
        this.view=view;
    }
    @Override
    public void getRouteDetail(String baseUrl, String route_id, String price_id) {
        travelBillsModel.getRouteDetail(baseUrl,route_id,price_id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidScheduler.mainThread(),false,100)
                .subscribe(new Subscriber<TravelBillsBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.getDataFailed(e);
                    }

                    @Override
                    public void onNext(TravelBillsBean travelBillsBean) {
                        view.getDataSuccess(travelBillsBean);
                    }

                });
    }
}
