package com.example.huixuegong.androiddevelop.designmode.abstractfactory;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public class BydCarFactory implements CarFactory {
    public Car createFuelCar() {
        return new BydCarMixed.BydFuelCar();
    }
    public Car createHybridCar() {
        return new BydCarMixed.BydHybridCar();
    }
    public Car createElectricCar() {
        return new BydCarMixed.BydElectricCar();
    }
}
