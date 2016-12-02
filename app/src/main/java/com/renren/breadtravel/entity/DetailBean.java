package com.renren.breadtravel.entity;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by wuyinlei on 2016/12/2.
 */

public class DetailBean {


    /**
     * status : 0
     * message :
     * data : {"elements":[{"data":[{"popular_place_str":"中国,大同","waypoints":93,"wifi_sync":true,"last_day":"2016-07-08","id":2387277129,"view_count":7681,"privacy":0,"day_count":11,"index_title":"再探 秘境山西","recommended":false,"share_url":"trips/2387277129/","comment_count":7,"version":1,"spot_count":0,"mileage":3057.08787136348,"description":"","last_modified":1.46813090930697E9,"user":{"gender":1,"email_verified":true,"location_name":"","name":"simonfu","resident_city_id":288158,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.s","cover":"http://photos.breadtrip.com/default_user_cover_05.jpg-usercover.display","custom_url":"simonfu","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2388334241,"user_desc":"","points":52503},"cover_image_default":"http://photos.breadtrip.com/photo_2016_06_30_33885e9e1a3dc3d7e251a28352745eb0.jpg?imageView/2/w/960/q/85","date_complete":1467953100,"device":1,"date_added":1467077220,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_07_07_b41b90f6241dbc2a8b4da2d8c22e71e5.jpg?imageView/2/w/960/","name":"秘境山西","default":false,"first_day":"2016-06-28","cover_image_1600":"http://photos.breadtrip.com/photo_2016_06_30_33885e9e1a3dc3d7e251a28352745eb0.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":41,"cover_image":"http://photos.breadtrip.com/covers_2016_07_07_b41b90f6241dbc2a8b4da2d8c22e71e5.jpg?imageView/2/w/960/","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"意大利,佛罗伦萨","waypoints":157,"wifi_sync":false,"last_day":"2016-08-01","id":2387264641,"view_count":16271,"privacy":0,"day_count":4,"index_title":"","recommended":false,"share_url":"trips/2387264641/","comment_count":5,"version":1,"spot_count":0,"mileage":9567.31560440766,"description":"","last_modified":1.4723066541756E9,"user":{"gender":1,"email_verified":true,"location_name":"","name":"嘿咔噜","resident_city_id":"","mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_a0_c4_305c35ac3096a871a6ffd7a0a73b84d06e3cb6d6.jpg-avatar.s","cover":"http://photos.breadtrip.com/user_cover_2015_08_30_2c91680e287644d577648a9051385338c06fe5e6.jpg-usercover.display","custom_url":"panshaozhe","country_code":null,"email":"","birthday":"","country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_a0_c4_305c35ac3096a871a6ffd7a0a73b84d06e3cb6d6.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_a0_c4_305c35ac3096a871a6ffd7a0a73b84d06e3cb6d6.jpg-avatar.m","is_hunter":true,"cdc2":false,"id":2387689570,"user_desc":"我是嘿咔噜，我喜欢自己制定计划带上心爱的人去旅行，走遍世界的每个角落，哪条路、哪道水、没有关联；哪阵风、哪片云，没有呼应。我们走过的城市、山川都化成了我们的生命。","points":1663},"cover_image_default":"http://photos.breadtrip.com/photo_2016_08_19_24557a3b6a26ff899c8d74bc5b4c5e4d.jpg?imageView/2/w/960/q/85","date_complete":1470059053,"device":0,"date_added":1469773374,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_08_19_5a33e8da1eee8c470a50c88965346461.jpg?imageView/2/w/960/","name":"意游未尽","default":false,"first_day":"2016-07-29","cover_image_1600":"http://photos.breadtrip.com/photo_2016_08_19_24557a3b6a26ff899c8d74bc5b4c5e4d.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":84,"cover_image":"http://photos.breadtrip.com/covers_2016_08_19_5a33e8da1eee8c470a50c88965346461.jpg?imageView/2/w/960/","start_point":{"latitude":34.25324367131224,"longitude":108.9280700688335},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"中国,青岛","waypoints":85,"wifi_sync":false,"last_day":"2016-05-02","id":2387257987,"view_count":12907,"privacy":0,"day_count":4,"index_title":"","recommended":false,"share_url":"trips/2387257987/","comment_count":3,"version":1,"spot_count":0,"mileage":20.510412245102,"description":"","last_modified":1.47644440839961E9,"user":{"gender":2,"email_verified":true,"location_name":"浙江_杭州","name":"寿司上的小饭团","resident_city_id":203,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_2a_39_7e66e61353af7618211f5545649bd076fb63977d.jpg-avatar.s","cover":"http://photos.breadtrip.com/user_cover_2016_05_31_5aaa0969b236c5db19275cc51144afc2460bcc3a.jpg-usercover.display","custom_url":"","country_code":null,"email":"","birthday":"","country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_2a_39_7e66e61353af7618211f5545649bd076fb63977d.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_2a_39_7e66e61353af7618211f5545649bd076fb63977d.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2388326238,"user_desc":"","points":512},"cover_image_default":"http://photos.breadtrip.com/photo_2016_07_20_2ae41e24bfeeb217425aaf0896c569cb.jpg?imageView/2/w/960/q/85","date_complete":1462169461,"device":1,"date_added":1461925200,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_08_13_3d1fbd0d51ecf8ff363e5bf92be577e9.jpg?imageView/2/w/960/","name":"红瓦绿树 碧海青岛","default":false,"first_day":"2016-04-29","cover_image_1600":"http://photos.breadtrip.com/photo_2016_07_20_2ae41e24bfeeb217425aaf0896c569cb.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":88,"cover_image":"http://photos.breadtrip.com/covers_2016_08_13_3d1fbd0d51ecf8ff363e5bf92be577e9.jpg?imageView/2/w/960/","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"泰国,曼谷","waypoints":105,"wifi_sync":false,"last_day":"2016-05-01","id":2387299585,"view_count":15018,"privacy":0,"day_count":8,"index_title":"","recommended":false,"share_url":"trips/2387299585/","comment_count":6,"version":1,"spot_count":0,"mileage":1546.22156550582,"description":"","last_modified":1.4754119190094E9,"user":{"gender":1,"email_verified":false,"location_name":"黑龙江_哈尔滨","name":"私物语","resident_city_id":264,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_dc_86_7804aee04748624b5508146e15d03ff382812084.jpg-avatar.s","cover":"http://photos.breadtrip.com/user_cover_2015_10_27_75aa09eb7ca5c8a577680fb712a21db18fa4321b.jpg-usercover.display","custom_url":"","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_dc_86_7804aee04748624b5508146e15d03ff382812084.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_dc_86_7804aee04748624b5508146e15d03ff382812084.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2383804808,"user_desc":"live fast.be wild.self enjoy.have fun\n","points":624},"cover_image_default":"http://photos.breadtrip.com/photo_2016_05_02_b707afb14efb584f7ead4bd7e27a67cf.jpg?imageView/2/w/960/q/85","date_complete":1462106280,"device":1,"date_added":1461460680,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_10_20_f1c01f02357d534cbbe9d74d11552121.jpeg?imageView/2/w/960/","name":"色彩×泰国","default":false,"first_day":"2016-04-24","cover_image_1600":"http://photos.breadtrip.com/photo_2016_05_02_b707afb14efb584f7ead4bd7e27a67cf.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":66,"cover_image":"http://photos.breadtrip.com/covers_2016_10_20_f1c01f02357d534cbbe9d74d11552121.jpeg?imageView/2/w/960/","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"英国,高地","waypoints":196,"wifi_sync":false,"last_day":"2016-06-19","id":2387276895,"view_count":9824,"privacy":0,"day_count":8,"index_title":"","recommended":false,"share_url":"trips/2387276895/","comment_count":5,"version":1,"spot_count":0,"mileage":4163.71657913044,"description":"","last_modified":1.47243627689585E9,"user":{"gender":1,"email_verified":true,"location_name":"","name":"键盘与面包","resident_city_id":269376,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_fe_6a_55396e739f2ab8ad59adc8f5dcfc139e.jpg-avatar.s","cover":"http://photos.breadtrip.com/user_cover_2015_01_12_399a2718ddfe7c84b58e99f20a62e93abf77d862.jpg-usercover.display","custom_url":"keyboard","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_fe_6a_55396e739f2ab8ad59adc8f5dcfc139e.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_fe_6a_55396e739f2ab8ad59adc8f5dcfc139e.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2387859240,"user_desc":"","points":33262},"cover_image_default":"http://photos.breadtrip.com/photo_2016_07_01_afab278d3575f5fa7f654006a851588e.jpg?imageView/2/w/960/q/85","date_complete":1466350002,"device":0,"date_added":1465722000,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_07_22_e9e6552a47ae2bda7cb66b8b0fc44845.jpg?imageView/2/w/960/","name":"苏格兰高地自驾游","default":false,"first_day":"2016-06-12","cover_image_1600":"http://photos.breadtrip.com/photo_2016_07_01_afab278d3575f5fa7f654006a851588e.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":98,"cover_image":"http://photos.breadtrip.com/covers_2016_07_22_e9e6552a47ae2bda7cb66b8b0fc44845.jpg?imageView/2/w/960/","start_point":{"latitude":55.9865866709,"longitude":-3.54725407812},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"","waypoints":0,"wifi_sync":true,"last_day":"2016-02-10","id":2387328824,"view_count":30464,"privacy":0,"day_count":3,"index_title":"#花Young春节#伊豆半岛* 花* 海 *空","recommended":false,"share_url":"btrip/trip/2387328824/","comment_count":1,"version":2,"spot_count":3,"mileage":0,"description":"","last_modified":1.45553872400245E9,"user":{"gender":2,"email_verified":true,"location_name":"北京_朝阳","name":"不必","resident_city_id":163,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_c4_e8_6a752997753cd312322b976adb2d317012e0df36.jpg-avatar.s","cover":"http://media.breadtrip.com/user_covers/default/cover_1.jpg","custom_url":"bubi","country_code":null,"email":"","birthday":"","country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_c4_e8_6a752997753cd312322b976adb2d317012e0df36.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_c4_e8_6a752997753cd312322b976adb2d317012e0df36.jpg-avatar.m","is_hunter":true,"cdc2":false,"id":2387959500,"user_desc":"做自己喜欢的人；做喜欢的事。","points":3},"cover_image_default":"http://photos.breadtrip.com/photo_2016_02_08_d965b1c777b3526f03533ef11e388c6b.jpg?imageView/2/w/960/q/85","date_complete":1455089784,"device":1,"date_added":1454934934,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_02_23_aa02c5f9f2b9d25ebae5ee8e666d800e.jpg?imageView/2/w/960/","name":"伊豆半岛* 花* 海 *空","default":false,"first_day":"2016-02-08","cover_image_1600":"http://photos.breadtrip.com/photo_2016_02_08_d965b1c777b3526f03533ef11e388c6b.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":false,"recommendations":23,"cover_image":"http://photos.breadtrip.com/covers_2016_02_23_aa02c5f9f2b9d25ebae5ee8e666d800e.jpg?imageView/2/w/960/","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":12,"desc":"热门游记"},{"data":[{"popular_place_str":"","waypoints":0,"wifi_sync":true,"last_day":"2016-05-25","id":2387098527,"view_count":2515,"privacy":0,"day_count":221,"index_title":"我与印章明信片的那些事儿","recommended":false,"share_url":"btrip/trip/2387098527/","comment_count":1,"version":2,"spot_count":13,"mileage":0,"description":"","last_modified":1.4641464647595E9,"user":{"gender":2,"email_verified":false,"location_name":"中国_北京","name":"爱旅行的茶tea","resident_city_id":288617,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_04_71_9475a36f683bb6aea9e6422d5587f47074bfde51.jpg-avatar.s","cover":"http://photos.breadtrip.com/user_cover_2016_10_11_6d903c2a30eaf0d6e33f6b7b556482126f8117a6.jpg-usercover.display","custom_url":"tea","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_04_71_9475a36f683bb6aea9e6422d5587f47074bfde51.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_04_71_9475a36f683bb6aea9e6422d5587f47074bfde51.jpg-avatar.m","is_hunter":true,"cdc2":false,"id":2387717775,"user_desc":"爱自由爱旅行，现在迷上了极限运动。水肺潜水Padi AOW 让我爱上了拍海洋生物。去过livehouse现场已成为一生戒不掉的瘾！找到自己独特个性后，就爱上了复古服饰，当然还有我一直喜爱的淘到的独一无二的首饰们，和家人般存在的，有灵性的人偶。快乐是最真的我，也许也有忧愁，但在你面前的我永远是快乐开朗天真的。","points":91},"cover_image_default":"http://photos.breadtrip.com/photo_2015_10_18_3a94735463d462723c3a315b27335ddc.jpg?imageView/2/w/960/q/85","date_complete":1464146238,"device":1,"date_added":1445175778,"cover_image_w640":"http://photos.breadtrip.com/photo_d_2015_10_21_08_46_24_816_6483441_-1704413772.jpg?imageView/2/w/960/q/85","name":"我的私人印章与明信片收藏的那些事儿","default":false,"first_day":"2015-10-18","cover_image_1600":"http://photos.breadtrip.com/photo_2015_10_18_3a94735463d462723c3a315b27335ddc.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":false,"recommendations":14,"cover_image":"http://photos.breadtrip.com/photo_d_2015_10_21_08_46_24_816_6483441_-1704413772.jpg?imageView/2/w/960/q/85","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":12,"desc":"热门游记"},{"data":[{"popular_place_str":"瑞士,劳特布伦嫩","waypoints":162,"wifi_sync":false,"last_day":"2016-08-02","id":2387266203,"view_count":13558,"privacy":0,"day_count":13,"index_title":"","recommended":false,"share_url":"trips/2387266203/","comment_count":2,"version":1,"spot_count":0,"mileage":34466.9424868884,"description":"","last_modified":1.47114614381404E9,"user":{"gender":2,"email_verified":true,"location_name":"中国_上海","name":"tracygua","resident_city_id":288678,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_df_84_4b2ed31f71d060e86fbc2581494b3782f21dae6a.jpg-avatar.s","cover":"http://photos.breadtrip.com/user_cover_2015_12_16_6fe5d46d231d2a3e79816d522eaf72e5cebe3be4.jpg-usercover.display","custom_url":"tracygua","country_code":null,"email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_df_84_4b2ed31f71d060e86fbc2581494b3782f21dae6a.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_df_84_4b2ed31f71d060e86fbc2581494b3782f21dae6a.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2387956730,"user_desc":"喜欢吃，喜欢旅行，剩下的时间做做research😉","points":4769},"cover_image_default":"http://photos.breadtrip.com/photo_2016_08_11_ac8bfff6683fe5ccbcff6e4fcbef2bb1.jpg?imageView/2/w/960/q/85","date_complete":1470142700,"device":0,"date_added":1469083260,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_08_14_9a543f6488dddd82e09997ec9675a7fb.jpg?imageView/2/w/960/","name":"阿尔卑斯山间的梦","default":false,"first_day":"2016-07-21","cover_image_1600":"http://photos.breadtrip.com/photo_2016_08_11_ac8bfff6683fe5ccbcff6e4fcbef2bb1.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":96,"cover_image":"http://photos.breadtrip.com/covers_2016_08_14_9a543f6488dddd82e09997ec9675a7fb.jpg?imageView/2/w/960/","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"中国,北京","waypoints":28,"wifi_sync":false,"last_day":"2016-12-02","id":2387253207,"view_count":18635,"privacy":0,"day_count":173,"index_title":"","recommended":false,"share_url":"trips/2387253207/","comment_count":5,"version":1,"spot_count":0,"mileage":90.1627308383845,"description":"","last_modified":1.4743681639595E9,"user":{"gender":2,"email_verified":true,"location_name":"","name":"郭七七Gladys","resident_city_id":288630,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_df_c8_1f035da762a1eba4601cd50e80e1e26f55411680.jpg-avatar.s","cover":"http://photos.breadtrip.com/default_user_cover_02.jpg-usercover.display","custom_url":"","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_df_c8_1f035da762a1eba4601cd50e80e1e26f55411680.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_df_c8_1f035da762a1eba4601cd50e80e1e26f55411680.jpg-avatar.m","is_hunter":true,"cdc2":false,"id":2384126276,"user_desc":"我是Gladys，一枚酷爱摄影的95后北京妹子，最开始接摄影也是一时兴起，心血来潮买了相机，后来渐渐拍的照片被周围越来越多的人赞同和认可，惊讶于摄影带给我的改变和生活上不同角度的看法，也从中找到了属于自己的风格。偏爱走文艺清新与复古路线的我闲暇时也喜欢去Mao听听摇滚，在草莓音乐节人群炙热的碰撞中享受青春的激情和澎湃。","points":157},"cover_image_default":"http://photos.breadtrip.com/photo_2016_06_13_d173393fe0f04b3cb7872b170ac08e74.jpg?imageView/2/w/960/q/85","date_complete":null,"device":1,"date_added":1457972100,"cover_image_w640":"http://photos.breadtrip.com/photo_2016_05_30_bbd61514f4bb0208a979b83fd421e495.jpg?imageView/1/w/640/h/480/q/85","name":"在帝都 以不同的角度看国贸CBD","default":false,"first_day":"2016-03-15","cover_image_1600":"http://photos.breadtrip.com/photo_2016_06_13_d173393fe0f04b3cb7872b170ac08e74.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":80,"cover_image":"http://photos.breadtrip.com/photo_2016_05_30_bbd61514f4bb0208a979b83fd421e495.jpg?imageView/1/w/640/h/480/q/85","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"瑞士,阿尔特","waypoints":169,"wifi_sync":false,"last_day":"2016-05-02","id":2387261706,"view_count":6447,"privacy":0,"day_count":12,"index_title":"","recommended":false,"share_url":"trips/2387261706/","comment_count":1,"version":1,"spot_count":0,"mileage":20833.3106165992,"description":"","last_modified":1.46389928787153E9,"user":{"gender":2,"email_verified":true,"location_name":"四川_成都","name":"春蛇","resident_city_id":99,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_26_6f_fea331350b86afdb6cd47deb125eacba67c35b13.jpg-avatar.s","cover":"http://photos.breadtrip.com/default_user_cover_02.jpg-usercover.display","custom_url":"","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_26_6f_fea331350b86afdb6cd47deb125eacba67c35b13.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_26_6f_fea331350b86afdb6cd47deb125eacba67c35b13.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2388492839,"user_desc":"奶们什么都不是","points":6857},"cover_image_default":"http://photos.breadtrip.com/photo_2016_05_11_4053ffce194197781ffe8334ba6f17d1.jpg?imageView/2/w/960/q/85","date_complete":1462192740,"device":1,"date_added":1461215520,"cover_image_w640":"http://photos.breadtrip.com/photo_2016_05_11_7ce9159d1abd5049f44d1811cb2b5b79.jpg?imageView/1/w/640/h/480/q/85","name":"戴着欧洲去旅行😂","default":false,"first_day":"2016-04-21","cover_image_1600":"http://photos.breadtrip.com/photo_2016_05_11_4053ffce194197781ffe8334ba6f17d1.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":50,"cover_image":"http://photos.breadtrip.com/photo_2016_05_11_7ce9159d1abd5049f44d1811cb2b5b79.jpg?imageView/1/w/640/h/480/q/85","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":4,"desc":"热门游记"}],"next_start":2387316920}
     */

