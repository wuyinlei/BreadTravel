package com.renren.breadtravel.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyinlei on 2016/12/20.
 */

public class SearchDbHelper {

    private static SearchDbHelper mSearchDbHelper;

    private Context mContext;

    private SearchHistorySqliteOpenHelper mHelper;

    private SQLiteDatabase db;

    public SearchDbHelper(Context context) {
        this.mContext = context;
        mSearchDbHelper = this;
        mHelper = SearchHistorySqliteOpenHelper.getInstance(context);
    }

    public static SearchDbHelper getSearchDbHelper(Context context) {
        if (mSearchDbHelper == null)
            mSearchDbHelper = new SearchDbHelper(context);
        return mSearchDbHelper;
    }

    /**
     * 热门游记方法
     * 插入数据
     *
     * @param queryName 查询的名字
     */
    public void insertTripData(String queryName) {
        db = mHelper.getWritableDatabase();
        db.execSQL("insert into trip_history(name) values('" + queryName + "')");
        db.close();
    }

    /**
     * 热门城市方法
     * 插入数据
     *
     * @param queryName 查询的名字
     */
    public void insertHotData(String queryName) {
        db = mHelper.getWritableDatabase();
        db.execSQL("insert into hot_city_history(name) values('" + queryName + "')");
        db.close();
    }

    /**
     * 热门城市方法
     * 热门游记方法
     *
     * 判断是否已经查询过  如果查询过就不需要再次进行插入
     *
     * @param queryName 查询的名字
     * @return true / false
     */
    public boolean hasTripData(String queryName) {
        Cursor cursor = mHelper.getReadableDatabase().rawQuery(
                "select id as _id , name from trip_history where name = ?", new String[]{queryName}
        );
        return cursor.moveToNext();
    }

    /**
     * 热门城市方法
     * 判断是否已经查询过  如果查询过就不需要再次进行插入
     *
     * @param queryName 查询的名字
     * @return true / false
     */
    public boolean hasHotData(String queryName) {
        Cursor cursor = mHelper.getReadableDatabase().rawQuery(
                "select id as _id , name from hot_city_history where name = ?", new String[]{queryName}
        );
        return cursor.moveToNext();
    }

    /**
     * 热门游记方法
     * 删除所有数据
     */
    public void deleteTripData() {
        db = mHelper.getWritableDatabase();
        db.execSQL("delete from trip_history");
        db.close();
    }

    /**
     * 热门城市方法
     * 删除所有数据
     */
    public void deleteHotData() {
        db = mHelper.getWritableDatabase();
        db.execSQL("delete from hot_city_history");
        db.close();
    }


    /**
     * 热门游记方法
     * 查询所有数据库中的数据  进行数据展示使用
     *
     * @return 查询key值
     */
    public List<String> queryTripData() {
        List<String> historySearchs = new ArrayList<>();
        Cursor cursor = mHelper.getReadableDatabase().query("trip_history", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String historySearch;
            historySearch = cursor.getString(cursor.getColumnIndex("name"));
            historySearchs.add(historySearch);
        }
        return historySearchs;
    }

    /**
     * 热门城市方法
     * 查询所有数据库中的数据  进行数据展示使用
     *
     * @return 查询key值
     */
    public List<String> queryHotData() {
        List<String> historySearchs = new ArrayList<>();
        Cursor cursor = mHelper.getReadableDatabase().query("hot_city_history", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String historySearch;
            historySearch = cursor.getString(cursor.getColumnIndex("name"));
            historySearchs.add(historySearch);
        }
        return historySearchs;
    }

}
