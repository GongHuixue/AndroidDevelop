package com.example.huixuegong.androiddevelop.designmode.abstractfactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;

public class AbstractFactoryActivity extends Activity {
    private BydCarFactory bydFactory;
    private Car byd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract_factory);

        bydFactory = new BydCarFactory();
        initView();
    }

    public void initView() {
        Button fuel = findViewById(R.id.byd_fuel);
        Button hybrid = findViewById(R.id.byd_hybrid);
        Button electric = findViewById(R.id.byd_electric);

        fuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byd = bydFactory.createFuelCar();
                Toast.makeText(AbstractFactoryActivity.this,
                        "Car Name = " + byd.carName() + ",Car Prize = " + byd.carPrize() + ",Car Type = " + byd.carType(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byd = bydFactory.createHybridCar();
                Toast.makeText(AbstractFactoryActivity.this,
                        "Car Name = " + byd.carName() + ",Car Prize = " + byd.carPrize() + ",Car Type = " + byd.carType(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        electric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byd = bydFactory.createElectricCar();
                Toast.makeText(AbstractFactoryActivity.this,
                        "Car Name = " + byd.carName() + ",Car Prize = " + byd.carPrize() + ",Car Type = " + byd.carType(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
