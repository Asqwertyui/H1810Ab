package com.ks.day02dos.view;

import com.ks.day02dos.bean.Art;

/**
 * Created by F0519 on 2019/5/29.
 */

public interface Myview {
    void OnSuccess(Art art);
    void OnFail(String msg);
}
