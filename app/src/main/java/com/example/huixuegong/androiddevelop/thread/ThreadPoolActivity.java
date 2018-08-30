package com.example.huixuegong.androiddevelop.thread;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.huixuegong.androiddevelop.R;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolActivity extends Activity {
    private final static String TAG = ThreadPoolActivity.class.getSimpleName();
    private final int CORE_POOL_SIZE = 5;
    private final int MAX_POOL_SIZE = 10;
    private final long KEEP_ALIVE_TIME = 1000;//Timeout of idle thread
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_pool);
        initView();
    }

    private void initView() {
        Button singleThread = (Button) findViewById(R.id.btn_singlepool);
        Button multiThread = (Button) findViewById(R.id.btn_multipool);

        singleThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                Executor singlePool = Executors.newSingleThreadExecutor();

                for(int i = 0; i < 100; i ++) {
                    singlePool.execute(WorkRunnable);
                }
            }
        });

        multiThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
                        TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());

                for(int i = 0; i < 100; i++) {
                    executor.execute(WorkRunnable);
                }
            }
        });
    }

    private Runnable WorkRunnable = new Runnable() {
        @Override
        public void run() {
            try{
                Thread.sleep(50);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    count++;
                    String msg = count < 100 ? "-->Start Count Until ":"-->Counting To ";
                    updateStatus(msg + count);
                }
            });
        }
    };

    private void updateStatus(String msg) {
        ((TextView)findViewById(R.id.thread_pool)).setText(msg);
    }
}
