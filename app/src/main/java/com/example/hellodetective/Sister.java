package com.example.hellodetective;

import android.content.res.Resources;

import com.example.hellodetective.CharacterSpeech;
import com.example.hellodetective.R;

public class Sister {
    public CharacterSpeech one,two,three,four,five,six,seven,eight;

    Sister (Resources resources){
        one = new CharacterSpeech (resources.getString(R.string.ask_about_sister), resources.getString(R.string.sister_one),0);

        two = new CharacterSpeech (resources.getString(R.string.ask_about_actor_father), resources.getString(R.string.sister_two),0);

        three = new CharacterSpeech (resources.getString(R.string.ask_about_actor_guest), resources.getString(R.string.sister_three),0);

        four = new CharacterSpeech (resources.getString(R.string.ask_about_luci), resources.getString(R.string.sister_four),0);

        five = new CharacterSpeech (resources.getString(R.string.ask_about_director), resources.getString(R.string.sister_five),0); //не спрашивал про оператора

        six = new CharacterSpeech (resources.getString(R.string.ask_about_director), resources.getString(R.string.sister_six),0); //спрашивал про оператора

        seven = new CharacterSpeech (resources.getString(R.string.ask_about_operator), resources.getString(R.string.sister_seven),0); //не спрашивал про режиссёра

        eight = new CharacterSpeech (resources.getString(R.string.ask_about_operator), resources.getString(R.string.sister_eight),0); //спрашивал про режиссёра
    }
}

