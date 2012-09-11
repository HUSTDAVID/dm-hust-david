
package com.wh.dm.activity;

import com.wh.dm.R;
import com.wh.dm.widget.TopicAdapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DM_TopicActivity extends Activity {

    LayoutInflater mInfalater;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_topic);

        init();
    }

    private void init() {

        mInfalater = getLayoutInflater();
        listView = (ListView) findViewById(R.id.lv_topic);

        // add header
        View headerView = mInfalater.inflate(R.layout.header_topic, null);
        ImageView headerImg = (ImageView) headerView.findViewById(R.id.img_topic_header);
        headerImg.setBackgroundResource(R.drawable.banner02);
        TextView headerTxt = (TextView) headerView.findViewById(R.id.txt_topic_header);
        headerTxt.setText("这里是标题");
        listView.addHeaderView(headerView);

        // set adapter
        TopicAdapter adapter = new TopicAdapter(this);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.topic_img);
        String title = "这里就是传说中的标题";
        for (int i = 0; i < 5; i++) {
            adapter.addItem(bmp, bmp, title, title);
        }
        listView.setAdapter(adapter);
    }

}
