package com.xiaoming.exercise.mygymclub.activities;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.xiaoming.exercise.mygymclub.R;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText mName;
    private TextInputEditText mPassword;
    private Button mLoginButton;
    private Button mRegisterButton;
    private Button mForgetButton;
    private String username;
    private String password;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        bindView();

        mLoginButton.setOnClickListener((View v) -> {
            if (checkForm()){

                this.finish();
            }
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

    private boolean checkForm() {
        username = mName.getText().toString();
        password = mPassword.getText().toString();

        boolean isPass = true;
        if (username.isEmpty()) {
            mName.setError("请输用户名");
            isPass = false;
        } else {
            mName.setError(null);
        }
        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请输入至少六位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }
        return isPass;
    }
}
