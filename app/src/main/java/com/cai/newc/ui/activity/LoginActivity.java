package com.cai.newc.ui.activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cai.newc.R;
import com.cai.newc.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/11/15 0015.
 */

public class LoginActivity extends BaseActivity {
    @Bind(R.id.btn_login)
    Button loginText;
    @Bind(R.id.txt_forget_pwd)
    TextView forgetPwdText;
    @Bind(R.id.ll_register)
    LinearLayout regiister;

    @Override
    public int layout() {
        return R.layout.activity_login;
    }

    @Override
    public void loadData() {
        // os git pull push

    }

    @Override
    public void initViews() {

        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
        forgetPwdText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgetPwdActivity.class));
            }
        });
        regiister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, EnterNumberActivity.class));
            }
        });

    }

    @Override
    public void onMessage(Message msg) {

    }
}
