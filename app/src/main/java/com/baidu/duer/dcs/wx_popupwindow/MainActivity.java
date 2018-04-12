package com.baidu.duer.dcs.wx_popupwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView format_textView;
    private TextView test;
    protected ArrayList<String> mlist;
    private ChoiceLabelPopupWindow myPopupWindow;
    private ChoiceLabelPopupAdapter myPopupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.title);
        format_textView = (TextView) findViewById(R.id.format_textView);
        test = (TextView) findViewById(R.id.textView);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.isSelected()) {
                    v.setSelected(true);
                }else {
                    v.setSelected(false);
                }
            }
        });
        initData();
        initPopupWindow();
        initPopupWindow2();
    }

    @Override
    public void reportFullyDrawn() {
        super.reportFullyDrawn();
    }

    private void initPopupWindow2(){
        format_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormatLabelPopupWindow mFormatLabelPopupWindow = new FormatLabelPopupWindow(MainActivity.this
                        , WindowManager.LayoutParams.WRAP_CONTENT
                        , WindowManager.LayoutParams.WRAP_CONTENT);
                mFormatLabelPopupWindow.getContentView().measure(View.MeasureSpec.UNSPECIFIED
                        , View.MeasureSpec.UNSPECIFIED);
                int h = mFormatLabelPopupWindow.getContentView().getMeasuredHeight();
                int w = mFormatLabelPopupWindow.getContentView().getMeasuredWidth();
                Log.i("wx", "width:" + w);
                mFormatLabelPopupWindow.showAsDropDown(format_textView, -format_textView.getWidth(), -format_textView.getHeight()-h);
            }
        });
    }


    private void initPopupWindow() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //int width = 1015;
                //int width = 512;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                int maxHeight = 1117;
                myPopupWindow = new ChoiceLabelPopupWindow(MainActivity.this, 1015, height);
                if(mlist.size() > 0){
                    myPopupAdapter = new ChoiceLabelPopupAdapter(MainActivity.this, mlist);
                    myPopupWindow.setListAdapter(myPopupAdapter, 8 );
                }
                //myPopupWindow.showAsDropDown(textView, -(myPopupWindow.getWidth()/2- textView.getWidth()/2), 0);
                myPopupWindow.showAsDropDown(textView);
                myPopupWindow.setOnItemLongClickListenerForListView(new AdapterView.OnItemLongClickListener() {

                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        view.findViewById(R.id.item_image).setVisibility(View.GONE);
                        return false;
                    }
                });

                myPopupWindow.setOnClickListenerForMiddleBottomTitle("新建", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                myPopupWindow.setOnClickListenerForLeftBottomTitle("新建", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                myPopupWindow.setOnClickListenerForRightBottomTitle("编辑", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        });
    }

    private void initData(){
        mlist = new ArrayList<>();
        mlist.add("全部记事");
        mlist.add("生活");
        mlist.add("工作");
        mlist.add("全部记事");
        mlist.add("生活");
        mlist.add("工作");
        mlist.add("全部记事");
        mlist.add("第八个");
        //mlist.add("第9个");
    }
    @Override
    protected void onResume() {
        super.onResume();

    }
}