    private int status;
    private String message;
    /**
     * elements : [{"data":[{"popular_place_str":"中国,大同","waypoints":93,"wifi_sync":true,"last_day":"2016-07-08","id":2387277129,"view_count":7681,"privacy":0,"day_count":11,"index_title":"再探 秘境山西","recommended":false,"share_url":"trips/2387277129/","comment_count":7,"version":1,"spot_count":0,"mileage":3057.08787136348,"description":"","last_modified":1.46813090930697E9,"user":{"gender":1,"email_verified":true,"location_name":"","name":"simonfu","resident_city_id":288158,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.s","cover":"http://photos.breadtrip.com/default_user_cover_05.jpg-usercover.display","custom_url":"simonfu","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2388334241,"user_desc":"","points":52503},"cover_image_default":"http://photos.breadtrip.com/photo_2016_06_30_33885e9e1a3dc3d7e251a28352745eb0.jpg?imageView/2/w/960/q/85","date_complete":1467953100,"device":1,"date_added":1467077220,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_07_07_b41b90f6241dbc2a8b4da2d8c22e71e5.jpg?imageView/2/w/960/","name":"秘境山西","default":false,"first_day":"2016-06-28","cover_image_1600":"http://photos.breadtrip.com/photo_2016_06_30_33885e9e1a3dc3d7e251a28352745eb0.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":41,"cover_image":"http://photos.breadtrip.com/covers_2016_07_07_b41b90f6241dbc2a8b4da2d8c22e71e5.jpg?imageView/2/w/960/","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"意大利,佛罗伦萨","waypoints":157,"wifi_sync":false,"last_day":"2016-08-01","id":2387264641,"view_count":16271,"privacy":0,"day_count":4,"index_title":"","recommended":false,"share_url":"trips/2387264641/","comment_count":5,"version":1,"spot_count":0,"mileage":9567.31560440766,"description":"","last_modified":1.4723066541756E9,"user":{"gender":1,"email_verified":true,"location_name":"","name":"嘿咔噜","resident_city_id":"","mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_a0_c4_305c35ac3096a871a6ffd7a0a73b84d06e3cb6d6.jpg-avatar.s","cover":"http://photos.breadtrip.com/user_cover_2015_08_30_2c91680e287644d577648a9051385338c06fe5e6.jpg-usercover.display","custom_url":"panshaozhe","country_code":null,"email":"","birthday":"","country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_a0_c4_305c35ac3096a871a6ffd7a0a73b84d06e3cb6d6.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_a0_c4_305c35ac3096a871a6ffd7a0a73b84d06e3cb6d6.jpg-avatar.m","is_hunter":true,"cdc2":false,"id":2387689570,"user_desc":"我是嘿咔噜，我喜欢自己制定计划带上心爱的人去旅行，走遍世界的每个角落，哪条路、哪道水、没有关联；哪阵风、哪片云，没有呼应。我们走过的城市、山川都化成了我们的生命。","points":1663},"cover_image_default":"http://photos.breadtrip.com/photo_2016_08_19_24557a3b6a26ff899c8d74bc5b4c5e4d.jpg?imageView/2/w/960/q/85","date_complete":1470059053,"device":0,"date_added":1469773374,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_08_19_5a33e8da1eee8c470a50c88965346461.jpg?imageView/2/w/960/","name":"意游未尽","default":false,"first_day":"2016-07-29","cover_image_1600":"http://photos.breadtrip.com/photo_2016_08_19_24557a3b6a26ff899c8d74bc5b4c5e4d.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":84,"cover_image":"http://photos.breadtrip.com/covers_2016_08_19_5a33e8da1eee8c470a50c88965346461.jpg?imageView/2/w/960/","start_point":{"latitude":34.25324367131224,"longitude":108.9280700688335},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"中国,青岛","waypoints":85,"wifi_sync":false,"last_day":"2016-05-02","id":2387257987,"view_count":12907,"privacy":0,"day_count":4,"index_title":"","recommended":false,"share_url":"trips/2387257987/","comment_count":3,"version":1,"spot_count":0,"mileage":20.510412245102,"description":"","last_modified":1.47644440839961E9,"user":{"gender":2,"email_verified":true,"location_name":"浙江_杭州","name":"寿司上的小饭团","resident_city_id":203,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_2a_39_7e66e61353af7618211f5545649bd076fb63977d.jpg-avatar.s","cover":"http://photos.breadtrip.com/user_cover_2016_05_31_5aaa0969b236c5db19275cc51144afc2460bcc3a.jpg-usercover.display","custom_url":"","country_code":null,"email":"","birthday":"","country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_2a_39_7e66e61353af7618211f5545649bd076fb63977d.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_2a_39_7e66e61353af7618211f5545649bd076fb63977d.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2388326238,"user_desc":"","points":512},"cover_image_default":"http://photos.breadtrip.com/photo_2016_07_20_2ae41e24bfeeb217425aaf0896c569cb.jpg?imageView/2/w/960/q/85","date_complete":1462169461,"device":1,"date_added":1461925200,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_08_13_3d1fbd0d51ecf8ff363e5bf92be577e9.jpg?imageView/2/w/960/","name":"红瓦绿树 碧海青岛","default":false,"first_day":"2016-04-29","cover_image_1600":"http://photos.breadtrip.com/photo_2016_07_20_2ae41e24bfeeb217425aaf0896c569cb.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":88,"cover_image":"http://photos.breadtrip.com/covers_2016_08_13_3d1fbd0d51ecf8ff363e5bf92be577e9.jpg?imageView/2/w/960/","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"泰国,曼谷","waypoints":105,"wifi_sync":false,"last_day":"2016-05-01","id":2387299585,"view_count":15018,"privacy":0,"day_count":8,"index_title":"","recommended":false,"share_url":"trips/2387299585/","comment_count":6,"version":1,"spot_count":0,"mileage":1546.22156550582,"description":"","last_modified":1.4754119190094E9,"user":{"gender":1,"email_verified":false,"location_name":"黑龙江_哈尔滨","name":"私物语","resident_city_id":264,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_dc_86_7804aee04748624b5508146e15d03ff382812084.jpg-avatar.s","cover":"http://photos.breadtrip.com/user_cover_2015_10_27_75aa09eb7ca5c8a577680fb712a21db18fa4321b.jpg-usercover.display","custom_url":"","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_dc_86_7804aee04748624b5508146e15d03ff382812084.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_dc_86_7804aee04748624b5508146e15d03ff382812084.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2383804808,"user_desc":"live fast.be wild.self enjoy.have fun\n","points":624},"cover_image_default":"http://photos.breadtrip.com/photo_2016_05_02_b707afb14efb584f7ead4bd7e27a67cf.jpg?imageView/2/w/960/q/85","date_complete":1462106280,"device":1,"date_added":1461460680,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_10_20_f1c01f02357d534cbbe9d74d11552121.jpeg?imageView/2/w/960/","name":"色彩×泰国","default":false,"first_day":"2016-04-24","cover_image_1600":"http://photos.breadtrip.com/photo_2016_05_02_b707afb14efb584f7ead4bd7e27a67cf.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":66,"cover_image":"http://photos.breadtrip.com/covers_2016_10_20_f1c01f02357d534cbbe9d74d11552121.jpeg?imageView/2/w/960/","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"英国,高地","waypoints":196,"wifi_sync":false,"last_day":"2016-06-19","id":2387276895,"view_count":9824,"privacy":0,"day_count":8,"index_title":"","recommended":false,"share_url":"trips/2387276895/","comment_count":5,"version":1,"spot_count":0,"mileage":4163.71657913044,"description":"","last_modified":1.47243627689585E9,"user":{"gender":1,"email_verified":true,"location_name":"","name":"键盘与面包","resident_city_id":269376,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_fe_6a_55396e739f2ab8ad59adc8f5dcfc139e.jpg-avatar.s","cover":"http://photos.breadtrip.com/user_cover_2015_01_12_399a2718ddfe7c84b58e99f20a62e93abf77d862.jpg-usercover.display","custom_url":"keyboard","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_fe_6a_55396e739f2ab8ad59adc8f5dcfc139e.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_fe_6a_55396e739f2ab8ad59adc8f5dcfc139e.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2387859240,"user_desc":"","points":33262},"cover_image_default":"http://photos.breadtrip.com/photo_2016_07_01_afab278d3575f5fa7f654006a851588e.jpg?imageView/2/w/960/q/85","date_complete":1466350002,"device":0,"date_added":1465722000,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_07_22_e9e6552a47ae2bda7cb66b8b0fc44845.jpg?imageView/2/w/960/","name":"苏格兰高地自驾游","default":false,"first_day":"2016-06-12","cover_image_1600":"http://photos.breadtrip.com/photo_2016_07_01_afab278d3575f5fa7f654006a851588e.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":98,"cover_image":"http://photos.breadtrip.com/covers_2016_07_22_e9e6552a47ae2bda7cb66b8b0fc44845.jpg?imageView/2/w/960/","start_point":{"latitude":55.9865866709,"longitude":-3.54725407812},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"","waypoints":0,"wifi_sync":true,"last_day":"2016-02-10","id":2387328824,"view_count":30464,"privacy":0,"day_count":3,"index_title":"#花Young春节#伊豆半岛* 花* 海 *空","recommended":false,"share_url":"btrip/trip/2387328824/","comment_count":1,"version":2,"spot_count":3,"mileage":0,"description":"","last_modified":1.45553872400245E9,"user":{"gender":2,"email_verified":true,"location_name":"北京_朝阳","name":"不必","resident_city_id":163,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_c4_e8_6a752997753cd312322b976adb2d317012e0df36.jpg-avatar.s","cover":"http://media.breadtrip.com/user_covers/default/cover_1.jpg","custom_url":"bubi","country_code":null,"email":"","birthday":"","country_num":null,"avatar_l":"http://photos.breadtrip.com/avatar_c4_e8_6a752997753cd312322b976adb2d317012e0df36.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_c4_e8_6a752997753cd312322b976adb2d317012e0df36.jpg-avatar.m","is_hunter":true,"cdc2":false,"id":2387959500,"user_desc":"做自己喜欢的人；做喜欢的事。","points":3},"cover_image_default":"http://photos.breadtrip.com/photo_2016_02_08_d965b1c777b3526f03533ef11e388c6b.jpg?imageView/2/w/960/q/85","date_complete":1455089784,"device":1,"date_added":1454934934,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_02_23_aa02c5f9f2b9d25ebae5ee8e666d800e.jpg?imageView/2/w/960/","name":"伊豆半岛* 花* 海 *空","default":false,"first_day":"2016-02-08","cover_image_1600":"http://photos.breadtrip.com/photo_2016_02_08_d965b1c777b3526f03533ef11e388c6b.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":false,"recommendations":23,"cover_image":"http://photos.breadtrip.com/covers_2016_02_23_aa02c5f9f2b9d25ebae5ee8e666d800e.jpg?imageView/2/w/960/","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":12,"desc":"热门游记"},{"data":[{"popular_place_str":"","waypoints":0,"wifi_sync":true,"last_day":"2016-05-25","id":2387098527,"view_count":2515,"privacy":0,"day_count":221,"index_title":"我与印章明信片的那些事儿","recommended":false,"share_url":"btrip/trip/2387098527/","comment_count":1,"version":2,"spot_count":13,"mileage":0,"description":"","last_modified":1.4641464647595E9,"user":{"gender":2,"email_verified":false,"location_name":"中国_北京","name":"爱旅行的茶tea","resident_city_id":288617,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_04_71_9475a36f683bb6aea9e6422d5587f47074bfde51.jpg-avatar.s","cover":"http://photos.breadtrip.com/user_cover_2016_10_11_6d903c2a30eaf0d6e33f6b7b556482126f8117a6.jpg-usercover.display","custom_url":"tea","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_04_71_9475a36f683bb6aea9e6422d5587f47074bfde51.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_04_71_9475a36f683bb6aea9e6422d5587f47074bfde51.jpg-avatar.m","is_hunter":true,"cdc2":false,"id":2387717775,"user_desc":"爱自由爱旅行，现在迷上了极限运动。水肺潜水Padi AOW 让我爱上了拍海洋生物。去过livehouse现场已成为一生戒不掉的瘾！找到自己独特个性后，就爱上了复古服饰，当然还有我一直喜爱的淘到的独一无二的首饰们，和家人般存在的，有灵性的人偶。快乐是最真的我，也许也有忧愁，但在你面前的我永远是快乐开朗天真的。","points":91},"cover_image_default":"http://photos.breadtrip.com/photo_2015_10_18_3a94735463d462723c3a315b27335ddc.jpg?imageView/2/w/960/q/85","date_complete":1464146238,"device":1,"date_added":1445175778,"cover_image_w640":"http://photos.breadtrip.com/photo_d_2015_10_21_08_46_24_816_6483441_-1704413772.jpg?imageView/2/w/960/q/85","name":"我的私人印章与明信片收藏的那些事儿","default":false,"first_day":"2015-10-18","cover_image_1600":"http://photos.breadtrip.com/photo_2015_10_18_3a94735463d462723c3a315b27335ddc.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":false,"recommendations":14,"cover_image":"http://photos.breadtrip.com/photo_d_2015_10_21_08_46_24_816_6483441_-1704413772.jpg?imageView/2/w/960/q/85","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":12,"desc":"热门游记"},{"data":[{"popular_place_str":"瑞士,劳特布伦嫩","waypoints":162,"wifi_sync":false,"last_day":"2016-08-02","id":2387266203,"view_count":13558,"privacy":0,"day_count":13,"index_title":"","recommended":false,"share_url":"trips/2387266203/","comment_count":2,"version":1,"spot_count":0,"mileage":34466.9424868884,"description":"","last_modified":1.47114614381404E9,"user":{"gender":2,"email_verified":true,"location_name":"中国_上海","name":"tracygua","resident_city_id":288678,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_df_84_4b2ed31f71d060e86fbc2581494b3782f21dae6a.jpg-avatar.s","cover":"http://photos.breadtrip.com/user_cover_2015_12_16_6fe5d46d231d2a3e79816d522eaf72e5cebe3be4.jpg-usercover.display","custom_url":"tracygua","country_code":null,"email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_df_84_4b2ed31f71d060e86fbc2581494b3782f21dae6a.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_df_84_4b2ed31f71d060e86fbc2581494b3782f21dae6a.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2387956730,"user_desc":"喜欢吃，喜欢旅行，剩下的时间做做research😉","points":4769},"cover_image_default":"http://photos.breadtrip.com/photo_2016_08_11_ac8bfff6683fe5ccbcff6e4fcbef2bb1.jpg?imageView/2/w/960/q/85","date_complete":1470142700,"device":0,"date_added":1469083260,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_08_14_9a543f6488dddd82e09997ec9675a7fb.jpg?imageView/2/w/960/","name":"阿尔卑斯山间的梦","default":false,"first_day":"2016-07-21","cover_image_1600":"http://photos.breadtrip.com/photo_2016_08_11_ac8bfff6683fe5ccbcff6e4fcbef2bb1.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":96,"cover_image":"http://photos.breadtrip.com/covers_2016_08_14_9a543f6488dddd82e09997ec9675a7fb.jpg?imageView/2/w/960/","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"中国,北京","waypoints":28,"wifi_sync":false,"last_day":"2016-12-02","id":2387253207,"view_count":18635,"privacy":0,"day_count":173,"index_title":"","recommended":false,"share_url":"trips/2387253207/","comment_count":5,"version":1,"spot_count":0,"mileage":90.1627308383845,"description":"","last_modified":1.4743681639595E9,"user":{"gender":2,"email_verified":true,"location_name":"","name":"郭七七Gladys","resident_city_id":288630,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_df_c8_1f035da762a1eba4601cd50e80e1e26f55411680.jpg-avatar.s","cover":"http://photos.breadtrip.com/default_user_cover_02.jpg-usercover.display","custom_url":"","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_df_c8_1f035da762a1eba4601cd50e80e1e26f55411680.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_df_c8_1f035da762a1eba4601cd50e80e1e26f55411680.jpg-avatar.m","is_hunter":true,"cdc2":false,"id":2384126276,"user_desc":"我是Gladys，一枚酷爱摄影的95后北京妹子，最开始接摄影也是一时兴起，心血来潮买了相机，后来渐渐拍的照片被周围越来越多的人赞同和认可，惊讶于摄影带给我的改变和生活上不同角度的看法，也从中找到了属于自己的风格。偏爱走文艺清新与复古路线的我闲暇时也喜欢去Mao听听摇滚，在草莓音乐节人群炙热的碰撞中享受青春的激情和澎湃。","points":157},"cover_image_default":"http://photos.breadtrip.com/photo_2016_06_13_d173393fe0f04b3cb7872b170ac08e74.jpg?imageView/2/w/960/q/85","date_complete":null,"device":1,"date_added":1457972100,"cover_image_w640":"http://photos.breadtrip.com/photo_2016_05_30_bbd61514f4bb0208a979b83fd421e495.jpg?imageView/1/w/640/h/480/q/85","name":"在帝都 以不同的角度看国贸CBD","default":false,"first_day":"2016-03-15","cover_image_1600":"http://photos.breadtrip.com/photo_2016_06_13_d173393fe0f04b3cb7872b170ac08e74.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":80,"cover_image":"http://photos.breadtrip.com/photo_2016_05_30_bbd61514f4bb0208a979b83fd421e495.jpg?imageView/1/w/640/h/480/q/85","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":4,"desc":"热门游记"},{"data":[{"popular_place_str":"瑞士,阿尔特","waypoints":169,"wifi_sync":false,"last_day":"2016-05-02","id":2387261706,"view_count":6447,"privacy":0,"day_count":12,"index_title":"","recommended":false,"share_url":"trips/2387261706/","comment_count":1,"version":1,"spot_count":0,"mileage":20833.3106165992,"description":"","last_modified":1.46389928787153E9,"user":{"gender":2,"email_verified":true,"location_name":"四川_成都","name":"春蛇","resident_city_id":99,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_26_6f_fea331350b86afdb6cd47deb125eacba67c35b13.jpg-avatar.s","cover":"http://photos.breadtrip.com/default_user_cover_02.jpg-usercover.display","custom_url":"","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_26_6f_fea331350b86afdb6cd47deb125eacba67c35b13.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_26_6f_fea331350b86afdb6cd47deb125eacba67c35b13.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2388492839,"user_desc":"奶们什么都不是","points":6857},"cover_image_default":"http://photos.breadtrip.com/photo_2016_05_11_4053ffce194197781ffe8334ba6f17d1.jpg?imageView/2/w/960/q/85","date_complete":1462192740,"device":1,"date_added":1461215520,"cover_image_w640":"http://photos.breadtrip.com/photo_2016_05_11_7ce9159d1abd5049f44d1811cb2b5b79.jpg?imageView/1/w/640/h/480/q/85","name":"戴着欧洲去旅行😂","default":false,"first_day":"2016-04-21","cover_image_1600":"http://photos.breadtrip.com/photo_2016_05_11_4053ffce194197781ffe8334ba6f17d1.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":50,"cover_image":"http://photos.breadtrip.com/photo_2016_05_11_7ce9159d1abd5049f44d1811cb2b5b79.jpg?imageView/1/w/640/h/480/q/85","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}],"type":4,"desc":"热门游记"}]
     * next_start : 2387316920
     */

