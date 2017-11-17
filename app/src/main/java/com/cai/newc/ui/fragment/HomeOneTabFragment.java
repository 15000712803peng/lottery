package com.cai.newc.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cai.newc.R;
import com.cai.newc.adapter.HomeMatchListAdapter;
import com.cai.newc.base.BaseFragment;
import com.cai.newc.live.FakeServer;
import com.cai.newc.live.LiveKit;
import com.cai.newc.live.controller.RcLog;
import com.cai.newc.model.MatchModel;
import com.cai.newc.net.HttpUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

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
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"on click",Toast.LENGTH_SHORT).show();
                fakeLogin("张三", "123456", "rtmp://live.hkstv.hk.lxdns.com/live/hks");
            }
        });
    }

    private void fakeLogin(String id, String password, final String url) {
        final UserInfo user = FakeServer.getLoginUser(id, password);
        FakeServer.getToken(user, new HttpUtil.OnResponse() {
            @Override
            public void onResponse(int code, String body) {
                if (code != 200) {
                    Toast.makeText(getActivity(), body, Toast.LENGTH_SHORT).show();
                    return;
                }

                String token;
                try {
                    JSONObject jsonObj = new JSONObject(body);
                    token = jsonObj.getString("token");
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Token 解析失败!", Toast.LENGTH_SHORT).show();
                    return;
                }

                LiveKit.connect(token, new RongIMClient.ConnectCallback() {
                    @Override
                    public void onTokenIncorrect() {

//                        RcLog.e("----------", "connect onTokenIncorrect");
                        Log.e("----------", "connect onTokenIncorrect");
                        Toast.makeText(getActivity(),"connect onTokenIncorrect",Toast.LENGTH_SHORT).show();
                        // 检查appKey 与token是否匹配.
                    }

                    @Override
                    public void onSuccess(String userId) {
                        Log.e("----------", "connect onSuccess");
                        Toast.makeText(getActivity(),"connect onSuccess",Toast.LENGTH_SHORT).show();
//                        RcLog.e("----------", "connect onSuccess");
                        LiveKit.setCurrentUser(user);
//                        Intent intent = new Intent(LoginActivity.this, LiveShowActivity.class);
//                        intent.putExtra(LiveShowActivity.LIVE_URL, url);
//                        startActivity(intent);
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode errorCode) {
//                        RcLog.d("--------", "connect onError = " + errorCode);
//                       Log.d("--------", "connect onError = " + errorCode);
                        Toast.makeText(getActivity(),"connect onError = ",Toast.LENGTH_SHORT).show();
                        // 根据errorCode 检查原因.
                    }

                    @Override
                    public void onFail(int errorCode) {
                        super.onFail(errorCode);
//                        Log.d("--------", "connect fail = " + errorCode);
                        Toast.makeText(getActivity(),"connect fail = ",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
