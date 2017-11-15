package com.cai.newc.ui.view;

/**
 * Created by peter on 16/3/25.
 */

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.cai.newc.R;

import butterknife.ButterKnife;


public class BottomShareDialog implements View.OnClickListener {

    private Context context;
    LinearLayout container;
    ViewGroup llBack;
    Display display;
    Dialog dialog;
    View view;
    ListView listView;
    String[] itemTitles;
    int[] itemTags;
    int[] itemImages;
    int[] itemColors;

    public BottomShareDialog builder() {
        view = LayoutInflater.from(context).inflate(
                R.layout.dialog_bottom_share, null);
        container = (LinearLayout) view.findViewById(R.id.rl_dialog_container);

        dialog = new Dialog(context, R.style.CustomDialog);
        dialog.setContentView(view);
//        dialog.setCancelable(false);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int) (display
                .getWidth()), ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.BOTTOM;
        container.setLayoutParams(params);
        dialog.getWindow().setWindowAnimations(R.style.main_menu_animstyle);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        return this;
    }


    @Override
    public void onClick(View view) {
        cancel();
    }

    public BottomShareDialog(final Context context) {

        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();

    }

    public void show() {
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    public void cancel() {
        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
        }
    }


}
