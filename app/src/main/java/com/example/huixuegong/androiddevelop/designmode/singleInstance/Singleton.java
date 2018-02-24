package com.example.huixuegong.androiddevelop.designmode.singleInstance;

/**
 * Created by huixue.gong on 2018/2/24.
 */

public class Singleton {
    private static Singleton singleton;
    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
