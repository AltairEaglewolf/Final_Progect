package com.example.hellodetective;

import android.content.res.Resources;

import com.example.hellodetective.CharacterSpeech;
import com.example.hellodetective.R;

public class Makeup {
    public CharacterSpeech one,two,three,four,five,six,seven,eight;

    Makeup (Resources resources){

        one = new CharacterSpeech (resources.getString(R.string.ask_about_sisters),resources.getString(R.string.makeup_one),0);

        two = new CharacterSpeech (resources.getString(R.string.ask_about_actor_father), resources.getString(R.string.makeup_two),0); //не спрашивал про режиссёра

        three = new CharacterSpeech (resources.getString(R.string.ask_about_actor_father), resources.getString(R.string.makeup_three),0); //спрашивал про режиссёра

        four = new CharacterSpeech (resources.getString(R.string.ask_about_actor_guest), resources.getString(R.string.makeup_four),0); //не спрашивал про сестёр

        five = new CharacterSpeech (resources.getString(R.string.ask_about_actor_guest), resources.getString(R.string.makeup_five),0); //спрашивал про сестёр

        six = new CharacterSpeech (resources.getString(R.string.ask_about_operator), resources.getString(R.string.makeup_six),0);

        seven = new CharacterSpeech (resources.getString(R.string.ask_about_director), resources.getString(R.string.makeup_seven),0); //не спрашивал про “отца”

        eight = new CharacterSpeech (resources.getString(R.string.ask_about_director), resources.getString(R.string.makeup_eight),0); //спрашивал про “отца”
    }
}
