package com.example.huixuegong.androiddevelop.designmode.adapter;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public class VoltAdapter extends Volt220 implements FiveVolt {
    Volt220 mVolt220;

    @Override
    public int get5Volt() {
        return 5;
    }

    public VoltAdapter(Volt220 volt220) {
        this.mVolt220 = volt220;
    }

    @Override
    public int get220Volt() {
        return mVolt220.get220Volt();
    }
}
