package com.renren.breadtravel.constant;

/**
 * Created by Administrator on 2016/12/1.
 */

public class HttpUrlPath {


    //基准url
    private static final String BASE_URL = "http://api.breadtrip.com/";

    //热门游记首页api
    public static final String HOME_POPULAR_TRAVEL = BASE_URL + "v2/index/";

    /**
     * 热门城市首页api
     *
     * @param start  开始位置
     * @param count  请求数量
     * @param country  国家代码
     * @return  热门城市首页api
     */
    public static final String getBreadOrder(int start, int count, String country) {
        return "http://web.breadtrip.com/product/topics/more/?start="
                + start + "&count=" + count + "&country=" + country;
    }


}
