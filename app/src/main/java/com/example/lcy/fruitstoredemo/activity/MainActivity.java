package com.example.lcy.fruitstoredemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.lcy.fruitstoredemo.R;
import com.example.lcy.fruitstoredemo.fragment.eat.EatFragment;
import com.example.lcy.fruitstoredemo.fragment.food.FoodFragment;
import com.example.lcy.fruitstoredemo.fragment.my.MyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.main_radioGroup)
    RadioGroup main_radioGroup;
    @BindView(R.id.eat_rt)
    RadioButton eat_rt;
    @BindView(R.id.food_rt)
    RadioButton food_rt;
    @BindView(R.id.my_rt)
    RadioButton my_rt;

    private EatFragment eatFragment;
    private FoodFragment foodFragment;
    private MyFragment myFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        main_radioGroup.setOnCheckedChangeListener(this);
        fragmentManager=getSupportFragmentManager();
        if (eatFragment==null){
            eatFragment=new EatFragment();
        }
        fragmentManager.beginTransaction().add(R.id.main_relative,eatFragment).commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction ft=fragmentManager.beginTransaction();
        hide(ft);
        switch (checkedId){
            case R.id.eat_rt:
                if (eatFragment==null){
                    eatFragment=new EatFragment();
                    ft.add(R.id.main_relative,eatFragment);
                }else{
                    ft.show(eatFragment);
                }
                break;
            case R.id.food_rt:
                if (foodFragment==null){
                    foodFragment=new FoodFragment();
                    ft.add(R.id.main_relative,foodFragment);
                }else{
                    ft.show(foodFragment);
                }
                break;
            case R.id.my_rt:
                if (myFragment==null){
                    myFragment=new MyFragment();
                    ft.add(R.id.main_relative,myFragment);
                }else{
                    ft.show(myFragment);
                }
                break;

        }
        ft.commit();
    }


    public void hide(FragmentTransaction ft){

        if (eatFragment!=null){
            ft.hide(eatFragment);
        }
        if (foodFragment!=null){
            ft.hide(foodFragment);
        }
        if (myFragment!=null){
            ft.hide(myFragment);
        }
    }
}
