package com.example.hellodetective;

import android.content.res.Resources;

import com.example.hellodetective.CharacterSpeech;
import com.example.hellodetective.R;

public class Corpse {
    public CharacterSpeech one,two,three,four,five,six,seven,eight;

    Corpse (Resources resources){
        one = new CharacterSpeech (resources.getString(R.string.check_sister), resources.getString(R.string.corpse_one),0); //не общался с сестрой; не осматривал других

        two = new CharacterSpeech (resources.getString(R.string.check_sister), resources.getString(R.string.corpse_two),0); //не общался с сестрой; осматривал других

        three = new CharacterSpeech (resources.getString(R.string.check_sister), resources.getString(R.string.corpse_three),0); //общался с сестрой; не осматривал других

        four = new CharacterSpeech (resources.getString(R.string.check_sister), resources.getString(R.string.corpse_four),0); //общался с сестрой; осматривал других

        five = new CharacterSpeech (resources.getString(R.string.check_actor_father), resources.getString(R.string.corpse_five),0); //не осматривал других

        six = new CharacterSpeech (resources.getString(R.string.check_actor_father), resources.getString(R.string.corpse_six),0); //осматривал других

        seven = new CharacterSpeech (resources.getString(R.string.check_actor_guest), resources.getString(R.string.corpse_seven),0); //не осматривал других

        eight = new CharacterSpeech (resources.getString(R.string.check_actor_guest), resources.getString(R.string.corpse_eight),0); //осматривал других

    }

}
