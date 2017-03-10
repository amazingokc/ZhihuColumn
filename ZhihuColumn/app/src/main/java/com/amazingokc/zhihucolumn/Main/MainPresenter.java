package com.amazingokc.zhihucolumn.main;

import com.amazingokc.zhihucolumn.BasePresenter;
import com.amazingokc.zhihucolumn.model.bean.latestnews.LatestNewsModel;
import com.amazingokc.zhihucolumn.model.source.LatestNewsSource;
import com.amazingokc.zhihucolumn.model.source.RLatestNewsSource;

/**
 * Created by cjy on 2017/3/7.
 */
public class MainPresenter extends BasePresenter<MainView> {

    private MainView mainView;

    private RLatestNewsSource rLatestNewsSource;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        attachPresenter(this.mainView);
        rLatestNewsSource = new RLatestNewsSource();
    }

    public void getLatestNews() {

        rLatestNewsSource.getLatestNews(new LatestNewsSource.GetLatestNewsCallback() {
            @Override
            public void onLatestNewsLoaded(LatestNewsModel latestNewsModel) {
                if (mainView != null) {
                    mainView.showTopStories(latestNewsModel.getTop_stories());
                }
            }

            @Override
            public void onLatestNewsNotAvailable(String error) {
                if (mainView != null) {
                    mainView.errorShowTopStories(error);
                }
            }
        });

    }

}
