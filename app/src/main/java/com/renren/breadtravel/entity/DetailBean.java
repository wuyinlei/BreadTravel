package com.renren.breadtravel.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wuyinlei on 2016/12/2.
 */

public class DetailBean {


    /**
     * cover_image_default : http://photos.breadtrip.com/photo_2016_11_15_a2b092b845d9ce7220d3481549538393.jpg?imageView/2/w/960/q/85
     * waypoints : 88
     * wifi_sync : true
     * last_day : 2016-09-25
     * id : 2387245057
     * view_count : 2710
     * privacy : 0
     * day_count : 9
     * index_title :
     * comment_count : 0
     * share_url : trips/2387245057/
     * recommended : false
     * version : 1
     * spot_count : 0
     * mileage : 3460.22408795498
     * description :
     * last_modified : 1.47990438627075E9
     * user : {"location_name":"法国_巴黎","name":"Aki_ru","resident_city_id":81,"mobile":"","gender":2,"avatar_m":"http://photos.breadtrip.com/avatar_75_a7_cff973780ad84682430413ef39aee1dd53dbbd39.jpg-avatar.m","cover":"http://photos.breadtrip.com/user_cover_2016_11_27_b6d7cfbebc6df7805b97f41e53641bfb2793b71e.jpg-usercover.display","custom_url":"","id":2384341377,"birthday":"","country_num":null,"avatar_s":"http://photos.breadtrip.com/avatar_75_a7_cff973780ad84682430413ef39aee1dd53dbbd39.jpg-avatar.s","country_code":null,"email_verified":true,"is_hunter":false,"cdc2":false,"avatar_l":"http://photos.breadtrip.com/avatar_75_a7_cff973780ad84682430413ef39aee1dd53dbbd39.jpg-avatar.l","email":"","user_desc":"一个少女。微博：蔺_sama_","points":353}
     * popular_place_str : 西班牙,巴塞罗纳
     * date_complete : 1474740000
     * device : 1
     * date_added : 1474050600
     * cover_image_w640 : http://photos.breadtrip.com/photo_2016_11_15_a2b092b845d9ce7220d3481549538393.jpg?imageView/2/w/1384/h/1384/q/85
     * name : 九月西班牙💐建筑，美食🍸和大海🏖
     * default : false
     * start_point : {"latitude":null,"longitude":null}
     * cover_image_1600 : http://photos.breadtrip.com/photo_2016_11_15_a2b092b845d9ce7220d3481549538393.jpg?imageView/1/w/640/h/480/q/85
     * summary :
     * is_hot_trip : true
     * recommendations : 2
     * cover_image : http://photos.breadtrip.com/photo_2016_11_15_a2b092b845d9ce7220d3481549538393.jpg?imageView/2/w/960/q/85
     * first_day : 2016-09-17
     * is_featured_trip : false
     */

    private String cover_image_default;
    private int waypoints;
    private boolean wifi_sync;
    private String last_day;
    private String id;
    private int view_count;
    private int privacy;
    private int day_count;
    private String index_title;
    private int comment_count;
    private String share_url;
    private boolean recommended;
    private int version;
    private int spot_count;
    private double mileage;
    private String description;
    private double last_modified;
    private UserEntity user;
    private String popular_place_str;
    private int date_complete;
    private int device;
    private int date_added;
    private String cover_image_w640;
    private String name;
    @SerializedName("default")
    private boolean defaultX;
    private StartPointEntity start_point;
    private String cover_image_1600;
    private String summary;
    private boolean is_hot_trip;
    private int recommendations;
    private String cover_image;
    private String first_day;
    private boolean is_featured_trip;

    public String getCover_image_default() {
        return cover_image_default;
    }

    public void setCover_image_default(String cover_image_default) {
        this.cover_image_default = cover_image_default;
    }

    public int getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(int waypoints) {
        this.waypoints = waypoints;
    }

    public boolean isWifi_sync() {
        return wifi_sync;
    }

    public void setWifi_sync(boolean wifi_sync) {
        this.wifi_sync = wifi_sync;
    }

    public String getLast_day() {
        return last_day;
    }

