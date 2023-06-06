package com.example.lab4_maixuanquan;

public class ProductItem {
    private String name;
    private int price;
    private int count;
    private int image;

    public ProductItem(String name, int price, int count, int image) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
