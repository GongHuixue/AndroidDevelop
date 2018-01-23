package com.example.huixuegong.androiddevelop.activity.launchmode;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huixue.gong on 2018/1/23.
 */

public class ActivityCollector {
    public static List<Activity> list = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        list.add(activity);
    }

    public static void removeActivity(Activity activity) {
        list.remove(activity);
    }

    public static void finishAll() {
        for(Activity activity:list) {
            if(!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
