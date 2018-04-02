package com.example.huixuegong.androiddevelop.adapter;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.huixuegong.androiddevelop.R;

public class ArrayAdapterActivity extends Activity {
    private String[] os = {"Android", "Iphone", "Linux", "Ubuntu", "Sybain", "Flyme", "Mi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);
        ListView lv = findViewById(R.id.array_list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ArrayAdapterActivity.this, android.R.layout.simple_list_item_1, os);
        lv.setAdapter(arrayAdapter);
    }
}

/*
public class ArrayAdapterActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        String[] os = {"Android", "Iphone", "Linux", "Ubuntu", "Sybain", "Flyme", "Mi"};
        ArrayAdapter<String>arrayAdapter = new ArrayAdapter<String>(ArrayAdapterActivity.this, android.R.layout.simple_list_item_1, os);
        setListAdapter(arrayAdapter);
    }
}
*/