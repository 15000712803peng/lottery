package com.cai.newc.data;

import android.app.Application;
import android.content.Context;

import com.cai.newc.live.FakeServer;
import com.cai.newc.live.LiveKit;

/**
 * Created by Administrator on 2017/11/17 0017.
 */

public class App extends Application{

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        LiveKit.init(context, FakeServer.getAppKey());

    }

    public static Context getContext() {
        return context;
    }
}
