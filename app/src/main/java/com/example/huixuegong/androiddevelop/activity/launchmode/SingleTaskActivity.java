package com.example.huixuegong.androiddevelop.activity.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;
import com.example.huixuegong.androiddevelop.activity.HelloWorldActivity;

public class SingleTaskActivity extends LaunchModeActivity {
    private String taskId = "";
    private String objectMsg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);

        taskId = String.valueOf(getTaskId());
        objectMsg = SingleTaskActivity.this.toString();
        Button btn = (Button) findViewById(R.id.btn_singletask);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTaskActivity.this, HelloWorldActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        objectMsg = SingleTaskActivity.this.toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(SingleTaskActivity.this, "current task id = " + taskId + "\n" + objectMsg, Toast.LENGTH_LONG).show();
    }
}
