package com.example.huixuegong.androiddevelop.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;

public class LocalActivity extends Activity {
    private LocalReceiver receiver;
    private IntentFilter intentFilter;
    private LocalBroadcastManager localBroadcastManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        receiver = new LocalReceiver();
        intentFilter = new IntentFilter();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        /*Register Receiver*/
        intentFilter.addAction("com.example.huixuegong.androiddevelop.LOCAL_BROADCAST");
        localBroadcastManager.registerReceiver(receiver, intentFilter);

        Button button = findViewById(R.id.btn_local);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.huixuegong.androiddevelop.LOCAL_BROADCAST");
                intent.putExtra("msg", "msg from LocalActivity");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    public class LocalReceiver extends BroadcastReceiver {
        private String msg = "";
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.hasExtra("msg"))
                msg = intent.getStringExtra("msg");
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(receiver);
    }
}
