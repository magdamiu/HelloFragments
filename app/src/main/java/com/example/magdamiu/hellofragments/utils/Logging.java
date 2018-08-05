package com.example.magdamiu.hellofragments.utils;

import android.util.Log;

import com.example.magdamiu.hellofragments.BuildConfig;

public class Logging {

    public static void show(Object obj, String message) {
        if (BuildConfig.DEBUG) {
            Log.e(obj.getClass().getName(), message);
        }
    }

    public static void show(Object obj, String message, Throwable e) {
        if (BuildConfig.DEBUG) {
            Log.e(obj.getClass().getName(), message, e);
        }
    }
}