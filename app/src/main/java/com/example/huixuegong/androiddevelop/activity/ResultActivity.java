package com.example.huixuegong.androiddevelop.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.huixuegong.androiddevelop.R;

public class ResultActivity extends Activity {

    private Button button;
    private TextView textView;
    private final static int Sub = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = (TextView) findViewById(R.id.text_main);
        button = (Button) findViewById(R.id.button_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, SubActivity.class);
                String content = "From Main Activity";
                intent.putExtra("Main", content);
                startActivityForResult(intent, Sub);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch(requestCode) {
            case Sub:
                Bundle sub = intent.getExtras();
                String msg = sub.getString("Sub");
                textView.setText(msg);
                break;
            default:
                break;
        }
    }
}
