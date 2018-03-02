package com.example.huixuegong.androiddevelop.designmode.strategy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;

public class StrategeActivity extends Activity {
    private Context contextAdd, contetDel;
    private int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stratege);

        initView();
    }

    private void initView() {
        Button add = findViewById(R.id.add_algorithm);
        Button del = findViewById(R.id.del_algorithm);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contextAdd = new Context(new AddStrategy());
                sum = contextAdd.Algorithm(2, 3);
                Toast.makeText(StrategeActivity.this, "Add Algorithm 2 + 3 = " + String.valueOf(sum), Toast.LENGTH_LONG).show();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contetDel = new Context(new DelStrategy());
                contetDel.Algorithm(3, 2);
                Toast.makeText(StrategeActivity.this, "Del Algorithm 3 -2 =  " + String.valueOf(sum), Toast.LENGTH_LONG).show();
            }
        });
    }
}
