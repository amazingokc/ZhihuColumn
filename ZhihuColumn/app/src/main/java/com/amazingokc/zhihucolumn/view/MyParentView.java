package com.amazingokc.zhihucolumn.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by amazingokc on 2017/3/10.
 */

public class MyParentView extends LinearLayout {

    private int firstYDown;
    private int yDown;  //手指按下时的y轴大小
    private int yLast;  //上一次手指所在的y轴大小
    private int yNow;   //此时手指所在y轴的大小
    private int mMove;  //yNow - yLast最小滑动距离，手指每动一下这个值都会对应改变
    private int moveAll = 0;  //手指总共移动的距离
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
        imageView = (ImageView) getChildAt(0);  //获取到第一个子view
        scrollView = (ScrollView) getChildAt(1);//获取到第二个子view

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        onInterceptTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int y = (int) ev.getY();   //当前手指所在屏幕的y轴位置

        int mScrollY = scrollView.getScrollY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstYDown = y;
                yDown = y;
                yLast = y;
                break;
            case MotionEvent.ACTION_MOVE:
                yNow = y;
//                LLog.d("MotionEvent", "_" + (yNow - yLast));
                if (Math.abs(yNow - yLast) > 0 && (yNow - firstYDown) > 0 && mScrollY == 0) {
                    if (!isIntercept) {
                        isIntercept = true;
                    }
                } else {
                    if (isIntercept) {
                        isIntercept = false;
                    }
                }

                break;
            case MotionEvent.ACTION_UP:
                imageView.layout(imageView.getLeft() + moveAll,
                        imageView.getTop(),
                        imageView.getRight() - moveAll,
                        imageView.getBottom() - moveAll);

                scrollView.layout(getLeft(),
                        scrollView.getTop()  - moveAll,
                        getRight(),
                        scrollView.getBottom());

                moveAll = 0;
                isIntercept = false;

                break;
        }
        if (Math.abs(yNow - yLast) > 0 && isIntercept) {
            mMove = yNow - yLast;
            moveAll += mMove;

            imageView.layout(imageView.getLeft() - mMove,
                    imageView.getTop(),
                    imageView.getRight() + mMove,
                    imageView.getBottom() + mMove);

            scrollView.layout(getLeft(),
                    scrollView.getTop() + mMove,
                    getRight(),
                    scrollView.getBottom());

            yLast = yNow;

        }
        return isIntercept;
    }

}
