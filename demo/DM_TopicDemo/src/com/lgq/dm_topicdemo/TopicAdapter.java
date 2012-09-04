
package com.lgq.dm_topicdemo;

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

public class TopicAdapter extends BaseAdapter {

    ArrayList<HashMap<String, Object>> mData;
    LayoutInflater inflater;
    Context context;

    public TopicAdapter(Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);
        mData = new ArrayList<HashMap<String, Object>>();
    }

    public void addItem(Bitmap bmp, String title) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("image", bmp);
        map.put("title", title);
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
            convertView = inflater.inflate(R.layout.topic_gridview_item, null);
            holder.image = (ImageView) convertView.findViewById(R.id.img_topic_item);
            holder.txt_title = (TextView) convertView.findViewById(R.id.txt_topic_item);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.image.setImageBitmap((Bitmap) mData.get(position).get("image"));
        holder.txt_title.setText(mData.get(position).get("title").toString());

        return convertView;
    }

    public static class ViewHolder {
        public ImageView image;
        public TextView txt_title;
    }

}
