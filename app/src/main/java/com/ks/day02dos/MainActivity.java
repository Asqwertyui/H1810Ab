package com.ks.day02dos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ks.day02dos.adpter.Myadapter;
import com.ks.day02dos.bean.Art;
import com.ks.day02dos.model.Mymodelimpl;
import com.ks.day02dos.persent.Mypersentimpl;
import com.ks.day02dos.view.Myview;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

//苏清芬

public class MainActivity extends AppCompatActivity implements Myview {

    private RecyclerView mRv;
    private ArrayList<Art.ResultsBean> mResultsBeans;
    private Myadapter mMyadapter;
    private Mypersentimpl mMypersentimpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mMypersentimpl = new Mypersentimpl(new Mymodelimpl(), this);
        mMypersentimpl.getData();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mResultsBeans = new ArrayList<>();
        mMyadapter = new Myadapter(mResultsBeans, this);
        mRv.setAdapter(mMyadapter);
        mMyadapter.setOnclickListener(new Myadapter.OnclickListener() {
            @Override
            public void Onclick(int position, Art.ResultsBean bean) {
              //  EventBus.getDefault().postSticky(bean.getUrl());
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
    }

    @Override
    public void OnSuccess(final Art art) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(art!=null){
                    mResultsBeans.addAll(art.getResults());
                    mMyadapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void OnFail(String msg) {
        Log.e("tga",msg);
    }
}
