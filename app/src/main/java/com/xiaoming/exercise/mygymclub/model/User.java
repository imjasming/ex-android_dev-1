package com.xiaoming.exercise.mygymclub.model;

import android.support.annotation.NonNull;
import java.util.UUID;

import cn.bmob.v3.BmobObject;

public class User extends BmobObject {
    private UUID mUUID;
    private String mNickName;
    private String mPassword;
    private int mTelNum;

    public User(UUID uuid, String password){
        mUUID = uuid;
        mPassword = password;
    }

    public User(UUID uuid, String nickName, String password, int telNum){
        mUUID = uuid;
        mNickName = nickName;
        mPassword = password;
        mTelNum = telNum;
    }

    public UUID getUUID() {
        return mUUID;
    }

    public void setUUID(UUID UUID) {
        mUUID = UUID;
    }

    public String getNickName() {
        return mNickName;
    }

    public void setNickName(String nickName) {
        mNickName = nickName;
    }

    public int getTelNum() {
        return mTelNum;
    }

    public void setTelNum(int telNum) {
        this.mTelNum = telNum;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    @NonNull
    @Override
    public String toString() {
        return mNickName;
    }
}
