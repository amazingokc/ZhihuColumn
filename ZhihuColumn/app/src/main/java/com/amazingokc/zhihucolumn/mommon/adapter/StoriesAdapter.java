//package com.amazingokc.zhihucolumn.mommon.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.amazingokc.zhihucolumn.R;
//
///**
// * Created by cjy on 2017/3/10.
// */
//public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.MyViewHolder> {
//
//    private Context context;
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        context = parent.getContext();
//        View view = LayoutInflater.from(context).inflate(R.layout.stories_item, null, false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return 60;
//    }
//
//    class MyViewHolder extends RecyclerView.ViewHolder {
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//        }
//    }
//}
