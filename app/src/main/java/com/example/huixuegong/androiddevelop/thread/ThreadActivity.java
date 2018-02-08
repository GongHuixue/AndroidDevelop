package com.example.huixuegong.androiddevelop.thread;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;

public class ThreadActivity extends Activity {
    private final static String TAG = ThreadActivity.class.getSimpleName();
    private Button runnableButton;
    private Button threadButton;
    private Button handlerButton;
    private Button asyncButton;
    private static Context mContext;

    private static HandlerThread handlerThread;
    private Handler handler;
    private Thread thread;
    private Runnable runnable;
    private static Handler mainHandler = new MainHandler();
    private AsyncTaskThread asyncThread;

    private final static int RUNNABLE_MSG = 1;
    private final static int THREAD_MSG = 2;
    private final static int HANDLER_MSG = 3;
    private final static int ASYNCTASK_MSG = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        mContext = this;

        initView();
    }

    private static class MainHandler extends Handler {
        public void handleMessage(Message msg) {
            int threadId = (int)msg.obj;
            Log.d(TAG, "handleMessage msg.what = " + msg.what + ", msg.obj = " + threadId);
            switch (msg.what) {
                case RUNNABLE_MSG:
                    Log.d(TAG, "Receive Msg from Runnable");
                    Toast.makeText(mContext, "Current Thread id is " + String.valueOf(threadId), Toast.LENGTH_SHORT).show();
                    break;
                case THREAD_MSG:
                    Log.d(TAG, "Receive Msg from Thread");
                    Toast.makeText(mContext, "Current Thread id is " + String.valueOf(threadId), Toast.LENGTH_SHORT).show();
                    break;
                case HANDLER_MSG:
                    Log.d(TAG, "Receive Msg from HandlerThread");
                    Toast.makeText(mContext, "Current Thread id is " + String.valueOf(threadId), Toast.LENGTH_SHORT).show();
                    try {
                        Thread.sleep(100);
                        if (handlerThread != null) {
                            handlerThread.quit();
                        }
                    }catch (Exception ex) {
                        Log.e(TAG, "destroy handlerThread failed");
                    }
                    break;
                case ASYNCTASK_MSG:

                    Log.d(TAG, "Receive Msg from AsyncTask");
                    Toast.makeText(mContext, "Current Thread id is " + String.valueOf(threadId), Toast.LENGTH_SHORT).show();

                    break;
                default:
                    break;
            }
        }
    }

    private void initView() {
        runnableButton = findViewById(R.id.new_runnable);
        threadButton = findViewById(R.id.new_thread);
        handlerButton = findViewById(R.id.new_handlerThread);
        asyncButton = findViewById(R.id.new_async);

        runnableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        Message msg = mainHandler.obtainMessage();
                        msg.what = RUNNABLE_MSG;
                        msg.obj = android.os.Process.myTid();
                        mainHandler.sendMessage(msg);
                    }
                };
                mainHandler.post(runnable);
            }
        });

        threadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = mainHandler.obtainMessage();
                        msg.what = THREAD_MSG;
                        msg.obj = android.os.Process.myTid();
                        mainHandler.sendMessage(msg);
                        Log.d(TAG, "");
                    }
                });
                thread.start();
            }
        });

        handlerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerThread = new HandlerThread("HandlerThread");
                handlerThread.start();
                handler = new Handler(handlerThread.getLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Message msg = mainHandler.obtainMessage();
                        msg.what = HANDLER_MSG;
                        msg.obj = android.os.Process.myTid();
                        mainHandler.sendMessage(msg);
                    }
                });
            }
        });

        asyncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncThread = new AsyncTaskThread();
                asyncThread.execute();
            }
        });
    }

    private static class AsyncTaskThread extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... arg0){
            Log.d(TAG, "AsyncTaskThread doInBackground");

            Message msg = mainHandler.obtainMessage();
            msg.what = ASYNCTASK_MSG;
            msg.obj = android.os.Process.myTid();
            mainHandler.sendMessage(msg);
            return null;
        }

        @Override
        protected void onPostExecute(Void arg1) {
            Log.d(TAG, "AsyncTaskThread onPostExecute");
        }

        @Override
        protected void onProgressUpdate(Void... arg2) {
            Log.d(TAG, "AsyncTaskThread onProgressUpdate");
        }
    }
}
