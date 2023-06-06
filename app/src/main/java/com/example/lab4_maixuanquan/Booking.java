package com.example.lab4_maixuanquan;

import java.util.ArrayList;

public class Booking {
    private static volatile Booking booking;
    private ArrayList<ProductItem> foodItems;
    private ArrayList<ProductItem> beverageItems;

    private Booking() {
        addFoodItems();
        addBeverageItems();
    }

    private void addFoodItems() {
        foodItems = new ArrayList<>();
        ProductItem productItem = new ProductItem("Phở Hà Nội", 10, 0, R.drawable.phohanoi);
        ProductItem productItem2 = new ProductItem("Bún Bò Huế", 11, 0, R.drawable.bunbohue);
        ProductItem productItem3 = new ProductItem("Mì Quảng", 8, 0, R.drawable.miquang);
        ProductItem productItem4 = new ProductItem("Hủ Tíu Sài Gòn", 9, 0, R.drawable.hutiusaigon);
        foodItems.add(productItem);
        foodItems.add(productItem2);
        foodItems.add(productItem3);
        foodItems.add(productItem4);
    }

    private void addBeverageItems() {
        beverageItems = new ArrayList<>();
        ProductItem productItem = new ProductItem("Pepsi", 1, 0, R.drawable.pepsi);
        ProductItem productItem2 = new ProductItem("Heineken", 2, 0, R.drawable.heineken);
        ProductItem productItem3 = new ProductItem("Tiger", 3, 0, R.drawable.tiger);
        ProductItem productItem4 = new ProductItem("Sài gòn Đỏ", 4, 0, R.drawable.saigondo);
        beverageItems.add(productItem);
        beverageItems.add(productItem2);
        beverageItems.add(productItem3);
        beverageItems.add(productItem4);
    }

    public ArrayList<ProductItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(ArrayList<ProductItem> foodItems) {
        this.foodItems = foodItems;
    }

    public ArrayList<ProductItem> getBeverageItems() {
        return beverageItems;
    }

    public void setBeverageItems(ArrayList<ProductItem> beverageItems) {
        this.beverageItems = beverageItems;
    }

    public static Booking getInstance() {
        if (booking != null) {
            return booking;
        }
        synchronized (Booking.class) {
            if (booking == null) {
                booking = new Booking();
            }
            return booking;
        }
    }
}
