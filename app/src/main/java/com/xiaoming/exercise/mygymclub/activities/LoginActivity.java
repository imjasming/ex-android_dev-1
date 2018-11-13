package com.xiaoming.exercise.mygymclub.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xiaoming.exercise.mygymclub.R;

public class LoginActivity extends AppCompatActivity {
    private boolean isSignIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener((View v) -> {
            //没有登录就进入登录界面
            if (!isSignIn) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            //没有用户数据，直接finish，进入mainActivity
            this.finish();
        });

        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }
}
