package com.example.hellodetective;

import android.content.res.Resources;

import com.example.hellodetective.CharacterSpeech;
import com.example.hellodetective.R;

public class Operator {
    public CharacterSpeech one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve;

    Operator (Resources resources){
        one = new CharacterSpeech (resources.getString(R.string.ask_about_sisters),resources.getString(R.string.operator_one),0);

        two = new CharacterSpeech (resources.getString(R.string.ask_about_actor_father),resources.getString(R.string.operator_two),0); //не спросил про режиссёра

        three = new CharacterSpeech (resources.getString(R.string.ask_about_actor_father), resources.getString(R.string.operator_three),0); //спросил про режиссёра

        four = new CharacterSpeech (resources.getString(R.string.ask_about_actor_guest), resources.getString(R.string.operator_four),0); //не спрашивал про конфликт

        five = new CharacterSpeech (resources.getString(R.string.ask_about_actor_guest), resources.getString(R.string.operator_five),0); //спрашивал про конфликт

        six = new CharacterSpeech (resources.getString(R.string.ask_about_director), resources.getString(R.string.operator_six),0);

        seven = new CharacterSpeech (resources.getString(R.string.ask_about_luci), resources.getString(R.string.operator_seven),0);

        eight = new CharacterSpeech (resources.getString(R.string.ask_about_second_education), resources.getString(R.string.operator_eight) ,0); //не спрашивал про режиссёра

        nine = new CharacterSpeech (resources.getString(R.string.ask_about_second_education),resources.getString(R.string.operator_nine),0); //спрашивал про режиссёра

        ten = new CharacterSpeech (resources.getString(R.string.ask_about_money), resources.getString(R.string.operator_ten),0);

        eleven = new CharacterSpeech (resources.getString(R.string.ask_about_conflict_guest), resources.getString(R.string.operator_eleven),0); //не спрашивал про гостя

        twelve = new CharacterSpeech (resources.getString(R.string.ask_about_conflict_guest), resources.getString(R.string.operator_twelve),0); //спрашивал про гостя

    }
}
