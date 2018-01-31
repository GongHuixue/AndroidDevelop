package com.example.huixuegong.androiddevelop.view.scroll;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.huixuegong.androiddevelop.R;

public class ScrollActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        final Button ScrollToBtn = (Button) findViewById(R.id.ScrollTo);
        final Button ScrollByBtn = (Button) findViewById(R.id.ScrollBy);

        ScrollToBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                ScrollToBtn.scrollTo(100, 100);
            }
        });

        ScrollByBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                ScrollByBtn.scrollBy(100, 100);
            }
        });
    }
}
