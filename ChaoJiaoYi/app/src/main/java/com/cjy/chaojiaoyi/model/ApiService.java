package com.cjy.chaojiaoyi.model;

import com.cjy.chaojiaoyi.common.Constants;
import com.cjy.chaojiaoyi.model.Bean.LauncherImageViewModel;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by cjy on 2017/3/14.
 */

public interface ApiService {

    /**获取启动页图片*/
    @GET(Constants.ADVERTISING_URL)
    Observable<LauncherImageViewModel> getLauncherImageView();

    /**获取轮播图片*/
    @GET(Constants.GETADVERTUSINGFOR_URL)
    Observable<Object> getAdvertusingfor();

    /**版本查询*/
    @GET(Constants.QUERYVERSION_URL)
    Observable<Object> getVersionCode();
}
