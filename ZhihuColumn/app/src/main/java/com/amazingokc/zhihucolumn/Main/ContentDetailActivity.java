package com.amazingokc.zhihucolumn.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amazingokc.zhihucolumn.R;
import com.amazingokc.zhihucolumn.view.CheckView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 内容浏览界面
 */
public class ContentDetailActivity extends AppCompatActivity {

    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.txt)
    TextView txt;
    @BindView(R.id.checkview)
    CheckView checkview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_detail);
        ButterKnife.bind(this);

        checkview.check();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}
