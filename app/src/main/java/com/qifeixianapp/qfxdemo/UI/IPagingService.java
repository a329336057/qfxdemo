package com.qifeixianapp.qfxdemo.UI;

import java.util.List;

import rx.Observer;

public interface IPagingService<T extends List> {
    /**
     * 加载分页数据
     * @param page 加载第几页
     * @param limit 1页加载多少条
     */
    void getData(int page,int limit, Observer<T> observer);
}
