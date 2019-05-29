package com.ks.day02dos.callback;

import com.ks.day02dos.bean.Art;

/**
 * Created by F0519 on 2019/5/29.
 */

public interface Mycallback {
    void OnSuccess(Art art);
    void OnFail(String msg);
}