    private DataBeanResult data;

    public static DetailBean objectFromData(String str) {

        return new Gson().fromJson(str, DetailBean.class);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBeanResult getData() {
        return data;
    }

    public void setData(DataBeanResult data) {
        this.data = data;
    }

    public static class DataBeanResult {
        private long next_start;
        /**
         * data : [{"popular_place_str":"中国,大同","waypoints":93,"wifi_sync":true,"last_day":"2016-07-08","id":2387277129,"view_count":7681,"privacy":0,"day_count":11,"index_title":"再探 秘境山西","recommended":false,"share_url":"trips/2387277129/","comment_count":7,"version":1,"spot_count":0,"mileage":3057.08787136348,"description":"","last_modified":1.46813090930697E9,"user":{"gender":1,"email_verified":true,"location_name":"","name":"simonfu","resident_city_id":288158,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.s","cover":"http://photos.breadtrip.com/default_user_cover_05.jpg-usercover.display","custom_url":"simonfu","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2388334241,"user_desc":"","points":52503},"cover_image_default":"http://photos.breadtrip.com/photo_2016_06_30_33885e9e1a3dc3d7e251a28352745eb0.jpg?imageView/2/w/960/q/85","date_complete":1467953100,"device":1,"date_added":1467077220,"cover_image_w640":"http://photos.breadtrip.com/covers_2016_07_07_b41b90f6241dbc2a8b4da2d8c22e71e5.jpg?imageView/2/w/960/","name":"秘境山西","default":false,"first_day":"2016-06-28","cover_image_1600":"http://photos.breadtrip.com/photo_2016_06_30_33885e9e1a3dc3d7e251a28352745eb0.jpg?imageView/1/w/640/h/480/q/85","summary":"","is_hot_trip":true,"recommendations":41,"cover_image":"http://photos.breadtrip.com/covers_2016_07_07_b41b90f6241dbc2a8b4da2d8c22e71e5.jpg?imageView/2/w/960/","start_point":{"latitude":null,"longitude":null},"is_featured_trip":false}]
         * type : 4
         * desc : 热门游记
         */

        private List<ElementsBean> elements;

        public static DataBeanResult objectFromData(String str) {

            return new Gson().fromJson(str, DataBeanResult.class);
        }

        public long getNext_start() {
            return next_start;
        }

        public void setNext_start(long next_start) {
            this.next_start = next_start;
        }

        public List<ElementsBean> getElements() {
            return elements;
        }

        public void setElements(List<ElementsBean> elements) {
            this.elements = elements;
        }

        public static class ElementsBean {
            private int type;
            private String desc;
            /**
             * popular_place_str : 中国,大同
             * waypoints : 93
             * wifi_sync : true
             * last_day : 2016-07-08
             * id : 2387277129
             * view_count : 7681
             * privacy : 0
             * day_count : 11
             * index_title : 再探 秘境山西
             * recommended : false
             * share_url : trips/2387277129/
             * comment_count : 7
             * version : 1
             * spot_count : 0
             * mileage : 3057.08787136348
             * description :
             * last_modified : 1.46813090930697E9
             * user : {"gender":1,"email_verified":true,"location_name":"","name":"simonfu","resident_city_id":288158,"mobile":"","avatar_s":"http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.s","cover":"http://photos.breadtrip.com/default_user_cover_05.jpg-usercover.display","custom_url":"simonfu","country_code":"CN","email":"","birthday":"","country_num":"86","avatar_l":"http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.l","avatar_m":"http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.m","is_hunter":false,"cdc2":false,"id":2388334241,"user_desc":"","points":52503}
             * cover_image_default : http://photos.breadtrip.com/photo_2016_06_30_33885e9e1a3dc3d7e251a28352745eb0.jpg?imageView/2/w/960/q/85
             * date_complete : 1467953100
             * device : 1
             * date_added : 1467077220
             * cover_image_w640 : http://photos.breadtrip.com/covers_2016_07_07_b41b90f6241dbc2a8b4da2d8c22e71e5.jpg?imageView/2/w/960/
             * name : 秘境山西
             * default : false
             * first_day : 2016-06-28
             * cover_image_1600 : http://photos.breadtrip.com/photo_2016_06_30_33885e9e1a3dc3d7e251a28352745eb0.jpg?imageView/1/w/640/h/480/q/85
             * summary :
             * is_hot_trip : true
             * recommendations : 41
             * cover_image : http://photos.breadtrip.com/covers_2016_07_07_b41b90f6241dbc2a8b4da2d8c22e71e5.jpg?imageView/2/w/960/
             * start_point : {"latitude":null,"longitude":null}
             * is_featured_trip : false
             */

            private List<DataBean> data;

            public static ElementsBean objectFromData(String str) {

                return new Gson().fromJson(str, ElementsBean.class);
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                private String popular_place_str;
                private int waypoints;
                private boolean wifi_sync;
                private String last_day;
                private long id;
                private int view_count;
                private int privacy;
                private int day_count;
                private String index_title;
                private boolean recommended;
                private String share_url;
                private int comment_count;
                private int version;
                private int spot_count;
                private double mileage;
                private String description;
                private double last_modified;
                /**
                 * gender : 1
                 * email_verified : true
                 * location_name :
                 * name : simonfu
                 * resident_city_id : 288158
                 * mobile :
                 * avatar_s : http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.s
                 * cover : http://photos.breadtrip.com/default_user_cover_05.jpg-usercover.display
                 * custom_url : simonfu
                 * country_code : CN
                 * email :
                 * birthday :
                 * country_num : 86
                 * avatar_l : http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.l
                 * avatar_m : http://photos.breadtrip.com/avatar_3f_f8_487355ee6dbd6c1c763446d6d9beb100ace6592a.jpg-avatar.m
                 * is_hunter : false
                 * cdc2 : false
                 * id : 2388334241
                 * user_desc :
                 * points : 52503
                 */

                private UserBean user;
                private String cover_image_default;
                private int date_complete;
                private int device;
                private int date_added;
                private String cover_image_w640;
                private String name;
                @SerializedName("default")
                private boolean defaultX;
                private String first_day;
                private String cover_image_1600;
                private String summary;
                private boolean is_hot_trip;
                private int recommendations;
                private String cover_image;
                /**
                 * latitude : null
                 * longitude : null
                 */

                private StartPointBean start_point;
                private boolean is_featured_trip;

                public static DataBean objectFromData(String str) {

                    return new Gson().fromJson(str, DataBean.class);
                }

                public String getPopular_place_str() {
                    return popular_place_str;
                }

                public void setPopular_place_str(String popular_place_str) {
                    this.popular_place_str = popular_place_str;
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

                public long getId() {
                    return id;
                }

                public void setId(long id) {
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

                public boolean isRecommended() {
                    return recommended;
                }

                public void setRecommended(boolean recommended) {
                    this.recommended = recommended;
                }

                public String getShare_url() {
                    return share_url;
                }

                public void setShare_url(String share_url) {
                    this.share_url = share_url;
                }

                public int getComment_count() {
                    return comment_count;
                }

                public void setComment_count(int comment_count) {
                    this.comment_count = comment_count;
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

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public String getCover_image_default() {
                    return cover_image_default;
                }

                public void setCover_image_default(String cover_image_default) {
                    this.cover_image_default = cover_image_default;
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

                public String getFirst_day() {
                    return first_day;
                }

                public void setFirst_day(String first_day) {
                    this.first_day = first_day;
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

                public StartPointBean getStart_point() {
                    return start_point;
                }

                public void setStart_point(StartPointBean start_point) {
                    this.start_point = start_point;
                }

                public boolean isIs_featured_trip() {
                    return is_featured_trip;
                }

                public void setIs_featured_trip(boolean is_featured_trip) {
                    this.is_featured_trip = is_featured_trip;
                }

                public static class UserBean {
                    private int gender;
                    private boolean email_verified;
                    private String location_name;
                    private String name;
                    private int resident_city_id;
                    private String mobile;
                    private String avatar_s;
                    private String cover;
                    private String custom_url;
                    private String country_code;
                    private String email;
                    private String birthday;
                    private String country_num;
                    private String avatar_l;
                    private String avatar_m;
                    private boolean is_hunter;
                    private boolean cdc2;
                    private long id;
                    private String user_desc;
                    private int points;

                    public static UserBean objectFromData(String str) {

                        return new Gson().fromJson(str, UserBean.class);
                    }

                    public int getGender() {
                        return gender;
                    }

                    public void setGender(int gender) {
                        this.gender = gender;
                    }

                    public boolean isEmail_verified() {
                        return email_verified;
                    }

                    public void setEmail_verified(boolean email_verified) {
                        this.email_verified = email_verified;
                    }

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

                    public String getAvatar_s() {
                        return avatar_s;
                    }

                    public void setAvatar_s(String avatar_s) {
                        this.avatar_s = avatar_s;
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

                    public String getCountry_code() {
                        return country_code;
                    }

                    public void setCountry_code(String country_code) {
                        this.country_code = country_code;
                    }

                    public String getEmail() {
                        return email;
                    }

                    public void setEmail(String email) {
                        this.email = email;
                    }

                    public String getBirthday() {
                        return birthday;
                    }

                    public void setBirthday(String birthday) {
                        this.birthday = birthday;
                    }

                    public String getCountry_num() {
                        return country_num;
                    }

                    public void setCountry_num(String country_num) {
                        this.country_num = country_num;
                    }

                    public String getAvatar_l() {
                        return avatar_l;
                    }

                    public void setAvatar_l(String avatar_l) {
                        this.avatar_l = avatar_l;
                    }

                    public String getAvatar_m() {
                        return avatar_m;
                    }

                    public void setAvatar_m(String avatar_m) {
                        this.avatar_m = avatar_m;
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

                    public long getId() {
                        return id;
                    }

                    public void setId(long id) {
                        this.id = id;
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

                public static class StartPointBean {
                    private Object latitude;
                    private Object longitude;

                    public static StartPointBean objectFromData(String str) {

                        return new Gson().fromJson(str, StartPointBean.class);
                    }

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
        }
    }
}
