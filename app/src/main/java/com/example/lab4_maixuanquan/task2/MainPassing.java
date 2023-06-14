package com.example.lab4_maixuanquan.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import com.example.lab4_maixuanquan.BeverageActivity;
import com.example.lab4_maixuanquan.MainActivity;
import com.example.lab4_maixuanquan.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;

public class MainPassing extends AppCompatActivity implements Serializable {
    private Button btnPassString;
    private Button btnPassInteger;
    private Button btnPassArray;
    private Button btnPassObject;
    private Button btnPassBundle;
    private FloatingActionButton btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_passing);
        btnPassArray = findViewById(R.id.btnPassArray);
        btnPassString = findViewById(R.id.btnPassString);
        btnPassInteger = findViewById(R.id.btnPassInt);
        btnPassObject = findViewById(R.id.btnPassObject);
        btnPassBundle = findViewById(R.id.btnPassBundle);
        btnChange = findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPassing.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnPassArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPassing.this, PassingArray.class);
                intent.putExtra("nameArray", new String[]{"Ronaldo", "Messi", "Buffon", "Arnold"});
                startActivity(intent);
            }
        });

        btnPassString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPassing.this, PassingString.class);
                intent.putExtra("name", "Trent Alexander-Arnold");
                startActivity(intent);
            }
        });

        btnPassInteger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPassing.this, PassingInteger.class);
                intent.putExtra("Age", 24);
                startActivity(intent);
            }
        });

        btnPassObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPassing.this, PassingObject.class);
                intent.putExtra("player", new Player("Trent Alexander-Arnold", 24, "Liverpool"));
                startActivity(intent);
            }
        });
        btnPassBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainPassing.this, PassingBundle.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("player", new Player("Trent Alexander-Arnold", 24, "Liverpool"));
                bundle.putFloat("height", 1.75f);
                intent.putExtra("playerBundle", bundle);
                startActivity(intent);
            }
        });
    }
}