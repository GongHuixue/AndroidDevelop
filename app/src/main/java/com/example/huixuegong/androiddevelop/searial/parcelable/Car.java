package com.example.huixuegong.androiddevelop.searial.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by huixue.gong on 2018/1/26.
 */

public class Car implements Parcelable {
    private String name;
    private int prize;
    
    protected Car(Parcel in) {
        name = in.readString();
        prize = in.readInt();
    }
    public static final Creator<Car> CREATOR = new Creator<Car>() {

        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in); // 在构造函数里面完成了 读取 的工作
        }
        //供反序列化本类数组时调用的
        @Override
        public Car[] newArray(int prize) {
            return new Car[prize];
        }
    };

    @Override
    public int describeContents() {
        return 0;  // 内容接口描述，默认返回0即可。
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);  // 写出 name
        dest.writeInt(prize);  // 写出 prize
    }

    public Car() {
    }
    public Car(String name, int prize) {
        this.name = name;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrize() {
        return prize;
    }
    public void setPrize(int prize) {
        this.prize = prize;
    }
}
