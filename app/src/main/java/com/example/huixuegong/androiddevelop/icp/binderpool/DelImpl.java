package com.example.huixuegong.androiddevelop.icp.binderpool;

/**
 * Created by huixue.gong on 2018/1/29.
 */

public class DelImpl extends IDel.Stub {
    @Override
    public int del(int x, int y) {
        return (x - y);
    }
}
