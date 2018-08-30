package com.example.huixuegong.androiddevelop.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;
import com.example.huixuegong.androiddevelop.searial.parcelable.Car;
import com.example.huixuegong.androiddevelop.searial.searializable.Person;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class HelloWorldActivity extends Activity {
    private final static String TAG = HelloWorldActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);

        Person person = (Person)getIntent().getSerializableExtra("serializable");
        Car car = (Car)getIntent().getParcelableExtra("parcelable");

        if (person != null) {
            if ((person.getGender().length() > 0) || (person.getName().length() > 0)) {
                Toast.makeText(this, "name = " + person.getName() + ", gender = " + person.getGender(), Toast.LENGTH_SHORT).show();
            }
        } else if (car != null) {
            if (car.getName().length() > 0) {
                Toast.makeText(this, "name = " + car.getName() + ", prize = " + Integer.valueOf(car.getPrize()).toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
