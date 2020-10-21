package com.example.hellodetective;



import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hellodetective.gameproces.FragNotebook;
import com.example.hellodetective.gameproces.WhoIsTheKiller;

public class TeaPartyOfTheDead extends AppCompatActivity {


    private boolean isPaused = false;
    private long timeRemaining,timeSave;


    SharedPreferences sharedPreferences;
    final String SAVED_TIME = "saved_time";
    final String SPEECH_SITUATION = "speech_situation";
    final String TAP_SITUATION = "tap_situation";
    final String CORPSE_ONE = "corpse_one";
    final String CORPSE_FIVE = "corpse_five";
    final String CORPSE_SEVEN = "corpse_seven";

    final String SISTER_ONE = "sister_one";
    final String SISTER_TWO = "sister_two";
    final String SISTER_THREE = "sister_three";
    final String SISTER_FOUR = "sister_four";
    final String SISTER_FIVE = "sister_five";
    final String SISTER_SEVEN = "sister_seven";

    final String MAKEUP_ONE = "makeup_one";
    final String MAKEUP_TWO = "makeup_two";
    final String MAKEUP_FOUR = "makeup_four";
    final String MAKEUP_SIX = "makeup_six";
    final String MAKEUP_SEVEN = "makeup_seven";

    final String OPERATOR_ONE = "operator_one";
    final String OPERATOR_TWO = "operator_two";
    final String OPERATOR_FOUR = "operator_four";
    final String OPERATOR_SIX = "operator_six";
    final String OPERATOR_SEVEN = "operator_seven";
    final String OPERATOR_EIGHT = "operator_eight";
    final String OPERATOR_TEN = "operator_ten";
    final String OPERATOR_ELEVEN = "operator_eleven";

    final String DIRECTOR_ONE = "director_one";
    final String DIRECTOR_TWO = "director_two";
    final String DIRECTOR_FOUR = "director_four";
    final String DIRECTOR_SIX = "director_six";
    final String DIRECTOR_EIGHT = "director_eight";
    final String DIRECTOR_TEN = "director_ten";
    final String DIRECTOR_ELEVEN = "director_eleven";


    FragNotebook frag_note;
    FragmentTransaction fragmentTransaction;
    LinearLayout menuLayout;


    ImageView director,luci,sister,operator,notes;
    TextView speech,who,time;
    Corpse corpse;
    Sister alive_sister;
    Makeup makeup;
    Operator operator_target;
    Director director_;

    Integer open_note,open_menu,speech_situation,tap_situation;

