package com.cai.newc.ui.activity;

import android.os.Message;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cai.newc.R;
import com.cai.newc.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by Sunway on 2017/11/20.
 */

public class PointsActivity extends BaseActivity {
    @Bind(R.id.icon_point)
    ImageView pointIcon;
    @Bind(R.id.tv_current_level)
    TextView currentLevelText;
    @Bind(R.id.tv_next_level)
    TextView nextLevelText;
    @Bind(R.id.ponit_bar)
    ProgressBar levelBar;
    private final int LEVEL_ONE = 1;
    private final int LEVEL_TWO = 2;
    private final int LEVEL_THREE = 3;
    private final int LEVEL_FOUR = 4;
    @Override
    public int layout() {
        return R.layout.page_my_points;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void initViews() {
        loadLevel(3);
    }

    @Override
    public void onMessage(Message msg) {

    }

    private void loadLevel(int level){
        switch (level){
            case LEVEL_ONE:
                currentLevelText.setText("LV1");
                nextLevelText.setText("LV2");
                pointIcon.setImageResource(R.mipmap.icon_points_lv1);

                levelBar.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_points_lv1));
                break;
            case LEVEL_TWO:
                currentLevelText.setText("LV13");
                nextLevelText.setText("LV14");
                pointIcon.setImageResource(R.mipmap.icon_points_lv2);
                levelBar.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_points_lv2));
                break;
            case LEVEL_THREE:
                currentLevelText.setText("LV23");
                nextLevelText.setText("LV24");
                pointIcon.setImageResource(R.mipmap.icon_points_lv3);
                levelBar.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_points_lv3));
                break;
            case LEVEL_FOUR:
                currentLevelText.setText("LV33");
                nextLevelText.setText("LV34");
                pointIcon.setImageResource(R.mipmap.icon_points_lv4);
                levelBar.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_points_lv4));
                break;

        }
    }
}
