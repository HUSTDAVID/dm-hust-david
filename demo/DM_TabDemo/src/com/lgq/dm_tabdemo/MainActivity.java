package com.lgq.dm_tabdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	TabHost tabHost;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initTabs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
              
    }
    
    private void initTabs()
    {
    	tabHost = getTabHost();
    	
    	tabHost.addTab(tabHost.newTabSpec("xinwen")
    			.setIndicator("",null)
    			.setContent(new Intent(this,NewsActivity.class)));
    	
    	tabHost.addTab(tabHost.newTabSpec("xinwen")
    			.setIndicator("",null)
    			.setContent(new Intent(this,TopicActivity.class)));
    	
    	tabHost.addTab(tabHost.newTabSpec("xinwen")
    			.setIndicator("",null)
    			.setContent(new Intent(this,DingyueActivity.class)));
    	
    	tabHost.addTab(tabHost.newTabSpec("xinwen")
    			.setIndicator("",null)
    			.setContent(new Intent(this,ShoucangActivity.class)));
    	
    	tabHost.setCurrentTab(0);
    	
    	//设置背景，图片齐全后使用drawable设置选择与否的不同背景
    	tabHost.getTabWidget().getChildAt(0).setBackgroundDrawable(getResources().getDrawable(R.drawable.news));
    	tabHost.getTabWidget().getChildAt(1).setBackgroundDrawable(getResources().getDrawable(R.drawable.topic));
    	tabHost.getTabWidget().getChildAt(2).setBackgroundDrawable(getResources().getDrawable(R.drawable.dingyue));
    	tabHost.getTabWidget().getChildAt(3).setBackgroundDrawable(getResources().getDrawable(R.drawable.shoucang));
       
    	//取消底部白线
    	 tabHost.setPadding(tabHost.getPaddingLeft(), tabHost.getPaddingTop(), 
                 tabHost.getPaddingRight(), tabHost.getPaddingBottom()-5);
    }
}
