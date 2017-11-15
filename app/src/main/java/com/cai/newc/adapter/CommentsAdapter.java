package com.cai.newc.adapter;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.cai.newc.R;
import com.cai.newc.model.Comment;

import java.util.List;


public class CommentsAdapter extends BaseAdapter{

    List<Comment> comments;
    Context context;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public void clear(){
        if(comments != null){
            comments.clear();
        }
    }

    public CommentsAdapter(List<Comment> comments, Context context ){
        this.comments = comments;
        this.context = context;
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int i) {
        return comments.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Comment comment = (Comment) getItem(i);
        Holder holder = null;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.comment_item,null);
            holder = new Holder();
            holder.comment = (TextView) view.findViewById(R.id.tv_comment);   //用户评论

            holder.nickName = (TextView) view.findViewById(R.id.tv_nickName);//昵称 nickName


            holder.createdDate = (TextView) view.findViewById(R.id.tv_createdDate); //createdDate 评论时间

            holder.headPortrait = (ImageView) view.findViewById(R.id.image_headPortrait);   // headPortraitUrl 头像图片URL
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }

        holder.comment.setText(comment.getComment());
        holder.createdDate.setText(comment.getCreatedDate());
        holder.nickName.setText(comment.getNickName());

//        Glide.with(context).load(comment.getHeadPortraitUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.headPortrait);
        return view;
    }

    class Holder{

        public  TextView comment;
        public TextView nickName;
        public TextView createdDate;
        public ImageView headPortrait;


    }
}
