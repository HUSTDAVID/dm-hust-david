
package com.wh.dm.widget;

import com.wh.dm.R;

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

public class TopicAdapter extends BaseAdapter {

    ArrayList<Map<String, Object>> mData;
    LayoutInflater mInflater;

    public TopicAdapter(Context context) {

        mData = new ArrayList<Map<String, Object>>();
        mInflater = LayoutInflater.from(context);
    }

    public void addItem(Bitmap leftBmp, Bitmap rightBmp, String leftTitle, String rightTitle) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("leftImage", leftBmp);
        map.put("leftTitle", leftTitle);
        map.put("rightImage", rightBmp);
        map.put("rightTitle", rightTitle);
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
            convertView = mInflater.inflate(R.layout.topic_item, null);
            holder.imgLeft = (ImageView) convertView.findViewById(R.id.img_topic_item_left);
            holder.imgRight = (ImageView) convertView.findViewById(R.id.img_topic_item_right);
            holder.txtLeft = (TextView) convertView.findViewById(R.id.txt_topic_item_left);
            holder.txtRight = (TextView) convertView.findViewById(R.id.txt_topic_item_right);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imgLeft.setImageBitmap((Bitmap) mData.get(position).get("leftImage"));
        holder.imgRight.setImageBitmap((Bitmap) mData.get(position).get("rightImage"));
        holder.txtLeft.setText(mData.get(position).get("leftTitle").toString());
        holder.txtRight.setText(mData.get(position).get("rightTitle").toString());

        return convertView;
    }

    static class ViewHolder {
        ImageView imgLeft;
        ImageView imgRight;
        TextView txtLeft;
        TextView txtRight;

    }

}
