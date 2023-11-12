package com.example.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Myviewholder> {
    private List<String> mList;
    private List<Integer> mSrc;
    private Context context;
    public RecyclerViewAdapter(Context context, List<Integer> src, List<String> list) {
        this.mSrc = src;
        this.mList = list;
        this.context=context;
    }


    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view=(View)LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        Myviewholder myviewholder=new Myviewholder((view));
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        holder.tvimg.setImageResource(mSrc.get(position));
        holder.tvContent.setText(mList.get(position));
        final int itemPosition = position;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedItem = mList.get(itemPosition);
                Toast.makeText(v.getContext(), "Clicked: " + selectedItem, Toast.LENGTH_SHORT).show();
                //跳转
                Intent intent = new Intent(context, FriendDetailsActivity.class);
                //传输信息给跳转的activity，以便在新的activity中显示被点击item对应的内容
                intent.putExtra("name", mList.get(itemPosition));
                intent.putExtra("avatar", mSrc.get(itemPosition));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder{
        TextView tvContent;
        ImageView tvimg;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            tvimg=itemView.findViewById((R.id.tv_img));
            tvContent=itemView.findViewById(R.id.tv_content);
        }
    }
}
