package com.amazingokc.zhihucolumn.main;

import com.amazingokc.zhihucolumn.BasePresenter;
import com.amazingokc.zhihucolumn.model.bean.latestnuews.LatestNewsModel;
import com.amazingokc.zhihucolumn.model.source.LatestNewsSource;
import com.amazingokc.zhihucolumn.model.source.RLatestNewsSource;

/**
 * Created by cjy on 2017/3/7.
 */
public class MainPresenter extends BasePresenter<MainView> {

    private MainView mainView;

    private RLatestNewsSource rLatestNewsSource;

    public MainPresenter(MainView mainView) {
        attachPresenter(mainView);
        this.mainView = mainView;
        rLatestNewsSource = new RLatestNewsSource();
    }

    public void getDate() {

        rLatestNewsSource.getLatestNews(new LatestNewsSource.GetLatestNewsCallback() {
            @Override
            public void onLatestNewsLoaded(LatestNewsModel latestNewsModel) {

            }

            @Override
            public void onLatestNewsNotAvailable(String error) {

            }
        });

    }

}
