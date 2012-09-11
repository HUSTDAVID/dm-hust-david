
package com.wh.dm.activity;

import com.wh.dm.R;
import com.wh.dm.widget.SubscibeRightAdapter;
import com.wh.dm.widget.SubscribeLeftAdapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.HashMap;

public class DM_SubActivity extends Activity {

    ListView lvSubLeft;
    ListView lvSubRight;

    int currentItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_subscibe);

        initViews();
        loadDataLeft();
        loadDataRight(0);
    }

    private void initViews() {

        lvSubLeft = (ListView) findViewById(R.id.lv_sub_left);
        lvSubRight = (ListView) findViewById(R.id.lv_sub_right);
    }

    private void loadDataLeft() {

        String[] typeStr = {
                "房产", "汽车", "生活", "旅游", "时尚"
        };
        Bitmap bmp = (Bitmap) BitmapFactory.decodeResource(getResources(), R.drawable.sub_left1);
        Bitmap[] typeBmp = {
                bmp, bmp, bmp, bmp, bmp
        };

        SubscribeLeftAdapter leftAdapter = new SubscribeLeftAdapter(DM_SubActivity.this);
        for (int i = 0; i < typeStr.length; i++) {
            leftAdapter.addItem(typeStr[i], typeBmp[i], i);
        }
        lvSubLeft.setAdapter(leftAdapter);

        lvSubLeft.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String, Object> map = (HashMap<String, Object>) parent.getAdapter()
                        .getItem(position);
                int leftId = (Integer) map.get("id");
                /*
                 * parent.getChildAt(currentItem).setBackgroundColor(
                 * getResources().getColor(R.color.sub_left_bg));
                 * view.setBackgroundColor
                 * (getResources().getColor(R.color.sub_right_bg));
                 */
                currentItem = position;

                loadDataRight(leftId);
            }
        });

    }

    private void loadDataRight(int leftId) {

        String[] leftStr = {
                "房产", "汽车", "生活", "旅游", "时尚"
        };
        String[] rightStr = new String[10];

        SubscibeRightAdapter rightAdapter = new SubscibeRightAdapter(DM_SubActivity.this);
        for (int i = 0; i < 10; i++) {
            rightStr[i] = "这里是" + leftStr[leftId] + i;
            rightAdapter.addItem(rightStr[i], false, leftId);
        }

        lvSubRight.setAdapter(rightAdapter);
    }
}
