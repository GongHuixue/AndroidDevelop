package com.example.huixuegong.androiddevelop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.huixuegong.androiddevelop.R;

public class SubActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Intent mainIntent = getIntent();
        String msg = mainIntent.getStringExtra("Main");
        TextView textView = findViewById(R.id.text_sub);
        Button button = findViewById(R.id.button_sub);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubActivity.this, ResultActivity.class);
                String subMsg = "From Sub Activity";
                intent.putExtra("Sub", subMsg);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        textView.setText(msg);
    }
}
