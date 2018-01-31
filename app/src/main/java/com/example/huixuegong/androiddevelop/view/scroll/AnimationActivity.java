package com.example.huixuegong.androiddevelop.view.scroll;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.huixuegong.androiddevelop.R;

public class AnimationActivity extends Activity {

    private ImageView imageView;
    private WindowManager manager;
    private int screenWidth;
    private int screenHeight;
    private int imageViewWidth;
    private int imageViewHeight;
    private int translationX;
    private int translationY;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        imageView = (ImageView) findViewById(R.id.imageView);
        manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        //得到屏幕的宽
        screenWidth = manager.getDefaultDisplay().getWidth();
        //得到屏幕的高
        screenHeight = manager.getDefaultDisplay().getHeight();

        imageView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //得到ImageView的宽
                imageViewWidth = v.getWidth();
                //得到ImageView的高
                imageViewHeight = v.getHeight();
                //计算平移的长
                translationX = screenWidth - imageViewWidth;
                //计算平移的宽
                translationY = screenHeight - imageViewHeight;
                AnimatorSet animatorTransactionSet = new AnimatorSet();
                //对集合中定义的动画依次播放
                animatorTransactionSet.playSequentially(
                        //平移动画，依次播放
                        ObjectAnimator.ofFloat(imageView, "translationX", 0, translationX),
                        ObjectAnimator.ofFloat(imageView, "translationY", 0, translationY),
                        ObjectAnimator.ofFloat(imageView, "translationX", translationX, 0),
                        ObjectAnimator.ofFloat(imageView, "translationY", translationY, 0)
                );
                //设置动画时间
                animatorTransactionSet.setDuration(2000).start();

                AnimatorSet animatorRotateSet = new AnimatorSet();
                animatorRotateSet.playTogether(
                        //旋转动画，同时播放
                        ObjectAnimator.ofFloat(imageView, "rotationX", 0, 360),
                        ObjectAnimator.ofFloat(imageView, "rotationY", 0, 360)
                );
                //设置动画时间
                animatorRotateSet.setDuration(2000*4).start();
            }
        });
    }
}
