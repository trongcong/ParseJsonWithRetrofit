package com.dev4u.ntc.retrofitdemo;

import com.dev4u.ntc.retrofitdemo.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * IDE: Android Studio
 * Created by Nguyen Trong Cong  - 2DEV4U.COM
 * Name packge: com.dev4u.ntc.retrofitdemo
 * Name project: RetrofitDemo
 * Date: 3/12/2017
 * Time: 17:49
 */

public interface APIService {
    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of post.
    */

    // GET latest news from server
    // Server return json array
    @GET("/news/api.php?latest_news=10")
    Call<List<Post>> getPostsDetails();

    // GET news by id post from server
    // Server return json object
    @GET("/news/api.php?id_post=2")
    Call<Post> getPostDetails();

}
