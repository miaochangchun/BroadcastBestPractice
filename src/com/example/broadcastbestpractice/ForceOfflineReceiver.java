package com.example.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * 强制下线广播接收器
 * @author Miao
 *
 */
public class ForceOfflineReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		//对话框 
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setTitle("Warning");
		//正文
		dialogBuilder.setMessage("You are forced to be offline. Please try to login again.");
		//不可取消 
		dialogBuilder.setCancelable(false);
		//按钮
		dialogBuilder.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//销毁所有活动
						ActivityCollector.finishAll();
						//启动登陆活动
						Intent intent = new Intent(context, LoginActivity.class);
						//在广播中启动活动，需要添加如下代码
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						context.startActivity(intent);
					}
				});
		AlertDialog alertDialog = dialogBuilder.create();
		//添加对话框类型：保证在广播中正常弹出 
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		//对话框展示 
		alertDialog.show();
	}

}
