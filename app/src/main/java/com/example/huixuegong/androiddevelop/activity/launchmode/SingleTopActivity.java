package com.example.huixuegong.androiddevelop.activity.launchmode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;

public class SingleTopActivity extends LaunchModeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);

        final String taskId = String.valueOf(getTaskId());
        final String objectMsg = SingleTopActivity.this.toString();
        Button btn =  (Button) findViewById(R.id.btn_singletop);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleTopActivity.this, SingleTopActivity.class);
                startActivity(intent);
                Toast.makeText(SingleTopActivity.this, "current task id = " + taskId + "\n" + objectMsg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
