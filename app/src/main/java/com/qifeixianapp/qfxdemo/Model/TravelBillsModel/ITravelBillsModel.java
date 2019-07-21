package com.qifeixianapp.qfxdemo.Model.TravelBillsModel;



import com.qifeixianapp.qfxdemo.Bean.TravelBillsBean;

import rx.Observable;

public interface ITravelBillsModel {
    Observable<TravelBillsBean> getRouteDetail(String url,String route_id,String price_id);
}
