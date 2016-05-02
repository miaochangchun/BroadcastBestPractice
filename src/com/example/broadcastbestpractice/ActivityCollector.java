package com.example.broadcastbestpractice;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityCollector {
	public static List<Activity> activities = new ArrayList<Activity>();
	/**
	 * 添加Activity活动到list集合
	 * @param activity
	 */
	public static void addActivity(Activity activity){
		activities.add(activity);
	}
	/**
	 * 删除Activity活动
	 * @param activity
	 */
	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}
	/**
	 * 关闭所有Activity活动
	 */
	public static void finishAll(){
		for(Activity activity : activities){
			if(!activity.isFinishing()){
				activity.finish();
			}
		}
	}
}
