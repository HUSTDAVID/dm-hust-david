
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
    private List<ImageView> imageViews; // ����ͼƬ�ļ���
    private String[] titles; // ͼƬ���⼯��
    private int[] ImageResId; // ͼƬID����
    private List<View> dots; // ͼƬ�ĵ�

    private TextView txt_title;
    private int currentItem = 0;

    // �Զ��л�ͼƬʹ�õ�,��onstart��ʼ������������onstopֹͣ
    private ScheduledExecutorService scheduled;

    // �л���ǰ��ʾ��ͼƬ
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            viewPager.setCurrentItem(currentItem);// �л���ǰ��ʾ��ͼƬ
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
     * ִ���л�����
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

        // ͼƬ��Դid
        ImageResId = new int[] {
                R.drawable.image01, R.drawable.image02, R.drawable.image03, R.drawable.image04
        };
        // ͼƬ����
        titles = new String[ImageResId.length];
        titles[0] = "�����Ǳ���һѽһѽ��ľ��";
        titles[1] = "�����Ǳ����ѽ��ѽ��ľ��";
        titles[2] = "�����Ǳ�����ѽ��ѽ��ľ��";
        titles[3] = "�����Ǳ�����ѽ��ѽ��ľ��";
        // ��ʼ������ͼƬ��Դ
        imageViews = new ArrayList<ImageView>();
        for (int i = 0; i < ImageResId.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(ImageResId[i]);
            imageView.setScaleType(ScaleType.CENTER_CROP);
            imageViews.add(imageView);
        }
        // ��ʼ��ͼƬ�ϵĵ�
        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.view_news_dot0));
        dots.add(findViewById(R.id.view_news_dot1));
        dots.add(findViewById(R.id.view_news_dot2));
        dots.add(findViewById(R.id.view_news_dot3));

        // ��ʼʱ�ı���
        txt_title.setText(titles[0]);

        viewPager.setAdapter(new MyAdapter());
        viewPager.setOnPageChangeListener(new MyPageChangeListener());
    }

    /*
     * ��ViewPager��ҳ���״̬�����ı�ʱ����
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
     * ���ViewPagerҳ���������
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
