package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.ActionBarPolicy;
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
        position++;
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
