package com.example.lcy.fruitstoredemo.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lcy on 2016/10/17.
 */
public class HttpUtils {

    public static final String BASE_URL="http://food.boohee.com";
    private static MyService myService;

    public static MyService getMyService(){
        if (myService==null){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            myService=retrofit.create(MyService.class);
        }
        return myService;
    }
}
