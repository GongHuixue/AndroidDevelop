package com.example.huixuegong.androiddevelop.searial.searializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.huixuegong.androiddevelop.R;
import com.example.huixuegong.androiddevelop.activity.HelloWorldActivity;

public class SerializableActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searilazable);

        /*store serializable to phone*/
        /*findViewById(R.id.btn_store).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        /*get serializable*/
        /*findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        /*transmit serializable to other activity*/
        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SerializableActivity.this, HelloWorldActivity.class);
                Person person = new Person();
                person.setName("Jack");
                person.setGender("man");
                intent.putExtra("serializable", person);
                startActivity(intent);
            }
        });
    }
}
