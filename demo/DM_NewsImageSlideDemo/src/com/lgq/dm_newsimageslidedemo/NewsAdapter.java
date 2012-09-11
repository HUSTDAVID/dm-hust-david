
package com.lgq.dm_newsimageslidedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewsAdapter extends BaseAdapter {

    private ArrayList<Map<String, Object>> mData;
    private LayoutInflater mInflater;

    public NewsAdapter(Context context) {

        mData = new ArrayList<Map<String, Object>>();
        mInflater = LayoutInflater.from(context);
    }

    public void addItem(Bitmap bmp, String title, String body) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("image", bmp);
        map.put("title", title);
        map.put("body", body);

        mData.add(map);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {

        return mData.size();
    }

    @Override
    public Object getItem(int position) {

        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.news_item, null);
            holder.image = (ImageView) convertView.findViewById(R.id.img_news_item);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.txt_news_item_title);
            holder.txtBody = (TextView) convertView.findViewById(R.id.txt_news_item_body);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.image.setImageBitmap((Bitmap) mData.get(position).get("image"));
        holder.txtTitle.setText(mData.get(position).get("title").toString());
        holder.txtBody.setText(mData.get(position).get("body").toString());
        return convertView;
    }

    public static class ViewHolder {
        public ImageView image;
        public TextView txtTitle;
        public TextView txtBody;
    }

}
