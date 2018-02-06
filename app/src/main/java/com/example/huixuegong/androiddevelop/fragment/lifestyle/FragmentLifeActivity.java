package com.example.huixuegong.androiddevelop.fragment.lifestyle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.huixuegong.androiddevelop.R;
import com.example.huixuegong.androiddevelop.activity.HelloWorldActivity;

public class FragmentLifeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_life);

        final Button startActivity, addFragment, replaceFragment, finish;
        startActivity = findViewById(R.id.start_activity);
        addFragment = findViewById(R.id.add_fragment);
        replaceFragment = findViewById(R.id.replace_fragment);
        finish = findViewById(R.id.finish);

        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentLifeActivity.this, HelloWorldActivity.class);
                startActivity(intent);
            }
        });

        addFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LifeStyleFragment fragment = new LifeStyleFragment();
                getFragmentManager().beginTransaction().replace(R.id.linerContainer, fragment).commit();
            }
        });

        replaceFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment fragment = new SecondFragment();
                getFragmentManager().beginTransaction().replace(R.id.linerContainer, fragment).commit();
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentLifeActivity.this.finish();
            }
        });
    }
}
