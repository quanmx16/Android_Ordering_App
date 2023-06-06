package com.example.lab4_maixuanquan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class BeverageActivity extends AppCompatActivity {

    private Button btnExit;
    private ListView lvProduct;
    private TextView tvTotal;
    private ProductItemAdapter productItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_page);
        Booking booking = Booking.getInstance();
        ArrayList<ProductItem> beverageItems = booking.getBeverageItems();
        btnExit = findViewById(R.id.btnExit);
        lvProduct = findViewById(R.id.lvProducts);
        tvTotal = findViewById(R.id.tvTotalPrice);
        productItemAdapter = new ProductItemAdapter(beverageItems, R.layout.product_item, this);
        lvProduct.setAdapter(productItemAdapter);
        int total = 0;
        int size = beverageItems.size();
        for (int i = 0; i < size; i++) {
            total += beverageItems.get(i).getCount() * beverageItems.get(i).getPrice();
        }
        tvTotal.setText(total + "đ");
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BeverageActivity.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });
    }

    public void increaseProduct(int position) {
        Booking booking = Booking.getInstance();
        ArrayList<ProductItem> beverageItems = booking.getBeverageItems();
        int currentCount = beverageItems.get(position).getCount();
        beverageItems.get(position).setCount(currentCount + 1);
        productItemAdapter.notifyDataSetChanged();
        int total = 0;
        int size = beverageItems.size();
        for (int i = 0; i < size; i++) {
            total += beverageItems.get(i).getCount() * beverageItems.get(i).getPrice();
        }
        tvTotal.setText(total + "đ");
    }
}