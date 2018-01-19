package com.example.huixuegong.androiddevelop.adapter;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.huixuegong.androiddevelop.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseAdapterActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyAdapter myAdapter = new MyAdapter(this, getListData());
        setListAdapter(myAdapter);
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

    private void showDetailInfo() {
        new AlertDialog.Builder(this)
                .setTitle("Personal Information")
                .setMessage("name, gender, age, phone, address")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    public final class ViewHolder {
        public TextView name;
        public TextView gender;
        public Button detail;
    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private List<Map<String, Object>> mData;
        public MyAdapter(Context context, List<Map<String, Object>> mdata) {
            this.mInflater = LayoutInflater.from(context);
            this.mData = mdata;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if(convertView == null) {
                viewHolder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.activity_base_adapter, null);

                viewHolder.name = (TextView)findViewById(R.id.name);
                viewHolder.gender = (TextView)findViewById(R.id.gender);
                viewHolder.detail = (Button)findViewById(R.id.detail_btn);

                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder)convertView.getTag();
            }

            viewHolder.name.setText((String)mData.get(position).get("name"));
            viewHolder.gender.setText((String)mData.get(position).get("gender"));
            viewHolder.detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDetailInfo();
                }
            });

            return convertView;
        }
    }
}
