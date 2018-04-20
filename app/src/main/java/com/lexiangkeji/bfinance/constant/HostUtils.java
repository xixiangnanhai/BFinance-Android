package com.lexiangkeji.bfinance.constant;

import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;
import com.lexiangkeji.bfinance.BuildConfig;

/**
 * Created by Eric.Gao on 2017/11/27.
 */

public class HostUtils {
    public static final String KApiUrlTestName = "Test环境";
    public static final String KApiUrlTest = "http://test.imhuasheng.com/";
    public static final String KApiUrlTest2Name = "Test2环境";
    public static final String KApiUrlTest2 = "http://test2.imhuasheng.com/";
    public static final String KApiUrlDebugUatName = "Uat环境";
    public static final String KApiUrlDebugUat = "http://uat.imhuasheng.com/";
    public static final String KApiUrlRelease = "https://hsapi.imhuasheng.com/";
    /*//               apiUrlDebug          : 'http://192.168.1.101:8080/platform/',
               apiUrlDebug          : 'http://test.imhuasheng.com/',
               apiUrlDebugUat       : 'http://uat.imhuasheng.com/',
//               apiUrlDebug         : 'https://stg.imhuasheng.com/',
//               apiUrlDebug         : 'https://hsapi.imhuasheng.com/',
//               apiUrlDebug         : 'http://192.168.1.122:8080/cddd-server-app/',
//               apiUrlRelease        : 'http://test.imhuasheng.com/',
               apiUrlRelease        : 'https://hsapi.imhuasheng.com/',
//               apiUrlRelease        : 'https://stg.imhuasheng.com/',*/

    private static String mCurrentHost;
    private static HostUtils mInstance;

    private HostUtils() {
    }

    public static HostUtils getInstance() {
        if (mInstance == null) {
            mInstance = new HostUtils();
        }
        return mInstance;
    }

    public void initHost() {
        if ( BuildConfig.DEBUG) {
            mCurrentHost = SPUtils.getInstance(Constants.SP.SP_HOST).getString(Constants.SP.CURRENT_HOST, KApiUrlTest);
        } else {
            mCurrentHost = KApiUrlRelease;
        }
    }

    public String getCurrentHost() {
        if (BuildConfig.DEBUG) {
            return TextUtils.isEmpty(mCurrentHost) ? KApiUrlTest : mCurrentHost;
        }
        return KApiUrlRelease;
    }

    public void switchHost(String host) {
        mCurrentHost = null;
        SPUtils.getInstance(Constants.SP.SP_HOST).put(Constants.SP.CURRENT_HOST, host);
        mCurrentHost = host;
    }

}
