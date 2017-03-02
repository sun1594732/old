package com.contact.contactdemo.Util;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/9/8.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int VERSION = 1;
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String infoSql = "create table if not exists people(_id Integer primary key autoincrement,name text,content text,publishtime text,phone text)";
        db.execSQL(infoSql);
//        String headSql = "create table if not exists head(_id Integer primary key autoincrement,news_id integer,title text,source text,publishtime text,imgurl1 text,imgurl2 text,imgurl3 text,videoImgurl text,imageNumber integer,isVideo interger)";
//        db.execSQL(headSql);
//        String deviceSql = "create table if not exists device(_id Integer primary key autoincrement,news_id integer,title text,source text,publishtime text,imgurl1 text,imgurl2 text,imgurl3 text,videoImgurl text,imageNumber integer,isVideo interger)";
//        db.execSQL(deviceSql);
//        String knowledgeSql = "create table if not exists video(_id Integer primary key autoincrement,news_id integer,title text,source text,publishtime text,imgurl1 text,imgurl2 text,imgurl3 text,videoImgurl text,imageNumber integer,isVideo interger)";
//        db.execSQL(knowledgeSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
