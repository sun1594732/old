package com.contact.contactdemo.Util;

import android.content.Context;
import android.widget.Toast;

import com.contact.contactdemo.MyApplication;

/**
 * Created by Administrator on 2016/8/3.
 */
public class ToastUtils {
    private static Context context = MyApplication.getAppContext();
    /**
     * 短吐司
     * */
    public static void ToastShort(String content){
        Toast.makeText(context,content,Toast.LENGTH_SHORT).show();
    }
    /**
     * 长吐司
     * */
    public static void ToastLong(String content){
        Toast.makeText(context,content,Toast.LENGTH_LONG).show();
    }
}
