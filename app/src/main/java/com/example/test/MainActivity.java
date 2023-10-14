package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.View;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;
    Fragment fragment1,fragment2,fragment3,fragment4;
    ImageButton img1, img2, img3, img4;
    FragmentManager manager;
    int transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);

        linearLayout1 = findViewById(R.id.chat);
        linearLayout2 = findViewById(R.id.people);
        linearLayout3 = findViewById(R.id.moment);
        linearLayout4 = findViewById(R.id.settings);

        //这些图片参数用来实现被点击是底部tab图标的变化
        img1 = findViewById(R.id.button1);
        img2 = findViewById(R.id.button2);
        img3 = findViewById(R.id.button3);
        img4 = findViewById(R.id.button4);

        manager = getSupportFragmentManager();

        fragment1 = new Fragment1();
        fragment2 = new settingFragment();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        inital();
        fragmentHide();
        showfragment(fragment1);
        img1.setImageResource(R.drawable.tab_weixin_pressed);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
    }

    public void onClick(View view) {
        /*
            每次遇到点击事件时，首先消除以前操作留下的fragmen和imagebutton
            然后在修改对应的img和fragment
        */
        fragmentHide();
        if (view.getId() == R.id.chat) {
            showfragment(fragment1);
            img1.setImageResource(R.drawable.tab_weixin_pressed);
        } else if (view.getId() == R.id.people) {
            showfragment(fragment2);
            img2.setImageResource(R.drawable.tab_address_pressed);
        } else if (view.getId() == R.id.moment) {
            showfragment(fragment3);
            img3.setImageResource(R.drawable.tab_find_frd_pressed);
        } else if (view.getId() == R.id.settings) {
            showfragment(fragment4);
            img4.setImageResource(R.drawable.tab_settings_pressed);
        }
    }

    private void showfragment(Fragment fragment) {
        transaction=manager.beginTransaction()
                .show(fragment)
                .commit();
    }

    //初始化容器内的元素
    public void inital(){
        transaction=manager.beginTransaction()
                .add(R.id.fragmentContainerView,fragment1)
                .add(R.id.fragmentContainerView,fragment2)
                .add(R.id.fragmentContainerView,fragment3)
                .add(R.id.fragmentContainerView,fragment4)
                .commit();
    }

    //初始化ui显示，每次程序启动时自动打开第一个fragment，并且点亮第一个icon
    public void fragmentHide(){
        img1.setImageResource(R.drawable.tab_weixin_normal);
        img2.setImageResource(R.drawable.tab_address_normal);
        img3.setImageResource(R.drawable.tab_find_frd_normal);
        img4.setImageResource(R.drawable.tab_settings_normal);
        transaction=manager.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4)
                .commit();
    }
}