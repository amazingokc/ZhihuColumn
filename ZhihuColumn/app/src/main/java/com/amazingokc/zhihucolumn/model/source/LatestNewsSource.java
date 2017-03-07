package com.amazingokc.zhihucolumn.model.source;

/**
 * Created by cjy on 2017/3/7.
 */

public interface LatestNewsSource {

    interface GetLatestNewsCallback {

        void onLatestNewsLoaded(Object o);

        void onLatestNewsNotAvailable(String error);
    }

    void getLatestNews(GetLatestNewsCallback callback);
}
