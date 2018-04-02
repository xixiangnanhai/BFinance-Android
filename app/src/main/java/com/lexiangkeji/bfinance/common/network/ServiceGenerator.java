package com.lexiangkeji.bfinance.common.network;

import com.google.gson.Gson;
import com.lexiangkeji.bfinance.common.data.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static String API_URL = Constants.NetWorkUrl.BASE_URL;

    private static final int CONNECT_TIME_OUT = 20;
    private static final int READ_TIME_OUT = 20;
    private static final int WRITE_TIME_OUT = 20;

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .client(buildOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(new Gson()))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    private static OkHttpClient buildOkHttpClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
//        httpClientBuilder.addInterceptor(new ApiHeaderInterceptor());

        //设置超时
        httpClientBuilder.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(READ_TIME_OUT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS);

        //错误重连
//        httpClientBuilder.retryOnConnectionFailure(true);
        return httpClientBuilder.build();
    }


    public static <T> T createService(Class<T> serviceClass) {
        Retrofit retrofit = builder.client(buildOkHttpClient()).build();
        return retrofit.create(serviceClass);
    }
}
