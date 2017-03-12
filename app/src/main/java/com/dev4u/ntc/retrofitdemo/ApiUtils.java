package com.dev4u.ntc.retrofitdemo;

/**
 * IDE: Android Studio
 * Created by Nguyen Trong Cong  - 2DEV4U.COM
 * Name packge: com.dev4u.ntc.retrofitdemo
 * Name project: RetrofitDemo
 * Date: 3/12/2017
 * Time: 17:49
 */

public class ApiUtils {
    public static final String BASE_URL = "http://dev.2dev4u.com";

    private ApiUtils() {
    }

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
