package com.example.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity{

	/**
	 * 所有活动的基类
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//每创建一个活动，就加入到活动管理器中 
		ActivityCollector.addActivity(this);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//每销毁一个活动，就从活动管理器中移除
		ActivityCollector.removeActivity(this);
	}
	
	
}
