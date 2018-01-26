package com.example.huixuegong.androiddevelop.searial.parcelable;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.huixuegong.androiddevelop.R;
import com.example.huixuegong.androiddevelop.activity.HelloWorldActivity;
import com.example.huixuegong.androiddevelop.searial.searializable.Person;
import com.example.huixuegong.androiddevelop.searial.searializable.SerializableActivity;

public class ParceableActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parceable);

        /*transmit serializable to other activity*/
        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParceableActivity.this, HelloWorldActivity.class);
                Car car = new Car();
                car.setName("BYD");
                car.setPrize(100000);
                intent.putExtra("parcelable", car);
                startActivity(intent);
            }
        });
    }
}
