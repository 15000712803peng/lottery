package com.cai.newc.ui.activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cai.newc.R;
import com.cai.newc.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Sunway on 2017/11/15.
 */

public class SettingActivity extends BaseActivity {
    @Bind(R.id.image_title_back)
    ImageButton titleBack;
    @Bind(R.id.text_title)
    TextView titleText;
    @Bind(R.id.ll_range)
    LinearLayout range;
    @Override
    public int layout() {
        return R.layout.page_setting;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initViews() {
        titleText.setText("系统设置");
        range.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingActivity.this,RangeActivity.class));
            }
        });

    }

    @Override
    public void onMessage(Message msg) {

    }
}
