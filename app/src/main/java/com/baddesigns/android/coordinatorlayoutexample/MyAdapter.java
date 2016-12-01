package com.baddesigns.android.coordinatorlayoutexample;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jon-Ross on 30/11/2016.
 */
class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private AppCompatActivity mActivity;
    private List<String> mItems;

    MyAdapter(AppCompatActivity activity, List<String> items) {
        mActivity = activity;
        mItems = items;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = mActivity.getLayoutInflater();
        TextView textView = (TextView) inflater.inflate(R.layout.list_item, parent, false);
        return new MyHolder(textView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        String text = mItems.get(position);
        holder.bindView(text);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        MyHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
            mTextView.setHeight(50);
        }

        void bindView(String text) {
            mTextView.setText(text);
        }
    }
}
