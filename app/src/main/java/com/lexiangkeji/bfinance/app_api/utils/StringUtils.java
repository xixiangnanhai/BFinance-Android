package com.lexiangkeji.bfinance.app_api.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.annotation.RawRes;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * Created by Eric.Gao on 2017/11/2.
 */

public class StringUtils {

    /**
     * 判断是否为空
     */
    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    /**
     * 判断是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isDecimal(String str) {
        if (TextUtils.isEmpty(str))
            return false;
        Pattern pattern = Pattern.compile("[0-9]*(\\.?)[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 将assets下的文件读成String
     *
     * @param context           上下文
     * @param strAssertFileName 文件名
     * @return 文件里面的字符串
     */
    public static String readAssertResource(Context context, String strAssertFileName) {
        AssetManager assetManager = context.getAssets();
        String strResponse = "";
        try {
            InputStream ims = assetManager.open(strAssertFileName);
            strResponse = getStringFromInputStream(ims);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        return strResponse;
    }

    /**
     * 读取Raw的文件
     *
     * @param context 上下文
     * @param id      文件夹id
     * @return 文件里面的字符串
     */
    public static String readRawResource(Context context, @RawRes int id) {
        String strResponse = "";
        try {
            InputStream ims = context.getResources().openRawResource(id);
            strResponse = getStringFromInputStream(ims);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
        return strResponse;
    }

    private static String getStringFromInputStream(InputStream a_is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(a_is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }
        return sb.toString();
    }
}
