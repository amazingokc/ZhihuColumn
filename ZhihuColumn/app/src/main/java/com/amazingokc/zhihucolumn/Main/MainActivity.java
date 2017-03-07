package com.amazingokc.zhihucolumn.main;

import android.os.Bundle;

import com.amazingokc.zhihucolumn.BaseActivity;
import com.amazingokc.zhihucolumn.R;

public class MainActivity extends BaseActivity implements MainView {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getDate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachPresenter();
    }
}