    Button back, first, second, third, fourth, fifth;
    Button first_first, first_second, first_third;
    Button second_first, second_second, second_third, second_fourth, second_fifth, second_sixth;
    Button third_first, third_second, third_third, third_fourth, third_fifth;
    Button fourth_first, fourth_second, fourth_third, fourth_fourth, fourth_fifth, fourth_sixth, fourth_seventh, fourth_eight;
    Button fifth_first, fifth_second, fifth_third, fifth_fourth, fifth_fifth, fifth_sixth, fifth_seventh;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tea_party_of_the_dead);

        menuLayout = (LinearLayout) findViewById(R.id.menuButton);
        frag_note = new FragNotebook();
        corpse = new Corpse(getResources());
        alive_sister = new Sister(getResources());
        makeup = new Makeup(getResources());
        operator_target = new Operator(getResources());
        director_ = new Director(getResources());


        director = (ImageView) findViewById(R.id.director);
        luci = (ImageView)findViewById(R.id.luci);
        sister = (ImageView) findViewById(R.id.sister);
        operator = (ImageView) findViewById(R.id.operator);

        speech = (TextView) findViewById(R.id.speech);
        speech.setMovementMethod(new ScrollingMovementMethod());// прокрутка текста
        who = (TextView) findViewById(R.id.who);
        time = (TextView) findViewById(R.id.time);

        open_menu = 0;//для проверки состояния меню
        open_note = 0;//для проверки состояния фрагмента
        speech_situation = 0; // для проверки состояния диалогового окна (сохранять)
        tap_situation = 0; // для проверки состояния действия (кого опрашивает) (сохранять)

        notes = (ImageView) findViewById(R.id.notes);//для фрагмента
        back = (Button) findViewById(R.id.back);

        first = (Button) findViewById(R.id.first);
        second = (Button) findViewById(R.id.second);
        third = (Button) findViewById(R.id.third);
        fourth = (Button) findViewById(R.id.fourth);
        fifth = (Button) findViewById(R.id.fifth);

        first_first = (Button) findViewById(R.id.first_first);//тела
        first_second = (Button) findViewById(R.id.first_second);
        first_third = (Button) findViewById(R.id.first_third);

        second_first = (Button) findViewById(R.id.second_first);//сестра
        second_second = (Button) findViewById(R.id.second_second);
        second_third = (Button) findViewById(R.id.second_third);
        second_fourth = (Button) findViewById(R.id.second_fourth);
        second_fifth = (Button) findViewById(R.id.second_fifth);
        second_sixth = (Button) findViewById(R.id.second_sixth);

        third_first = (Button) findViewById(R.id.third_first);//гримёрша
        third_second = (Button) findViewById(R.id.third_second);
        third_third = (Button) findViewById(R.id.third_third);
        third_fourth = (Button) findViewById(R.id.third_fourth);
        third_fifth = (Button) findViewById(R.id.third_fifth);

        fourth_first = (Button) findViewById(R.id.fourth_first);//оператор
        fourth_second = (Button) findViewById(R.id.fourth_second);
        fourth_third = (Button) findViewById(R.id.fourth_third);
        fourth_fourth = (Button) findViewById(R.id.fourth_fourth);
        fourth_fifth = (Button) findViewById(R.id.fourth_fifth);
        fourth_sixth = (Button) findViewById(R.id.fourth_sixth);
        fourth_seventh = (Button) findViewById(R.id.fourth_seventh);
        fourth_eight = (Button) findViewById(R.id.fourth_eight);

        fifth_first = (Button) findViewById(R.id.fifth_first);//директор
        fifth_second = (Button) findViewById(R.id.fifth_second);
        fifth_third = (Button) findViewById(R.id.fifth_third);
        fifth_fourth = (Button) findViewById(R.id.fifth_fourth);
        fifth_fifth = (Button) findViewById(R.id.fifth_fifth);
        fifth_sixth = (Button) findViewById(R.id.fifth_sixth);
        fifth_seventh = (Button) findViewById(R.id.fifth_seventh);


        /////////////////////////////////////время/////////////////////////////////////////////

        loadGame();
        new CountDownTimer(timeSave,1000){

            public void onTick (long millisUntilFinished){

                if (isPaused) {
                    time.setText("Пауза");
                    cancel();
                } else {

                    long minute = millisUntilFinished/ 60000;
                    long seconds = (millisUntilFinished/1000)%60;

                    if ((minute <10)&&(seconds <10)) {
                        time.setText("0"+ minute +":0" + seconds);
                    }

                    else
                    if ((minute >10)&&(seconds <10)) {
                        time.setText(minute +":0" + seconds);}

                    else
                    if ((minute <10)&&(seconds >10)) {
                        time.setText("0"+minute+":" + seconds);}

                    else
                    {
                        time.setText(minute +":" + seconds);
                    }
                    timeRemaining = millisUntilFinished;
                }

            }

            public void onFinish (){

                timeRemaining = 600000;

                speech_situation = 0;
                tap_situation = 0;
                corpse.one.said = 0;
                corpse.five.said = 0;
                corpse.seven.said = 0;

                alive_sister.one.said = 0;
                alive_sister.two.said = 0;
                alive_sister.three.said = 0;
                alive_sister.four.said = 0;
                alive_sister.five.said = 0;
                alive_sister.seven.said = 0;

                makeup.one.said = 0;
                makeup.two.said = 0;
                makeup.four.said = 0;
                makeup.six.said = 0;
                makeup.seven.said = 0;

                operator_target.one.said = 0;
                operator_target.two.said = 0;
                operator_target.four.said = 0;
                operator_target.six.said = 0;
                operator_target.seven.said = 0;
                operator_target.eight.said = 0;
                operator_target.ten.said = 0;
                operator_target.eleven.said = 0;

                director_.one.said = 0;
                director_.two.said = 0;
                director_.four.said = 0;
                director_.six.said = 0;
                director_.eight.said = 0;
                director_.ten.said = 0;
                director_.eleven.said = 0;

                saveGame();


                Intent a = new Intent(TeaPartyOfTheDead.this, WhoIsTheKiller.class);
                startActivity(a);

            }

        }.start();


        ////////////////////////фрагмент (блокнот)//////////////////////////////
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goneMain();
                goneFirst();
                goneSecond();
                goneThird();
                goneFourth();
                goneFifth();
                fragmentTransaction = getFragmentManager().beginTransaction();

                switch (open_note) {

                    case 0:
                        fragmentTransaction.add(R.id.frgmContainer,frag_note);
                        isPaused = true;
                        open_note++;
                        break;
                    case 1:
                        fragmentTransaction.remove(frag_note);
                        isPaused = false;
                        new CountDownTimer(timeRemaining,1000){

                            public void onTick (long millisUntilFinished){

                                if (isPaused) {
                                    time.setText("Пауза");
                                    cancel();
                                } else {

                                    long minute = millisUntilFinished/ 60000;
                                    long seconds = (millisUntilFinished/1000)%60;

                                    if ((minute <10)&&(seconds <10)) {
                                        time.setText("0"+ minute +":0" + seconds);
                                    }

                                    else
                                    if ((minute >10)&&(seconds <10)) {
                                        time.setText(minute +":0" + seconds);}

                                    else
                                    if ((minute <10)&&(seconds >10)) {
                                        time.setText("0"+minute+":" + seconds);}

                                    else
                                    {
                                        time.setText(minute +":" + seconds);
                                    }
                                    timeRemaining = millisUntilFinished;
                                }

                            }

                            public void onFinish (){

                                timeRemaining = 600000;

                                speech_situation = 0;
                                tap_situation = 0;
                                corpse.one.said = 0;
                                corpse.five.said = 0;
                                corpse.seven.said = 0;

                                alive_sister.one.said = 0;
                                alive_sister.two.said = 0;
                                alive_sister.three.said = 0;
                                alive_sister.four.said = 0;
                                alive_sister.five.said = 0;
                                alive_sister.seven.said = 0;

                                makeup.one.said = 0;
                                makeup.two.said = 0;
                                makeup.four.said = 0;
                                makeup.six.said = 0;
                                makeup.seven.said = 0;

                                operator_target.one.said = 0;
                                operator_target.two.said = 0;
                                operator_target.four.said = 0;
                                operator_target.six.said = 0;
                                operator_target.seven.said = 0;
                                operator_target.eight.said = 0;
                                operator_target.ten.said = 0;
                                operator_target.eleven.said = 0;

                                director_.one.said = 0;
                                director_.two.said = 0;
                                director_.four.said = 0;
                                director_.six.said = 0;
                                director_.eight.said = 0;
                                director_.ten.said = 0;
                                director_.eleven.said = 0;

                                saveGame();

                                Intent a = new Intent(TeaPartyOfTheDead.this, WhoIsTheKiller.class);
                                startActivity(a);
                            }

                        }.start();

                        open_note--;
                        break;
                    default:
                        break;
                }

                fragmentTransaction.commit();
            }
        });

        /////////////////////////////////////запуск/////////////////////////////////////////////
        if (speech_situation == 0) {
            director.setVisibility(View.VISIBLE); //начало
            who.setText("Анатолий Дмитреевич"); //начало
            speech.setText("Как хорошо, что вы прибыли так быстро. Хотелось бы разобраться с этим как можно скорее."); //начало
        } else {
            who.setText(" ");
            speech.setText("Нажмите на верхнюю часть экрана, чтобы открыть список доступных действий.");
        }

        switch (tap_situation) {

            case 3: {
                who.setText("Елена Стурапова");
                sister.setVisibility(View.VISIBLE);
                break;
            }
            case 4: {
                who.setText("Люся Манеева");
                luci.setVisibility(View.VISIBLE);
                break;
            }
            case 5: {
                who.setText("Даниил Скачков");
                operator.setVisibility(View.VISIBLE);
                break;
            }
            case 6: {
                who.setText("Генадий Скачков");
                director.setVisibility(View.VISIBLE);
                break;
            }

        }

    }

    /////////////////////////////////////////////сохранение/////////////////////////////////////////
    void saveGame(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        timeSave = timeRemaining;

        ed.putLong(SAVED_TIME, timeSave);
        ed.putInt(SPEECH_SITUATION, speech_situation);
        ed.putInt(TAP_SITUATION, tap_situation);

        ed.putInt(CORPSE_ONE, corpse.one.said);
        ed.putInt(CORPSE_FIVE, corpse.five.said);
        ed.putInt(CORPSE_SEVEN, corpse.seven.said);

        ed.putInt(SISTER_ONE, alive_sister.one.said);
        ed.putInt(SISTER_TWO, alive_sister.two.said);
        ed.putInt(SISTER_THREE, alive_sister.three.said);
        ed.putInt(SISTER_FOUR, alive_sister.four.said);
        ed.putInt(SISTER_FIVE, alive_sister.five.said);
        ed.putInt(SISTER_SEVEN, alive_sister.seven.said);

        ed.putInt(MAKEUP_ONE, makeup.one.said);
        ed.putInt(MAKEUP_TWO, makeup.two.said);
        ed.putInt(MAKEUP_FOUR,makeup.four.said);
        ed.putInt(MAKEUP_SIX, makeup.six.said);
        ed.putInt(MAKEUP_SEVEN, makeup.seven.said);

        ed.putInt(OPERATOR_ONE, operator_target.one.said);
        ed.putInt(OPERATOR_TWO, operator_target.two.said);
        ed.putInt(OPERATOR_FOUR, operator_target.four.said);
        ed.putInt(OPERATOR_SIX, operator_target.six.said);
        ed.putInt(OPERATOR_SEVEN, operator_target.seven.said);
        ed.putInt(OPERATOR_EIGHT, operator_target.eight.said);
        ed.putInt(OPERATOR_TEN, operator_target.ten.said);
        ed.putInt(OPERATOR_ELEVEN, operator_target.eleven.said);

        ed.putInt(DIRECTOR_ONE, director_.one.said);
        ed.putInt(DIRECTOR_TWO, director_.two.said);
        ed.putInt(DIRECTOR_FOUR, director_.four.said);
        ed.putInt(DIRECTOR_SIX, director_.six.said);
        ed.putInt(DIRECTOR_EIGHT, director_.eight.said);
        ed.putInt(DIRECTOR_TEN, director_.ten.said);
        ed.putInt(DIRECTOR_ELEVEN, director_.eleven.said);

        ed.commit();
    }

    void loadGame(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        timeSave = sharedPreferences.getLong(SAVED_TIME, 600000);
        speech_situation = sharedPreferences.getInt(SPEECH_SITUATION,0);
        tap_situation = sharedPreferences.getInt(TAP_SITUATION,0);

        corpse.one.said = sharedPreferences.getInt(CORPSE_ONE,0);
        corpse.five.said = sharedPreferences.getInt(CORPSE_FIVE,0);
        corpse.seven.said = sharedPreferences.getInt(CORPSE_SEVEN,0);

        alive_sister.one.said = sharedPreferences.getInt(SISTER_ONE,0);
        alive_sister.two.said = sharedPreferences.getInt(SISTER_TWO,0);
        alive_sister.three.said = sharedPreferences.getInt(SISTER_THREE,0);
        alive_sister.four.said = sharedPreferences.getInt(SISTER_FOUR,0);
        alive_sister.five.said = sharedPreferences.getInt(SISTER_FIVE,0);
        alive_sister.seven.said = sharedPreferences.getInt(SISTER_SEVEN,0);

        makeup.one.said = sharedPreferences.getInt(MAKEUP_ONE,0);
        makeup.two.said = sharedPreferences.getInt(MAKEUP_TWO,0);
        makeup.four.said = sharedPreferences.getInt(MAKEUP_FOUR,0);
        makeup.six.said = sharedPreferences.getInt(MAKEUP_SIX,0);
        makeup.seven.said = sharedPreferences.getInt(MAKEUP_SEVEN,0);

        operator_target.one.said = sharedPreferences.getInt(OPERATOR_ONE,0);
        operator_target.two.said = sharedPreferences.getInt(OPERATOR_TWO,0);
        operator_target.four.said = sharedPreferences.getInt(OPERATOR_FOUR,0);
        operator_target.six.said = sharedPreferences.getInt(OPERATOR_SIX,0);
        operator_target.seven.said = sharedPreferences.getInt(OPERATOR_SEVEN,0);
        operator_target.eight.said = sharedPreferences.getInt(OPERATOR_EIGHT,0);
        operator_target.ten.said = sharedPreferences.getInt(OPERATOR_TEN,0);
        operator_target.eleven.said = sharedPreferences.getInt(OPERATOR_ELEVEN,0);

        director_.one.said = sharedPreferences.getInt(DIRECTOR_ONE,0);
        director_.two.said = sharedPreferences.getInt(DIRECTOR_TWO,0);
        director_.four.said = sharedPreferences.getInt(DIRECTOR_FOUR,0);
        director_.six.said = sharedPreferences.getInt(DIRECTOR_SIX,0);
        director_.eight.said = sharedPreferences.getInt(DIRECTOR_EIGHT,0);
        director_.ten.said = sharedPreferences.getInt(DIRECTOR_TEN,0);
        director_.eleven.said = sharedPreferences.getInt(DIRECTOR_ELEVEN,0);

    }

    ////////////////////////////появление нужных кнопок при нажатии на экран//////////////////////
    @Override
    public boolean onTouchEvent (MotionEvent event){

        switch (tap_situation) {

            case 1:
                who.setText(" ");
                speech.setText("Кого опросим?");

                first.setVisibility(View.VISIBLE);
                second.setVisibility(View.VISIBLE);
                third.setVisibility(View.VISIBLE);
                fourth.setVisibility(View.VISIBLE);
                fifth.setVisibility(View.VISIBLE);
                break;

            case 2://тела

                if (corpse.one.said == 0){
                    first_first.setVisibility(View.VISIBLE);
                }

                if (corpse.five.said == 0) {
                    first_second.setVisibility(View.VISIBLE);
                }

                if (corpse.seven.said == 0) {
                    first_third.setVisibility(View.VISIBLE);
                }

                back.setVisibility(View.VISIBLE);
                break;

            case 3://сестра

                if (alive_sister.one.said == 0){
                    second_first.setVisibility(View.VISIBLE);
                }

                if (alive_sister.two.said == 0){
                    second_second.setVisibility(View.VISIBLE);
                }

                if (alive_sister.three.said == 0){
                    second_third.setVisibility(View.VISIBLE);
                }

                if (alive_sister.four.said == 0){
                    second_fourth.setVisibility(View.VISIBLE);
                }

                if (alive_sister.five.said == 0){
                    second_fifth.setVisibility(View.VISIBLE);
                }

                if (alive_sister.seven.said == 0){
                    second_sixth.setVisibility(View.VISIBLE);
                }

                back.setVisibility(View.VISIBLE);
                break;

            case 4://гримёрша

                if (makeup.one.said == 0){
                    third_first.setVisibility(View.VISIBLE);
                }

                if (makeup.two.said == 0){
                    third_second.setVisibility(View.VISIBLE);
                }

                if (makeup.four.said == 0){
                    third_third.setVisibility(View.VISIBLE);
                }

                if (makeup.six.said == 0){
                    third_fourth.setVisibility(View.VISIBLE);
                }

                if (makeup.seven.said == 0){
                    third_fifth.setVisibility(View.VISIBLE);
                }

                back.setVisibility(View.VISIBLE);
                break;

            case 5://оператор

                int educ = (alive_sister.seven.said + makeup.six.said + operator_target.six.said + operator_target.ten.said + director_.eight.said);//доп. вопрос
                int money = (alive_sister.seven.said + makeup.six.said + operator_target.four.said + director_.eight.said);//доп. вопрос
                int conflict = (makeup.six.said + operator_target.four.said + operator_target.ten.said + director_.four.said);//доп. вопрос

                if (operator_target.one.said == 0){
                    fourth_first.setVisibility(View.VISIBLE);
                }

                if (operator_target.two.said == 0){
                    fourth_second.setVisibility(View.VISIBLE);
                }

                if (operator_target.four.said == 0){
                    fourth_third.setVisibility(View.VISIBLE);
                }

                if (operator_target.six.said == 0){
                    fourth_fourth.setVisibility(View.VISIBLE);
                }

                if (operator_target.seven.said == 0){
                    fourth_fifth.setVisibility(View.VISIBLE);
                }



                if (operator_target.eight.said == 0 && educ>0){
                    fourth_sixth.setVisibility(View.VISIBLE);
                }

                if (operator_target.ten.said == 0 && money>0){
                    fourth_seventh.setVisibility(View.VISIBLE);
                }

                if (operator_target.eleven.said == 0 && conflict>0){
                    fourth_eight.setVisibility(View.VISIBLE);
                }


                back.setVisibility(View.VISIBLE);
                break;

            case 6://директор

                int educd = (alive_sister.five.said + operator_target.six.said);
                int conflictd = (makeup.two.said + makeup.seven.said + director_.two.said);

                if (director_.one.said == 0){
                    fifth_first.setVisibility(View.VISIBLE);
                }

                if (director_.two.said == 0){
                    fifth_second.setVisibility(View.VISIBLE);
                }

                if (director_.four.said == 0){
                    fifth_third.setVisibility(View.VISIBLE);
                }

                if (director_.six.said == 0){
                    fifth_fourth.setVisibility(View.VISIBLE);
                }

                if (director_.eight.said == 0){
                    fifth_fifth.setVisibility(View.VISIBLE);
                }



                if (director_.ten.said == 0 && educd >0){
                    fifth_sixth.setVisibility(View.VISIBLE);
                }

                if (director_.eleven.said == 0 && conflictd >0){
                    fifth_seventh.setVisibility(View.VISIBLE);
                }

                back.setVisibility(View.VISIBLE);
                break;

            default:
                break;
        }
        return true;
    }


    ///////////////////////////////////////////////меню///////////////////////////////////////////
    public void menu (View view) {

        if (open_menu == 0) {
        menuLayout.setVisibility(View.VISIBLE);
        goneMain();
        goneFirst();
        goneSecond();
        goneThird();
        goneFourth();
        goneFifth();
        open_menu++;

        isPaused = true;

    } else {
            menuLayout.setVisibility(View.GONE);
            open_menu--;

            isPaused = false;
            new CountDownTimer(timeRemaining,1000){

                public void onTick (long millisUntilFinished){

                    if (isPaused) {
                        time.setText("Пауза");
                        cancel();
                    } else {

                        long minute = millisUntilFinished/ 60000;
                        long seconds = (millisUntilFinished/1000)%60;

                        if ((minute <10)&&(seconds <10)) {
                            time.setText("0"+ minute +":0" + seconds);
                        }

                        else
                        if ((minute >10)&&(seconds <10)) {
                            time.setText(minute +":0" + seconds);}

                        else
                        if ((minute <10)&&(seconds >10)) {
                            time.setText("0"+minute+":" + seconds);}

                        else
                        {
                            time.setText(minute +":" + seconds);
                        }
                        timeRemaining = millisUntilFinished;
                    }

                }

                public void onFinish (){

                    timeRemaining = 600000;

                    speech_situation = 0;
                    tap_situation = 0;
                    corpse.one.said = 0;
                    corpse.five.said = 0;
                    corpse.seven.said = 0;

                    alive_sister.one.said = 0;
                    alive_sister.two.said = 0;
                    alive_sister.three.said = 0;
                    alive_sister.four.said = 0;
                    alive_sister.five.said = 0;
                    alive_sister.seven.said = 0;

                    makeup.one.said = 0;
                    makeup.two.said = 0;
                    makeup.four.said = 0;
                    makeup.six.said = 0;
                    makeup.seven.said = 0;

                    operator_target.one.said = 0;
                    operator_target.two.said = 0;
                    operator_target.four.said = 0;
                    operator_target.six.said = 0;
                    operator_target.seven.said = 0;
                    operator_target.eight.said = 0;
                    operator_target.ten.said = 0;
                    operator_target.eleven.said = 0;

                    director_.one.said = 0;
                    director_.two.said = 0;
                    director_.four.said = 0;
                    director_.six.said = 0;
                    director_.eight.said = 0;
                    director_.ten.said = 0;
                    director_.eleven.said = 0;

                    saveGame();

                    Intent a = new Intent(TeaPartyOfTheDead.this, WhoIsTheKiller.class);
                    startActivity(a);
                }

            }.start();
        }

    }

    ////////////////////////////////////////////выход///////////////////////////////////////////
    public void exit (View view) {
        Intent i;
        i = new Intent(TeaPartyOfTheDead.this, MainActivity.class);
        startActivity(i);
    }

    ////////////////////////////////////////////правила///////////////////////////////////////////
    public void rules (View view) {
        Intent i;
        i = new Intent(TeaPartyOfTheDead.this, Rules.class);
        startActivity(i);
    }

    ////////////////////////сохранение по нажатию кнопки///////////////////////////////////////////

    public void saving (View view) {
        saveGame();
        Toast toast = Toast.makeText(getApplicationContext(),
                "Сохранено", Toast.LENGTH_SHORT);
        toast.show();
    }

    //////////////////////////////////// нажатие диалогового окна (самое начало игры)/////////////////////////////////
    public void speech (View view){

        switch (speech_situation){
            case 0:
                who.setText("Вы");
                speech.setText("Мне сказали, что тут массовое убийство. Сколько человек погибло?");
                speech_situation++;
                break;
            case 1:
                who.setText("Анатолий Дмитреевич");
                speech.setText("Трое наших актёров. Наталья Стурапова,Георгий Жирнов и Макар Ларуев. Это… это ужасно, они погибли буквально на наших глазах, а мы даже этого и не поняли сразу.");
                speech_situation ++;
                break;
            case 2:
                who.setText("Вы");
                speech.setText("Как это произошло?");
                speech_situation++;
                break;
            case 3:
                who.setText("Анатолий Дмитреевич");
                speech.setText("Мы снимали сцену отравления для сериала. По сюжету, одна из двух близняшек должна была налить яд в чай своего отца, "+
                        "сестры и гостя. Мы… мы даже не поняли сразу, что яд оказался настоящим. Думали, что это просто очень качественная игра. "+
                        "Поняли, только когда выжившая близняшка подняла тревогу. Мы вызвали скорую, но как оказалось было слишком поздно.");
                speech_situation ++;
                break;
            case 4:
                who.setText("Вы");
                speech.setText("Ясно. Будьте добры, проводите меня к месту преступления.");
                speech_situation++;
                break;
            case 5:
                who.setText("Анатолий Дмитреевич");
                speech.setText("А? Да да, конечно, пройдёмте.");
                speech_situation ++;
                break;
            case 6:
                director.setVisibility(View.GONE);
                who.setText(" ");
                speech.setText("Проводив вас, он сказал, что будет недалеко и, если вам понадобится узнать о чём-то ещё, он с радостью ответит на ваши вопросы.");
                speech_situation ++;
                break;
            case 7:
                who.setText(" ");
                speech.setText("Нажмите на верхнюю часть экрана, чтобы открыть список доступных действий.");
                speech_situation++;
                tap_situation=1;
                break;
            default:
                break;
        }

    }


    /////////////////////////////////возвращение к первому выбору////////////////////////////////
    public void back (View view){

        who.setText(" ");
        speech.setText("Кого опросим?");
        
        switch (tap_situation){

            case 2://тела

                first_first.setVisibility(View.GONE);
                first_second.setVisibility(View.GONE);
                first_third.setVisibility(View.GONE);
                break;

            case 3://сестра

                second_first.setVisibility(View.GONE);
                second_second.setVisibility(View.GONE);
                second_third.setVisibility(View.GONE);
                second_fourth.setVisibility(View.GONE);
                second_fifth.setVisibility(View.GONE);
                second_sixth.setVisibility(View.GONE);
                sister.setVisibility(View.GONE);
                break;

            case 4://гримёрша

                third_first.setVisibility(View.GONE);
                third_second.setVisibility(View.GONE);
                third_third.setVisibility(View.GONE);
                third_fourth.setVisibility(View.GONE);
                third_fifth.setVisibility(View.GONE);
                luci.setVisibility(View.GONE);
                break;

            case 5://оператор

                fourth_first.setVisibility(View.GONE);
                fourth_second.setVisibility(View.GONE);
                fourth_third.setVisibility(View.GONE);
                fourth_fourth.setVisibility(View.GONE);
                fourth_fifth.setVisibility(View.GONE);
                fourth_sixth.setVisibility(View.GONE);
                fourth_seventh.setVisibility(View.GONE);
                fourth_eight.setVisibility(View.GONE);
                operator.setVisibility(View.GONE);
                break;

            case 6://директор

                fifth_first.setVisibility(View.GONE);
                fifth_second.setVisibility(View.GONE);
                fifth_third.setVisibility(View.GONE);
                fifth_fourth.setVisibility(View.GONE);
                fifth_fifth.setVisibility(View.GONE);
                fifth_sixth.setVisibility(View.GONE);
                fifth_seventh.setVisibility(View.GONE);
                director.setVisibility(View.GONE);
                break;

            default:
                break;

        }


        back.setVisibility(View.GONE);
        tap_situation = 1;
    }


    //////////////////////////////появление и исчезновение кнопок//////////////////////////////
    protected void goneMain () {
        first.setVisibility(View.GONE);
        second.setVisibility(View.GONE);
        third.setVisibility(View.GONE);
        fourth.setVisibility(View.GONE);
        fifth.setVisibility(View.GONE);
    }

    protected void goneFirst () {
        first_first.setVisibility(View.GONE);
        first_second.setVisibility(View.GONE);
        first_third.setVisibility(View.GONE);
        back.setVisibility(View.GONE);
    }

    protected void goneSecond () {
        second_first.setVisibility(View.GONE);
        second_second.setVisibility(View.GONE);
        second_third.setVisibility(View.GONE);
        second_fourth.setVisibility(View.GONE);
        second_fifth.setVisibility(View.GONE);
        second_sixth.setVisibility(View.GONE);
        back.setVisibility(View.GONE);
    }

    protected void goneThird () {
        third_first.setVisibility(View.GONE);
        third_second.setVisibility(View.GONE);
        third_third.setVisibility(View.GONE);
        third_fourth.setVisibility(View.GONE);
        third_fifth.setVisibility(View.GONE);
        back.setVisibility(View.GONE);
    }

    protected void goneFourth () {
        fourth_first.setVisibility(View.GONE);
        fourth_second.setVisibility(View.GONE);
        fourth_third.setVisibility(View.GONE);
        fourth_fourth.setVisibility(View.GONE);
        fourth_fifth.setVisibility(View.GONE);
        fourth_sixth.setVisibility(View.GONE);
        fourth_seventh.setVisibility(View.GONE);
        fourth_eight.setVisibility(View.GONE);
        back.setVisibility(View.GONE);
    }

    protected void goneFifth () {
        fifth_first.setVisibility(View.GONE);
        fifth_second.setVisibility(View.GONE);
        fifth_third.setVisibility(View.GONE);
        fifth_fourth.setVisibility(View.GONE);
        fifth_fifth.setVisibility(View.GONE);
        fifth_sixth.setVisibility(View.GONE);
        fifth_seventh.setVisibility(View.GONE);
        back.setVisibility(View.GONE);
    }

    ///////////////////////////////////////первый выбор//////////////////////////////////////
    public void first (View view){
        goneMain();
        who.setText("");
        speech.setText("Кого осмотреть?");
        tap_situation= 2;
    }//тела

    public void second (View view){
        goneMain();

        int ask_sister = (alive_sister.one.said + alive_sister.two.said + alive_sister.three.said +
                alive_sister.four.said +alive_sister.five.said +alive_sister.seven.said);//сколько задал вопросов

        who.setText("Вы");

        if (ask_sister < 3) {
            speech.setText("Здравствуйте, сожалею о вашей потере, позвольте задать вам несколько вопросов.");
        } else
        {
            speech.setText("(Пожалуй больше информации вы от неё не получите.)");
        }
        sister.setVisibility(View.VISIBLE);
        tap_situation= 3;
    }//сестра

    public void third (View view){
        goneMain();

        who.setText("Вы");
        speech.setText("Здравствуйте, позвольте задать вам несколько вопросов.");
        luci.setVisibility(View.VISIBLE);
        tap_situation= 4;
    }//гримёрша

    public void fourth (View view){
        goneMain();

        who.setText("Вы");
        speech.setText("Здравствуйте, позвольте задать вам несколько вопросов.");
        operator.setVisibility(View.VISIBLE);
        tap_situation= 5;
    }//оператор

    public void fifth (View view){
        goneMain();

        who.setText("Вы");
        speech.setText("Позвольте задать вам ещё несколько вопросов.");
        director.setVisibility(View.VISIBLE);
        tap_situation= 6;
    }//директор


    ////////////////////////////////////////тела/////////////////////////////////////////////
    public void first_first (View view){
        goneFirst();

        int seen = (corpse.one.said + corpse.five.said + corpse.seven.said);//видел ли труп (в классе нельзя так как не пересчитывает)
        int seen_sister = (alive_sister.one.said + alive_sister.two.said + alive_sister.three.said +
                alive_sister.four.said +alive_sister.five.said +alive_sister.seven.said); //видел ли живую сестру

        who.setText("");

        if (seen == 0 && seen_sister == 0) {
            speech.setText(corpse.one.question +"\n\n" + corpse.one.text);
        }
        else if (seen > 0 && seen_sister == 0){
            speech.setText(corpse.one.question +"\n\n" +corpse.two.text);
        }
        else if (seen == 0 && seen_sister > 0){
            speech.setText(corpse.one.question +"\n\n" +corpse.three.text);
        }
        else {
            speech.setText(corpse.one.question +"\n\n" +corpse.four.text);
        }

        corpse.one.said = 1;
    }

    public void first_second (View view){
        goneFirst();

        int seen = (corpse.one.said + corpse.five.said + corpse.seven.said); //видел ли труп
        who.setText("");

        if (seen == 0) {
            speech.setText(corpse.five.question+"\n\n" +corpse.five.text);
        }
        else {
            speech.setText(corpse.five.question+"\n\n" +corpse.six.text);
        }

        corpse.five.said = 1;
    }

    public void first_third (View view){
        goneFirst();

        int seen = (corpse.one.said + corpse.five.said + corpse.seven.said); //видел ли труп
        who.setText("");

        if (seen == 0) {
            speech.setText(corpse.seven.question+"\n\n" +corpse.seven.text);
        }
        else {
            speech.setText(corpse.seven.question+"\n\n" +corpse.eight.text);
        }

        corpse.seven.said = 1;
    }


    ////////////////////////////////////////сестра////////////////////////////////////////////
    public void second_first (View view){
        goneSecond();

        int ask_sister = (alive_sister.one.said + alive_sister.two.said + alive_sister.three.said +
                alive_sister.four.said +alive_sister.five.said +alive_sister.seven.said);//сколько задал вопросов

        who.setText("Елена Стурапова");

        if (ask_sister < 2) {
            speech.setText(alive_sister.one.question + "\n\n" + alive_sister.one.text);
        }
        else if (ask_sister == 2)
        {
            speech.setText(alive_sister.one.question+"\n\nЗачем вы так много спрашиваете? Вы должны треклятого убийцу искать, а не языком чесать!");
        }
        else if (ask_sister == 3)
        {
            speech.setText(alive_sister.one.question+"\n\nХватит! Я вам много рассказала! Идите уже, ищите того, кто убил мою близняшку!");
        } else
        {
            speech.setText(alive_sister.one.question+"\n\n......\n(Похоже больше информации вы от неё не получите.)");
        }

        alive_sister.one.said = 1;
    }

    public void second_second (View view){
        goneSecond();

        int ask_sister = (alive_sister.one.said + alive_sister.two.said + alive_sister.three.said +
                alive_sister.four.said +alive_sister.five.said +alive_sister.seven.said);//сколько задал вопросов

        who.setText("Елена Стурапова");

        if (ask_sister < 2) {
            speech.setText(alive_sister.two.question+"\n\n" + alive_sister.two.text);
        }
        else if (ask_sister == 2)
        {
            speech.setText(alive_sister.two.question+"\n\nЗачем вы так много спрашиваете? Вы должны треклятого убийцу искать, а не языком чесать!");
        }
        else if (ask_sister == 3)
        {
            speech.setText(alive_sister.two.question+"\n\nХватит! Я вам много рассказала! Идите уже, ищите того, кто убил мою близняшку!");
        } else
        {
            speech.setText(alive_sister.two.question+"\n\n......\n(Похоже больше информации вы от неё не получите.)");
        }

        alive_sister.two.said = 1;
    }

    public void second_third (View view){
        goneSecond();

        int ask_sister = (alive_sister.one.said + alive_sister.two.said + alive_sister.three.said +
                alive_sister.four.said +alive_sister.five.said +alive_sister.seven.said);//сколько задал вопросов

        who.setText("Елена Стурапова");

        if (ask_sister < 2) {
            speech.setText(alive_sister.three.question+"\n\n" + alive_sister.three.text);
        }
        else if (ask_sister == 2)
        {
            speech.setText(alive_sister.three.question+"\n\nЗачем вы так много спрашиваете? Вы должны треклятого убийцу искать, а не языком чесать!");
        }
        else if (ask_sister == 3)
        {
            speech.setText(alive_sister.three.question+"\n\nХватит! Я вам много рассказала! Идите уже, ищите того, кто убил мою близняшку!");
        } else
        {
            speech.setText(alive_sister.three.question+"\n\n......\n(Похоже больше информации вы от неё не получите.)");
        }

        alive_sister.three.said = 1;
    }

    public void second_fourth (View view){
        goneSecond();

        int ask_sister = (alive_sister.one.said + alive_sister.two.said + alive_sister.three.said +
                alive_sister.four.said +alive_sister.five.said +alive_sister.seven.said);//сколько задал вопросов

        who.setText("Елена Стурапова");

        if (ask_sister < 2) {
            speech.setText(alive_sister.four.question+"\n\n" + alive_sister.four.text);
        }
        else if (ask_sister == 2)
        {
            speech.setText(alive_sister.four.question+"\n\nЗачем вы так много спрашиваете? Вы должны треклятого убийцу искать, а не языком чесать!");
        }
        else if (ask_sister == 3)
        {
            speech.setText(alive_sister.four.question+"\n\nХватит! Я вам много рассказала! Идите уже, ищите того, кто убил мою близняшку!");
        } else
        {
            speech.setText(alive_sister.four.question+"\n\n......\n(Похоже больше информации вы от неё не получите.)");
        }

        alive_sister.four.said = 1;
    }

    public void second_fifth (View view){
        goneSecond();

        int ask_sister = (alive_sister.one.said + alive_sister.two.said + alive_sister.three.said +
                alive_sister.four.said +alive_sister.five.said +alive_sister.seven.said);//сколько задал вопросов

        who.setText("Елена Стурапова");

        if (ask_sister < 2) {

            if (alive_sister.seven.said == 0) {
                speech.setText(alive_sister.five.question+"\n\n" + alive_sister.five.text);
            } else
            {
                speech.setText(alive_sister.five.question+"\n\n" + alive_sister.six.text);
            }

        }
        else if (ask_sister == 2)
        {
            speech.setText(alive_sister.five.question+"\n\nЗачем вы так много спрашиваете? Вы должны треклятого убийцу искать, а не языком чесать!");
        }
        else if (ask_sister == 3)
        {
            speech.setText(alive_sister.five.question+"\n\nХватит! Я вам много рассказала! Идите уже, ищите того, кто убил мою близняшку!");
        } else
        {
            speech.setText(alive_sister.five.question+"\n\n......\n(Похоже больше информации вы от неё не получите.)");
        }



        ///////////////всплывающее сообщение/////////
        if (operator_target.six.said ==0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "К директору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }

        alive_sister.five.said = 1;
    }

    public void second_sixth (View view){
        goneSecond();

        int ask_sister = (alive_sister.one.said + alive_sister.two.said + alive_sister.three.said +
                alive_sister.four.said +alive_sister.five.said +alive_sister.seven.said);//сколько задал вопросов

        who.setText("Елена Стурапова");

        if (ask_sister < 2) {

            if (alive_sister.five.said == 0) {
                speech.setText(alive_sister.seven.question+"\n\n" + alive_sister.seven.text);
            } else
            {
                speech.setText(alive_sister.seven.question+"\n\n" + alive_sister.eight.text);
            }

        }
        else if (ask_sister == 2)
        {
            speech.setText(alive_sister.seven.question+"\n\nЗачем вы так много спрашиваете? Вы должны треклятого убийцу искать, а не языком чесать!");
        }
        else if (ask_sister == 3)
        {
            speech.setText(alive_sister.seven.question+"\n\nХватит! Я вам много рассказала! Идите уже, ищите того, кто убил мою близняшку!");
        } else
        {
            speech.setText(alive_sister.seven.question+"\n\n......\n(Похоже больше информации вы от неё не получите.)");
        }



        ///////////////всплывающее сообщение/////////
        if (((makeup.six.said + operator_target.six.said + operator_target.ten.said + director_.eight.said) ==0) || ((makeup.six.said + operator_target.four.said + director_.eight.said) ==0))  {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "К оператору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }

        alive_sister.seven.said = 1;
    }


    /////////////////////////////////////////гримёрша//////////////////////////////////////////
    public void third_first (View view){
        goneThird();

        who.setText("Люся Манеева");

        speech.setText(makeup.one.question+"\n\n" + makeup.one.text);

        makeup.one.said = 1;
    }

    public void third_second (View view){
        goneThird();

        who.setText("Люся Манеева");

        if (makeup.seven.said == 0){
            speech.setText(makeup.two.question+"\n\n" + makeup.two.text);
        } else
        {
            speech.setText(makeup.two.question+"\n\n" + makeup.three.text);
        }


        ///////////////всплывающее сообщение/////////
        if ( (makeup.seven.said + director_.two.said) ==0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "К оператору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }

        makeup.two.said = 1;
}

    public void third_third (View view){
        goneThird();

        who.setText("Люся Манеева");

        if (makeup.one.said == 0){
            speech.setText(makeup.four.question+"\n\n" + makeup.four.text);
        } else
        {
            speech.setText(makeup.four.question+"\n\n" + makeup.five.text);
        }

        makeup.four.said = 1;
    }

    public void third_fourth (View view){
        goneThird();

        who.setText("Люся Манеева");

        speech.setText(makeup.six.question+"\n\n" + makeup.six.text);



        ///////////////всплывающее сообщение/////////
        if (( (alive_sister.seven.said + operator_target.six.said + operator_target.ten.said + director_.eight.said) ==0) ||

        ((alive_sister.seven.said + operator_target.four.said + director_.eight.said) ==0) ||

        ((operator_target.four.said + operator_target.ten.said + director_.four.said) ==0)) {

            Toast toast = Toast.makeText(getApplicationContext(),
                    "К оператору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }


        makeup.six.said = 1;
    }

    public void third_fifth (View view){
        goneThird();

        who.setText("Люся Манеева");

        if (makeup.two.said == 0){
            speech.setText(makeup.seven.question+"\n\n" + makeup.seven.text);
        } else
        {
            speech.setText(makeup.seven.question+"\n\n" + makeup.eight.text);
        }



        ///////////////всплывающее сообщение/////////
        if ( (makeup.two.said + director_.two.said) ==0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "К директору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }

        makeup.seven.said = 1;
    }


    ////////////////////////////////////////оператор/////////////////////////////////////////////
    public void fourth_first (View view) {
        goneFourth();

        who.setText("Даниил Скачков");

        speech.setText(operator_target.one.question+"\n\n" + operator_target.one.text);

        operator_target.one.said = 1;
    }

    public void fourth_second (View view) {
        goneFourth();

        who.setText("Даниил Скачков");

        if (operator_target.six.said == 0){
            speech.setText(operator_target.two.question+"\n\n" + operator_target.two.text);
        } else {
            speech.setText(operator_target.two.question+"\n\n" + operator_target.three.text);
        }

        operator_target.two.said = 1;
    }

    public void fourth_third (View view) {
        goneFourth();

        who.setText("Даниил Скачков");

        if (operator_target.eleven.said == 0){
            speech.setText(operator_target.four.question+"\n\n" + operator_target.four.text);
        } else {
            speech.setText(operator_target.four.question+"\n\n" + operator_target.five.text);
        }



        ///////////////всплывающее сообщение/////////
        if ( ((alive_sister.seven.said + makeup.six.said + director_.eight.said) ==0) ||
                ((makeup.six.said + operator_target.ten.said + director_.four.said) ==0)) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "К оператору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }

        operator_target.four.said = 1;
    }

    public void fourth_fourth (View view) {
        goneFourth();

        who.setText("Даниил Скачков");

        speech.setText(operator_target.six.question+"\n\n" + operator_target.six.text);



        ///////////////всплывающее сообщение/////////


        if ( ((alive_sister.seven.said + makeup.six.said + operator_target.ten.said + director_.eight.said) ==0) && (alive_sister.five.said == 0) ) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "К оператору и директору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if ((alive_sister.seven.said + makeup.six.said + operator_target.ten.said + director_.eight.said) ==0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "К оператору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (alive_sister.five.said ==0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "К директору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }

        operator_target.six.said = 1;
    }

    public void fourth_fifth (View view) {
        goneFourth();

        who.setText("Даниил Скачков");

        speech.setText(operator_target.seven.question+"\n\n" + operator_target.seven.text);

        operator_target.seven.said = 1;
    }

    public void fourth_sixth (View view) {
        goneFourth();

        who.setText("Даниил Скачков");

        if (operator_target.six.said == 0){
            speech.setText(operator_target.eight.question+"\n\n" + operator_target.eight.text);
        } else {
            speech.setText(operator_target.eight.question+"\n\n" + operator_target.nine.text);
        }

        operator_target.eight.said = 1;
    }

    public void fourth_seventh (View view) {
        goneFourth();

        who.setText("Даниил Скачков");

        speech.setText(operator_target.ten.question+"\n\n" + operator_target.ten.text);


        ///////////////всплывающее сообщение/////////
        if (( (alive_sister.seven.said + makeup.six.said + operator_target.six.said + director_.eight.said) ==0) ||((makeup.six.said + operator_target.four.said + director_.four.said) ==0) ) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "К оператору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }

        operator_target.ten.said = 1;
    }

    public void fourth_eight (View view) {
        goneFourth();

        who.setText("Даниил Скачков");

        if (operator_target.four.said == 0){
            speech.setText(operator_target.eleven.question+"\n\n" + operator_target.eleven.text);
        } else {
            speech.setText(operator_target.eleven.question+"\n\n" + operator_target.twelve.text);
        }

        operator_target.eleven.said = 1;
    }

    ////////////////////////////////////////директор/////////////////////////////////////////////
    public void fifth_first (View view) {
        goneFifth();

        who.setText("Генадий Скачков");

        speech.setText(director_.one.question+"\n\n" + director_.one.text);

        director_.one.said = 1;
    }

    public void fifth_second (View view) {
        goneFifth();

        who.setText("Генадий Скачков");

        if (director_.eleven.said == 0){
            speech.setText(director_.two.question+"\n\n" + director_.two.text);
        } else {
            speech.setText(director_.two.question+"\n\n" + director_.three.text);
        }



        ///////////////всплывающее сообщение/////////
        if ( (makeup.two.said + makeup.seven.said) ==0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "К директору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }

        director_.two.said = 1;
    }

    public void fifth_third (View view) {
        goneFifth();

        who.setText("Генадий Скачков");

        if (director_.eight.said == 0){
            speech.setText(director_.four.question+"\n\n" + director_.four.text);
        } else {
            speech.setText(director_.four.question+"\n\n" + director_.five.text);
        }



        ///////////////всплывающее сообщение/////////
        if ( (makeup.six.said + operator_target.four.said + operator_target.ten.said) ==0) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "К оператору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }

        director_.four.said = 1;
    }

    public void fifth_fourth (View view) {
        goneFifth();

        who.setText("Генадий Скачков");

        if (director_.one.said == 0){
            speech.setText(director_.six.question+"\n\n" + director_.six.text);
        } else {
            speech.setText(director_.six.question+"\n\n" + director_.seven.text);
        }

        director_.six.said = 1;
    }

    public void fifth_fifth (View view) {
        goneFifth();

        who.setText("Генадий Скачков");

        if (director_.four.said == 0){
            speech.setText(director_.eight.question+"\n\n" + director_.eight.text);
        } else {
            speech.setText(director_.eight.question+"\n\n" + director_.nine.text);
        }



        ///////////////всплывающее сообщение/////////
        if (((alive_sister.seven.said + makeup.six.said + operator_target.six.said + operator_target.ten.said) ==0) ||
                ( (alive_sister.seven.said + makeup.six.said + operator_target.four.said) ==0) ) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "К оператору появились новые вопросы", Toast.LENGTH_SHORT);
            toast.show();
        }
        director_.eight.said = 1;
    }

    public void fifth_sixth (View view) {
        goneFifth();

        who.setText("Генадий Скачков");

        speech.setText(director_.ten.question+"\n\n" + director_.ten.text);

        director_.ten.said = 1;
    }

    public void fifth_seventh (View view) {
        goneFifth();

        who.setText("Генадий Скачков");

        if (director_.two.said == 0){
            speech.setText(director_.eleven.question+"\n\n" + director_.eleven.text);
        } else {
            speech.setText(director_.eleven.question+"\n\n" + director_.twelve.text);
        }

        director_.eleven.said = 1;
    }

}

