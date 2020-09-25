package com.example.hellodetective;



import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragNotebook extends Fragment {

    EditText edit;
    Button save;
    String savedText;

    SharedPreferences sharedPreferences;

    public static final String SAVED_TEXT = "saved_text";

    @Override

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate (R.layout.notebook , null);


        edit = (EditText) view.findViewById(R.id.notes);
        save = (Button) view.findViewById(R.id.write_down);

        edit.setMovementMethod(new ScrollingMovementMethod());

        loadText();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveText();
            }
        });
        return view;
    }


    void saveText (){
        sharedPreferences = this.getActivity().getSharedPreferences("myPref",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putString(SAVED_TEXT,edit.getText().toString());
        ed.commit();
    }

    void loadText (){
        sharedPreferences = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        savedText = sharedPreferences.getString(SAVED_TEXT,"");
        edit.setText(savedText);
    }
}