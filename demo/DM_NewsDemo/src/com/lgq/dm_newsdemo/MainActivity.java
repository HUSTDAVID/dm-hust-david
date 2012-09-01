package com.lgq.dm_newsdemo;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView listview;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
        addData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private void init()
    {
    	listview = (ListView)findViewById(R.id.listview_news);
    	
    }
    
    private void addData()
    {
    	NewsAdapter adapter = new NewsAdapter(this);
    	for(int i=0; i<6; i++)
    	{
    		Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.news_item_image);
    	    String title = getResources().getString(R.string.title);
    	    String body = getResources().getString(R.string.body);
    	    adapter.addItem(bmp, title, body);
    	}
    	
    	listview.setAdapter(adapter);
    }
    
}
