package com.test.testdemo.Util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


/**
 * Created by imac on 15/4/10.
 */
public class AlertDialogUtil {

    public static void showAlertDialog(Context context, String title, String message, DialogInterface.OnClickListener listener, DialogInterface.OnClickListener cancelListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog.THEME_HOLO_LIGHT);
        builder.setCancelable(false);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("确定", listener);
        builder.setNegativeButton("取消", cancelListener);
        builder.show();
    }
}
