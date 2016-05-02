package com.example.broadcastbestpractice;

import com.example.broadcastbestpratice.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

	private EditText accountEdit;
	private EditText passwordEdit;
	private Button login;
	private CheckBox rememberPass;
	private SharedPreferences pref;
	private SharedPreferences.Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//首先调用父类的方法
		super.onCreate(savedInstanceState);
		//加载登陆布局
		setContentView(R.layout.login);
		//android系统下用于数据存储的一个方便的API,
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		//获取输入内容
		accountEdit = (EditText) findViewById(R.id.account);
		passwordEdit = (EditText) findViewById(R.id.password);
		rememberPass = (CheckBox) findViewById(R.id.remember_password);
		login = (Button) findViewById(R.id.login);
		boolean isRememberPass = pref.getBoolean("remember_password", false);
		//进入界面时，这个if用来判断SharedPreferences里面name和password有没有数据，有的话则直接打在EditText上面
		if(isRememberPass){
			String account = pref.getString("account", "");
			String password = pref.getString("password", "");
			accountEdit.setText(account);
			passwordEdit.setText(password);
			rememberPass.setChecked(true);
		}
		//注册按钮点击事件
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String accountString = accountEdit.getText().toString();
				String passwString = passwordEdit.getText().toString();
				if(accountString.equalsIgnoreCase("admin") && passwString.equalsIgnoreCase("123456")){
					editor = pref.edit();
					if (rememberPass.isChecked()) {
						editor.putBoolean("remember_password", true);
						editor.putString("account", accountString);
						editor.putString("password", passwString);
					}else {
						editor.clear();
					}
					editor.commit();
					//登陆成功，启用MainActivity活动 
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					//启动
					startActivity(intent);
					//当前活动销毁 
					finish();
				}else {
					//登陆失败，清空内容
					Toast.makeText(LoginActivity.this, "account or password is invalid!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
}
