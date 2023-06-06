package com.example.lab4_maixuanquan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    private Button btnExit;
    private ListView lvProduct;
    private TextView tvTotal;
    private ProductItemAdapter productItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_page);
        Booking booking = Booking.getInstance();
        ArrayList<ProductItem> foodItems = booking.getFoodItems();
        btnExit = findViewById(R.id.btnExit);
        lvProduct = findViewById(R.id.lvProducts);
        tvTotal = findViewById(R.id.tvTotalPrice);
        productItemAdapter = new ProductItemAdapter(foodItems, R.layout.product_item, this);
        lvProduct.setAdapter(productItemAdapter);
        int total = 0;
        int size = foodItems.size();
        for (int i = 0; i < size; i++) {
            total += foodItems.get(i).getCount() * foodItems.get(i).getPrice();
        }
        tvTotal.setText(total + "đ");
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FoodActivity.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });
    }

    public void increaseProduct(int position) {
        Booking booking = Booking.getInstance();
        ArrayList<ProductItem> foodItems = booking.getFoodItems();
        int currentCount = foodItems.get(position).getCount();
        foodItems.get(position).setCount(currentCount + 1);
        productItemAdapter.notifyDataSetChanged();
        int total = 0;
        int size = foodItems.size();
        for (int i = 0; i < size; i++) {
            total += foodItems.get(i).getCount() * foodItems.get(i).getPrice();
        }
        tvTotal.setText(total + "đ");
    }
}