package com.cai.newc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cai.newc.R;
import com.cai.newc.model.MatchModel;

import java.util.List;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class HomeMatchListAdapter extends BaseAdapter{

    public HomeMatchListAdapter(Context context,List<MatchModel> mathes){
        layoutInflater = LayoutInflater.from(context);
        this.mathes = mathes;
    }

    List<MatchModel> mathes;
    LayoutInflater layoutInflater;

    public List<MatchModel> getMathes() {
        return mathes;
    }

    public void setMathes(List<MatchModel> mathes) {
        this.mathes = mathes;
    }

    @Override
    public int getCount() {
        return mathes.size();
    }

    @Override
    public Object getItem(int position) {
        return mathes.get(position);
    }

    @Override
    public int getViewTypeCount() {
        return 100;
    }

    @Override
    public int getItemViewType(int position) {
        MatchModel match = (MatchModel) getItem(position);
        return match.getType();
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
                case MatchModel.TYPE_DATE:
                    convertView = layoutInflater.inflate(R.layout.date_item,null);
                    break;
                case MatchModel.TYPE_MATCH_ING:
                    convertView = layoutInflater.inflate(R.layout.match_ing_item,null);
                    break;
                case MatchModel.TYPE_MATCH_TO:
                    break;
                case MatchModel.TYPE_MATCH_DONE:
                    break;
            }
        }else {

        }
        return convertView;
    }
    private void bindViewByType(int type,View view){
        switch (type){
            case MatchModel.TYPE_DATE:
                view = layoutInflater.inflate(R.layout.date_item,null);
                break;
            case MatchModel.TYPE_MATCH_ING:
                view = layoutInflater.inflate(R.layout.match_ing_item,null);
                break;
            case MatchModel.TYPE_MATCH_TO:
                break;
            case MatchModel.TYPE_MATCH_DONE:
                break;
        }
    }
}
