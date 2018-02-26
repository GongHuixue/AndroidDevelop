package com.example.huixuegong.androiddevelop.designmode.observer;

/**
 * Created by huixue.gong on 2018/2/26.
 */

public class ObserverOne implements Observer{
    private String obsevermsg;
    public void update(String content) {
        obsevermsg = content;
    }

    public String getMsg() {
        return obsevermsg;
    }
}
