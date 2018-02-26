package com.example.huixuegong.androiddevelop.designmode.abstractfactory;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public interface CarFactory {
    public Car createFuelCar();
    public Car createHybridCar();
    public Car createElectricCar();
}
