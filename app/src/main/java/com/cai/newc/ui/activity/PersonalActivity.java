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

public class PersonalActivity extends BaseActivity {
    @Bind(R.id.image_title_back)
    ImageButton titleBack;
    @Bind(R.id.text_title)
    TextView titleText;
    @Bind(R.id.text_title_right)
    TextView titleRight;
    @Bind(R.id.ll_name)
    LinearLayout reviseName;
    @Bind(R.id.ll_revise_phone_number)
    LinearLayout reviseNumber;
    @Bind(R.id.ll_password)
    LinearLayout password;
    @Override
    public int layout() {
        return R.layout.page_personal_data;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initViews() {
        titleText.setText("个人资料");
        reviseName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PersonalActivity.this,ReviseNameActivity.class));
            }
        });
        reviseNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PersonalActivity.this,ReviseNumberActivity.class));
            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PersonalActivity.this,RevisePasswordActivity.class));
            }
        });

    }
    @Override
    public void onMessage(Message msg) {

    }
}
