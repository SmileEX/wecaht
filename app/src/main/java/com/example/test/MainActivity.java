package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.View;
import android.os.Bundle;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;
    Fragment fragment1,fragment2,fragment3,fragment4;
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

        manager = getSupportFragmentManager();

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        inital();
        fragmentHide();
        showfragment(fragment1);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
    }

    public void onClick(View view) {
        fragmentHide();
        if (view.getId() == R.id.chat) {
            showfragment(fragment1);
        } else if (view.getId() == R.id.people) {
            showfragment(fragment2);
        } else if (view.getId() == R.id.moment) {
            showfragment(fragment3);
        } else if (view.getId() == R.id.settings) {
            showfragment(fragment4);
        }
    }

    private void showfragment(Fragment fragment) {
        transaction=manager.beginTransaction()
                .show(fragment)
                .commit();
    }

    public void inital(){
        transaction=manager.beginTransaction()
                .add(R.id.fragmentContainerView,fragment1)
                .add(R.id.fragmentContainerView,fragment2)
                .add(R.id.fragmentContainerView,fragment3)
                .add(R.id.fragmentContainerView,fragment4)
                .commit();
    }

    public void fragmentHide(){
        transaction=manager.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4)
                .commit();
    }
}