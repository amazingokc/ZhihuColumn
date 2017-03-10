package com.amazingokc.zhihucolumn.mommon.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amazingokc.zhihucolumn.R;
import com.amazingokc.zhihucolumn.model.bean.latestnews.TopstoriesModel;
import com.amazingokc.zhihucolumn.mommon.MyApplication;
import com.amazingokc.zhihucolumn.utils.LLog;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by cjy on 2017/3/10.
 */
public class TopStoriesAdapter extends PagerAdapter {

    private ImageView iviewImage;
    private TextView txtTitle;
    private List<TopstoriesModel> dataList;

    public TopStoriesAdapter(List<TopstoriesModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        LLog.d("getCount", dataList.size() + "");
        if (dataList != null) {
            return dataList.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(MyApplication.getApplication())
                .inflate(R.layout.topstoriesfragment_item, container, false);
        iviewImage = (ImageView) view.findViewById(R.id.iview_image);
        txtTitle = (TextView) view.findViewById(R.id.txt_title);

        txtTitle.setText(dataList.get(position).getTitle());
        Glide.with(MyApplication.getApplication())
                .load(dataList.get(position).getImage())
                .into(iviewImage);

        container.addView(view);
        return view;
    }

    public void notifyData(List<TopstoriesModel> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }


}
