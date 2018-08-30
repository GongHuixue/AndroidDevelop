package com.example.huixuegong.androiddevelop.designmode.Factory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huixuegong.androiddevelop.R;
import com.example.huixuegong.androiddevelop.storage.file.FileActivity;

public class FactoryActivity extends Activity {
    private CarFactory bydFactory;
    private CarFactory havalFactory;
    private Car byd;
    private Car haval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory);
        bydFactory = new BydCarFactory();
        havalFactory = new HavalCarFactory();
        initView();
    }

    public void initView() {
        Button tang = (Button) findViewById(R.id.byd_tang);
        Button song = (Button) findViewById(R.id.byd_song);
        Button yuan = (Button) findViewById(R.id.byd_yuan);
        Button h2 = (Button) findViewById(R.id.haval_h2);
        Button h6 = (Button) findViewById(R.id.haval_h6);
        Button h9 = (Button) findViewById(R.id.haval_h9);

        tang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byd = bydFactory.createCar(BydCar.BYD_TANG);
                Toast.makeText(FactoryActivity.this, "CarName = " + byd.carName() + ",CarPrize = " + byd.carPrize(), Toast.LENGTH_SHORT).show();
            }
        });

        song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byd = bydFactory.createCar(BydCar.BYD_SONG);
                Toast.makeText(FactoryActivity.this, "CarName = " + byd.carName() + ",CarPrize = " + byd.carPrize(), Toast.LENGTH_SHORT).show();
            }
        });

        yuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byd = bydFactory.createCar(BydCar.BYD_YUAN);
                Toast.makeText(FactoryActivity.this, "CarName = " + byd.carName() + ",CarPrize = " + byd.carPrize(), Toast.LENGTH_SHORT).show();
            }
        });

        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haval = havalFactory.createCar(HavalCar.H2);
                Toast.makeText(FactoryActivity.this, "CarName = " + haval.carName() + ",CarPrize = " + haval.carPrize(), Toast.LENGTH_SHORT).show();
            }
        });

        h6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haval = havalFactory.createCar(HavalCar.H6);
                Toast.makeText(FactoryActivity.this, "CarName = " + haval.carName() + ",CarPrize = " + haval.carPrize(), Toast.LENGTH_SHORT).show();
            }
        });

        h9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                haval = havalFactory.createCar(HavalCar.H9);
                Toast.makeText(FactoryActivity.this, "CarName = " + haval.carName() + ",CarPrize = " + haval.carPrize(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
