package com.amazingokc.zhihucolumn.model.bean.latestnews;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cjy on 2017/3/7.
 */

public class StoriesModel implements Serializable {

    private String title;

    //供 Google Analytics 使用(不知道什么作用)
    private String ga_prefix;

    private List<String> images;

    private int type;

    private long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StoriesModel{" +
                "title='" + title + '\'' +
                ", ga_prefix='" + ga_prefix + '\'' +
                ", images=" + images +
                ", type=" + type +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoriesModel)) return false;

        StoriesModel that = (StoriesModel) o;

        if (getType() != that.getType()) return false;
        if (getId() != that.getId()) return false;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null)
            return false;
        if (getGa_prefix() != null ? !getGa_prefix().equals(that.getGa_prefix()) : that.getGa_prefix() != null)
            return false;
        return getImages() != null ? getImages().equals(that.getImages()) : that.getImages() == null;

    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getGa_prefix() != null ? getGa_prefix().hashCode() : 0);
        result = 31 * result + (getImages() != null ? getImages().hashCode() : 0);
        result = 31 * result + getType();
        result = 31 * result + (int) (getId() ^ (getId() >>> 32));
        return result;
    }
}
