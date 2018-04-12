package com.baidu.duer.dcs.wx_popupwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (TextView) findViewById(R.id.test);
        initPopupWindow();
    }

    private void initPopupWindow(){
        ChoiceLabelPopupWindow mFormatLabelPopupWindow = new ChoiceLabelPopupWindow(Main2Activity.this
                , WindowManager.LayoutParams.WRAP_CONTENT
                , WindowManager.LayoutParams.WRAP_CONTENT);
        mFormatLabelPopupWindow.showAsDropDown(button);
    }
}
