package com.example.lab4_maixuanquan.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lab4_maixuanquan.R;

public class PassingInteger extends AppCompatActivity {
    private TextView tvPlayerAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_integer);
        tvPlayerAge = findViewById(R.id.tvPlayerAge);
        Intent intent = getIntent();
        int playerAge = intent.getIntExtra("Age", 0);
        tvPlayerAge.setText("" + playerAge);
    }
}