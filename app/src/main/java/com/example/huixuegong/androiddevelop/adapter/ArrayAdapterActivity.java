package com.example.huixuegong.androiddevelop.adapter;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.huixuegong.androiddevelop.R;

public class ArrayAdapterActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private String[] os = {"Android", "Iphone", "Linux", "Ubuntu", "Sybain", "Flyme", "Mi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_adapter);

        listView = (ListView)findViewById(R.id.array_list);
        arrayAdapter = new ArrayAdapter<String>(ArrayAdapterActivity.this, android.R.layout.simple_list_item_1, os);

        listView.setAdapter(arrayAdapter);
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