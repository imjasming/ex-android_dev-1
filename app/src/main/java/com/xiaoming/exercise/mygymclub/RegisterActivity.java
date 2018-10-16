package com.xiaoming.exercise.mygymclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        confirm = findViewById(R.id.confirm);
        //不需要验证直接关了
        confirm.setOnClickListener(v -> finish());
    }
}
