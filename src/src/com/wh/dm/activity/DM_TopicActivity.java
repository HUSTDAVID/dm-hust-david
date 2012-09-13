
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

    ImageView imgLogo;
    TextView txtTitle;

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
        headerTxt.setText("五月天 请带我一起 将须臾活成不朽");
        listView.addHeaderView(headerView);

        // header
        imgLogo = (ImageView) findViewById(R.id.img_logo);
        txtTitle = (TextView) findViewById(R.id.txt_title);

        imgLogo.setVisibility(View.GONE);
        txtTitle.setText(getResources().getString(R.string.photo));

        // set adapter
        TopicAdapter adapter = new TopicAdapter(this);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.topic_img);
        String title = "西班牙超级杯";
        for (int i = 0; i < 5; i++) {
            adapter.addItem(bmp, bmp, title, title);
        }
        listView.setAdapter(adapter);
    }
}
