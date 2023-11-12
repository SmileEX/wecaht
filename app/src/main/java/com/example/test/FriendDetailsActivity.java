package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FriendDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_details);

        //接受Adapter传输过来的信息
        Intent intent = getIntent();
        //第一个是联系人id信息
        String string = intent.getStringExtra("name");
        //第二个是联系人头像信息
        int avatar = intent.getIntExtra("avatar", 0);
        //然后再给对应的view设置对应信息的路径
        TextView textview = findViewById(R.id.information);
        textview.setText(string);
        ImageView imageview = findViewById(R.id.avatar);
        imageview.setImageResource(avatar);
    }
}