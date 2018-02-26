package com.example.huixuegong.androiddevelop.designmode.agent;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public class HouseProxy implements Ihouse {
    private Ihouse ihouse;
    public HouseProxy(Ihouse house) {
        this.ihouse = house;
    }

    public void getHouseInfo() {
        ihouse.getHouseInfo();
    }

    public void makeDeal() {
        ihouse.makeDeal();
    }
}
