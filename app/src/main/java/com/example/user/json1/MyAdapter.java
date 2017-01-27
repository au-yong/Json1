package com.example.user.json1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by User on 23/1/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewHolder>
{
    ArrayList<NewsConstant> newslist;
    private Context mContext;

    public MyAdapter (Context context){
        mContext = context;

    }
    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        viewHolder holder = new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        NewsConstant constant = newslist.get(position);

        holder.mTitle.setText(constant.getTitle());
        holder.mAuthor.setText(constant.getAuthor());
        holder.mSection.setText(constant.getUrl());
        Picasso.with(mContext).load(constant.getThumbUrl()).fit().error(android.R.drawable.alert_dark_frame).into(holder.mImageView);


    }
    public void setData (ArrayList<NewsConstant> list){
        newslist = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(null==newslist)return 0;
        return newslist.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{

        private TextView mTitle,mSection,mAuthor;
        private ImageView mImageView;
        public viewHolder(View itemView) {
            super(itemView);

            mTitle = (TextView)itemView.findViewById(R.id.title);
            mSection = (TextView)itemView.findViewById(R.id.section);
            mAuthor = (TextView)itemView.findViewById(R.id.date);
           mImageView = (ImageView)itemView.findViewById(R.id.image);


        }
    }

}
