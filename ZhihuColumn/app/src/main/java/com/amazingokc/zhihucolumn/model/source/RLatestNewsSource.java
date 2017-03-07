package com.amazingokc.zhihucolumn.model.source;

import com.amazingokc.zhihucolumn.model.http.MyApiService;
import com.amazingokc.zhihucolumn.model.http.MyRetrofit;
import com.amazingokc.zhihucolumn.utils.LLog;

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
                .subscribe(new Observer<Object>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        callback.onLatestNewsNotAvailable("");
                        LLog.d("onError", e.toString());
                    }

                    @Override
                    public void onNext(Object object) {
                        callback.onLatestNewsLoaded(object);
                    }
                });
    }
}
