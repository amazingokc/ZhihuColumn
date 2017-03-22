package com.cjy.chaojiaoyi.contract;

import com.cjy.chaojiaoyi.BaseView;
import com.cjy.chaojiaoyi.model.Bean.LauncherImageViewModel;

/**
 * Created by cjy on 2017/3/14.
 */

public interface LauncherView extends BaseView{

    void showLauncherImageView(LauncherImageViewModel launcherImageViewModel);

    void noLauncherImageView(String error);
}
