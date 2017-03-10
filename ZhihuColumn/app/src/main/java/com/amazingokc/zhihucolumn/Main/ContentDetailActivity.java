package com.amazingokc.zhihucolumn.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amazingokc.zhihucolumn.R;
import com.amazingokc.zhihucolumn.mommon.adapter.StoriesAdapter;

import butterknife.ButterKnife;

/**
 * 内容浏览界面
 */
public class ContentDetailActivity extends AppCompatActivity {

    private StoriesAdapter storiesAdapter;
    float lastx = 0;
    float lasty = 0;
    float iviewX;
    float iviewH;
    float rviewH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_detail);
        ButterKnife.bind(this);

//        storiesAdapter = new StoriesAdapter();
//        rcview.setLayoutManager(new LinearLayoutManager(this));
//        rcview.setAdapter(storiesAdapter);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                iviewX = iview.getWidth();
//                iviewH = iview.getHeight();
//                rviewH = rcview.getY();
//            }
//        }, 500);
//
//        rcview.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                int y = (int) motionEvent.getY();
//                int x = (int) motionEvent.getX();
//
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        lastx = x;
//                        lasty = y;
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        if (!rcview.canScrollVertically(-1) && motionEvent.getY() - lasty > 0 && motionEvent.getY() - lasty < iviewH) {
//
//                            iview.layout((int) -Math.abs(motionEvent.getY() - lasty),
//                                    0,
//                                    (int) (iviewX + Math.abs(motionEvent.getY() - lasty)),
//                                    (int) (iviewH + Math.abs(motionEvent.getY() - lasty)));
////                            rcview.scrollBy(0, (int) Math.abs(motionEvent.getY() - lasty));
//                        }
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        iview.layout(0,
//                                0,
//                                (int) iviewX,
//                                (int) iviewH);
////                        rcview.scrollTo(0, 0);
//                        break;
//                }
////                lastx = x;
////                lasty = y;
//
//                return false;
//            }
//        });


    }
}
