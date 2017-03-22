package com.cjy.chaojiaoyi.model;

import com.cjy.chaojiaoyi.model.Bean.LauncherImageViewModel;

/**
 * Created by cjy on 2017/3/14.
 */

public interface LauncherImageView {

    interface GetLauncherImageViewCallback {

        void getLauncherImageViewSuccess(LauncherImageViewModel launcherImageViewModel);

        void getLauncherImageViewFail(String error);
    }

    void getLauncherImage(GetLauncherImageViewCallback callback);
}
