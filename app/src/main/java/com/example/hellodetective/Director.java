package com.example.hellodetective;

import android.content.res.Resources;

import com.example.hellodetective.CharacterSpeech;
import com.example.hellodetective.R;

public class Director {

    public CharacterSpeech one,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve;

    Director (Resources resources){
        one = new CharacterSpeech (resources.getString(R.string.ask_about_sisters),resources.getString(R.string.director_one),0);

        two = new CharacterSpeech (resources.getString(R.string.ask_about_actor_father), resources.getString(R.string.director_two),0); //не спросил про спор

        three = new CharacterSpeech (resources.getString(R.string.ask_about_actor_father), resources.getString(R.string.director_three),0); //спросил про спор

        four = new CharacterSpeech (resources.getString(R.string.ask_about_actor_guest), resources.getString(R.string.director_four),0); //не спрашивал про оператора

        five = new CharacterSpeech (resources.getString(R.string.ask_about_actor_guest), resources.getString(R.string.director_five),0); //спрашивал про оператора

        six = new CharacterSpeech (resources.getString(R.string.ask_about_luci), resources.getString(R.string.director_six),0);//не спрашивал про сестёр

        seven = new CharacterSpeech (resources.getString(R.string.ask_about_luci), resources.getString(R.string.director_seven),0);//спрашивал про сестёр

        eight = new CharacterSpeech (resources.getString(R.string.ask_about_operator), resources.getString(R.string.director_eight),0); //не спрашивал про гостя

        nine = new CharacterSpeech (resources.getString(R.string.ask_about_operator),resources.getString(R.string.director_nine),0); //спрашивал про гостя

        ten = new CharacterSpeech (resources.getString(R.string.ask_about_second_education), resources.getString(R.string.director_ten),0);

        eleven = new CharacterSpeech (resources.getString(R.string.ask_about_conflict_father), resources.getString(R.string.director_eleven),0); //не спрашивал про отца

        twelve = new CharacterSpeech (resources.getString(R.string.ask_about_conflict_father), resources.getString(R.string.director_twelve),0); //спрашивал про отца

    }
}
