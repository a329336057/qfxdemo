package com.qifeixianapp.qfxdemo;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static RetrofitFactory ourInstance;
    public synchronized static RetrofitFactory getInstance() {
        if (null == ourInstance) {
            synchronized (RetrofitFactory.class) {
                if (ourInstance == null) {
                    ourInstance = new RetrofitFactory();
                }
            }
        }
        return ourInstance;
    }
    public API getCustomHaierAPi(String baseUrl) {
        return getRetrofit(baseUrl).create(API.class);
    }
    public Retrofit getRetrofit(String baseUrl) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
//                AirLogger.debugE("okhttp",message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000, TimeUnit.MILLISECONDS)
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }
}
