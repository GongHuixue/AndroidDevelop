package com.example.huixuegong.androiddevelop.designmode.builder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;

public class BuilderActivity extends Activity {
    private Builder carBuilder;
    private CarProduct car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);

        carBuilder = new BydBuilder();
        Button builder = findViewById(R.id.builder);
        builder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carBuilder.buildBYD();
                car = carBuilder.getCar();
                Toast.makeText(BuilderActivity.this, "Car Information is " + car.getCarInfo(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
