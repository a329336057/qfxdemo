package com.qifeixianapp.qfxdemo.Model.TravelBillsModel;

import com.qifeixianapp.qfxdemo.Bean.TravelBillsBean;
import com.qifeixianapp.qfxdemo.RetrofitFactory;

import rx.Observable;

public class TravelBillsModel implements ITravelBillsModel {
    private  static TravelBillsModel travelBillsModel;

    public synchronized static TravelBillsModel getInstance() {

        if (null == travelBillsModel) {
            synchronized (TravelBillsModel.class) {
                travelBillsModel = new TravelBillsModel();
            }
        }

        return travelBillsModel;
    }

    @Override
    public Observable<TravelBillsBean> getRouteDetail(String url,String route_id, String price_id) {
        return RetrofitFactory.getInstance().getCustomHaierAPi(url).getRouteDetail(route_id,price_id);
    }
}
