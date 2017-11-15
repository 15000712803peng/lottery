package com.cai.newc.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.cai.newc.R;
import com.cai.newc.adapter.NewsAdapter;
import com.cai.newc.base.BaseFragment;
import com.cai.newc.model.NewsModel;
import com.cai.newc.ui.activity.NewsActivity;
import com.cai.newc.ui.view.XListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class DiscFragment extends BaseFragment{
    @Bind(R.id.list)
    XListView list;

    List<NewsModel> news = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_disc;
    }

    @Override
    protected void loadData() {
        super.loadData();
        news.add(new NewsModel(NewsModel.TYPE_NES_ONE));
        news.add(new NewsModel(NewsModel.TYPE_NES_TWO));
        news.add(new NewsModel(NewsModel.TYPE_NES_ONE));
        list.setAdapter(new NewsAdapter(getActivity(),news));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), NewsActivity.class));
            }
        });
    }
}
