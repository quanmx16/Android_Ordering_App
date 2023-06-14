package com.example.lab4_maixuanquan.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lab4_maixuanquan.R;

import java.util.ArrayList;

public class PassingArray extends AppCompatActivity {

    private ListView lvPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_array);
        lvPlayer = findViewById(R.id.lvPlayers);
        Intent intent = getIntent();
        String[] players = intent.getStringArrayExtra("nameArray");
        ArrayList<String> playerArrayList;
        if (players != null) {
            playerArrayList = new ArrayList<>();
            for (String item : players) {
                playerArrayList.add(item);
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, playerArrayList);
            lvPlayer.setAdapter(adapter);
        }
    }
}