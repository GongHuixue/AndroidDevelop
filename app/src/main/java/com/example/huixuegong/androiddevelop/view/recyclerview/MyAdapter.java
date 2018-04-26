package com.example.huixuegong.androiddevelop.view.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.huixuegong.androiddevelop.R;

import java.util.ArrayList;

/**
 * Created by huixue.gong on 2018/4/26.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private ArrayList<String> mData;

    public MyAdapter(ArrayList<String> data) {
        this.mData = data;
    }

    @Override
    public int getItemCount() {
        return (mData == null) ? 0 : mData.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTv.setText(mData.get(position));
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTv;

        public MyViewHolder (View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.text_item);
        }
    }
}
