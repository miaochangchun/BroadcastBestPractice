package com.example.broadcastbestpractice;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity{

	/**
	 * ���л�Ļ���
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//ÿ����һ������ͼ��뵽��������� 
		ActivityCollector.addActivity(this);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//ÿ����һ������ʹӻ���������Ƴ�
		ActivityCollector.removeActivity(this);
	}
	
	
}
