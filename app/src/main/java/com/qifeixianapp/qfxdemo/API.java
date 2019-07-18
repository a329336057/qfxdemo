package com.qifeixianapp.qfxdemo;

import com.qifeixianapp.qfxdemo.Bean.TravelRequestListBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface API {
        @GET("travel/travels/getRouteList")
        Observable<TravelRequestListBean> getRouteList(@Query("page")String page, @Query("limit")String limit,@Query("name")String selectname,@Query("tourist_type")String tourist_type,@Query("start_city")String start_city);
}
