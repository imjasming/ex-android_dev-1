package com.xiaoming.exercise.mygymclub.ec;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class RegisterHandler {


    public static void onRegister(String response){
        final JSONObject userJson = JSON.parseObject(response).getJSONObject("data");
        final String username = userJson.getString("username");
    }
}
