package com.xinlan.newview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/6/23.
 */
public class ListAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<String> datas;
    private LayoutInflater mLayoutInflater;

    public ListAdapter(Context mContext, List<String> datas) {
        this.mContext = mContext;
        this.datas = datas;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.view_item, null);
        ListViewHolder holder = new ListViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        position = holder.getLayoutPosition();
        ListViewHolder mListViewHolder = (ListViewHolder) holder;
        mListViewHolder.nameTextView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addItem(){
        datas.add(3,"addOne");
        this.notifyItemInserted(3);
    }

    public void removeItem(){
        datas.remove(3);
        this.notifyItemRemoved(3);
    }
}//end class

class ListViewHolder extends RecyclerView.ViewHolder {
    public TextView nameTextView;

    public ListViewHolder(View itemView) {
        super(itemView);
        nameTextView = (TextView) itemView.findViewById(R.id.name_text);
    }
} //class

