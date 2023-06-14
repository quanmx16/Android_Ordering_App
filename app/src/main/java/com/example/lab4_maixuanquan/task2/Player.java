package com.example.lab4_maixuanquan.task2;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int age;
    private String club;

    public Player(String name, int age, String club) {
        this.name = name;
        this.age = age;
        this.club = club;
    }

    public Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}
