package com.example.huixuegong.androiddevelop.designmode.Factory;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public class BydCar implements Car{
    private String carname;
    private int carprize;
    public final static int BYD_TANG = 0;
    public final static int BYD_SONG = 1;
    public final static int BYD_YUAN = 2;

    @Override
    public String carName() {
        return carname;
    }

    @Override
    public int carPrize(){
        return carprize;
    }

    public BydCar(int Id) {
        switch (Id) {
            case 0:
                carname = "Tang";
                carprize = 300000;
                break;
            case 1:
                carname = "Song";
                carprize = 200000;
                break;
            case 2:
                carname = "Yuan";
                carprize = 100000;
                break;
            default:
                break;
        }
    }
}
