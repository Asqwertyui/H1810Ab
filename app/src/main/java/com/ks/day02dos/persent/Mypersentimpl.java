package com.ks.day02dos.persent;

import com.ks.day02dos.bean.Art;
import com.ks.day02dos.callback.Mycallback;
import com.ks.day02dos.model.Mymodel;
import com.ks.day02dos.view.Myview;

/**
 * Created by F0519 on 2019/5/29.
 */

public class Mypersentimpl implements Mypersent, Mycallback {
    private Mymodel mymodel;
    private Myview myview;

    public Mypersentimpl(Mymodel mymodel, Myview myview) {
        this.mymodel = mymodel;
        this.myview = myview;
    }

    @Override
    public void getData() {
        if(mymodel!=null){
            mymodel.getData(this);
        }
    }

    @Override
    public void OnSuccess(Art art) {
        if(myview!=null){
            myview.OnSuccess(art);
        }
    }

    @Override
    public void OnFail(String msg) {
        if(myview!=null){
            myview.OnFail(msg);
        }
    }
}
