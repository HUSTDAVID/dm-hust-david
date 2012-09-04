
package com.lgq.dm_topicdemo;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends Activity {

    GridView gv_topic;

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

    private void init() {

        gv_topic = (GridView) findViewById(R.id.gv_topic);
        TopicAdapter adapter = new TopicAdapter(this);

        LayoutInflater inflater = LayoutInflater.from(this);
        View header = inflater.inflate(R.layout.dm_topic_header, null);

        // 添加测试数据
        adapter.addItem(BitmapFactory.decodeResource(getResources(), R.drawable.topic_image2),
                getResources().getString(R.string.title2));
        adapter.addItem(BitmapFactory.decodeResource(getResources(), R.drawable.topic_image2),
                getResources().getString(R.string.title3));
        adapter.addItem(BitmapFactory.decodeResource(getResources(), R.drawable.topic_image2),
                getResources().getString(R.string.title4));
        adapter.addItem(BitmapFactory.decodeResource(getResources(), R.drawable.topic_image2),
                getResources().getString(R.string.title5));
        adapter.addItem(BitmapFactory.decodeResource(getResources(), R.drawable.topic_image2),
                getResources().getString(R.string.title2));
        adapter.addItem(BitmapFactory.decodeResource(getResources(), R.drawable.topic_image2),
                getResources().getString(R.string.title3));
        adapter.addItem(BitmapFactory.decodeResource(getResources(), R.drawable.topic_image2),
                getResources().getString(R.string.title4));
        adapter.addItem(BitmapFactory.decodeResource(getResources(), R.drawable.topic_image2),
                getResources().getString(R.string.title5));

        gv_topic.setAdapter(adapter);

        gv_topic.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long row) {

                TopicAdapter adapter = (TopicAdapter) parent.getAdapter();
                HashMap<String, Object> map = (HashMap<String, Object>) adapter.getItem(position);
                String title = map.get("title").toString();
                Toast.makeText(MainActivity.this, "点击查看:" + title, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
