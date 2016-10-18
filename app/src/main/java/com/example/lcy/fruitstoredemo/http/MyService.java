package com.example.lcy.fruitstoredemo.http;

import com.example.lcy.fruitstoredemo.bean.eat.CateBean;
import com.example.lcy.fruitstoredemo.bean.eat.EatBean;
import com.example.lcy.fruitstoredemo.bean.eat.EvaluatingBean;
import com.example.lcy.fruitstoredemo.bean.eat.HomeDetailBean;
import com.example.lcy.fruitstoredemo.bean.eat.KnowBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lcy on 2016/10/17.
 */
public interface MyService {

    //首页
    @GET("/fb/v1/feeds/category_feed?page=1&category=1&per=10&app_device=Android&app_version=2.5&channel=wandoujia&user_key=&token=&phone_model=GT-P5210&os_version=4.2.2")
    Call<EatBean>queryAll(@Query("page") int page);
    //首页详情
    @GET("/fb/v1/food_cards/id?app_device=Android&app_version=2.5&channel=wandoujia&user_key=&token=&phone_model=GT-P5210&os_version=4.2.2")
    Call<HomeDetailBean>getId(@Query("id")int id);

    //评测
    @GET("/fb/v1/feeds/category_feed?page=1&category=2&per=10&app_device=Android&app_version=2.5&channel=wandoujia&user_key=&token=&phone_model=GT-P5210&os_version=4.2.2")
    Call<EvaluatingBean>queryAll2(@Query("page")int page);


    //知识
    @GET("/fb/v1/feeds/category_feed?page=1&category=3&per=10&app_device=Android&app_version=2.5&channel=wandoujia&user_key=&token=&phone_model=GT-P5210&os_version=4.2.2")
    Call<KnowBean>queryAll3(@Query("page")int page);


    //美食
    @GET("/fb/v1/feeds/category_feed?page=1&category=4&per=10&app_device=Android&app_version=2.5&channel=wandoujia&user_key=&token=&phone_model=GT-P5210&os_version=4.2.2")
    Call<CateBean>queryAll4(@Query("page")int page);
}
