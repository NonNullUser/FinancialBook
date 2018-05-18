package com.wyh.financialbook;

import android.app.Application;
import android.content.Context;

/**
 * Created by wyh on 18-5-18
 */
public class BaseApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        //获取Context
        context = getApplicationContext();
    }

    //返回
    public static Context getContext() {
        return context;
    }
}
