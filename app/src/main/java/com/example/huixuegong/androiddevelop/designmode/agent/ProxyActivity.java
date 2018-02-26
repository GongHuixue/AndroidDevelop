package com.example.huixuegong.androiddevelop.designmode.agent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.example.huixuegong.androiddevelop.R;

public class ProxyActivity extends Activity {
    private Ihouse house;
    private Ihouse proxyHouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);

        house = new House("Vanke", "XiaMen", 2000);
        proxyHouse = new HouseProxy(house);

        proxyHouse.getHouseInfo();
        proxyHouse.makeDeal();
    }
}
