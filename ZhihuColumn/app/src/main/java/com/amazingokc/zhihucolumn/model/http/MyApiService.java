package com.amazingokc.zhihucolumn.model.http;

import com.amazingokc.zhihucolumn.mommon.Constants;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by cjy on 2017/3/7.
 */

public interface MyApiService {

    /**获取最新消息*/
    @GET(Constants.LATESTMEWSURL)
    Observable<Object> getLatestNews();

}
