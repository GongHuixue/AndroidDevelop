package com.example.huixuegong.androiddevelop.view.scroll;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewMoveActivity extends ListActivity {
    private final static String TAG = ViewMoveActivity.class.getSimpleName();

    private String[] mListData = new String[] {
            "ScrollTo ScrollBy Demo",
            "Animation Demo",
            "LayoutParams Demo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, mListData);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        Log.d(TAG, "Position = " + position + ", click");
        switch (position) {
            case 0:
                startActivity(new Intent(this, ScrollActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, AnimationActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, LayoutParamsActivity.class));
            default:
                break;
        }
    }
}
