package com.renren.breadtravel.entity;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuyinlei on 2016/12/20.
 */

public class HotRecomment implements Serializable {

    /**
     * status : 0
     * message :
     * data : [{"id":22,"name":"悉尼"},{"id":4,"name":"东京"},{"id":5,"name":"大阪"},{"id":6,"name":"冲绳"},{"id":7,"name":"清迈"},{"id":8,"name":"普吉岛"},{"id":9,"name":"台湾"},{"id":10,"name":"新加坡"},{"id":11,"name":"洛杉矶"},{"id":12,"name":"苏梅岛"},{"id":13,"name":"巴厘岛"},{"id":14,"name":"香港"},{"id":15,"name":"曼谷"},{"id":16,"name":"纽约"},{"id":17,"name":"通讯WIFI"},{"id":18,"name":"环球影城"},{"id":19,"name":"亲子"},{"id":20,"name":"电话卡"},{"id":21,"name":"首尔"},{"id":23,"name":"墨尔本"},{"id":24,"name":"凯恩斯"},{"id":25,"name":"新西兰"},{"id":26,"name":"大堡礁"},{"id":27,"name":"热气球"},{"id":28,"name":"跳伞"}]
     */

    private int status;
    private String message;
    /**
     * id : 22
     * name : 悉尼
     */

    private List<DataBean> data;

    public static HotRecomment objectFromData(String str) {

        return new Gson().fromJson(str, HotRecomment.class);
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private String name;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
