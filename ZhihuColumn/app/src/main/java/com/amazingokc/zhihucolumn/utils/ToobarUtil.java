package com.amazingokc.zhihucolumn.utils;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by cjy on 2016/8/19.
 */
public class ToobarUtil {

    private static ActionBar actionBar;

    public static void initNormalToobar(final AppCompatActivity context, Toolbar toolbar, String title) {

        context.setSupportActionBar(toolbar);
        actionBar = context.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);//设置返回箭头显示
        actionBar.setDisplayUseLogoEnabled(false);//设置logo是否显示（默认为true）
        actionBar.setTitle(title);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.finish();
            }
        });

    }
}









