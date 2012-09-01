package com.example.dm_collectdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends Activity {
  
    private ListView collect_list;
    List<Map<String,Object>> list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dm_activity_main);
        collect_list =(ListView)findViewById(R.id.list);
        
        
        list = new ArrayList<Map<String,Object>>();    
        LayoutInflater inflater = LayoutInflater.from(this);
        View header = inflater.inflate(R.layout.header, null);
        collect_list.addHeaderView(header);
        
        for(int i=0;i<5;i++){
            Map<String,Object> map =new  HashMap<String,Object>();
            map.put("txt_collect_title", "为何美国人拿的奥运奖牌比我们多") ;  
            map.put("txt_collect_body","收藏时间：2012-12-30  16：12") ;
            map.put("check",true ) ;
            list.add(map);
        }
        ItemAdapter adapter = new ItemAdapter(this, list);
        collect_list.setAdapter(adapter);   
   
    }    
    
}