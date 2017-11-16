package com.cai.newc.ui.activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cai.newc.R;
import com.cai.newc.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Sunway on 2017/11/15.
 */

public class OpinionActivity extends BaseActivity {
    @Bind(R.id.image_title_back)
    ImageButton titleBack;
    @Bind(R.id.text_title)
    TextView titleText;
    @Bind(R.id.text_title_right)
    TextView titleRight;
    @Override
    public int layout() {
        return R.layout.page_opinion;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initViews() {
        titleText.setText("我要吐槽");
        titleRight.setText("历史吐槽");
        titleRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpinionActivity.this,OpinionHistoryActivity.class));
            }
        });
    }

    @Override
    public void onMessage(Message msg) {

    }
}
