package com.example.broadcastbestpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityCollector {
	public static List<Activity> activities = new ArrayList<Activity>();
	/**
	 * ���Activity���list����
	 * @param activity
	 */
	public static void addActivity(Activity activity){
		activities.add(activity);
	}
	/**
	 * ɾ��Activity�
	 * @param activity
	 */
	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}
	/**
	 * �ر�����Activity�
	 */
	public static void finishAll(){
		for(Activity activity : activities){
			if(!activity.isFinishing()){
				activity.finish();
			}
		}
	}
}
