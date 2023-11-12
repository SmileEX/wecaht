package com.example.test;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class settingFragment extends Fragment {
    private Context context;
    private List<String> mList = new ArrayList<>();
    private List<Integer> mSrc = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.activity_recycler_view, container, false);
        context = view.getContext();
        InitData();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(context, mSrc, mList);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context,LinearLayoutManager.VERTICAL ));
        return view;
    }

    private void InitData() {
        mList.add("玉皇大帝");
        mList.add("三藏");
        mList.add("悟空");
        mList.add("悟净");
        mList.add("悟能");
        mList.add("元始天尊");
        mList.add("刘玄德");
        mList.add("关云长");
        mList.add("张翼德");
        mList.add("孔明");
        mList.add("曹贼");
        mSrc.add(R.drawable.yhdd);
        mSrc.add(R.drawable.tang);
        mSrc.add(R.drawable.wukong);
        mSrc.add(R.drawable.wujing);
        mSrc.add(R.drawable.bajie);
        mSrc.add(R.drawable.yuanshi);
        mSrc.add(R.drawable.liubei);
        mSrc.add(R.drawable.guanyu);
        mSrc.add(R.drawable.zhang);
        mSrc.add(R.drawable.zhuge);
        mSrc.add(R.drawable.caozei);
    }

}