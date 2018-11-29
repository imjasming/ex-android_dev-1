package com.xiaoming.exercise.mygymclub.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xfhy.easybanner.ui.EasyBanner;
import com.xiaoming.exercise.mygymclub.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageFragment extends Fragment {
    @BindView(R.id.list_home_recomend_recycler_view)
    RecyclerView mRecommendGridView;
    @BindView(R.id.banner_home_news)
    EasyBanner mNewsBanner;
    @BindView(R.id.btn_home_recommend)
    Button mRecommedButton;

    private MyRecyclerViewAdapter mAdapter;
    private ArrayList<MyIcon> mMyIcons;

    private List<String> mIMGList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMyIcons = new ArrayList<>();
        mMyIcons.add(new MyIcon(R.drawable.banner, "class1"));
        mMyIcons.add(new MyIcon(R.drawable.sport, "this class"));
        mMyIcons.add(new MyIcon(R.drawable.banner_gym, "another class"));

        mAdapter = new MyRecyclerViewAdapter(mMyIcons);

        mIMGList = getImageUrlData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_page_fragment, container, false);
        ButterKnife.bind(this, v);

        //首页轮播图
        mNewsBanner.initBanner(mIMGList, getContentData());
        mNewsBanner.start();

        //推荐的项目
        mRecommendGridView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mRecommendGridView.setAdapter(mAdapter);

        return v;
    }


    private List<String> getImageUrlData() {
        List<String> imageList = new ArrayList<>();
        imageList.add("https://ws3.sinaimg.cn/large/005ODKsIgw1fatjcvhpsnj31hc0u0tf5.jpg");
        imageList.add("https://ws1.sinaimg.cn/large/005ODKsIgy1fip1i5u5v7j30iw0c7myf.jpg");
        imageList.add("https://ws3.sinaimg.cn/large/005ODKsIgw1fakyqhgrtxj31hc0u0gpm.jpg");
        imageList.add("https://ws2.sinaimg.cn/large/005ODKsIgw1faojyat103j31hc0u0te2.jpg");
        imageList.add("https://pic2.zhimg.com/v2-4d873d82642d347aa0e709b2e2f5be81.jpg");

        return imageList;
    }

    private List<String> getContentData() {
        List<String> contentList = new ArrayList<>();
        contentList.add("Activity: 女健身狂魔");
        contentList.add("Activity：一起来健身吧");
        contentList.add("窝在床上的坏处 (~_~)");
        contentList.add("微笑面对生活 (-v-)");
        contentList.add("「不主动追求你，也不明确拒绝你」，这就是现代人的爱情");

        return contentList;
    }


    private class MyIcon {
        private int resId;
        private String infom;

        public MyIcon(int resId) {
            this.resId = resId;
        }

        public MyIcon(int resId, String infom) {
            this.resId = resId;
            this.infom = infom;
        }

        public int getResId() {
            return resId;
        }

        public void setResId(int resId) {
            this.resId = resId;
        }

        public String getInfom() {
            return infom;
        }

        public void setInfom(String infom) {
            this.infom = infom;
        }
    }



    class MyRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.item_grid_title)
        TextView mTitle;
        @BindView(R.id.item_grid_image)
        ImageView mImage;

        public MyRecyclerViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_grid_view_icon, parent, false));
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bind(MyIcon myIcon) {
            mImage.setImageResource(myIcon.getResId());
            mTitle.setText(myIcon.getInfom());
        }

        @Override
        public void onClick(View v) {

        }
    }

    private class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {

        private List<MyIcon> mDatas;

        public MyRecyclerViewAdapter(List<MyIcon> datas) {
            mDatas = datas;
        }

        @NonNull
        @Override
        public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new MyRecyclerViewHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull MyRecyclerViewHolder myRecyclerViewHolder, int i) {
            MyIcon crime = mDatas.get(i);
            myRecyclerViewHolder.bind(crime);
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }
    }
}
