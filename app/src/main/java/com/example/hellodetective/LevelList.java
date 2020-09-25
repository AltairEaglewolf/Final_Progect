package com.example.hellodetective;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LevelList extends ListActivity {

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new ArrayAdapter<String>(this, R.layout.level_list, levels);
        setListAdapter(mAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {


        super.onListItemClick(l, v, position, id);
        Intent a;
        a = new Intent(LevelList.this, StartLevel.class);


        switch (position){
            case 0:
                a.putExtra("what","one");
                startActivity(a);
                break;
            case 1:
                a.putExtra("what","not");
                startActivity(a);
                break;
        } // не "if" так как удобнее добавлять уровни в будущем
    }

    final String[] levels = new String[] { "Чаепитие мёртвых", " ", " ", " ", " ", " ", " ", " ", " " };

}
