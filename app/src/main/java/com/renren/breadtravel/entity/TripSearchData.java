package com.renren.breadtravel.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuyinlei on 2016/12/21.
 */

public class TripSearchData implements Serializable {


    /**
     * status : 0
     * message :
     * data : {"users":[{"bio":"","resident_city_id":"","relationship":1,"avatar_m":"http://photos.breadtrip.com/avatar_b9_fc_4eac31f9a104ee2d22cacd9d37968732fe5d5763.jpg-avatar.m","custom_url":"","birthday":"","followings_count":1,"avatar_s":"http://photos.breadtrip.com/avatar_b9_fc_4eac31f9a104ee2d22cacd9d37968732fe5d5763.jpg-avatar.s","country_code":null,"id":2383755060,"user_desc":"","location_name":"","name":"上海：燕子","mobile":"","gender":2,"cover":"http://photos.breadtrip.com/default_user_cover_04.jpg-usercover.display","followers_count":0,"points":74,"country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_b9_fc_4eac31f9a104ee2d22cacd9d37968732fe5d5763.jpg-avatar.l","email_verified":false,"is_hunter":false,"cdc2":false,"email":""},{"bio":"","resident_city_id":"","relationship":1,"avatar_m":"http://photos.breadtrip.com/avatar_87_32_4d8fe41ed7fc95593896455cc2f745bc69e8dfa6.jpg-avatar.m","custom_url":"","birthday":"","followings_count":1,"avatar_s":"http://photos.breadtrip.com/avatar_87_32_4d8fe41ed7fc95593896455cc2f745bc69e8dfa6.jpg-avatar.s","country_code":null,"id":2383888654,"user_desc":"","location_name":"","name":"上海-雨辰","mobile":"","gender":0,"cover":"http://photos.breadtrip.com/default_user_cover_04.jpg-usercover.display","followers_count":0,"points":70,"country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_87_32_4d8fe41ed7fc95593896455cc2f745bc69e8dfa6.jpg-avatar.l","email_verified":false,"is_hunter":false,"cdc2":false,"email":""},{"bio":"","resident_city_id":"","relationship":1,"avatar_m":"http://photos.breadtrip.com/avatar_74_31_6562dc3db9a61b0982d76cbe2afd6d6ae0488bc2.jpg-avatar.m","custom_url":"","birthday":"","followings_count":1,"avatar_s":"http://photos.breadtrip.com/avatar_74_31_6562dc3db9a61b0982d76cbe2afd6d6ae0488bc2.jpg-avatar.s","country_code":null,"id":2384410395,"user_desc":"","location_name":"","name":"刘李兵.上海.F14","mobile":"","gender":1,"cover":"http://photos.breadtrip.com/default_user_cover_10.jpg-usercover.display","followers_count":1,"points":70,"country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_74_31_6562dc3db9a61b0982d76cbe2afd6d6ae0488bc2.jpg-avatar.l","email_verified":false,"is_hunter":false,"cdc2":false,"email":""},{"bio":"","resident_city_id":"","relationship":1,"avatar_m":"http://photos.breadtrip.com/avatar_4d_04_62146023f772142c4beccea35e54d839f505f166.jpg-avatar.m","custom_url":"","birthday":"","followings_count":1,"avatar_s":"http://photos.breadtrip.com/avatar_4d_04_62146023f772142c4beccea35e54d839f505f166.jpg-avatar.s","country_code":null,"id":2388472091,"user_desc":"","location_name":"","name":"邮上海","mobile":"","gender":1,"cover":"http://media.breadtrip.com/user_covers/default/cover_2.jpg","followers_count":1,"points":70,"country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_4d_04_62146023f772142c4beccea35e54d839f505f166.jpg-avatar.l","email_verified":false,"is_hunter":false,"cdc2":false,"email":""},{"bio":"新疆之旅","resident_city_id":"","relationship":1,"avatar_m":"http://media.breadtrip.com/avatars/default/m.png","custom_url":"","birthday":"","followings_count":1,"avatar_s":"http://media.breadtrip.com/avatars/default/s.png","country_code":null,"id":2387125734,"user_desc":"","location_name":"","name":"上海徐","mobile":"","gender":0,"cover":"http://media.breadtrip.com/user_covers/default/cover_2.jpg","followers_count":0,"points":55,"country_num":null,"avatar_l":"http://media.breadtrip.com/avatars/default/l.png","email_verified":false,"is_hunter":false,"cdc2":false,"email":""}],"trips_more":true,"users_more":true,"places":[{"province":{"name":"上海市","url":"/scenic/2/13958/","name_orig":"上海市","location":{"lat":31.228402,"lng":121.478143},"name_zh":"上海市","name_en":"Shanghai","slug_url":"/shanghai-shi/","type":2,"id":13958,"icon":"http://media.breadtrip.com/images/icons/province.png"},"name":"上海","url":"/scenic/3/13961/","country":{"name":"中国","url":"/scenic/1/3793/","name_orig":"中国","location":{"lat":35.861469,"lng":104.198074},"slug_url":"/cn/","type":1,"id":"CN","icon":"http://media.breadtrip.com/images/icons/country.png"},"has_experience":false,"type":3,"id":13961,"has_route_maps":false,"icon":"http://media.breadtrip.com/images/icons/city.png"},{"province":{"name":"萊因蘭-法爾茲","url":"/scenic/2/6948/","name_orig":"萊因蘭-法爾茲","location":{"lat":50.118346,"lng":7.308953},"name_zh":"萊因蘭-法爾茲","name_en":"Rhineland-Palatinate","slug_url":"/rheinland-pfalz/","type":2,"id":6948,"icon":"http://media.breadtrip.com/images/icons/province.png"},"name":"上海因巴赫","url":"/scenic/3/77899/","country":{"name":"德国","url":"/scenic/1/3541/","name_orig":"德国","location":{"lat":51.165691,"lng":10.451526},"slug_url":"/de/","type":1,"id":"DE","icon":"http://media.breadtrip.com/images/icons/country.png"},"has_experience":false,"type":3,"id":77899,"has_route_maps":false,"icon":"http://media.breadtrip.com/images/icons/city.png"},{"name":"上海市","url":"/scenic/2/13958/","country":{"name":"中国","url":"/scenic/1/3793/","name_orig":"中国","location":{"lat":35.861469,"lng":104.198074},"slug_url":"/cn/","type":1,"id":"CN","icon":"http://media.breadtrip.com/images/icons/country.png"},"has_experience":false,"type":2,"id":13958,"has_route_maps":false,"icon":"http://media.breadtrip.com/images/icons/province.png"}],"trips":[{"waypoints":3226,"wifi_sync":false,"total_comments_count":5803,"id":2387709507,"view_count":201213,"privacy":0,"day_count":514,"version":1,"liked_count":11248,"spot_count":0,"mileage":93822.3011070692,"description":"","last_modified":1.39032546165604E9,"cover_image_default":"http://photos.breadtrip.com/photo_2012_09_09_37be5f11db8daba02e454248ec3aa0a4.jpg?imageView/2/w/960/q/85","date_complete":1390321080,"device":1,"date_added":1346052240,"cover_image_w640":"http://photos.breadtrip.com/photo_2012_09_09_37be5f11db8daba02e454248ec3aa0a4.jpg?imageView/2/w/1384/h/1384/q/85","name":"Odyssey In HK","default":false,"cover_image_1600":"http://photos.breadtrip.com/photo_2012_09_09_37be5f11db8daba02e454248ec3aa0a4.jpg?imageView/1/w/640/h/480/q/85","recommendations":1999,"cover_image":"http://photos.breadtrip.com/photo_2012_09_09_37be5f11db8daba02e454248ec3aa0a4.jpg?imageView/1/w/280/h/280/q/75"},{"waypoints":1043,"wifi_sync":true,"total_comments_count":6171,"id":2387675584,"view_count":115128,"privacy":0,"day_count":862,"version":1,"liked_count":10015,"spot_count":0,"mileage":6258.25283879175,"description":"","last_modified":1.42005065332047E9,"cover_image_default":"http://photos.breadtrip.com/photo_2013_01_08_116a610b6922268f993cc1de18992bd2.jpg?imageView/2/w/960/q/85","date_complete":1420044000,"device":1,"date_added":1345704960,"cover_image_w640":"http://photos.breadtrip.com/photo_2013_01_08_116a610b6922268f993cc1de18992bd2.jpg?imageView/2/w/1384/h/1384/q/85","name":"上海单身食记","default":false,"cover_image_1600":"http://photos.breadtrip.com/photo_2013_01_08_116a610b6922268f993cc1de18992bd2.jpg?imageView/1/w/640/h/480/q/85","recommendations":2141,"cover_image":"http://photos.breadtrip.com/photo_2013_01_08_116a610b6922268f993cc1de18992bd2.jpg?imageView/1/w/280/h/280/q/75"},{"waypoints":507,"wifi_sync":true,"total_comments_count":1100,"id":2387668398,"view_count":107440,"privacy":0,"day_count":456,"version":1,"liked_count":6250,"spot_count":0,"mileage":1470.23089362422,"description":"","last_modified":1.40394087838143E9,"cover_image_default":"http://photos.breadtrip.com/photo_2013_05_18_30f83a81ea69cca18a1a8be31ac911a2.jpg?imageView/2/w/960/q/85","date_complete":1377944340,"device":1,"date_added":1338599220,"cover_image_w640":"http://photos.breadtrip.com/photo_2013_05_18_30f83a81ea69cca18a1a8be31ac911a2.jpg?imageView/2/w/1384/h/1384/q/85","name":"我的城 2012-2013","default":false,"cover_image_1600":"http://photos.breadtrip.com/photo_2013_05_18_30f83a81ea69cca18a1a8be31ac911a2.jpg?imageView/1/w/640/h/480/q/85","recommendations":2285,"cover_image":"http://photos.breadtrip.com/photo_2013_05_18_30f83a81ea69cca18a1a8be31ac911a2.jpg?imageView/1/w/280/h/280/q/75"},{"waypoints":2134,"wifi_sync":true,"total_comments_count":208,"id":2387919248,"view_count":226690,"privacy":0,"day_count":2672,"version":1,"liked_count":2955,"spot_count":0,"mileage":142517.318916059,"description":"","last_modified":1.47845372341984E9,"cover_image_default":"http://photos.breadtrip.com/photo_2015_11_24_986655d776c8cf0d86d309fc9ec50673.jpg?imageView/2/w/960/q/85","date_complete":1478438053,"device":1,"date_added":1247660040,"cover_image_w640":"http://photos.breadtrip.com/photo_2015_11_24_986655d776c8cf0d86d309fc9ec50673.jpg?imageView/2/w/1384/h/1384/q/85","name":"吃货养成记【国内篇】","default":false,"cover_image_1600":"http://photos.breadtrip.com/photo_2015_11_24_986655d776c8cf0d86d309fc9ec50673.jpg?imageView/1/w/640/h/480/q/85","recommendations":1687,"cover_image":"http://photos.breadtrip.com/photo_2015_11_24_986655d776c8cf0d86d309fc9ec50673.jpg?imageView/1/w/280/h/280/q/75"},{"waypoints":1090,"wifi_sync":true,"total_comments_count":683,"id":2387812531,"view_count":33789,"privacy":0,"day_count":150,"version":1,"liked_count":7281,"spot_count":0,"mileage":5558.34720432139,"description":"","last_modified":1.39442711890185E9,"cover_image_default":"http://photos.breadtrip.com/photo_2013_12_31_93955d15b3e7981db4c2955f166d153f.jpg?imageView/2/w/960/q/85","date_complete":null,"device":3,"date_added":1377128100,"cover_image_w640":"http://photos.breadtrip.com/photo_2013_12_31_93955d15b3e7981db4c2955f166d153f.jpg?imageView/2/w/1384/h/1384/q/85","name":"Episode I \u2022 HK Taste Adventure（I）","default":false,"cover_image_1600":"http://photos.breadtrip.com/photo_2013_12_31_93955d15b3e7981db4c2955f166d153f.jpg?imageView/1/w/640/h/480/q/85","recommendations":798,"cover_image":"http://photos.breadtrip.com/photo_2013_12_31_93955d15b3e7981db4c2955f166d153f.jpg?imageView/1/w/280/h/280/q/75"}]}
     */

