package com.cai.newc.data;

import android.app.Application;
import android.content.Context;


/**
 * Created by Administrator on 2017/11/17 0017.
 */

public class App extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

    }

    public static Context getContext() {
        return context;
    }
}
