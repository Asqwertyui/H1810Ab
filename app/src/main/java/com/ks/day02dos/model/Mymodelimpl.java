package com.ks.day02dos.model;

import android.util.Log;

import com.google.gson.Gson;
import com.ks.day02dos.bean.Art;
import com.ks.day02dos.callback.Mycallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by F0519 on 2019/5/29.
 */

public class Mymodelimpl implements Mymodel {
    @Override
    public void getData(final Mycallback mycallback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        Request request = new Request.Builder()
                .url("https://gank.io/api/data/福利/20/1")
                .get()
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                Art art = gson.fromJson(string, Art.class);
                if(art!=null){
                    mycallback.OnSuccess(art);
                }else {
                    mycallback.OnFail("no");
                }
            }
        });
    }
}
