package cn.edu.gdpt.topline171000hwh.fragment;


import android.app.DownloadManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextLinks;
import android.widget.LinearLayout;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;


import com.itheima.PullToRefreshView;
import com.squareup.okhttp.Response;

import java.io.IOException;

import cn.edu.gdpt.topline171000hwh.R;
import cn.edu.gdpt.topline171000hwh.utils.Constant;
import cn.edu.gdpt.topline171000hwh.view.WrapRecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private WrapRecyclerView recyclerView;
    private PullToRefreshView mPullToRefresh;
    private OkHttpClient okHttpClient;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        okHttpClient=new OkHttpClient();
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        getADData();
        return view;
    }

    private void getADData() {
        Request request=new Request.Builder().url(Constant.WEB_SITE+Constant.REQUEST_AD_URL).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }
            @Override
            public void onResponse(Response response) throws IOException {
                String res=response.body().string();
                Log.i("AD",res);
            }
        });
    }

    private void initView(View view) {
        recyclerView = (WrapRecyclerView) view.findViewById(R.id.recycler_view);
        mPullToRefresh = (PullToRefreshView) view.findViewById(R.id.pull_to_refresh);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
