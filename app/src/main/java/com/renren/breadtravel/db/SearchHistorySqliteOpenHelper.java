package com.renren.breadtravel.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wuyinlei on 2016/12/20.
 */

public class SearchHistorySqliteOpenHelper extends SQLiteOpenHelper {

    private static String dbName = "SHistory.db";
    private static Integer version = 1;

    private static SearchHistorySqliteOpenHelper mHelper;

    public static SearchHistorySqliteOpenHelper getInstance(Context context){
        if (null == mHelper){
            synchronized (SearchHistorySqliteOpenHelper.class){
                mHelper = new SearchHistorySqliteOpenHelper(context);
            }
        }
        return mHelper;
    }

    public SearchHistorySqliteOpenHelper(Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table trip_history (id integer primary key autoincrement,name varchar(200))");
        db.execSQL("create table hot_city_history (id integer primary key autoincrement,name varchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
