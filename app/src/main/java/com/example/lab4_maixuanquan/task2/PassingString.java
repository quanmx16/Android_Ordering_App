package com.example.lab4_maixuanquan.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lab4_maixuanquan.R;

public class PassingString extends AppCompatActivity {
    private TextView tvPlayerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_string);
        tvPlayerName = findViewById(R.id.tvPlayerName);
        Intent intent = getIntent();
        String playerName = intent.getStringExtra("name");
        if (playerName != null) {
            tvPlayerName.setText(playerName);
        }
    }
}