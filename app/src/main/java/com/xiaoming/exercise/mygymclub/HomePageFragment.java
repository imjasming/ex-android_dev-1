package com.xiaoming.exercise.mygymclub;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.xfhy.easybanner.ui.EasyBanner;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment extends Fragment {
    private GridView mRecommendGridView;
    private EasyBanner mNewsBanner;
    private Button mRecommedButton;

    private MyGidViewAdapter mAdapter;
    private ArrayList<MyIcon> mMyIcons;

    private List<String> mIMGList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMyIcons = new ArrayList<>();
        mMyIcons.add(new MyIcon(R.drawable.banner, "class1"));
        mMyIcons.add(new MyIcon(R.drawable.sport, "this class"));
        mMyIcons.add(new MyIcon(R.drawable.banner_gym, "another class"));

        mAdapter = new MyGidViewAdapter(mMyIcons);

        mIMGList = getImageUrlData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_page_fragment, container, false);

        //首页轮播图
        mNewsBanner = v.findViewById(R.id.news_banner);
        mNewsBanner.initBanner(mIMGList, getContentData());
        mNewsBanner.start();

        //全部推荐项目
        mRecommedButton = v.findViewById(R.id.button_recommend);
        //推荐的项目
        mRecommendGridView = v.findViewById(R.id.recomend_grid_view);
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

    private static class MyGidViewAdapter extends BaseAdapter {
        private ArrayList<MyIcon> mDatas;

        public MyGidViewAdapter(ArrayList<MyIcon> datas) {
            mDatas = datas;
        }

        @Override
        public int getCount() {
            return mDatas == null ? 0 : mDatas.size();
        }

        @Override
        public MyIcon getItem(int position) {
            return mDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            MyViewHolder holder = MyViewHolder.bind(parent.getContext(), convertView, parent,
                    R.layout.item_grid_view_icon, position);
            holder.setImageResource(R.id.item_grid_image, getItem(position).getResId());
            holder.setText(R.id.item_grid_title, getItem(position).getInfom());

            return holder.getItemView();
        }


        //添加一个元素
        public void add(MyIcon data) {
            if (mDatas == null) {
                mDatas = new ArrayList<>();
            }
            mDatas.add(data);
            notifyDataSetChanged();
        }
    }

    public static class MyViewHolder {

        private SparseArray<View> mViews;   //存储ListView 的 item中的View
        private View item;                  //存放convertView
        private int position;               //游标
        private Context context;            //Context上下文

        //构造方法，完成相关初始化
        private MyViewHolder(Context context, ViewGroup parent, int layoutRes) {
            mViews = new SparseArray<>();
            this.context = context;
            View convertView = LayoutInflater.from(context).inflate(layoutRes, parent, false);
            convertView.setTag(this);
            item = convertView;
        }

        //绑定ViewHolder与item
        public static MyViewHolder bind(Context context, View convertView, ViewGroup parent,
                                        int layoutRes, int position) {
            MyViewHolder holder;
            if (convertView == null) {
                holder = new MyViewHolder(context, parent, layoutRes);
            } else {
                holder = (MyViewHolder) convertView.getTag();
                holder.item = convertView;
            }
            holder.position = position;




            return holder;
        }

        @SuppressWarnings("unchecked")
        public <T extends View> T getView(int id) {
            T t = (T) mViews.get(id);
            if (t == null) {
                t = (T) item.findViewById(id);
                mViews.put(id, t);
            }
            return t;
        }


        /**
         * 获取当前条目
         */
        public View getItemView() {
            return item;
        }

        /**
         * 获取条目位置
         */
        public int getItemPosition() {
            return position;
        }

        /**
         * 设置文字
         */
        public MyViewHolder setText(int id, CharSequence text) {
            View view = getView(id);
            if (view instanceof TextView) {
                ((TextView) view).setText(text);
            }
            return this;
        }

        /**
         * 设置图片
         */
        public MyViewHolder setImageResource(int id, int drawableRes) {
            View view = getView(id);
            if (view instanceof ImageView) {
                ((ImageView) view).setImageResource(drawableRes);
            } else {
                view.setBackgroundResource(drawableRes);
            }
            return this;
        }

    }
}
