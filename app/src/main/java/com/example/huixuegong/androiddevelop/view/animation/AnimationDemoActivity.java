package com.example.huixuegong.androiddevelop.view.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.huixuegong.androiddevelop.R;

public class AnimationDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_demo);

        initView();
    }

    private void initView() {
        Button rotate = findViewById(R.id.rotate);
        Button scale = findViewById(R.id.scale);
        Button translate = findViewById(R.id.translate);
        final Button alpha = findViewById(R.id.alpha);
        final ImageView image = findViewById(R.id.animationimage);

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5F,
                        Animation.RELATIVE_TO_SELF, 0.5f);

                rotateAnimation.setDuration(2000);
                animationSet.addAnimation(rotateAnimation);

                image.startAnimation(animationSet);
            }
        });

        scale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                ScaleAnimation scaleAnimation = new ScaleAnimation(
                        0, 0.1f,0,0.1f,
                        Animation.RELATIVE_TO_SELF,0.5f,
                        Animation.RELATIVE_TO_SELF,0.5f);

                scaleAnimation.setDuration(2000);
                animationSet.addAnimation(scaleAnimation);
                image.startAnimation(animationSet);
            }
        });

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                TranslateAnimation translateAnimation = new TranslateAnimation(
                                Animation.RELATIVE_TO_SELF,0f,
                                Animation.RELATIVE_TO_SELF,0.5f,
                                Animation.RELATIVE_TO_SELF,0f,
                                Animation.RELATIVE_TO_SELF,0.5f);

                translateAnimation.setDuration(2000);
                animationSet.addAnimation(translateAnimation);
                image.startAnimation(animationSet);
            }
        });

        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationSet animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);

                alphaAnimation.setDuration(2000);
                animationSet.addAnimation(alphaAnimation);
                image.startAnimation(animationSet);
            }
        });
    }
}
