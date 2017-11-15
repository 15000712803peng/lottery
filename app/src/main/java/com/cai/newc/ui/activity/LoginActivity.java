package com.cai.newc.ui.activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.cai.newc.R;
import com.cai.newc.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/15 0015.
 */

public class LoginActivity extends BaseActivity{
    @Bind(R.id.btn_login)
    TextView loginText;
    @Bind(R.id.txt_forget_pwd)
    TextView forgetPwdText;
    @Override
    public int layout() {
        return R.layout.activity_login;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initViews() {
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            }
        });
        forgetPwdText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgetPwdActivity.class));
            }
        });

    }

    @Override
    public void onMessage(Message msg) {

    }
}
