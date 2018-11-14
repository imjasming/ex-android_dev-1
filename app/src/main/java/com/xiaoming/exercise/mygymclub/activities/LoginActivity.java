package com.xiaoming.exercise.mygymclub.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xiaoming.exercise.mygymclub.R;

public class LoginActivity extends AppCompatActivity {
    private boolean isSignIn = false;
    private TextInputEditText mName;
    private TextInputEditText mPassword;
    private Button mLoginButton;
    private Button mRegisterButton;
    private Button mForgetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        bindView();

        mLoginButton.setOnClickListener((View v) -> {
            //没有登录就进入登录界面
            if (!isSignIn) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            //没有用户数据，直接finish，进入mainActivity
            this.finish();
        });
        mRegisterButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void bindView(){
        mName = findViewById(R.id.edit_login_username);
        mPassword = findViewById(R.id.edit_login_password);
        mLoginButton = findViewById(R.id.button_login);
        mRegisterButton = findViewById(R.id.button_login_register);
        mForgetButton = findViewById(R.id.button_login_forget);
    }

    private void checkForm(){

    }
}
