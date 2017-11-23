package com.cai.newc.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cai.newc.R;
import com.cai.newc.adapter.HomeMatchListAdapter;
import com.cai.newc.base.BaseFragment;

import com.cai.newc.model.MatchModel;
import com.cai.newc.net.HttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;


/**
 * Created by Administrator on 2017/11/13 0013.
 */

public class HomeOneTabFragment extends BaseFragment{
    @Bind(R.id.list)
    ListView list;
    List<MatchModel> mathchDatas = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_one;
    }

    @Override
    protected void loadData() {
        super.loadData();
        mathchDatas.add(new MatchModel(MatchModel.TYPE_DATE));
        mathchDatas.add(new MatchModel(MatchModel.TYPE_MATCH_ING));
        mathchDatas.add(new MatchModel(MatchModel.TYPE_MATCH_ING));
        list.setAdapter(new HomeMatchListAdapter(getActivity(),mathchDatas));

    }


}
