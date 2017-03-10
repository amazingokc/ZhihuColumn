package com.amazingokc.zhihucolumn.main;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amazingokc.zhihucolumn.R;
import com.amazingokc.zhihucolumn.model.bean.latestnews.TopstoriesModel;
import com.amazingokc.zhihucolumn.mommon.adapter.StoriesAdapter;
import com.amazingokc.zhihucolumn.mommon.adapter.TopStoriesAdapter;
import com.amazingokc.zhihucolumn.view.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class StoriesFragment extends Fragment implements MainView {
    // TODO: Rename parameter arguments, choose names that match
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.rcview_stories)
    RecyclerView rcviewStories;
    @BindView(R.id.indicator)
    CirclePageIndicator indicator;

    private MainPresenter presenter;
    private ActionBar actionBar;

    private List<TopstoriesModel> topstoriesModelList;
    private TopStoriesAdapter topStoriesAdapter;
    private StoriesAdapter storiesAdapter;

    public StoriesFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StoriesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StoriesFragment newInstance(String param1, String param2) {
        StoriesFragment fragment = new StoriesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_stories, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViewpage();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (presenter == null) {
            presenter = new MainPresenter(this);
        }
        presenter.getLatestNews();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (presenter != null) {
            presenter.detachPresenter();
        }
    }

    private void initViewpage() {

        topstoriesModelList = new ArrayList<>();
        topStoriesAdapter = new TopStoriesAdapter(topstoriesModelList);
        viewpager.setOffscreenPageLimit(2);
        viewpager.setCurrentItem(0);
        viewpager.setAdapter(topStoriesAdapter);
        indicator.setViewPager(viewpager);

        storiesAdapter = new StoriesAdapter();
        rcviewStories.setLayoutManager(new LinearLayoutManager(getContext()));
        rcviewStories.setAdapter(storiesAdapter);
    }


    @Override
    public void showTopStories(List<TopstoriesModel> topstoriesModelList) {
        topStoriesAdapter.notifyData(topstoriesModelList);
    }

    @Override
    public void errorShowTopStories(String error) {

    }
}
