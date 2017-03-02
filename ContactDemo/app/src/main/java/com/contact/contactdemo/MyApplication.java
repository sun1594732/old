package com.contact.contactdemo;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application{
    /**
    * 提供app全局上下文对象
    * */
    private static MyApplication mContext;
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        mContext = this;

    }
    /**
     * 全局获取context的方法
     * */
    public static Context getAppContext(){
        return mContext;
    }
}
