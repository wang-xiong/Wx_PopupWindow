package com.baidu.duer.dcs.wx_popupwindow;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class ChoiceLabelPopupWindow extends PopupWindow{
    private Context mContext;
    private View mRootView;
    private ListView mListView;
    private TextView mLeftBottomView;
    private TextView mRightBottomView;
    private TextView mMiddleBottomView;
    private int width ;
    private int height ;


    public ChoiceLabelPopupWindow(Context context, int width, int height){
        super();
        this.mContext = context;
        this.width = width;
        this.height = height;
        initView();
        initPopupWindow();
    }

    private void initView() {
        mRootView = LayoutInflater.from(mContext).inflate(R.layout.choice_label_layout, null);
        mListView = (ListView) mRootView.findViewById(R.id.label_listView);
        mLeftBottomView = (TextView) mRootView.findViewById(R.id.tv_left_title);
        mRightBottomView = (TextView) mRootView.findViewById(R.id.tv_right_title);
        mMiddleBottomView = (TextView) mRootView.findViewById(R.id.tv_middle_title);
    }

    private void initPopupWindow() {
        this.setContentView(mRootView);
        this.setFocusable(true);
        this.setTouchable(true);
        this.setOutsideTouchable(true);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setOnItemClickListenerForListView(OnItemClickListener listener) {
        mListView.setOnItemClickListener(listener);
    }
    
    public void setOnItemLongClickListenerForListView(OnItemLongClickListener listener) {
        mListView.setOnItemLongClickListener(listener);
    }
    
    public void setOnClickListenerForLeftBottomTitle(String title, OnClickListener listener){
        mLeftBottomView.setVisibility(View.VISIBLE);
        mLeftBottomView.setText(title);
        mLeftBottomView.setOnClickListener(listener);
    }
    
    public void setOnClickListenerForRightBottomTitle(String title, OnClickListener listener){
        mRightBottomView.setVisibility(View.VISIBLE);
        mRightBottomView.setText(title);
        mRightBottomView.setOnClickListener(listener);
    }

    public void setOnClickListenerForMiddleBottomTitle(String title, OnClickListener listener){
        mMiddleBottomView.setVisibility(View.VISIBLE);
        mMiddleBottomView.setText(title);
        mMiddleBottomView.setOnClickListener(listener);
    }

    public void setListAdapter(ChoiceLabelPopupAdapter adapter, int MaxItemCount) {
        mListView.setVisibility(View.VISIBLE);
        mListView.setAdapter(adapter);
        mListView.setPadding(49, 0, 58, 0);
        //this.setHeight((MaxItemCount+1)*120+18+1);
        if(adapter.getCount() > MaxItemCount){

        }
    }
}
