package com.cai.newc.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import com.cai.newc.R;
import com.cai.newc.base.BaseFragment;
import com.cai.newc.ui.activity.OpinionActivity;
import com.cai.newc.ui.activity.PersonalActivity;
import com.cai.newc.ui.activity.PointsActivity;
import com.cai.newc.ui.activity.SettingActivity;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/15 0015.
 */

public class MineFragment extends BaseFragment{
    @Bind(R.id.ll_setting)
    LinearLayout setting;
    @Bind(R.id.ll_mine)
    LinearLayout mine;
    @Bind(R.id.ll_opinion)
    LinearLayout opinion;
    @Bind(R.id.ll_points)
    LinearLayout points;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View rootView) {
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),SettingActivity.class));
            }
        });
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),PersonalActivity.class));
            }
        });
        opinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),OpinionActivity.class));
            }
        });
        points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),PointsActivity.class));
            }
        });
    }
}
