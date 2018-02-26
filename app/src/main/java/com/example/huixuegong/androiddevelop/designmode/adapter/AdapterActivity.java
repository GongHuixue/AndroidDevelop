package com.example.huixuegong.androiddevelop.designmode.adapter;

import android.app.Activity;
import android.os.Bundle;

import com.example.huixuegong.androiddevelop.R;

public class AdapterActivity extends Activity {
    private FiveVolt voltAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        voltAdapter = new VoltAdapter(new Volt220());
        voltAdapter.get5Volt();
    }
}
