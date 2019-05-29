package com.ks.day02dos;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ks.day02dos.adpter.MyviewPager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mVp;
    private ArrayList<String> mStrings;
    private MyviewPager mMyviewPager;
   // private WebView mWb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
      //  EventBus.getDefault().register(this);
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mStrings = new ArrayList<>();

        mStrings.add("https://ww1.sinaimg.cn/large/0065oQSqly1g2hekfwnd7j30sg0x4djy.jpg");
        mStrings.add("https://ws1.sinaimg.cn/large/0065oQSqly1g0ajj4h6ndj30sg11xdmj.jpg");
        mStrings.add("https://ws1.sinaimg.cn/large/0065oQSqly1fytdr77urlj30sg10najf.jpg");
        mStrings.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fy58bi1wlgj30sg10hguu.jpg");
        mStrings.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fxno2dvxusj30sf10nqcm.jpg");
        mStrings.add("https://ws1.sinaimg.cn/large/0065oQSqgy1fwyf0wr8hhj30ie0nhq6p.jpg ");
        mStrings.add("https://ww1.sinaimg.cn/large/0065oQSqly1g2hekfwnd7j30sg0x4djy.jpg");
        mStrings.add("https://ww1.sinaimg.cn/large/0065oQSqly1g2hekfwnd7j30sg0x4djy.jpg");
        mMyviewPager = new MyviewPager(mStrings, this);
        mVp.setAdapter(mMyviewPager);
      //  mWb = (WebView) findViewById(R.id.wb);
    }

  /*  private static final String TAG = "Main2Activity";
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getData(String msg) {
           *//* mWb.loadUrl(msg);
            mWb.setWebViewClient(new WebViewClient());*//*
           mStrings.add(msg);
           // Log.i(TAG, "getData: "+mWb);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }*/
}