    public int status;
    public String message;
    /**
     * users : [{"bio":"","resident_city_id":"","relationship":1,"avatar_m":"http://photos.breadtrip.com/avatar_b9_fc_4eac31f9a104ee2d22cacd9d37968732fe5d5763.jpg-avatar.m","custom_url":"","birthday":"","followings_count":1,"avatar_s":"http://photos.breadtrip.com/avatar_b9_fc_4eac31f9a104ee2d22cacd9d37968732fe5d5763.jpg-avatar.s","country_code":null,"id":2383755060,"user_desc":"","location_name":"","name":"上海：燕子","mobile":"","gender":2,"cover":"http://photos.breadtrip.com/default_user_cover_04.jpg-usercover.display","followers_count":0,"points":74,"country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_b9_fc_4eac31f9a104ee2d22cacd9d37968732fe5d5763.jpg-avatar.l","email_verified":false,"is_hunter":false,"cdc2":false,"email":""},{"bio":"","resident_city_id":"","relationship":1,"avatar_m":"http://photos.breadtrip.com/avatar_87_32_4d8fe41ed7fc95593896455cc2f745bc69e8dfa6.jpg-avatar.m","custom_url":"","birthday":"","followings_count":1,"avatar_s":"http://photos.breadtrip.com/avatar_87_32_4d8fe41ed7fc95593896455cc2f745bc69e8dfa6.jpg-avatar.s","country_code":null,"id":2383888654,"user_desc":"","location_name":"","name":"上海-雨辰","mobile":"","gender":0,"cover":"http://photos.breadtrip.com/default_user_cover_04.jpg-usercover.display","followers_count":0,"points":70,"country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_87_32_4d8fe41ed7fc95593896455cc2f745bc69e8dfa6.jpg-avatar.l","email_verified":false,"is_hunter":false,"cdc2":false,"email":""},{"bio":"","resident_city_id":"","relationship":1,"avatar_m":"http://photos.breadtrip.com/avatar_74_31_6562dc3db9a61b0982d76cbe2afd6d6ae0488bc2.jpg-avatar.m","custom_url":"","birthday":"","followings_count":1,"avatar_s":"http://photos.breadtrip.com/avatar_74_31_6562dc3db9a61b0982d76cbe2afd6d6ae0488bc2.jpg-avatar.s","country_code":null,"id":2384410395,"user_desc":"","location_name":"","name":"刘李兵.上海.F14","mobile":"","gender":1,"cover":"http://photos.breadtrip.com/default_user_cover_10.jpg-usercover.display","followers_count":1,"points":70,"country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_74_31_6562dc3db9a61b0982d76cbe2afd6d6ae0488bc2.jpg-avatar.l","email_verified":false,"is_hunter":false,"cdc2":false,"email":""},{"bio":"","resident_city_id":"","relationship":1,"avatar_m":"http://photos.breadtrip.com/avatar_4d_04_62146023f772142c4beccea35e54d839f505f166.jpg-avatar.m","custom_url":"","birthday":"","followings_count":1,"avatar_s":"http://photos.breadtrip.com/avatar_4d_04_62146023f772142c4beccea35e54d839f505f166.jpg-avatar.s","country_code":null,"id":2388472091,"user_desc":"","location_name":"","name":"邮上海","mobile":"","gender":1,"cover":"http://media.breadtrip.com/user_covers/default/cover_2.jpg","followers_count":1,"points":70,"country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_4d_04_62146023f772142c4beccea35e54d839f505f166.jpg-avatar.l","email_verified":false,"is_hunter":false,"cdc2":false,"email":""},{"bio":"新疆之旅","resident_city_id":"","relationship":1,"avatar_m":"http://media.breadtrip.com/avatars/default/m.png","custom_url":"","birthday":"","followings_count":1,"avatar_s":"http://media.breadtrip.com/avatars/default/s.png","country_code":null,"id":2387125734,"user_desc":"","location_name":"","name":"上海徐","mobile":"","gender":0,"cover":"http://media.breadtrip.com/user_covers/default/cover_2.jpg","followers_count":0,"points":55,"country_num":null,"avatar_l":"http://media.breadtrip.com/avatars/default/l.png","email_verified":false,"is_hunter":false,"cdc2":false,"email":""}]
     * trips_more : true
     * users_more : true
     * places : [{"province":{"name":"上海市","url":"/scenic/2/13958/","name_orig":"上海市","location":{"lat":31.228402,"lng":121.478143},"name_zh":"上海市","name_en":"Shanghai","slug_url":"/shanghai-shi/","type":2,"id":13958,"icon":"http://media.breadtrip.com/images/icons/province.png"},"name":"上海","url":"/scenic/3/13961/","country":{"name":"中国","url":"/scenic/1/3793/","name_orig":"中国","location":{"lat":35.861469,"lng":104.198074},"slug_url":"/cn/","type":1,"id":"CN","icon":"http://media.breadtrip.com/images/icons/country.png"},"has_experience":false,"type":3,"id":13961,"has_route_maps":false,"icon":"http://media.breadtrip.com/images/icons/city.png"},{"province":{"name":"萊因蘭-法爾茲","url":"/scenic/2/6948/","name_orig":"萊因蘭-法爾茲","location":{"lat":50.118346,"lng":7.308953},"name_zh":"萊因蘭-法爾茲","name_en":"Rhineland-Palatinate","slug_url":"/rheinland-pfalz/","type":2,"id":6948,"icon":"http://media.breadtrip.com/images/icons/province.png"},"name":"上海因巴赫","url":"/scenic/3/77899/","country":{"name":"德国","url":"/scenic/1/3541/","name_orig":"德国","location":{"lat":51.165691,"lng":10.451526},"slug_url":"/de/","type":1,"id":"DE","icon":"http://media.breadtrip.com/images/icons/country.png"},"has_experience":false,"type":3,"id":77899,"has_route_maps":false,"icon":"http://media.breadtrip.com/images/icons/city.png"},{"name":"上海市","url":"/scenic/2/13958/","country":{"name":"中国","url":"/scenic/1/3793/","name_orig":"中国","location":{"lat":35.861469,"lng":104.198074},"slug_url":"/cn/","type":1,"id":"CN","icon":"http://media.breadtrip.com/images/icons/country.png"},"has_experience":false,"type":2,"id":13958,"has_route_maps":false,"icon":"http://media.breadtrip.com/images/icons/province.png"}]
     * trips : [{"waypoints":3226,"wifi_sync":false,"total_comments_count":5803,"id":2387709507,"view_count":201213,"privacy":0,"day_count":514,"version":1,"liked_count":11248,"spot_count":0,"mileage":93822.3011070692,"description":"","last_modified":1.39032546165604E9,"cover_image_default":"http://photos.breadtrip.com/photo_2012_09_09_37be5f11db8daba02e454248ec3aa0a4.jpg?imageView/2/w/960/q/85","date_complete":1390321080,"device":1,"date_added":1346052240,"cover_image_w640":"http://photos.breadtrip.com/photo_2012_09_09_37be5f11db8daba02e454248ec3aa0a4.jpg?imageView/2/w/1384/h/1384/q/85","name":"Odyssey In HK","default":false,"cover_image_1600":"http://photos.breadtrip.com/photo_2012_09_09_37be5f11db8daba02e454248ec3aa0a4.jpg?imageView/1/w/640/h/480/q/85","recommendations":1999,"cover_image":"http://photos.breadtrip.com/photo_2012_09_09_37be5f11db8daba02e454248ec3aa0a4.jpg?imageView/1/w/280/h/280/q/75"},{"waypoints":1043,"wifi_sync":true,"total_comments_count":6171,"id":2387675584,"view_count":115128,"privacy":0,"day_count":862,"version":1,"liked_count":10015,"spot_count":0,"mileage":6258.25283879175,"description":"","last_modified":1.42005065332047E9,"cover_image_default":"http://photos.breadtrip.com/photo_2013_01_08_116a610b6922268f993cc1de18992bd2.jpg?imageView/2/w/960/q/85","date_complete":1420044000,"device":1,"date_added":1345704960,"cover_image_w640":"http://photos.breadtrip.com/photo_2013_01_08_116a610b6922268f993cc1de18992bd2.jpg?imageView/2/w/1384/h/1384/q/85","name":"上海单身食记","default":false,"cover_image_1600":"http://photos.breadtrip.com/photo_2013_01_08_116a610b6922268f993cc1de18992bd2.jpg?imageView/1/w/640/h/480/q/85","recommendations":2141,"cover_image":"http://photos.breadtrip.com/photo_2013_01_08_116a610b6922268f993cc1de18992bd2.jpg?imageView/1/w/280/h/280/q/75"},{"waypoints":507,"wifi_sync":true,"total_comments_count":1100,"id":2387668398,"view_count":107440,"privacy":0,"day_count":456,"version":1,"liked_count":6250,"spot_count":0,"mileage":1470.23089362422,"description":"","last_modified":1.40394087838143E9,"cover_image_default":"http://photos.breadtrip.com/photo_2013_05_18_30f83a81ea69cca18a1a8be31ac911a2.jpg?imageView/2/w/960/q/85","date_complete":1377944340,"device":1,"date_added":1338599220,"cover_image_w640":"http://photos.breadtrip.com/photo_2013_05_18_30f83a81ea69cca18a1a8be31ac911a2.jpg?imageView/2/w/1384/h/1384/q/85","name":"我的城 2012-2013","default":false,"cover_image_1600":"http://photos.breadtrip.com/photo_2013_05_18_30f83a81ea69cca18a1a8be31ac911a2.jpg?imageView/1/w/640/h/480/q/85","recommendations":2285,"cover_image":"http://photos.breadtrip.com/photo_2013_05_18_30f83a81ea69cca18a1a8be31ac911a2.jpg?imageView/1/w/280/h/280/q/75"},{"waypoints":2134,"wifi_sync":true,"total_comments_count":208,"id":2387919248,"view_count":226690,"privacy":0,"day_count":2672,"version":1,"liked_count":2955,"spot_count":0,"mileage":142517.318916059,"description":"","last_modified":1.47845372341984E9,"cover_image_default":"http://photos.breadtrip.com/photo_2015_11_24_986655d776c8cf0d86d309fc9ec50673.jpg?imageView/2/w/960/q/85","date_complete":1478438053,"device":1,"date_added":1247660040,"cover_image_w640":"http://photos.breadtrip.com/photo_2015_11_24_986655d776c8cf0d86d309fc9ec50673.jpg?imageView/2/w/1384/h/1384/q/85","name":"吃货养成记【国内篇】","default":false,"cover_image_1600":"http://photos.breadtrip.com/photo_2015_11_24_986655d776c8cf0d86d309fc9ec50673.jpg?imageView/1/w/640/h/480/q/85","recommendations":1687,"cover_image":"http://photos.breadtrip.com/photo_2015_11_24_986655d776c8cf0d86d309fc9ec50673.jpg?imageView/1/w/280/h/280/q/75"},{"waypoints":1090,"wifi_sync":true,"total_comments_count":683,"id":2387812531,"view_count":33789,"privacy":0,"day_count":150,"version":1,"liked_count":7281,"spot_count":0,"mileage":5558.34720432139,"description":"","last_modified":1.39442711890185E9,"cover_image_default":"http://photos.breadtrip.com/photo_2013_12_31_93955d15b3e7981db4c2955f166d153f.jpg?imageView/2/w/960/q/85","date_complete":null,"device":3,"date_added":1377128100,"cover_image_w640":"http://photos.breadtrip.com/photo_2013_12_31_93955d15b3e7981db4c2955f166d153f.jpg?imageView/2/w/1384/h/1384/q/85","name":"Episode I \u2022 HK Taste Adventure（I）","default":false,"cover_image_1600":"http://photos.breadtrip.com/photo_2013_12_31_93955d15b3e7981db4c2955f166d153f.jpg?imageView/1/w/640/h/480/q/85","recommendations":798,"cover_image":"http://photos.breadtrip.com/photo_2013_12_31_93955d15b3e7981db4c2955f166d153f.jpg?imageView/1/w/280/h/280/q/75"}]
     */

