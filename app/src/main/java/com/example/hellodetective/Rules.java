package com.example.hellodetective;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Rules extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_activity);

        text = findViewById(R.id.textRules);
        text.setMovementMethod(new ScrollingMovementMethod());

        text.setText(getResources().getString(R.string.rules));


    }
}

/*text = (TextView) findViewById(R.id.textRules);

        text.setMovementMethod(new ScrollingMovementMethod());
        text.setText(getResources().getString(R.string.rules));*/