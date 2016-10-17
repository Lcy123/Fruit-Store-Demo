package com.example.lcy.fruitstoredemo.fragment.eat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lcy.fruitstoredemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvaluatingFragment extends Fragment {


    public EvaluatingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_evaluating, container, false);
    }

}
