package com.amazingokc.zhihucolumn.main;

import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;

import com.amazingokc.zhihucolumn.BaseActivity;
import com.amazingokc.zhihucolumn.R;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

//    @BindView(R.id.left_drawer)
//    RecyclerView leftDrawer;
//    @BindView(R.id.drawerlayout)
//    DrawerLayout drawerlayout;
//    @BindView(R.id.fragment_content)
//    FrameLayout fragmentContent;

    private StoriesFragment storiesFragment;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        storiesFragment =
//                (StoriesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_content);
//
//        if (storiesFragment == null) {
//            storiesFragment = StoriesFragment.newInstance("", "");
//            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
//                    storiesFragment, R.id.fragment_content);
//        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
