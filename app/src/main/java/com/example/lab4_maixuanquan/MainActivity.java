package com.example.lab4_maixuanquan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnChooseFood;
    private Button btnChooseBeverage;
    private Button btnExit;
    private TextView orderItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChooseFood = findViewById(R.id.btnChooseFood);
        btnChooseBeverage = findViewById(R.id.btnChooseBeverage);
        btnExit = findViewById(R.id.btnExit);
        orderItem = findViewById(R.id.tvOrderItem);
        btnChooseFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(i);
            }
        });
        btnChooseBeverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, BeverageActivity.class);
                startActivity(i);
            }
        });
    }

}