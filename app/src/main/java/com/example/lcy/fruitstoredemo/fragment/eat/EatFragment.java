package com.example.lcy.fruitstoredemo.fragment.eat;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lcy.fruitstoredemo.R;
import com.example.lcy.fruitstoredemo.adapter.EatFragmentAdapter;
import com.example.lcy.fruitstoredemo.utils.ZXingUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EatFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.eat_tab)
    TabLayout eat_tab;
    @BindView(R.id.eat_viewPager)
    ViewPager viewPager;
    @BindView(R.id.eat_camare)
    ImageView eat_camare;

    EatFragmentAdapter adapter;
    List<String> titlelist = new ArrayList<>();
    List<Fragment> fragmentList = new ArrayList<>();

    public EatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eat, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        titlelist.add("首页");
        titlelist.add("评测");
        titlelist.add("知识");
        titlelist.add("美食");
        for (int i = 0; i < titlelist.size(); i++) {
            eat_tab.addTab(eat_tab.newTab().setText(titlelist.get(i)));
            if (i == 0) {
                fragmentList.add(new HomePageFragment());
            } else if (i == 1) {
                fragmentList.add(new EvaluatingFragment());
            } else if (i == 2) {
                fragmentList.add(new KnowledgeFragment());
            } else {
                fragmentList.add(new CateFragment());
            }
        }
        adapter = new EatFragmentAdapter(getFragmentManager(), fragmentList, titlelist);
        viewPager.setAdapter(adapter);
        eat_tab.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.eat_camare:
                break;
        }
    }
}
