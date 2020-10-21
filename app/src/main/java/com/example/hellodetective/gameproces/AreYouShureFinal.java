package com.example.hellodetective.gameproces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hellodetective.MainActivity;
import com.example.hellodetective.R;

public class AreYouShureFinal extends AppCompatActivity {

    String choosed;
    Integer choose;
    Button finish, yes, no;
    TextView win;
    ImageView director,luci,sister,operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.are_you_shure_final);

        Bundle arguments = getIntent().getExtras();
        choosed = arguments.get("who").toString();

        director = (ImageView) findViewById(R.id.director);
        luci = (ImageView)findViewById(R.id.luci);
        sister = (ImageView) findViewById(R.id.sister);
        operator = (ImageView) findViewById(R.id.operator);

        finish = (Button) findViewById(R.id.finish);
        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);

        win = (TextView) findViewById(R.id.win_or_not);

        switch (choosed){
            case "one":
               sister.setVisibility(View.VISIBLE);
               choose = 1;
                break;
            case "two":
                luci.setVisibility(View.VISIBLE);
                choose = 2;
                break;
            case "three":
                operator.setVisibility(View.VISIBLE);
                choose = 3;
                break;
            case "four":
                choose = 4;
                director.setVisibility(View.VISIBLE);
                break;
        }

    }

    public void finish (View view){
        if (choose == 3){
            Intent a;
            a = new Intent(AreYouShureFinal.this, MainActivity.class);
            startActivity(a);
        }
        else {
            Intent a;
            a = new Intent(AreYouShureFinal.this, WhoIsTheKiller.class);
            startActivity(a);
        }
    }

    public void yes (View view){

        if (choose == 3){
            yes.setVisibility(View.GONE);
            no.setVisibility(View.GONE);

            finish.setVisibility(View.VISIBLE);
            finish.setText("Главно меню");

            win.setVisibility(View.VISIBLE);
            win.setText("Поздравляю, вы поймали виновного");
        } else {
            yes.setVisibility(View.GONE);
            no.setVisibility(View.GONE);

            finish.setVisibility(View.VISIBLE);
            finish.setText("Выбрать ещё раз");

            win.setVisibility(View.VISIBLE);
            win.setText("Вы ошиблись");
        }
    }

    public void no (View view){
        Intent a;
        a = new Intent(AreYouShureFinal.this, WhoIsTheKiller.class);
        startActivity(a);
    }
}