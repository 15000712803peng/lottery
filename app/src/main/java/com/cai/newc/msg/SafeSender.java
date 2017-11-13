package com.cai.newc.msg;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;


public class SafeSender extends Handler{

    private WeakReference<OnMessageReceiver> onMessageReceiver;
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if(onMessageReceiver != null && onMessageReceiver.get() != null){
            onMessageReceiver.get().onMessage(msg);
        }
    }

    public SafeSender(OnMessageReceiver onMessageReceiver){
        this.onMessageReceiver = new WeakReference<>(onMessageReceiver);
    }

    public static interface OnMessageReceiver{
        void onMessage(Message msg);
    };
}
