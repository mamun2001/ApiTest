package com.example.apitest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userHolder> {
    MainActivity mainActivity;
    List<DataModel> alluserList;
    public userAdapter(MainActivity mainActivity, List<DataModel> alluserList) {
        this.mainActivity=mainActivity;
        this.alluserList=alluserList;
    }

    @NonNull
    @Override
    public userHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new userHolder(LayoutInflater.from(mainActivity).inflate(R.layout.item_user,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull userHolder holder, int position) {
        Glide.with(mainActivity).load(alluserList.get(position).getThumbnailUrl()).into(holder.imgPhoto);
        holder.txtTitle.setText(alluserList.get(position).getTitle());
        holder.txtImgPath.setText(alluserList.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return alluserList.size();
    }

    public class userHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        ImageView imgPhoto;
        TextView txtImgPath;
        public userHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto=itemView.findViewById(R.id.imgPhoto);
            txtTitle=itemView.findViewById(R.id.txtTitle);
            txtImgPath=itemView.findViewById(R.id.txtImgPath);
        }
    }
}
