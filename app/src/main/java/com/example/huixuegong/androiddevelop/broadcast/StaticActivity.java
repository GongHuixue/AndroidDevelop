package com.example.huixuegong.androiddevelop.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;

public class StaticActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static);

        Button button = (Button) findViewById(R.id.btn_sendbroadcast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.huixuegong.androiddevelop.broadcast.MyBroadcastReceiver");
                intent.putExtra("msg", "msg from staticActivity");
                sendBroadcast(intent);

                Toast.makeText(StaticActivity.this, "send broadcast from staticActivity[action not match]", Toast.LENGTH_LONG).show();
            }
        });
    }
}
