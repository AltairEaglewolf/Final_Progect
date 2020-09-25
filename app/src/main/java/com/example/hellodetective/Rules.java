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

        text = (TextView) findViewById(R.id.text);
        text.setMovementMethod(new ScrollingMovementMethod());

        text.setText("В данной игре ваша цель найти преступника среди тех, кого вы встретите во время игры. Чтобы узнать достаточно информации, опрашивайте свидетелей, осматривайтесь и заносите информацию, которую посчитаете нужной в блокнот (нажмите на иконку с блокнотом, чтобы открыть его). \n" +
                "Выбрав кого опросить, вам будут предложены варианты вопросов. В основном вы сможете задать их все, однако если персонаж сильно шокирован, напуган или испытывает другие сильные эмоции, количество вопросов на которые вы получите ответ будет ограничено (понять настроение можно по аватару, так что если персонаж, например, плачет, выбирайте вопросы внимательнее).\n" +
                "Так же порой спросив задав персонажу определённый вопрос вам будет открыт новый. Узнать про это вам помогут всплывающие сообщения.\n" +
                "Время вашей игры ограничено, и по его истечению вам будет предложено выбрать того, кто является виновником по вашему мнению (ваш блокнот и записи будут доступны). Так что, как бы вам не хотелось, поговорить абсолютно обо всём не удастся.\n" +
                "Не забывайте нажимать на дискет в верхнем правом углу экрана, чтобы сохранить свой прогресс.\n");
    }
}