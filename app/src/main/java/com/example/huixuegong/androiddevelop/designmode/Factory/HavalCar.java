package com.example.huixuegong.androiddevelop.designmode.Factory;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public class HavalCar implements Car{
    private String carname;
    private int carprize;
    public final static int H2 = 0;
    public final static int H6 = 1;
    public final static int H9 = 2;

    @Override
    public String carName() {
        return carname;
    }

    @Override
    public int carPrize(){
        return carprize;
    }

    public HavalCar(int Id) {
        switch (Id) {
            case 0:
                carname = "H2";
                carprize = 100000;
                break;
            case 1:
                carname = "H6";
                carprize = 150000;
                break;
            case 2:
                carname = "H9";
                carprize = 200000;
                break;
            default:
                break;
        }
    }
}

