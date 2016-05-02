package com.example.broadcastbestpractice;

import com.example.broadcastbestpratice.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private Button forceOffline;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取按钮 
        forceOffline = (Button) findViewById(R.id.force_offline);
        //注册事件 
        forceOffline.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//启用广播
				Intent intent = new Intent("com.exmaple.boradcastbestpractice.FORCE_OFFLINE");
				//发送广播--标准广播 
				sendBroadcast(intent);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
