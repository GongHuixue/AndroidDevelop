package com.example.huixuegong.androiddevelop.designmode.simplefactory;

/**
 * Created by huixue.gong on 2018/2/24.
 */

public class CarFactory {
    public ICar createBydCar(){
        return new BydCar();
    }

    public ICar createGreatWallCar() {
        return new GreatWallCar();
    }
}
