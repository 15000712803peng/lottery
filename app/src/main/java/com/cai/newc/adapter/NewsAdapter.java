package com.cai.newc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cai.newc.R;
import com.cai.newc.model.MatchModel;
import com.cai.newc.model.NewsModel;

import java.util.List;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class NewsAdapter extends BaseAdapter{

    public NewsAdapter(Context context, List<NewsModel> news){
        layoutInflater = LayoutInflater.from(context);
        this.news = news;
    }

    List<NewsModel> news;
    LayoutInflater layoutInflater;

    public List<NewsModel> getNews() {
        return news;
    }

    public void setNews(List<NewsModel> news) {
        this.news = news;
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int position) {
        return news.get(position);
    }

    @Override
    public int getViewTypeCount() {
        return 100;
    }

    @Override
    public int getItemViewType(int position) {
        NewsModel news = (NewsModel) getItem(position);
        return news.getType();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        if(convertView == null){
            switch (type){
                case NewsModel.TYPE_NES_ONE:
                    convertView = layoutInflater.inflate(R.layout.news_item,null);
                    break;
                case NewsModel.TYPE_NES_TWO:
                    convertView = layoutInflater.inflate(R.layout.news_item2,null);
                    break;

            }
        }else {

        }
        return convertView;
    }

}
