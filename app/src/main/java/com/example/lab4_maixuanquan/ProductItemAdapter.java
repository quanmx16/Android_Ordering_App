package com.example.lab4_maixuanquan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductItemAdapter extends BaseAdapter {
    private ArrayList<ProductItem> productItems;
    private int layout;
    private Context context;

    public ProductItemAdapter(ArrayList<ProductItem> productItems, int layout, Context context) {
        this.productItems = productItems;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return productItems.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        ImageView productImage = convertView.findViewById(R.id.imgItem);
        TextView productName = convertView.findViewById(R.id.tvProductName);
        TextView productPrice = convertView.findViewById(R.id.tvProductPrice);
        EditText count = convertView.findViewById(R.id.edtProductCount);
        Button btnPlus = convertView.findViewById(R.id.btnPlus);
        Button btnMinus = convertView.findViewById(R.id.btnMinus);
        productImage.setImageResource(productItems.get(position).getImage());
        productName.setText(productItems.get(position).getName());
        productPrice.setText(productItems.get(position).getPrice() + "đ");
        count.setText(Integer.toString((productItems.get(position).getCount())));
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseProduct(position);
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseProduct(position);
            }
        });
        return convertView;
    }

    private void increaseProduct(int position) {
        if (context instanceof FoodActivity) {
            ((FoodActivity) context).increaseProduct(position);
        } else if (context instanceof BeverageActivity) {
            ((BeverageActivity) context).increaseProduct(position);
        }
    }

    private void decreaseProduct(int position) {
        if (context instanceof FoodActivity) {
            ((FoodActivity) context).decreaseProduct(position);
        } else if (context instanceof BeverageActivity) {
            ((BeverageActivity) context).decreaseProduct(position);
        }
    }
}
