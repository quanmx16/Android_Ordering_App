package com.example.lab4_maixuanquan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab4_maixuanquan.task2.MainPassing;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button btnChooseFood;
    private Button btnChooseBeverage;
    private Button btnExit;
    private TextView orderItem;
    private TextView billTotal;
    private FloatingActionButton btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChooseFood = findViewById(R.id.btnChooseFood);
        btnChooseBeverage = findViewById(R.id.btnChooseBeverage);
        btnExit = findViewById(R.id.btnExit);
        orderItem = findViewById(R.id.tvOrderItem);
        billTotal = findViewById(R.id.tvBillTotal);
        btnChange = findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainPassing.class);
                startActivity(intent);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
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

    @Override
    protected void onResume() {
        super.onResume();

        Booking booking = Booking.getInstance();
        ArrayList<ProductItem> beverageItems = booking.getBeverageItems();
        ArrayList<ProductItem> foodItems = booking.getFoodItems();
        int beverageSize = beverageItems.size();
        ProductItem tmp;
        String orderDetails = "";
        int total = 0;
        for (int i = 0; i < beverageSize; i++) {
            tmp = beverageItems.get(i);
            if (tmp.getCount() > 0) {
                if (orderDetails.length() > 0) {
                    orderDetails = orderDetails + "\n" + tmp.getName() + " x" + tmp.getCount();
                } else {
                    orderDetails = tmp.getName() + " x" + tmp.getCount();
                }
                total += tmp.getPrice() * tmp.getCount();
            }
        }
        orderDetails += "\n";
        int foodSize = foodItems.size();
        for (int i = 0; i < foodSize; i++) {
            tmp = foodItems.get(i);
            if (tmp.getCount() > 0) {
                if (orderDetails.length() > 0) {
                    orderDetails = orderDetails + "\n" + tmp.getName() + " x" + tmp.getCount();
                } else {
                    orderDetails = tmp.getName() + " x" + tmp.getCount();
                }
                total += tmp.getPrice() * tmp.getCount();
            }
        }
        orderItem.setText(orderDetails);
        billTotal.setText(Integer.toString(total) + "đ");
    }
}