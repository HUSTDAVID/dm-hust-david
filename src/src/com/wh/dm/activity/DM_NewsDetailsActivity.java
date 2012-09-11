
package com.wh.dm.activity;

import com.wh.dm.R;
import com.wh.dm.widget.NewsReplyAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DM_NewsDetailsActivity extends Activity {

    LayoutInflater mInflater;
    private ListView lvNews;
    private View newsMessage;
    private EditText edtxMyReply;
    private Button btnMyShare;
    private Button btnMyFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_news_details);

        initViews();
    }

    private void initViews() {

        mInflater = getLayoutInflater();
        lvNews = (ListView) findViewById(R.id.lv_news_details);
        // news body message
        newsMessage = (View) mInflater.inflate(R.layout.news_details, null);
        TextView newsTitle = (TextView) newsMessage.findViewById(R.id.txt_news_title);
        TextView newsTime = (TextView) newsMessage.findViewById(R.id.txt_news_time);
        TextView newsSource = (TextView) newsMessage.findViewById(R.id.txt_news_source);
        TextView newsBody = (TextView) newsMessage.findViewById(R.id.txt_news_body);
        // add news body data
        newsTitle.setText(getResources().getString(R.string.news_title));
        newsTime.setText(getResources().getString(R.string.news_time));
        newsSource.setText(getResources().getString(R.string.news_source));
        newsBody.setText(getResources().getString(R.string.news_body));

        edtxMyReply = (EditText) findViewById(R.id.edtx_news_my_reply);
        btnMyShare = (Button) findViewById(R.id.btn_news_share);
        btnMyFavorite = (Button) findViewById(R.id.btn_news_my_favorite);

        lvNews.addHeaderView(newsMessage);
        NewsReplyAdapter adapter = new NewsReplyAdapter(this);
        // for (int i = 0; i < 10; i++) {
        adapter.addItem("手机版网友", "13小时前", "真搞笑，银行多给了就要回，少给了离柜不负责！", "顶");
        // }
        lvNews.setAdapter(adapter);

        btnMyShare.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                String str = edtxMyReply.getText().toString();
                Toast.makeText(DM_NewsDetailsActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
