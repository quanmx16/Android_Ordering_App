package com.example.lab4_maixuanquan.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.lab4_maixuanquan.R;

public class PassingObject extends AppCompatActivity {
    private TextView tvPlayerName;
    private TextView tvPlayerAge;
    private TextView tvPlayerClub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_object);
        tvPlayerName = findViewById(R.id.tvPlayerName);
        tvPlayerAge = findViewById(R.id.tvPlayerAge);
        tvPlayerClub = findViewById(R.id.tvPlayerClub);

        Intent intent = getIntent();

        Player player = (Player) intent.getSerializableExtra("player");
        if (player != null) {
            tvPlayerName.setText(player.getName());
            tvPlayerAge.setText("" + player.getAge());
            tvPlayerClub.setText(player.getClub());
        }
    }
}