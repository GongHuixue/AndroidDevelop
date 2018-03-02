package com.example.huixuegong.androiddevelop.designmode.strategy;

/**
 * Created by huixue on 2018/3/2.
 */

public class Context {
    Strategy strategy;
    public Context(Strategy strategyMethod) {
        this.strategy = strategyMethod;
    }

    public int Algorithm(int x, int y) {
        return strategy.Algorithm(x, y);
    }
}
