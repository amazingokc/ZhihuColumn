package com.amazingokc.zhihucolumn.model.source;

import com.amazingokc.zhihucolumn.model.bean.latestnuews.LatestNewsModel;
import com.amazingokc.zhihucolumn.model.http.MyApiService;
import com.amazingokc.zhihucolumn.model.http.MyRetrofit;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cjy on 2017/3/7.
 */

public class RLatestNewsSource implements LatestNewsSource{


    @Override
    public void getLatestNews(final GetLatestNewsCallback callback) {

        MyRetrofit.getRetrofit()
                .create(MyApiService.class)
                .getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LatestNewsModel>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        callback.onLatestNewsNotAvailable("");
                    }

                    @Override
                    public void onNext(LatestNewsModel latestNewsModel) {
                        callback.onLatestNewsLoaded(latestNewsModel);
                    }
                });
    }
}
