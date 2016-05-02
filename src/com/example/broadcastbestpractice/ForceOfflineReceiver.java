package com.example.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * ǿ�����߹㲥������
 * @author Miao
 *
 */
public class ForceOfflineReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		//�Ի��� 
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
		dialogBuilder.setTitle("Warning");
		//����
		dialogBuilder.setMessage("You are forced to be offline. Please try to login again.");
		//����ȡ�� 
		dialogBuilder.setCancelable(false);
		//��ť
		dialogBuilder.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//�������л
						ActivityCollector.finishAll();
						//������½�
						Intent intent = new Intent(context, LoginActivity.class);
						//�ڹ㲥�����������Ҫ������´���
						intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						context.startActivity(intent);
					}
				});
		AlertDialog alertDialog = dialogBuilder.create();
		//��ӶԻ������ͣ���֤�ڹ㲥���������� 
		alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		//�Ի���չʾ 
		alertDialog.show();
	}

}
