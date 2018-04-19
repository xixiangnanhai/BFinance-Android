package com.lexiangkeji.bfinance.app_api.api;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.lexiangkeji.bfinance.BFinanceApplication;
import com.lexiangkeji.bfinance.BuildConfig;
import com.lexiangkeji.bfinance.app_api.api.interceptor.ApiHeaderInterceptor;
import com.lexiangkeji.bfinance.app_api.utils.GsonHelper;
import com.readystatesoftware.chuck.ChuckInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MuckServiceGenerator {

    public static final String API_URL = "http://ic_launcher.168.2.113:9000/";
    private static final int CONNECT_TIME_OUT = 15;
    private static final int READ_TIME_OUT = 30;
    private static final int WRITE_TIME_OUT = 30;

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .client(buildOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(GsonHelper.getDefault()))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .baseUrl(API_URL);


    private static OkHttpClient buildOkHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new ApiHeaderInterceptor());

        if ( BuildConfig.DEBUG) {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(logInterceptor);
            httpClient.addInterceptor(new ChuckInterceptor(BFinanceApplication.getAppContext()));
        }
        //设置超时
        httpClient.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS);
        httpClient.readTimeout(READ_TIME_OUT, TimeUnit.SECONDS);
        httpClient.writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS);

        //设置Cookie持久化
        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(),
                        new SharedPrefsCookiePersistor(BFinanceApplication.getAppContext()));
        httpClient.cookieJar(cookieJar);

        //错误重连
        httpClient.retryOnConnectionFailure(true);
        return httpClient.build();
    }

    public static <T> T createService(Class<T> serviceClass) {
        Retrofit retrofit = builder.client(buildOkHttpClient()).build();
        return retrofit.create(serviceClass);
    }
}
