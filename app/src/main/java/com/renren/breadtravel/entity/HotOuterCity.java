package com.renren.breadtravel.entity;

import com.google.gson.Gson;

/**
 * Created by wuyinlei on 2016/12/2.
 */

public class HotOuterCity {


    /**
     * rating : 0
     * name : 三亚
     * url : /scenic/3/65557/
     * wish_to_go_count : 8874
     * name_orig : 三亚
     * visited_count : 11472
     * comments_count : 0
     * location : {"lat":18.251176,"lng":109.51604}
     * has_experience : false
     * rating_users : 0
     * name_zh : 三亚
     * name_en : Sanya
     * type : 3
     * id : 65557
     * has_route_maps : false
     * icon : http://media.breadtrip.com/images/icons/2/city.png
     */

    private int rating;
    private String name;
    private String url;
    private int wish_to_go_count;
    private String name_orig;
    private int visited_count;
    private int comments_count;
    /**
     * lat : 18.251176
     * lng : 109.51604
     */

    private LocationBean location;
    private boolean has_experience;
    private int rating_users;
    private String name_zh;
    private String name_en;
    private int type;
    private int id;
    private boolean has_route_maps;
    private String icon;

    public static HotOuterCity objectFromData(String str) {

        return new Gson().fromJson(str, HotOuterCity.class);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWish_to_go_count() {
        return wish_to_go_count;
    }

    public void setWish_to_go_count(int wish_to_go_count) {
        this.wish_to_go_count = wish_to_go_count;
    }

    public String getName_orig() {
        return name_orig;
    }

    public void setName_orig(String name_orig) {
        this.name_orig = name_orig;
    }

    public int getVisited_count() {
        return visited_count;
    }

    public void setVisited_count(int visited_count) {
        this.visited_count = visited_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public boolean isHas_experience() {
        return has_experience;
    }

    public void setHas_experience(boolean has_experience) {
        this.has_experience = has_experience;
    }

    public int getRating_users() {
        return rating_users;
    }

    public void setRating_users(int rating_users) {
        this.rating_users = rating_users;
    }

    public String getName_zh() {
        return name_zh;
    }

    public void setName_zh(String name_zh) {
        this.name_zh = name_zh;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHas_route_maps() {
        return has_route_maps;
    }

    public void setHas_route_maps(boolean has_route_maps) {
        this.has_route_maps = has_route_maps;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public static class LocationBean {
        private double lat;
        private double lng;

        public static LocationBean objectFromData(String str) {

            return new Gson().fromJson(str, LocationBean.class);
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }
    }
}
