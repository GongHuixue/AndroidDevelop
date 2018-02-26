package com.example.huixuegong.androiddevelop.designmode.observer;

import android.app.ListFragment;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public class NotificationHandler implements Observe{
    private static NotificationHandler singleInstance = null;
    private List<Observer> observerList = new ArrayList<>();

    public static synchronized NotificationHandler getSingleInstance() {
        if(singleInstance == null) {
            singleInstance = new NotificationHandler();
        }
        return singleInstance;
    }

    @Override
    public void registerListener(Observer obs) {
        observerList.add(obs);
    }

    @Override
    public void unregisterListener(Observer obs) {
        observerList.remove(obs);
    }

    @Override
    public void notifyListener(String contents) {
        for(Observer observer:observerList) {
            observer.update(contents);
        }
    }
}
