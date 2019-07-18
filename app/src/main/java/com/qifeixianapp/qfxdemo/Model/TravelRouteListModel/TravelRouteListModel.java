package com.qifeixianapp.qfxdemo.Model.TravelRouteListModel;

import com.qifeixianapp.qfxdemo.Bean.TravelRequestListBean;
import com.qifeixianapp.qfxdemo.RetrofitFactory;

import rx.Observable;

public class TravelRouteListModel implements ITravelRouteListModel {
    private  static TravelRouteListModel travelRouteListModel;

    public synchronized static TravelRouteListModel getInstance() {

        if (null == travelRouteListModel) {
            synchronized (TravelRouteListModel.class) {
                travelRouteListModel = new TravelRouteListModel();
            }
        }

        return travelRouteListModel;
    }
    @Override
    public Observable<TravelRequestListBean> getRouteList(String url,String page, String limit,String name,String tourist_type, String start_city) {
        return RetrofitFactory.getInstance().getCustomHaierAPi(url).getRouteList(page,limit,name,tourist_type,start_city);

    }
}
