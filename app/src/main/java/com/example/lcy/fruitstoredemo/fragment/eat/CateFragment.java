package com.example.lcy.fruitstoredemo.fragment.eat;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.example.lcy.fruitstoredemo.R;
import com.example.lcy.fruitstoredemo.adapter.CateAdapter;
import com.example.lcy.fruitstoredemo.bean.eat.CateBean;
import com.example.lcy.fruitstoredemo.http.HttpUtils;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CateFragment extends Fragment {

    @BindView(R.id.Cate_listView)
    PullToRefreshListView listView;

    Context context;
    int page=1;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public CateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_cate, container, false);
        ButterKnife.bind(this,view);
        initData();
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("==","==");
                        ILoadingLayout proxy = listView.getLoadingLayoutProxy(true, false);
                        proxy.setRefreshingLabel("正在加载");
                        proxy.setLastUpdatedLabel("上次更新时间:");
                        listView.onRefreshComplete();
                    }
                },1000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ILoadingLayout proxy = listView.getLoadingLayoutProxy(false, true);
                        proxy.setRefreshingLabel("查看更多");
                        proxy.setReleaseLabel("松开载入更多");
                        page++;
                        initData();
                        listView.onRefreshComplete();
                    }
                },1000);
            }
        });

        return view;
    }

    private void initData() {
        HttpUtils.getMyService().queryAll4(page).enqueue(new Callback<CateBean>() {
            @Override
            public void onResponse(Call<CateBean> call, Response<CateBean> response) {
                CateBean bean=response.body();
                List<CateBean.FeedsBean>list=bean.getFeeds();
                CateAdapter adapter=new CateAdapter(list,context);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<CateBean> call, Throwable t) {

            }
        });
    }

}
