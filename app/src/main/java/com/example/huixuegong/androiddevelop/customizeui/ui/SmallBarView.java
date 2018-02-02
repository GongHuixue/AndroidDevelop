package com.example.huixuegong.androiddevelop.customizeui.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.jar.Attributes;

/**
 * Created by huixue.gong on 2018/2/2.
 */

public class SmallBarView  extends View {
    private float mCurrentX = 100;
    private float mCurrentY = 100;
    Paint paint = new Paint();

    public SmallBarView(Context context) {
        super(context);
    }

    public SmallBarView(Context context, AttributeSet set) {
        super(context, set);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        paint.setColor(Color.RED);
        canvas.drawCircle(mCurrentX, mCurrentY, 15, paint);
    }

    public boolean onTouchEvent(MotionEvent event) {
        mCurrentX = event.getX();
        mCurrentY = event.getY();
        invalidate();
        return true;
    }
}
