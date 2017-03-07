package com.amazingokc.zhihucolumn;

/**
 * Created by cjy on 2017/3/7.
 */

public class BasePresenter<T extends BaseView>{

    private T t;

    public void  attachPresenter(T t) {
        this.t = t;
    }

    public void detachPresenter() {
        t = null;
    }

}
