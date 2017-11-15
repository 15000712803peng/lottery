package com.cai.newc.ui.activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.cai.newc.R;
import com.cai.newc.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Sunway on 2017/11/15.
 */

public class EnterNumberActivity extends BaseActivity {
    @Bind(R.id.button_code)
    Button code;
    @Override
    public int layout() {
        return R.layout.activity_enter_phone_number;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initViews() {
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EnterNumberActivity.this, GetCodeActivity.class));
            }
        });
    }

    @Override
    public void onMessage(Message msg) {

    }
}
