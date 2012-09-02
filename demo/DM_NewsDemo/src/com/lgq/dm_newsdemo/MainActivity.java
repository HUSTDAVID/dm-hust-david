package com.lgq.dm_newsdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView listview;
	
	//滑动图片集合
	private ArrayList<View> imagePageViews = null;
	private ViewPager viewPager = null;
	//当前ViewPager索引
	private int pageIndex = 0;
	

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
       // addData();
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private void init()
    {
    	//listview = (ListView)findViewById(R.id.listview_news);
    	imagePageViews = new ArrayList<View>(); 
    	
    	//添加四个imageview ，四张不同图片
    	ImageView imageView1 = new ImageView(this);
    	imageView1.setBackgroundDrawable(getResources().getDrawable(R.drawable.image01));
    	imagePageViews.add(imageView1);
    	ImageView imageView2 = new ImageView(this);
    	imageView1.setBackgroundDrawable(getResources().getDrawable(R.drawable.image02));
    	imagePageViews.add(imageView2);
    	ImageView imageView3 = new ImageView(this);
    	imageView1.setBackgroundDrawable(getResources().getDrawable(R.drawable.image03));
    	imagePageViews.add(imageView3);
    	ImageView imageView4 = new ImageView(this);
    	imageView1.setBackgroundDrawable(getResources().getDrawable(R.drawable.image04));
    	imagePageViews.add(imageView4);
    	
    	
    	viewPager = (ViewPager)findViewById(R.id.image_slide_page);
    	viewPager.setAdapter(new SlideImageAdapter());
    	viewPager.setCurrentItem(1);
    }
    
   
    
    private void addData()
    {
    	NewsAdapter adapter = new NewsAdapter(this);
    	//添加数据
    	for(int i=0; i<10; i++)
    	{
    		Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.news_item_image);
    	    String title = i + getResources().getString(R.string.title);
    	    String body = getResources().getString(R.string.body);
    	    adapter.addItem(bmp, title, body);
    	}
    	//添加header
    	//LayoutInflater mInflater = LayoutInflater.from(this);
    	//View header = mInflater.inflate(R.layout.news_list_header, null);
    	//listview.addHeaderView(header);
    	
    	listview.setAdapter(adapter);
    }
    
    //滑动图片数据适配器
    private class SlideImageAdapter extends PagerAdapter
    {

		@Override
		public int getCount() {
			
			return imagePageViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager)container).removeView(imagePageViews.get(position));
		}

		@Override
		public int getItemPosition(Object object) {
			
			return super.getItemPosition(object);
		}

		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager)container).addView((ImageView)imagePageViews.get(position));
			return imagePageViews.get(position);
		}
    	
    }
    
    //滑动页面更改事件监听
    private class ImagePageChangeListener implements OnPageChangeListener
    {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int index) {
			pageIndex = index;
						
		}
    	
    }
}
