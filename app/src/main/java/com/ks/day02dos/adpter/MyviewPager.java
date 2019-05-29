package com.ks.day02dos.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ks.day02dos.R;

import java.util.ArrayList;

/**
 * Created by F0519 on 2019/5/29.
 */

public class MyviewPager extends PagerAdapter {
    private ArrayList<String> mStrings;
    private Context context;

    public MyviewPager(ArrayList<String> strings, Context context) {
        mStrings = strings;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mStrings.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.item, null);
        ImageView iv = view.findViewById(R.id.iv);
        String s = mStrings.get(position);
        Glide.with(context).load(s).into(iv);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
