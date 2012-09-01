package com.lgq.dm_newsdemo;

import java.util.ArrayList;
import java.util.Map;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class NewsAdapter extends BaseAdapter {

	ArrayList<Map<String,Object>> mData = new ArrayList<Map<String,Object>>();
	
	public void addItem(Bitmap bmp, String title, String body)
	{
		Map<String, Object> map = new HashMap<String, Object>;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

}
