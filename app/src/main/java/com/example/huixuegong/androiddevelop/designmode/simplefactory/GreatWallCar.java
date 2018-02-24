package com.example.huixuegong.androiddevelop.designmode.simplefactory;

/**
 * Created by huixue.gong on 2018/2/24.
 */

public class GreatWallCar implements ICar {
    public final static int ID = 1;
    public String createCar() {
        return "Create Wall";
    }
}
