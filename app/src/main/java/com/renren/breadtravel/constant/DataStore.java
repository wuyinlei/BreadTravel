package com.renren.breadtravel.constant;

/**
 * Created by wuyinlei on 2016/12/9.
 */

public class DataStore {

    private static DataStore mInstance;

    public static DataStore getInstance() {
        if (mInstance == null) {
            mInstance = new DataStore();
        }
        return mInstance;
    }

    String data;

    /**
     * 获取到热门列表数据进行全局缓存
     *
     * @param value 缓存key值
     */
    public void saveHotListData(String value) {
        this.data = value;
    }

    /**
     * 获取到热门的列表数据
     *
     * @return
     */
    public String getHotListData() {
        return data;
    }

}
