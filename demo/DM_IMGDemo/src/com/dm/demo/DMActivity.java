package com.dm.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

public class DMActivity extends Activity {
  
    private ListView lv_dm;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dm_img_activity);
        lv_dm =(ListView)findViewById(R.id.lv_img);
        MutiItemAdapter adapter = new MutiItemAdapter(this);     
        LayoutInflater inflater = LayoutInflater.from(this);
        View header = inflater.inflate(R.layout.dm_img_header, null);
        lv_dm.addHeaderView(header);
        
        for(int i=0;i<10;i++){
            if(i%2==0){
                adapter.addItemType2("item"+i);
            }else{
                adapter.addItemType1("item"+i);
            }
        }
        lv_dm.setAdapter(adapter);
        
       
    }
}