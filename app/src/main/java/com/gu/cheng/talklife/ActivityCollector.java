package com.gu.cheng.talklife;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guangcheng.Zhang on 2016/6/14 21:58.
 * Email:zhang411988153@163.com
 */

public class ActivityCollector {
    public static List<Activity> activityList = new ArrayList<Activity>();


    /**
     * add activity to control app
     * @param activity
     */
    public static void addActivity(Activity activity) {
        if (!activityList.contains(activity)) {
            activityList.add(activity);
        }
    }

    public static void removeActivity(Activity activity) {
        if (activityList.contains(activity)) {
            activityList.remove(activity);
        }
    }

    public static void finishAll() {
        for (Activity activity : activityList) {
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}
