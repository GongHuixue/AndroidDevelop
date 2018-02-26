package com.example.huixuegong.androiddevelop.designmode.builder;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public class BydBuilder implements Builder {
    private CarProduct car = new CarProduct();

    public void buildBYD() {
        car.setCarName("BYD Tang");
        car.setCarSize(300000);
    }

    public CarProduct getCar() {
        return car;
    }
}
