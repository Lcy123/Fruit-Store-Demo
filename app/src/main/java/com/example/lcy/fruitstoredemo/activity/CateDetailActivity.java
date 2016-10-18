package com.example.lcy.fruitstoredemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.example.lcy.fruitstoredemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CateDetailActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.cate_detail_wv)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate_detail);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        webView.loadUrl(getIntent().getStringExtra("url"));
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.eva_detail_back:
                Intent intent=new Intent(CateDetailActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.eva_detail_collect:
                break;
            case R.id.eva_detail_share:
                break;
        }
    }
}
