package com.example.huixuegong.androiddevelop.searial.searializable;

import java.io.Serializable;

/**
 * Created by huixue.gong on 2018/1/26.
 */

public class Person implements Serializable {
    private final static long serialId = 1L;
    private String name;
    private String gender;

    public void setName(String userName) {
        this.name = userName;
    }
    public String getName() {
        return name;
    }

    public void setGender(String userGender) {
        this.gender = userGender;
    }
    public String getGender() {
        return gender;
    }
}
