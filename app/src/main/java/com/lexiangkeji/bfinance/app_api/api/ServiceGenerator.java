package com.lexiangkeji.bfinance.app_api.api;

import android.text.TextUtils;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.lexiangkeji.bfinance.BFinanceApplication;
import com.lexiangkeji.bfinance.BuildConfig;
import com.lexiangkeji.bfinance.app_api.api.interceptor.ApiHeaderInterceptor;
import com.lexiangkeji.bfinance.app_api.utils.FilePathUtil;
import com.lexiangkeji.bfinance.app_api.utils.GsonHelper;
import com.readystatesoftware.chuck.ChuckInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    public static String API_URL = "";
    private static final int CONNECT_TIME_OUT = 30;
    private static final int READ_TIME_OUT = 30;
    private static final int WRITE_TIME_OUT = 30;
    public static OkHttpClient mOkHttpClient;
    public static ClearableCookieJar mCookieJar;

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .client(buildOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(GsonHelper.getDefault()))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

    public static void setHost(String host) {
        API_URL = host;
        builder.baseUrl(host);
    }

    private static OkHttpClient buildOkHttpClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(new ApiHeaderInterceptor());

        if ( BuildConfig.DEBUG) {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(logInterceptor);
            httpClientBuilder.addInterceptor(new ChuckInterceptor(BFinanceApplication.getAppContext()));
        }
        //设置超时
        httpClientBuilder.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(READ_TIME_OUT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS);

        //设置Cookie持久化
        mCookieJar =
                new PersistentCookieJar(new SetCookieCache(),
                        new SharedPrefsCookiePersistor(BFinanceApplication.getAppContext()));
        httpClientBuilder.cookieJar(mCookieJar);

        Cache cache = initCache();
        if (cache != null) {
            httpClientBuilder.cache(cache);
        }

        //错误重连
//        httpClientBuilder.retryOnConnectionFailure(true);
        mOkHttpClient = httpClientBuilder.build();
        return mOkHttpClient;
    }

    private static final long CACHE_SIZE = 1000 * 1000 * 20;//20m

    private static Cache initCache() {
        String cacheDir = FilePathUtil.getDirectoryPriorInstinct(BFinanceApplication.getAppContext(), FilePathUtil.CachePathType.CACHE);
        if (!TextUtils.isEmpty(cacheDir)) {
            cacheDir = cacheDir + "netCache";
            File file = new File(cacheDir);
            boolean fileExist;
            if (!file.exists()) {
                fileExist = file.mkdirs();
            } else {
                fileExist = true;
            }
            if (fileExist) {
                return new Cache(file, CACHE_SIZE);
            }
        }
        return null;
    }

    public static <T> T createService(Class<T> serviceClass) {
        Retrofit retrofit = builder.client(buildOkHttpClient()).build();
        return retrofit.create(serviceClass);
    }
}
