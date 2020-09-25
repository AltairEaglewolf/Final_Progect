package com.example.hellodetective;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WhoIsTheKiller extends AppCompatActivity {

    Intent a;
    TextView notebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.who_is_the_killer);

       notebook = (TextView) findViewById (R.id.notes);
       notebook.setMovementMethod(new ScrollingMovementMethod());

        String someText = getSharedPreferences("myPref",MODE_PRIVATE).getString(FragNotebook.SAVED_TEXT, "default text");

        notebook.setText (someText);


        a = new Intent(WhoIsTheKiller.this, AreYouShureFinal.class);
    }

    public void one (View view){
        a.putExtra("who","one");
        startActivity(a);
    }

    public void two (View view){
        a.putExtra("who","two");
        startActivity(a);
    }

    public void three (View view){
        a.putExtra("who","three");
        startActivity(a);
    }

    public void four (View view){
        a.putExtra("who","four");
        startActivity(a);
    }
}