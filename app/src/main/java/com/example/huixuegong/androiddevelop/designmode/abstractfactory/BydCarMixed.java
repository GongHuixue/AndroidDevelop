package com.example.huixuegong.androiddevelop.designmode.abstractfactory;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public class BydCarMixed {
    private static String carname;
    private static int carprize;
    private static String cartype;
    public static class BydFuelCar extends FuelCar{
        public String carName() {
            carname = "BYD S6";
            return carname;
        }
        public int carPrize() {
            carprize = 80000;
            return carprize;
        }
        public String carType() {
            cartype = "Fuel Car";
            return cartype;
        }
    }

    public static class BydHybridCar extends HybridCar{
        public String carName() {
            carname = "BYD QIN";
            return carname;
        }
        public int carPrize() {
            carprize = 150000;
            return carprize;
        }
        public String carType() {
            cartype = "Hybrid Car";
            return cartype;
        }
    }

    public static class BydElectricCar extends ElectricCar{
        public String carName() {
            carname = "BYD E6";
            return carname;
        }
        public int carPrize() {
            carprize = 300000;
            return carprize;
        }
        public String carType() {
            cartype = "Electric Car";
            return cartype;
        }
    }

}
