package com.lexiangkeji.bfinance.common.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 樊磊 on 2018/4/4.
 */

public final class GsonUtils {

    private GsonUtils() {
        throw new UnsupportedOperationException("you can't instantiate me...");
    }

    private static class GsonUtilHolder {
        static Gson instance = new Gson();
    }

    public static Gson getInstance() {
        return GsonUtilHolder.instance;
    }

    public void objectToJson(Object obj) {
        getInstance().toJson(obj);
    }

    public <T> T jsonToObject(String json, Class<T> cls) {
        return getInstance().fromJson(json, cls);
    }

}
