package com.dev4u.ntc.retrofitdemo.model;

/**
 * IDE: Android Studio
 * Created by Nguyen Trong Cong  - 2DEV4U.COM
 * Name packge: com.dev4u.ntc.retrofitdemo
 * Name project: RetrofitDemo
 * Date: 3/12/2017
 * Time: 17:49
 */

public class Post {
    int id_post;
    int id_ca;
    String name_ca;
    String title;
    String description;
    String content;
    String datetime;
    String image;

    public int getId_post() {
        return id_post;
    }

    public int getId_ca() {
        return id_ca;
    }

    public String getName_ca() {
        return name_ca;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public String getDatetime() {
        return datetime;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return (title);
    }
}
