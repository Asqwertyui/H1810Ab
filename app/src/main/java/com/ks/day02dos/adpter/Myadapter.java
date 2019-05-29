package com.ks.day02dos.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ks.day02dos.R;
import com.ks.day02dos.bean.Art;

import java.util.ArrayList;

/**
 * Created by F0519 on 2019/5/29.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private ArrayList<Art.ResultsBean> mResultsBeans;
    private Context context;

    public Myadapter(ArrayList<Art.ResultsBean> resultsBeans, Context context) {
        mResultsBeans = resultsBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.tem, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Art.ResultsBean bean = mResultsBeans.get(position);
        holder.tv.setText(bean.getPublishedAt());
        Glide.with(context).load(bean.getUrl()).into(holder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnclickListener.Onclick(position,bean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mResultsBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            iv=itemView.findViewById(R.id.iv);
        }
    }
    private OnclickListener OnclickListener;

    public void setOnclickListener(Myadapter.OnclickListener onclickListener) {
        OnclickListener = onclickListener;
    }

    public interface  OnclickListener{
        void Onclick(int position, Art.ResultsBean bean);
    }
}
