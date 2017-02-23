package com.tutorialsbuzz.scrolldownrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    List<String> stringList;
    Context mContext;

    public RVAdapter(Context context, List<String> stringList) {
        this.mContext = context;
        this.stringList = stringList;
    }

    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(mContext)
                .inflate(R.layout.list_items, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(RVAdapter.ViewHolder holder, final int position) {
        holder.mTextView.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textview01);
        }
    }

}
