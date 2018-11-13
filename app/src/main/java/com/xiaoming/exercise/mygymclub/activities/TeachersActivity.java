package com.xiaoming.exercise.mygymclub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.xiaoming.exercise.mygymclub.R;

public class TeachersActivity extends AppCompatActivity {
    LinearLayout teacher1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);
        teacher1 = findViewById(R.id.teacher1);
        teacher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeachersActivity.this,IntroductionActivity.class);
                startActivity(intent);
            }
        });
    }
}
