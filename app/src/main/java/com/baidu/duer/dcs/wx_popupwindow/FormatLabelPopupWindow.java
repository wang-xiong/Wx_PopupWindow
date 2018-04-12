package com.baidu.duer.dcs.wx_popupwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by wx on 2016/12/16.
 */
public class FormatLabelPopupWindow extends PopupWindow{
    private Context mContext;
    private View mRootView;

    public FormatLabelPopupWindow(Context context, int width, int height) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(mContext).inflate(R.layout.format_label_layout, null);
        this.setContentView(mRootView);
        this.setFocusable(true);
        this.setTouchable(true);
        this.setOutsideTouchable(true);
        this.setWidth(width);
        this.setHeight(height);

    }

    private void initView(){


    }
}
