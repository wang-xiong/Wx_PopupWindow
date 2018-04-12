package com.baidu.duer.dcs.wx_popupwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wx on 2016/12/13.
 */
public class ChoiceLabelPopupAdapter extends BaseAdapter {

    private ArrayList<String> mList;
    private Context mContext;
    public ChoiceLabelPopupAdapter(Context context, ArrayList<String> list){
        this.mList = list;
        this.mContext = context;

    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.choice_label_item, null);
            viewHolder.title_TextView = (TextView) convertView.findViewById(R.id.item_title);
            viewHolder.choice_ImageView = (ImageView) convertView.findViewById(R.id.item_image);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title_TextView.setText(mList.get(position));

        return convertView;
    }

    class ViewHolder{
        TextView title_TextView;
        ImageView choice_ImageView;
    }
}