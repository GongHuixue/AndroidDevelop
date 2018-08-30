package com.example.huixuegong.androiddevelop.designmode.observer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;

public class ObserverActivity extends Activity {
    private NotificationHandler notificationHandler;
    private ObserverOne observer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);

        notificationHandler = NotificationHandler.getSingleInstance();
        observer = new ObserverOne();
        initView();
    }

    private void initView() {
        Button add = (Button) findViewById(R.id.add_lister);
        Button del = (Button) findViewById(R.id.del_listen);
        Button notify = (Button) findViewById(R.id.notify);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationHandler.registerListener(observer);
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationHandler.unregisterListener(observer);
            }
        });

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationHandler.notifyListener("Something update");

                Toast.makeText(ObserverActivity.this, "Notify " + observer.getMsg(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
