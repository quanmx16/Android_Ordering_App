package com.example.lab4_maixuanquan.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab4_maixuanquan.R;

import java.io.Serializable;

public class PassingBundle extends AppCompatActivity {

    private TextView tvPlayerName;
    private TextView tvPlayerAge;
    private TextView tvPlayerClub;
    private TextView tvPlayerHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_bundle);
        tvPlayerName = findViewById(R.id.tvPlayerName);
        tvPlayerAge = findViewById(R.id.tvPlayerAge);
        tvPlayerClub = findViewById(R.id.tvPlayerClub);
        tvPlayerHeight = findViewById(R.id.tvPlayerHeight);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("playerBundle");

        if (bundle != null) {
            Serializable player = bundle.getSerializable("player");
            float height = bundle.getFloat("height", 0f);
            if (player != null) {
                Player playerData = (Player) player;
                tvPlayerName.setText(playerData.getName());
                tvPlayerAge.setText(Integer.toString(playerData.getAge()));
                tvPlayerClub.setText(playerData.getClub());
                tvPlayerHeight.setText(Float.toString(height));
            }
        }
    }
}