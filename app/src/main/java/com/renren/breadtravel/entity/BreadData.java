package com.renren.breadtravel.entity;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuyinlei on 2016/12/17.
 */

public class BreadData implements Serializable {


    private int status;
    private String message;


    private DataBean data;

    public static BreadData objectFromData(String str) {

        return new Gson().fromJson(str, BreadData.class);
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private boolean has_more;
        private String next_start;


        private List<TopicListBean> topic_list;

        public static DataBean objectFromData(String str) {

            return new Gson().fromJson(str, DataBean.class);
        }

        public boolean isHas_more() {
            return has_more;
        }

        public void setHas_more(boolean has_more) {
            this.has_more = has_more;
        }

        public String getNext_start() {
            return next_start;
        }

        public void setNext_start(String next_start) {
            this.next_start = next_start;
        }

        public List<TopicListBean> getTopic_list() {
            return topic_list;
        }

        public void setTopic_list(List<TopicListBean> topic_list) {
            this.topic_list = topic_list;
        }

        public static class TopicListBean {
            private String url;
            private String sub_title;
            private String cover_image_url;
            private String title;
            /**
             * cover_img : http://photos.breadtrip.com/covers_2016_07_04_795fadd535c3252ef9e65200dab736fc.image?imageView2/2/w/240/h/200/format/jpg/interlace/1/
             * text : 【赞礼号游轮2017首航】皇家加勒比天津-釜山（韩国）-天津4晚5日
             * price : 3999
             * url : http://vacation.breadtrip.com/share/product/1010960/book/
             * market_price : 4999
             * address : 北京
             * id : 1010960
             */

            private List<ProductsBean> products;

            public static TopicListBean objectFromData(String str) {

                return new Gson().fromJson(str, TopicListBean.class);
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getSub_title() {
                return sub_title;
            }

            public void setSub_title(String sub_title) {
                this.sub_title = sub_title;
            }

            public String getCover_image_url() {
                return cover_image_url;
            }

            public void setCover_image_url(String cover_image_url) {
                this.cover_image_url = cover_image_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ProductsBean> getProducts() {
                return products;
            }

            public void setProducts(List<ProductsBean> products) {
                this.products = products;
            }

            public static class ProductsBean {
                private String cover_img;
                private String text;
                private String price;
                private String url;
                private String market_price;
                private String address;
                private String id;
                public boolean isLookMore = false;

                public static ProductsBean objectFromData(String str) {

                    return new Gson().fromJson(str, ProductsBean.class);
                }

                public String getCover_img() {
                    return cover_img;
                }

                public void setCover_img(String cover_img) {
                    this.cover_img = cover_img;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getMarket_price() {
                    return market_price;
                }

                public void setMarket_price(String market_price) {
                    this.market_price = market_price;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }
    }
}
