package com.test.testdemo.Util;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class CustomDialog extends Dialog {

    private static int default_width = 160; // 默认宽度
    private static int default_height = 120;// 默认高度


    public CustomDialog(Context context, View layout, int style) {
        this(context, default_width, default_height, layout, style);
    }



    //    自定义对话框代码：
    public CustomDialog(Context context, int width, int height, View layout,
                        int style) {
        super(context, style);
        setContentView(layout);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0; // 新位置X坐标
        params.y = 0; // 新位置Y坐标
        params.width = width; // 宽度
        params.height = height; // 高度
        window.setAttributes(params);
    }

}