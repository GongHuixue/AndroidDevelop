package com.example.huixuegong.androiddevelop.designmode.builder;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public class CarProduct {
    private String carName;
    private int carPrize;
    private String carInfo;

    public void setCarName(String name) {
        this.carName = name;
    }

    public void setCarSize(int prize) {
        this.carPrize = prize;
    }

    public String getCarInfo() {
        carInfo = this.carName + this.carPrize;
        return carInfo;
    }
}