    public void setLast_day(String last_day) {
        this.last_day = last_day;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public int getDay_count() {
        return day_count;
    }

    public void setDay_count(int day_count) {
        this.day_count = day_count;
    }

    public String getIndex_title() {
        return index_title;
    }

    public void setIndex_title(String index_title) {
        this.index_title = index_title;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getSpot_count() {
        return spot_count;
    }

    public void setSpot_count(int spot_count) {
        this.spot_count = spot_count;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(double last_modified) {
        this.last_modified = last_modified;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getPopular_place_str() {
        return popular_place_str;
    }

    public void setPopular_place_str(String popular_place_str) {
        this.popular_place_str = popular_place_str;
    }

    public int getDate_complete() {
        return date_complete;
    }

    public void setDate_complete(int date_complete) {
        this.date_complete = date_complete;
    }

    public int getDevice() {
        return device;
    }

    public void setDevice(int device) {
        this.device = device;
    }

    public int getDate_added() {
        return date_added;
    }

    public void setDate_added(int date_added) {
        this.date_added = date_added;
    }

    public String getCover_image_w640() {
        return cover_image_w640;
    }

    public void setCover_image_w640(String cover_image_w640) {
        this.cover_image_w640 = cover_image_w640;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefaultX() {
        return defaultX;
    }

    public void setDefaultX(boolean defaultX) {
        this.defaultX = defaultX;
    }

    public StartPointEntity getStart_point() {
        return start_point;
    }

    public void setStart_point(StartPointEntity start_point) {
        this.start_point = start_point;
    }

    public String getCover_image_1600() {
        return cover_image_1600;
    }

    public void setCover_image_1600(String cover_image_1600) {
        this.cover_image_1600 = cover_image_1600;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isIs_hot_trip() {
        return is_hot_trip;
    }

    public void setIs_hot_trip(boolean is_hot_trip) {
        this.is_hot_trip = is_hot_trip;
    }

    public int getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(int recommendations) {
        this.recommendations = recommendations;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getFirst_day() {
        return first_day;
    }

    public void setFirst_day(String first_day) {
        this.first_day = first_day;
    }

    public boolean isIs_featured_trip() {
        return is_featured_trip;
    }

    public void setIs_featured_trip(boolean is_featured_trip) {
        this.is_featured_trip = is_featured_trip;
    }

    public static class UserEntity {
        /**
         * location_name : 法国_巴黎
         * name : Aki_ru
         * resident_city_id : 81
         * mobile :
         * gender : 2
         * avatar_m : http://photos.breadtrip.com/avatar_75_a7_cff973780ad84682430413ef39aee1dd53dbbd39.jpg-avatar.m
         * cover : http://photos.breadtrip.com/user_cover_2016_11_27_b6d7cfbebc6df7805b97f41e53641bfb2793b71e.jpg-usercover.display
         * custom_url :
         * id : 2384341377
         * birthday :
         * country_num : null
         * avatar_s : http://photos.breadtrip.com/avatar_75_a7_cff973780ad84682430413ef39aee1dd53dbbd39.jpg-avatar.s
         * country_code : null
         * email_verified : true
         * is_hunter : false
         * cdc2 : false
         * avatar_l : http://photos.breadtrip.com/avatar_75_a7_cff973780ad84682430413ef39aee1dd53dbbd39.jpg-avatar.l
         * email :
         * user_desc : 一个少女。微博：蔺_sama_
         * points : 353
         */

        private String location_name;
        private String name;
        private int resident_city_id;
        private String mobile;
        private int gender;
        private String avatar_m;
        private String cover;
        private String custom_url;
        private String id;
        private String birthday;
        private Object country_num;
        private String avatar_s;
        private Object country_code;
        private boolean email_verified;
        private boolean is_hunter;
        private boolean cdc2;
        private String avatar_l;
        private String email;
        private String user_desc;
        private int points;

        public String getLocation_name() {
            return location_name;
        }

        public void setLocation_name(String location_name) {
            this.location_name = location_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getResident_city_id() {
            return resident_city_id;
        }

        public void setResident_city_id(int resident_city_id) {
            this.resident_city_id = resident_city_id;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getAvatar_m() {
            return avatar_m;
        }

        public void setAvatar_m(String avatar_m) {
            this.avatar_m = avatar_m;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCustom_url() {
            return custom_url;
        }

        public void setCustom_url(String custom_url) {
            this.custom_url = custom_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public Object getCountry_num() {
            return country_num;
        }

        public void setCountry_num(Object country_num) {
            this.country_num = country_num;
        }

        public String getAvatar_s() {
            return avatar_s;
        }

        public void setAvatar_s(String avatar_s) {
            this.avatar_s = avatar_s;
        }

        public Object getCountry_code() {
            return country_code;
        }

        public void setCountry_code(Object country_code) {
            this.country_code = country_code;
        }

        public boolean isEmail_verified() {
            return email_verified;
        }

        public void setEmail_verified(boolean email_verified) {
            this.email_verified = email_verified;
        }

        public boolean isIs_hunter() {
            return is_hunter;
        }

        public void setIs_hunter(boolean is_hunter) {
            this.is_hunter = is_hunter;
        }

        public boolean isCdc2() {
            return cdc2;
        }

        public void setCdc2(boolean cdc2) {
            this.cdc2 = cdc2;
        }

        public String getAvatar_l() {
            return avatar_l;
        }

        public void setAvatar_l(String avatar_l) {
            this.avatar_l = avatar_l;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUser_desc() {
            return user_desc;
        }

        public void setUser_desc(String user_desc) {
            this.user_desc = user_desc;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
    }

    public static class StartPointEntity {
        /**
         * latitude : null
         * longitude : null
         */

        private Object latitude;
        private Object longitude;

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }
    }
}
