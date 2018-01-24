package com.example.huixuegong.androiddevelop.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by huixue.gong on 2018/1/24.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    private final static String TAG = MyBroadcastReceiver.class.getSimpleName();
    private String msg = "";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.hasExtra("msg"))
            msg = intent.getStringExtra("msg");
        Log.d(TAG, "receive msg = " + msg);
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
