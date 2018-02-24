package com.example.huixuegong.androiddevelop.designmode.simplefactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;

public class SimpleFactoryActivity extends Activity {
    private ICar car;
    private CarFactory factory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_factory);

        factory = new CarFactory();

        Button byd = findViewById(R.id.byd);
        Button greatewall = findViewById(R.id.greatewall);

        byd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                car = factory.createBydCar();
                Toast.makeText(SimpleFactoryActivity.this, "Create Car Name = " + car.createCar(), Toast.LENGTH_SHORT).show();
            }
        });

        greatewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                car = factory.createGreatWallCar();
                Toast.makeText(SimpleFactoryActivity.this, "Create Car Name = " + car.createCar(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
