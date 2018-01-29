package com.example.huixuegong.androiddevelop.icp.binderpool;

/**
 * Created by huixue.gong on 2018/1/29.
 */

public class AddImpl extends IAdd.Stub {
    @Override
    public int add(int x, int y) {
        return (x + y);
    }
}
