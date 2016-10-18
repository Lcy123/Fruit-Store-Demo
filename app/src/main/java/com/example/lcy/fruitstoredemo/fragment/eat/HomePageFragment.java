package com.example.lcy.fruitstoredemo.fragment.eat;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.lcy.fruitstoredemo.R;
import com.example.lcy.fruitstoredemo.adapter.HomePageFragmentAdapter;
import com.example.lcy.fruitstoredemo.bean.eat.EatBean;
import com.example.lcy.fruitstoredemo.http.HttpUtils;
import com.example.lcy.fruitstoredemo.utils.MyGridView;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {

    @BindView(R.id.home_gridView)
    PullToRefreshGridView gridView;
    int page=1;

    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home_page, container, false);
        ButterKnife.bind(this,view);

        initData();

        gridView.setMode(PullToRefreshBase.Mode.BOTH);
        gridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("==","==");
                        ILoadingLayout proxy = gridView.getLoadingLayoutProxy(true, false);
                        proxy.setRefreshingLabel("正在加载");
                        proxy.setLastUpdatedLabel("上次更新时间:");
                        gridView.onRefreshComplete();
                    }
                },1000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ILoadingLayout proxy = gridView.getLoadingLayoutProxy(false, true);
                        proxy.setRefreshingLabel("查看更多");
                        proxy.setReleaseLabel("松开载入更多");
                        page++;
                        initData();
                        gridView.onRefreshComplete();
                    }
                },1000);
            }
        });

        return view;
    }

    private void initData() {
        HttpUtils.getMyService().queryAll(page).enqueue(new Callback<EatBean>() {
            @Override
            public void onResponse(retrofit2.Call<EatBean> call, Response<EatBean> response) {
                EatBean bean=response.body();
                List<EatBean.FeedsBean>list=bean.getFeeds();
                HomePageFragmentAdapter adapter=new HomePageFragmentAdapter(list,context);
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(retrofit2.Call<EatBean> call, Throwable t) {

            }
        });
    }

}
