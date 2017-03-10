package com.amazingokc.zhihucolumn.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.amazingokc.zhihucolumn.utils.LLog;

/**
 * Created by cjy on 2017/3/10.
 */

public class MyParentView extends LinearLayout {

    private int mMove;
    private int yLast, yNow;
    private int moveAll = 0;  //总共移动的距离
    private boolean isIntercept = false;

    public MyParentView(Context context) {
        super(context);
    }

    public MyParentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyParentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private ScrollView scrollView;
    private ImageView imageView;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        imageView = (ImageView) getChildAt(0);
        scrollView = (ScrollView) getChildAt(1);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        onInterceptTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int y = (int) ev.getY();
        int mScrollY = scrollView.getScrollY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                yLast = y;
                break;
            case MotionEvent.ACTION_MOVE:
                LLog.d("MotionEvent", "" + mScrollY);
                yNow = y;
                if (yNow - yLast > 0 && mScrollY == 0) {
                    if (!isIntercept) {
                        isIntercept = true;
                    }
                }

                break;
            case MotionEvent.ACTION_UP:
                imageView.layout(imageView.getLeft(),
                        imageView.getTop(),
                        imageView.getRight(),
                        imageView.getBottom() - moveAll);

//                layout(getLeft(),
//                        getTop() - moveAll,
//                        getRight(),
//                        getBottom() - moveAll);

//                scrollView.layout(scrollView.getLeft(),
//                        scrollView.getTop(),
//                        scrollView.getRight(),
//                        scrollView.getBottom() - moveAll);
                moveAll = 0;
                isIntercept = false;

                break;
        }
        if (yNow - yLast > 0 && isIntercept) {
            mMove = yNow - yLast;
            moveAll += mMove;

            imageView.layout(imageView.getLeft(),
                    imageView.getTop(),
                    imageView.getRight(),
                    imageView.getBottom() + mMove);

//            layout(getLeft(),
//                    getTop() + mMove,
//                    getRight(),
//                    getBottom() + mMove);

//            scrollView.layout(imageView.getLeft(),
//                    scrollView.getTop(),
//                    scrollView.getRight(),
//                    scrollView.getBottom() + mMove);

            yLast = yNow;

        }
        return isIntercept;
    }
}
