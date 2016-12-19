package com.renren.breadtravel.constant;

/**
 * Created by Administrator on 2016/12/1.
 */

public class HttpUrlPath {


    //基准url
    private static final String BASE_URL = "http://api.breadtrip.com/";

    //热门游记首页api
    public static final String HOME_POPULAR_TRAVEL = BASE_URL + "v2/index/";

    //热门游记item点击调整url
    //http://api.breadtrip.com/trips/2387246443/waypoints/
    public static final String getHomePopularTravelItem(String id) {
        return BASE_URL + "trips/" + id + "/waypoints/";
    }

    /**
     * 获取某一个photo中的评论数据
     * http://api.breadtrip.com/trips/2387122390/waypoints/2355942363/replies/?count=32767
     */
    public static final String getHomePopularTravelItemComments(String tripId, String commentId) {
        return getHomePopularTravelItem(tripId) + commentId + "/replies/?count=32767";
    }

    /**
     * 热门城市首页api
     *
     * @param start   开始位置
     * @param count   请求数量
     * @param country 国家代码
     * @return 热门城市首页api
     */
    public static final String getBreadOrder(int start, int count, String country) {
        return "http://web.breadtrip.com/product/topics/more/?start="
                + start + "&count=" + count + "&country=" + country;
    }


}
