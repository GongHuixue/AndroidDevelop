package com.example.huixuegong.androiddevelop.adapter;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.huixuegong.androiddevelop.R;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter( new SimpleAdapter(this, getListData(), R.layout.activity_simple_adapter,
                new String[]{"name", "gender"}, new int[]{R.id.name, R.id.gender}));
    }

    private List<Map<String, Object>> getListData() {
        List<Map<String, Object>> listData = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Jack");
        map.put("gender", "man");
        listData.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "Jaky");
        map.put("gender", "man");
        listData.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "Rose");
        map.put("gender", "woman");
        listData.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "Kitty");
        map.put("gender", "woman");
        listData.add(map);

        return listData;
    }
}
