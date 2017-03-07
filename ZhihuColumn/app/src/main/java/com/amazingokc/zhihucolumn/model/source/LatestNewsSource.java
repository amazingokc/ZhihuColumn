package com.amazingokc.zhihucolumn.model.source;

import com.amazingokc.zhihucolumn.model.bean.latestnuews.LatestNewsModel;

/**
 * Created by cjy on 2017/3/7.
 */

public interface LatestNewsSource {

    interface GetLatestNewsCallback {

        void onLatestNewsLoaded(LatestNewsModel latestNewsModel);

        void onLatestNewsNotAvailable(String error);
    }

    void getLatestNews(GetLatestNewsCallback callback);
}
