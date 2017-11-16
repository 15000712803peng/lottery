package com.cai.newc.ui.activity;

import android.os.Message;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cai.newc.R;
import com.cai.newc.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Sunway on 2017/11/16.
 */

public  class RangeActivity extends BaseActivity {
    @Bind(R.id.image_title_back)
    ImageButton titleBack;
    @Bind(R.id.text_title)
    TextView titleText;
    @Bind(R.id.text_title_right)
    TextView titleRight;
    @Override
    public int layout() {
        return R.layout.page_range;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initViews() {
        titleText.setText("提示范围");
        titleRight.setText("保存");
    }

    @Override
    public void onMessage(Message msg) {

    }
}
