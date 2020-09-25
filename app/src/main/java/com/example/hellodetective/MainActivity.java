package com.example.hellodetective;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        Intent i;
        i = new Intent(MainActivity.this, LevelList.class);
        startActivity(i);
    }

    public void rules (View view) {
        Intent i;
        i = new Intent(MainActivity.this, Rules.class);
        startActivity(i);
    }
}