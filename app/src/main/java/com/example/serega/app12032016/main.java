package com.example.serega.app12032016;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.serega.app12032016.people.People;

import java.sql.Time;
import java.util.Timer;
import java.util.TreeSet;

public class main extends AppCompatActivity {

    View v;
    private EditText _name, _surname, _mark;
    private TextView _output;
    private Button _add, _drop, _clear;
    private TreeSet<People> peopleTreeSet = new TreeSet<People>();
    private long mLastClickTime = System.currentTimeMillis();
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TreeSet<String> tSet = (TreeSet<String>) sharedPreferences.getStringSet("SOMEKEY",new TreeSet<String>());// загружаем TreeSet из prefernces, если его нет, создаем новый

        _name = (EditText) findViewById(R.id._name);
        _surname = (EditText) findViewById(R.id._surname);
        _mark=(EditText) findViewById(R.id._mark);
        _output = (TextView) findViewById(R.id._output);
        _add = (Button) findViewById(R.id._add);
        _drop = (Button) findViewById(R.id._drop);
        _clear = (Button) findViewById(R.id._clear);

        _add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (System.currentTimeMillis() - mLastClickTime < 1000) {
                    _output.setText(peopleTreeSet.toString());
                } else {

                    if ((_surname.getText().toString().length() < 1) || (_name.getText().toString().length() < 1) || (_mark.getText().toString().length() < 1)) {
                        _output.setText("Empty field!");
                    } else {
                        peopleTreeSet.add(new People(_surname.getText().toString(), _name.getText().toString(), new Integer(_mark.getText().toString())));
                        _output.setText(peopleTreeSet.toString());
                    }

                    mLastClickTime = System.currentTimeMillis();
                }

                /*
                //
                sharedPreferences = getPreferences(MODE_PRIVATE); //подключение к хранилищу
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("SOMEKEY","SOMEVALUE"); //лишь одно значение
                editor.commit();//коммит, на всякий записать в onDestroy()
                _output.setText(sharedPreferences.getString("SOMEVALUE", "X3P 73B3"));//вывод значения
                //
                */
            }
        });

        _drop.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
                peopleTreeSet.clear();
                _output.setText(peopleTreeSet.toString());
            }
        });

        _clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _output.setText("");
            }
        });

    }

    /*
    //на всякий
    @Override
    protected void onDestroy(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.commit();
        super.onDestroy();
    }
    */

}
