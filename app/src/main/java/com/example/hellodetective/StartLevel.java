package com.example.hellodetective;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class StartLevel extends AppCompatActivity {

    TextView description, name;
    String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_level);

        name = (TextView) findViewById(R.id.textView3);
        description = (TextView) findViewById(R.id.textView4);
        description.setMovementMethod(new ScrollingMovementMethod());

        Bundle arguments = getIntent().getExtras();

        level = arguments.get("what").toString();

        switch (level){
            case "one":
                name.setText("Чаепитие мёртвых");
                description.setText("Сегодня вас вызвали вечером, когда вам уже казалось, что этот день пройдёт без трупов, нервных свидетеле и "+
                        "шокированных родственников убитого, и сообщили о трёх погибших в результате отравления. На этот раз вызов пришёл с съёмочной "+
                        "площадки сериала, относительно недалеко от вашего рабочего места, что оказалось несомненным плюсом, ведь уже в течении долгого "+
                        "времени на дорогах были пробки. На входе в здание вас встретил довольно пожилой человек, которой представился как Анатолий "+
                        "Дмитреевич – режиссёр данного сериала.");
                break;
            case "not":
                name.setText("Только тело");
                description.setText("Что-то...");
                break;
        }

    }

    public void begin(View view) {
        Intent a,no;
        a = new Intent(StartLevel.this, TeaPartyOfTheDead.class);
        no = new Intent(StartLevel.this, LevelInProgres.class);

        switch (level){
            case "one":
                startActivity(a);
                break;
            default:
                startActivity(no);
                break;
        }
    }
}