package com.example.huixuegong.androiddevelop.designmode.Factory;

/**
 * Created by huixue.gong on 2018/2/24.
 */

public class BydCarFactory extends CarFactory{
    public Car createCar(int Id) {
        return new BydCar(Id);
    }
}
