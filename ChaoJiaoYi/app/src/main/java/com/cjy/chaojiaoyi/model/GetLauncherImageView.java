package com.cjy.chaojiaoyi.model;

import com.cjy.chaojiaoyi.common.LLog;
import com.cjy.chaojiaoyi.model.Bean.LauncherImageViewModel;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cjy on 2017/3/14.
 */

public class GetLauncherImageView implements LauncherImageView {

    @Override
    public void getLauncherImage(final GetLauncherImageViewCallback callback) {

        MyRetrofit.getRetrofit()
                .create(ApiService.class)
                .getLauncherImageView()
                .subscribeOn(Schedulers.io())  //生产
                .observeOn(AndroidSchedulers.mainThread())  //消费
                .subscribe(new Observer<LauncherImageViewModel>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LLog.d("getLauncherImage", "" + e);
                        callback.getLauncherImageViewFail("");
                    }

                    @Override
                    public void onNext(LauncherImageViewModel launcherImageViewModel) {
                        LLog.d("getLauncherImage", "" + launcherImageViewModel.toString());
                        callback.getLauncherImageViewSuccess(launcherImageViewModel);
                    }
                });
    }
}
