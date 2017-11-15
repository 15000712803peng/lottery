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

public  class GetCodeActivity extends BaseActivity {
    @Bind(R.id.button_login)
    Button login;
    @Override
    public int layout() {
        return R.layout.activity_get_code;
    }

    @Override
    public void loadData() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetCodeActivity.this, LoginActivity.class));
            }
        });
    }

    @Override
    public void initViews() {

    }

    @Override
    public void onMessage(Message msg) {

    }
}
