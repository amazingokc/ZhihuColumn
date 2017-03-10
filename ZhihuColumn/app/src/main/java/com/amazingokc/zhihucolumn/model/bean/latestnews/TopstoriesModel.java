package com.amazingokc.zhihucolumn.model.bean.latestnews;

import java.io.Serializable;

/**
 * Created by cjy on 2017/3/7.
 */

public class TopstoriesModel implements Serializable {

    private String title;

    //供 Google Analytics 使用(不知道什么作用)
    private String ga_prefix;

    private String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        return "TopstoriesModel{" +
                "title='" + title + '\'' +
                ", ga_prefix='" + ga_prefix + '\'' +
                ", image='" + image + '\'' +
                ", type=" + type +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopstoriesModel that = (TopstoriesModel) o;

        if (type != that.type) return false;
        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (ga_prefix != null ? !ga_prefix.equals(that.ga_prefix) : that.ga_prefix != null)
            return false;
        return image != null ? image.equals(that.image) : that.image == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (ga_prefix != null ? ga_prefix.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
