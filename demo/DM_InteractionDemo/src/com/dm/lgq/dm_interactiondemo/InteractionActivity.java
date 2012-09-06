package com.dm.lgq.dm_interactiondemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class InteractionActivity extends Activity implements OnClickListener{

	RelativeLayout relVote;
	RelativeLayout relCritic;
	RelativeLayout relAward;
	RelativeLayout relEssence;
	RelativeLayout relDepth;
	
	Button btnVote;
	Button btnCritic;
	Button btnAward;
	Button btnEssence;
	Button btnDepth;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;     
    }
    
    private void init()
    {
    	relVote = (RelativeLayout)findViewById(R.id.rel_interaction_vote);
    	relCritic = (RelativeLayout)findViewById(R.id.rel_interaction_critic);
    	relAward = (RelativeLayout)findViewById(R.id.rel_interaction_award);
    	relEssence = (RelativeLayout)findViewById(R.id.rel_interaction_essence);
    	relDepth = (RelativeLayout)findViewById(R.id.rel_interaction_depth);
    	
    	btnVote = (Button)findViewById(R.id.btn_interaction_vote);
    	btnCritic = (Button)findViewById(R.id.btn_interaction_critic);
    	btnAward = (Button)findViewById(R.id.btn_interaction_award);
    	btnEssence = (Button)findViewById(R.id.btn_interaction_essence);
    	btnDepth = (Button)findViewById(R.id.btn_interaction_depth);
    	
    	relVote.setOnClickListener(this);
    	relCritic.setOnClickListener(this);
    	relAward.setOnClickListener(this);
    	relEssence.setOnClickListener(this);
    	relDepth.setOnClickListener(this);
    	
    	btnVote.setOnClickListener(this);
    	btnCritic.setOnClickListener(this);
    	btnAward.setOnClickListener(this);
    	btnEssence.setOnClickListener(this);
    	btnDepth.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.rel_interaction_vote:
		case R.id.btn_interaction_vote:
			Toast.makeText(InteractionActivity.this, "投票", Toast.LENGTH_SHORT).show();
			break;
		case R.id.rel_interaction_critic:
		case R.id.btn_interaction_critic:
			Toast.makeText(InteractionActivity.this, "评论", Toast.LENGTH_SHORT).show();
			break;
		case R.id.rel_interaction_award:
		case R.id.btn_interaction_award:
			Toast.makeText(InteractionActivity.this, "有奖竞猜", Toast.LENGTH_SHORT).show();
			break;
		case R.id.rel_interaction_essence:
		case R.id.btn_interaction_essence:
			Toast.makeText(InteractionActivity.this, "精华", Toast.LENGTH_SHORT).show();
			break;
		case R.id.rel_interaction_depth:
		case R.id.btn_interaction_depth:
			Toast.makeText(InteractionActivity.this, "深度", Toast.LENGTH_SHORT).show();
			break;
		}
		
	}
}
