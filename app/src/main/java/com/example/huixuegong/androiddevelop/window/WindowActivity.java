package com.example.huixuegong.androiddevelop.window;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.huixuegong.androiddevelop.R;

public class WindowActivity extends Activity implements View.OnTouchListener {
    private static final String TAG = WindowActivity.class.getSimpleName();
    private Button mWindowButton;
    private Button mFloatingButton;
    private WindowManager.LayoutParams layoutParams;
    private WindowManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window);

        mWindowButton = (Button) findViewById(R.id.create_window);
        manager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        Log.d(TAG, "onCreate Enter");
    }

    public void onButtonClick(View v) {
        if (v == mWindowButton) {
            mFloatingButton = new Button(this);
            mFloatingButton.setText("click me");
            layoutParams = new WindowManager.LayoutParams(
                    layoutParams.WRAP_CONTENT, layoutParams.WRAP_CONTENT, 0, 0,
                    PixelFormat.TRANSPARENT);
            layoutParams.flags = layoutParams.FLAG_NOT_TOUCH_MODAL
                    | layoutParams.FLAG_NOT_FOCUSABLE
                    | layoutParams.FLAG_SHOW_WHEN_LOCKED;
            layoutParams.type = layoutParams.TYPE_SYSTEM_ERROR;
            layoutParams.gravity = Gravity.LEFT | Gravity.TOP;
            layoutParams.x = 100;
            layoutParams.y = 300;
            mFloatingButton.setOnTouchListener(this);
            manager.addView(mFloatingButton, layoutParams);
        }
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();

        Log.d(TAG, "onTouch " + rawX + rawY);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int x = (int) event.getX();
                int y = (int) event.getY();
                Log.d(TAG, "onTouch x = " + x + ", y = " + y);
                layoutParams.x = rawX;
                layoutParams.y = rawY;
                manager.updateViewLayout(mFloatingButton, layoutParams);
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            default:
                break;
        }

        return false;
    }

    @Override
    protected void onDestroy() {
        try {
            manager.removeView(mFloatingButton);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }
}
