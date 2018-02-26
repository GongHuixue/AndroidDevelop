package com.example.huixuegong.androiddevelop.designmode.agent;

import android.util.Log;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public class House implements Ihouse{
    private String name;
    private int prize;
    private String addr;

    public House(String name, String addr, int prize) {
        this.addr = addr;
        this.name = name;
        this.prize = prize;
    }
    @Override
    public void getHouseInfo() {
        Log.d("House", "House Addr = " + this.addr + ", Name = " + this.name + ", Prize = " + this.prize);
    }

    public void makeDeal() {
        Log.d("House", "Make a deal");
    }
}
