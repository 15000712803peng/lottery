package com.cai.newc.ui.activity;

import android.os.Message;
import android.widget.ImageButton;
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

    }

    @Override
    public void onMessage(Message msg) {

    }
}
