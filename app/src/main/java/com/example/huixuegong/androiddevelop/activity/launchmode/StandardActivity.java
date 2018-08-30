package com.example.huixuegong.androiddevelop.activity.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;

public class StandardActivity extends LaunchModeActivity {
    private final static String TAG = StandardActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

        final String taskId = String.valueOf(StandardActivity.this.getTaskId());
        final String objectMsg = StandardActivity.this.toString();

        Log.d(TAG, "Current task id = " + taskId);
        Button btn = (Button) findViewById(R.id.btn_standard);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StandardActivity.this, StandardActivity.class);
                startActivity(intent);
                Toast.makeText(StandardActivity.this, "current task id = " + taskId + "\n" + objectMsg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
