package com.lexiangkeji.bfinance.app_api.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class GsonHelper {
    private static Gson sGson;

    public static synchronized Gson getDefault() {
        if (sGson == null) {
            sGson = new GsonBuilder()
                    .create();
        }
        return sGson;
    }

    public static Map<String, Object> json2Map(String jsonStr) {
        return getDefault()
                .fromJson(jsonStr, new TypeToken<HashMap<String, Object>>() {
                }.getType());
    }

    public static Map<String, String> json2StringMap(String jsonStr) {
        return getDefault()
                .fromJson(jsonStr, new TypeToken<HashMap<String, String>>() {
                }.getType());
    }

    public static <T> T json2Object(String jsonStr, Class<T> clazz) {
        return getDefault()
                .fromJson(jsonStr, clazz);
    }

    public static String toJsonString(Object obj) {
        return getDefault().toJson(obj);
    }
}
