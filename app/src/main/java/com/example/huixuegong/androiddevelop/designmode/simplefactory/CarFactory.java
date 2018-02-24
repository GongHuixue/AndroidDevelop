package com.example.huixuegong.androiddevelop.designmode.simplefactory;

/**
 * Created by huixue.gong on 2018/2/24.
 */

public class CarFactory {
    ICar car;
    public ICar createCarName(int id) {
        switch (id) {
            case 0:
                car = new BydCar();
                break;
            case 1:
                car = new GreatWallCar();
                break;
            default:
                break;
        }
        return car;
    }
}
