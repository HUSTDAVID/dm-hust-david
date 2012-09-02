
package com.lgq.dm_newsimageslidedemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends Activity {

    private ViewPager viewPager;
    private List<ImageView> imageViews; // 滑动图片的集合
    private String[] titles; // 图片标题集合
    private int[] ImageResId; // 图片ID集合
    private List<View> dots; // 图片的点

    private TextView txt_title;
    private int currentItem = 0;

    // 自动切换图片使用的,在onstart初始化并启动，在onstop停止
    private ScheduledExecutorService scheduled;

    // 切换当前显示的图片
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            viewPager.setCurrentItem(currentItem);// 切换当前显示的图片
        };
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    protected void onStart() {

        scheduled = Executors.newSingleThreadScheduledExecutor();
        scheduled.scheduleAtFixedRate(new ScrollTask(), 1, 4, TimeUnit.SECONDS);
        super.onStart();
    }

    @Override
    protected void onStop() {

        scheduled.shutdown();
        super.onStop();
    }

    /*
     * 执行切换任务
     */
    private class ScrollTask implements Runnable {

        @Override
        public void run() {

            synchronized (viewPager) {
                currentItem = (currentItem + 1) % imageViews.size();
                handler.obtainMessage().sendToTarget();
            }

        }

    }

    private void init() {

        txt_title = (TextView) findViewById(R.id.txt_news_title);
        viewPager = (ViewPager) findViewById(R.id.vp_news_image_slide);

        // 图片资源id
        ImageResId = new int[] {
                R.drawable.image01, R.drawable.image02, R.drawable.image03, R.drawable.image04
        };
        // 图片标题
        titles = new String[ImageResId.length];
        titles[0] = "这里是标题一呀一呀有木有";
        titles[1] = "这里是标题二呀二呀有木有";
        titles[2] = "这里是标题三呀三呀有木有";
        titles[3] = "这里是标题四呀四呀有木有";
        // 初始化滑动图片资源
        imageViews = new ArrayList<ImageView>();
        for (int i = 0; i < ImageResId.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(ImageResId[i]);
            imageView.setScaleType(ScaleType.CENTER_CROP);
            imageViews.add(imageView);
        }
        // 初始化图片上的点
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.view_news_dot0));
        dots.add(findViewById(R.id.view_news_dot1));
        dots.add(findViewById(R.id.view_news_dot2));
        dots.add(findViewById(R.id.view_news_dot3));

        // 开始时的标题
        txt_title.setText(titles[0]);

        viewPager.setAdapter(new MyAdapter());
        viewPager.setOnPageChangeListener(new MyPageChangeListener());
    }

    /*
     * 当ViewPager中页面的状态发生改变时调用
     */
    private class MyPageChangeListener implements OnPageChangeListener {

        private int oldPosition = 0;

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {

            currentItem = position;
            txt_title.setText(titles[position]);
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(position).setBackgroundResource(R.drawable.dot_focused);
            oldPosition = position;
        }

    }

    /*
     * 填充ViewPager页面的适配器
     */
    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {

            return ImageResId.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {

            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            ((ViewPager) container).removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ((ViewPager) container).addView(imageViews.get(position));
            return imageViews.get(position);
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {

        }

        @Override
        public void finishUpdate(ViewGroup container) {

        }

        @Override
        public void startUpdate(View container) {

        }

    }

}
