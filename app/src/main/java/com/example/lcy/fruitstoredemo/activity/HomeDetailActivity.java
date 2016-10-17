package com.example.lcy.fruitstoredemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lcy.fruitstoredemo.R;
import com.example.lcy.fruitstoredemo.bean.eat.HomeDetailBean;
import com.example.lcy.fruitstoredemo.http.HttpUtils;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeDetailActivity extends AppCompatActivity {

    @BindView(R.id.home_detail_back)
    ImageView back;
    @BindView(R.id.home_detail_share)
    ImageView share;
    @BindView(R.id.home_detail_image)
    ImageView imageView;
    @BindView(R.id.home_detail_agree)
    TextView agree;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);
        ButterKnife.bind(this);
        id=getIntent().getIntExtra("id",id);
        initData();
    }

    private void initData() {
        HttpUtils.getMyService().getItem_id(id).enqueue(new Callback<HomeDetailBean>() {
            @Override
            public void onResponse(Call<HomeDetailBean> call, Response<HomeDetailBean> response) {

            }

            @Override
            public void onFailure(Call<HomeDetailBean> call, Throwable t) {

            }
        });
    }

}