    public DataBean data;

    public static TripSearchData objectFromData(String str) {

        return new Gson().fromJson(str, TripSearchData.class);
    }

    public static class DataBean {
        public boolean trips_more;
        public boolean users_more;
        /**
         * bio :
         * resident_city_id :
         * relationship : 1
         * avatar_m : http://photos.breadtrip.com/avatar_b9_fc_4eac31f9a104ee2d22cacd9d37968732fe5d5763.jpg-avatar.m
         * custom_url :
         * birthday :
         * followings_count : 1
         * avatar_s : http://photos.breadtrip.com/avatar_b9_fc_4eac31f9a104ee2d22cacd9d37968732fe5d5763.jpg-avatar.s
         * country_code : null
         * id : 2383755060
         * user_desc :
         * location_name :
         * name : 上海：燕子
         * mobile :
         * gender : 2
         * cover : http://photos.breadtrip.com/default_user_cover_04.jpg-usercover.display
         * followers_count : 0
         * points : 74
         * country_num : null
         * avatar_l : http://photos.breadtrip.com/avatar_b9_fc_4eac31f9a104ee2d22cacd9d37968732fe5d5763.jpg-avatar.l
         * email_verified : false
         * is_hunter : false
         * cdc2 : false
         * email :
         */

        public List<UsersBean> users;
        /**
         * province : {"name":"上海市","url":"/scenic/2/13958/","name_orig":"上海市","location":{"lat":31.228402,"lng":121.478143},"name_zh":"上海市","name_en":"Shanghai","slug_url":"/shanghai-shi/","type":2,"id":13958,"icon":"http://media.breadtrip.com/images/icons/province.png"}
         * name : 上海
         * url : /scenic/3/13961/
         * country : {"name":"中国","url":"/scenic/1/3793/","name_orig":"中国","location":{"lat":35.861469,"lng":104.198074},"slug_url":"/cn/","type":1,"id":"CN","icon":"http://media.breadtrip.com/images/icons/country.png"}
         * has_experience : false
         * type : 3
         * id : 13961
         * has_route_maps : false
         * icon : http://media.breadtrip.com/images/icons/city.png
         */

