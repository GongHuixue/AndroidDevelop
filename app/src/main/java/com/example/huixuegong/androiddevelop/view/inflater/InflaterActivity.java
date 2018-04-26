package com.example.huixuegong.androiddevelop.view.inflater;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.huixuegong.androiddevelop.R;

public class InflaterActivity extends Activity {
    private LinearLayout container1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflater);

        container1 = this.findViewById(R.id.container);

        LayoutInflater inflater = LayoutInflater.from(InflaterActivity.this);
        /*inflater.inflate(R.layout.inflater_add, container1, true);

        View view = inflater.inflate(R.layout.inflater_add, container1, false);
        container1.addView(view);*/

        View view = inflater.inflate(R.layout.inflater_add, null, false);
        container1.addView(view);
    }
}
