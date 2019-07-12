package com.qifeixianapp.qfxdemo.Model.TravelRouteListModel;

import com.qifeixianapp.qfxdemo.Bean.TravelRequestListBean;

import rx.Observable;

public interface ITravelRouteListModel {
    Observable<TravelRequestListBean> getRouteList(String url,String page, String limit,String name,String start_city);
}
