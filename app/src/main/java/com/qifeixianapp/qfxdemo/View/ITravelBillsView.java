package com.qifeixianapp.qfxdemo.View;

import com.qifeixianapp.qfxdemo.Adapter.Bean.TravelListBean;
import com.qifeixianapp.qfxdemo.Bean.TravelBillsBean;


public interface ITravelBillsView {
    void getDataFailed(Throwable e);
    void getDataSuccess(TravelBillsBean travelBillsBean);
}
