package com.example.lcy.fruitstoredemo.fragment.eat;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lcy.fruitstoredemo.R;
import com.example.lcy.fruitstoredemo.adapter.HomePageFragmentAdapter;
import com.example.lcy.fruitstoredemo.bean.eat.EatBean;
import com.example.lcy.fruitstoredemo.http.HttpUtils;
import com.example.lcy.fruitstoredemo.utils.MyGridView;

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
    MyGridView gridView;
    int category=1;

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
        return view;
    }

    private void initData() {
        HttpUtils.getMyService().queryAll(category).enqueue(new Callback<EatBean>() {
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