        public List<PlacesBean> places;
        /**
         * waypoints : 3226
         * wifi_sync : false
         * total_comments_count : 5803
         * id : 2387709507
         * view_count : 201213
         * privacy : 0
         * day_count : 514
         * version : 1
         * liked_count : 11248
         * spot_count : 0
         * mileage : 93822.3011070692
         * description :
         * last_modified : 1.39032546165604E9
         * cover_image_default : http://photos.breadtrip.com/photo_2012_09_09_37be5f11db8daba02e454248ec3aa0a4.jpg?imageView/2/w/960/q/85
         * date_complete : 1390321080
         * device : 1
         * date_added : 1346052240
         * cover_image_w640 : http://photos.breadtrip.com/photo_2012_09_09_37be5f11db8daba02e454248ec3aa0a4.jpg?imageView/2/w/1384/h/1384/q/85
         * name : Odyssey In HK
         * default : false
         * cover_image_1600 : http://photos.breadtrip.com/photo_2012_09_09_37be5f11db8daba02e454248ec3aa0a4.jpg?imageView/1/w/640/h/480/q/85
         * recommendations : 1999
         * cover_image : http://photos.breadtrip.com/photo_2012_09_09_37be5f11db8daba02e454248ec3aa0a4.jpg?imageView/1/w/280/h/280/q/75
         */

