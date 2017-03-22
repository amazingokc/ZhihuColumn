package com.amazingokc.zhihucolumn.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amazingokc.zhihucolumn.R;
import com.amazingokc.zhihucolumn.utils.LLog;
import com.amazingokc.zhihucolumn.view.test.MyButton;
import com.amazingokc.zhihucolumn.view.test.MyLinerLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TouchTestActivity extends AppCompatActivity {

    @BindView(R.id.btn)
    MyButton btn;
    @BindView(R.id.activity_touch_test)
    MyLinerLayout activityTouchTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_test);
        ButterKnife.bind(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LLog.d("onClick", "click");
            }
        });
    }
}
