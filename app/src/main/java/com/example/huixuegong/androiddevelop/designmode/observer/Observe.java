package com.example.huixuegong.androiddevelop.designmode.observer;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public interface Observe {
    public void registerListener(Observer observer);
    public void unregisterListener(Observer observer);
    public void notifyListener(String content);
}
