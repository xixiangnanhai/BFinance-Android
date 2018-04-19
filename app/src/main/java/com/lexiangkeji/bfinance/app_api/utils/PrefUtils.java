package com.lexiangkeji.bfinance.app_api.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefUtils {

    public static final String PREF_FIRST_IN_APP = "pref_first_in_app";
    public static final String PREF_MORTGAGE_CITY = "pref_mortgage_city";

    public static boolean getPrefFirstInApp(final Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(PREF_FIRST_IN_APP, true);
    }

    public static void setPrefFirstInApp(final Context context, boolean b) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(PREF_FIRST_IN_APP, b).commit();
    }

    public static String getPrefMortageCity(final Context context) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getString(PREF_MORTGAGE_CITY, null);
    }

    public static void setPrefMortageCity(final Context context, String city) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putString(PREF_MORTGAGE_CITY, city).commit();
    }

}