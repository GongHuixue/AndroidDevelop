package com.example.huixuegong.androiddevelop.designmode.singleInstance;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;

public class SingleInstanceActivity extends Activity {
    private Singleton singleInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);

        Button single = (Button) findViewById(R.id.single);
        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleInstance = Singleton.getInstance();
                Toast.makeText(SingleInstanceActivity.this, "Singleton address is " + singleInstance, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
