package com.lexiangkeji.bfinance.common.data;

import com.lexiangkeji.bfinance.BuildConfig;

/**
 * Created by 樊磊 on 2018/4/2.
 * <p>
 * 常用数据类
 */

public class Constants {

    public static class NetWorkUrl {
        private static String RELEASE_URL = "";
        private static String DEBUG_URL = "";
        public static String BASE_URL = BuildConfig.DEBUG ? DEBUG_URL : RELEASE_URL;
    }

}
