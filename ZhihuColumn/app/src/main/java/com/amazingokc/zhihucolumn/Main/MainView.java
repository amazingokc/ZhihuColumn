package com.amazingokc.zhihucolumn.main;

import com.amazingokc.zhihucolumn.BaseView;
import com.amazingokc.zhihucolumn.model.bean.latestnews.TopstoriesModel;

import java.util.List;

/**
 * Created by cjy on 2017/3/7.
 */

public interface MainView extends BaseView {


    void showTopStories(List<TopstoriesModel> topstoriesModelList);

    void errorShowTopStories(String error);

}