        public List<TripsBean> trips;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }


        public static class UsersBean {
            public String bio;
            public String resident_city_id;
            public int relationship;
            public String avatar_m;
            public String custom_url;
            public String birthday;
            public int followings_count;
            public String avatar_s;
            public Object country_code;
            public String id;
            public String user_desc;
            public String location_name;
            public String name;
            public String mobile;
            public int gender;
            public String cover;
            public int followers_count;
            public int points;
            public Object country_num;
            public String avatar_l;
            public boolean email_verified;
            public boolean is_hunter;
            public boolean cdc2;
            public String email;

            public static UsersBean objectFromData(String str) {

                return new Gson().fromJson(str, UsersBean.class);
            }

        }

        public static class PlacesBean {
            /**
             * name : 上海市
             * url : /scenic/2/13958/
             * name_orig : 上海市
             * location : {"lat":31.228402,"lng":121.478143}
             * name_zh : 上海市
             * name_en : Shanghai
             * slug_url : /shanghai-shi/
             * type : 2
             * id : 13958
             * icon : http://media.breadtrip.com/images/icons/province.png
             */

            public ProvinceBean province;
            public String name;
            public String url;
            /**
             * name : 中国
             * url : /scenic/1/3793/
             * name_orig : 中国
             * location : {"lat":35.861469,"lng":104.198074}
             * slug_url : /cn/
             * type : 1
             * id : CN
             * icon : http://media.breadtrip.com/images/icons/country.png
             */

