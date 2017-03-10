package com.amazingokc.zhihucolumn.model.bean.latestnews;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cjy on 2017/3/7.
 */

public class LatestNewsModel implements Serializable {

    private String date;

    //当日新闻
    private List<StoriesModel> stories;

    //界面顶部 ViewPager 滚动显示的显示内容（子项格式同上）（请注意区分此处的 image 属性与 stories 中的 images 属性）
    private List<TopstoriesModel> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesModel> getStories() {
        return stories;
    }

    public void setStories(List<StoriesModel> stories) {
        this.stories = stories;
    }

    public List<TopstoriesModel> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopstoriesModel> top_stories) {
        this.top_stories = top_stories;
    }

    @Override
    public String toString() {
        return "LatestNewsModel{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LatestNewsModel)) return false;

        LatestNewsModel that = (LatestNewsModel) o;

        if (getDate() != null ? !getDate().equals(that.getDate()) : that.getDate() != null)
            return false;
        if (getStories() != null ? !getStories().equals(that.getStories()) : that.getStories() != null)
            return false;
        return getTop_stories() != null ? getTop_stories().equals(that.getTop_stories()) : that.getTop_stories() == null;

    }

    @Override
    public int hashCode() {
        int result = getDate() != null ? getDate().hashCode() : 0;
        result = 31 * result + (getStories() != null ? getStories().hashCode() : 0);
        result = 31 * result + (getTop_stories() != null ? getTop_stories().hashCode() : 0);
        return result;
    }
}
