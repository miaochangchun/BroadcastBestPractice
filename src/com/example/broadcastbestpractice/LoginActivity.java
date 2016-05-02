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
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		accountEdit = (EditText) findViewById(R.id.account);
		passwordEdit = (EditText) findViewById(R.id.password);
		rememberPass = (CheckBox) findViewById(R.id.remember_password);
		login = (Button) findViewById(R.id.login);
		boolean isRememberPass = pref.getBoolean("remember_password", false);
		if(isRememberPass){
			String account = pref.getString("account", "");
			String password = pref.getString("password", "");
			accountEdit.setText(account);
			passwordEdit.setText(password);
			rememberPass.setChecked(true);
		}
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
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
				}else {
					Toast.makeText(LoginActivity.this, "account or password is invalid!", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
	
}
