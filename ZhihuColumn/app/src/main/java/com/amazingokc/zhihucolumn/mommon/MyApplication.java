package com.amazingokc.zhihucolumn.mommon;

import android.app.Application;
import android.content.Context;

/**
 * Created by cjy on 2017/3/7.
 */

public class MyApplication extends Application {

    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }

    public static Context getApplication() {
        return context;
    }
}
