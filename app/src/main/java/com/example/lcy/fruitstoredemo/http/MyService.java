package com.example.lcy.fruitstoredemo.http;

import com.example.lcy.fruitstoredemo.bean.eat.EatBean;
import com.example.lcy.fruitstoredemo.bean.eat.HomeDetailBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lcy on 2016/10/17.
 */
public interface MyService {

    @GET("/fb/v1/feeds/category_feed?page=1&category=1&per=10&app_device=Android&app_version=2.5&channel=wandoujia&user_key=&token=&phone_model=GT-P5210&os_version=4.2.2")
    Call<EatBean>queryAll(@Query("category") int category);

    @GET("/fb/v1/food_cards/item_id?app_device=Android&app_version=2.5&channel=wandoujia&user_key=&token=&phone_model=GT-P5210&os_version=4.2.2")
    Call<HomeDetailBean>getItem_id(@Query("id")int id);
}
