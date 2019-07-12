package com.qifeixianapp.qfxdemo.View;

import com.qifeixianapp.qfxdemo.Bean.TravelRequestListBean;

public interface ITravelRouteListView {
    void getDataFailed(Throwable e);
    void getDataSuccess(TravelRequestListBean travelRequestListBean);
}
