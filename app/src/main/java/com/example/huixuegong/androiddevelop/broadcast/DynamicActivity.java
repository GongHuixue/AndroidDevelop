package com.example.huixuegong.androiddevelop.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;

public class DynamicActivity extends Activity {

    MyBroadcastReceiver receiver = new MyBroadcastReceiver();
    IntentFilter intentFilter = new IntentFilter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        /*register receiver*/
        intentFilter.addAction("com.example.huixuegong.androiddevelop.broadcast.MyBroadcastReceiver");
        registerReceiver(receiver, intentFilter);

        Button button = (Button) findViewById(R.id.btn_dynamic);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.huixuegong.androiddevelop.broadcast.MyBroadcastReceiver");
                intent.putExtra("msg", "msg from dynamicActivity");
                sendBroadcast(intent);

                //Toast.makeText(DynamicActivity.this, "send broadcast from DynamicActivity", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