            public CountryBean country;
            public boolean has_experience;
            public int type;
            public String id;
            public boolean has_route_maps;
            public String icon;

            public static PlacesBean objectFromData(String str) {

                return new Gson().fromJson(str, PlacesBean.class);
            }


            public static class ProvinceBean {
                public String name;
                public String url;
                public String name_orig;
                /**
                 * lat : 31.228402
                 * lng : 121.478143
                 */

                public LocationBean location;
                public String name_zh;
                public String name_en;
                public String slug_url;
                public int type;
                public String id;
                public String icon;

                public static ProvinceBean objectFromData(String str) {

                    return new Gson().fromJson(str, ProvinceBean.class);
                }


                public static class LocationBean {
                    public double lat;
                    public double lng;

                    public static LocationBean objectFromData(String str) {

                        return new Gson().fromJson(str, LocationBean.class);
                    }

                }
            }

            public static class CountryBean {
                public String name;
                public String url;
                public String name_orig;
                /**
                 * lat : 35.861469
                 * lng : 104.198074
                 */

                public LocationBean location;
                public String slug_url;
                public int type;
                public String id;
                public String icon;

                public static CountryBean objectFromData(String str) {

                    return new Gson().fromJson(str, CountryBean.class);
                }



                public static class LocationBean {
                    public double lat;
                    public double lng;

                    public static LocationBean objectFromData(String str) {

                        return new Gson().fromJson(str, LocationBean.class);
                    }

                }
            }
        }

        public static class TripsBean {
            public int waypoints;
            public boolean wifi_sync;
            public int total_comments_count;
            public String id;
            public String view_count;
            public int privacy;
            public int day_count;
            public int version;
            public int liked_count;
            public int spot_count;
            public double mileage;
            public String description;
            public double last_modified;
            public String cover_image_default;
            public String date_complete;
            public int device;
            public String date_added;
            public String cover_image_w640;
            public String name;
            @SerializedName("default")
            public boolean defaultX;
            public String cover_image_1600;
            public int recommendations;
            public String cover_image;


        }
    }
}
