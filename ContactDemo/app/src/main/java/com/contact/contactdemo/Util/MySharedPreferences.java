package com.contact.contactdemo.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.Set;

public class MySharedPreferences {

    private static Editor editor;
    private static SharedPreferences mySharePreference;
    private static MySharedPreferences _instance = null;

    private MySharedPreferences(Context context) {

        mySharePreference = context.getSharedPreferences(
                "MySharedPreferencesEdit", Context.MODE_PRIVATE);
        editor = mySharePreference.edit();
    }

    public static MySharedPreferences getInstance(Context ct) {
        if (_instance == null)
            _instance = new MySharedPreferences(ct);
        return _instance;
    }

    public void setString(String key, String value) {
        editor = mySharePreference.edit();
        editor.putString(key, value);
        editor.commit();

    }

    public void setStringSet(String key, Set<String> stringSet) {
        editor = mySharePreference.edit();
        editor.putStringSet(key, stringSet);
        editor.commit();
    }


    public void setInt(String key, int value) {
        editor = mySharePreference.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key, int value) {
        return mySharePreference.getInt(key, value);
    }

    public String getString(String key) {
        return mySharePreference.getString(key, "");
    }

    public void setBoolean(String key, Boolean value) {

        editor = mySharePreference.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public Boolean getBoolean(String key) {
        return mySharePreference.getBoolean(key, false);
    }

    public Set<String> getStringSet(String key) {
        return mySharePreference.getStringSet(key, null);
    }

    public boolean isFirstLauncher() {
        return mySharePreference.getBoolean("isFirstLauncher", true);
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }
}
