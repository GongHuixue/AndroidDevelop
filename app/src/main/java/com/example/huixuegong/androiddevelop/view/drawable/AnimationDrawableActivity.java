package com.example.huixuegong.androiddevelop.view.drawable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.huixuegong.androiddevelop.R;

public class AnimationDrawableActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_drawable);

        final ImageView image = findViewById(R.id.image);
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.animation);
        anim.setFillAfter(true);

        Button button = findViewById(R.id.start_anim);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image.startAnimation(anim);
            }
        });
    }
}
