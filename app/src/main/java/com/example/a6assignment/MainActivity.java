package com.example.a6assignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    ListView listView;
    EditText editText;
    Date currentTime = Calendar.getInstance().getTime();
    Database tietokanta;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> stringLista;
    myTableDao myTableDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = findViewById(R.id.listview1);
        this.button = findViewById(R.id.button1);
        this.editText = findViewById(R.id.teksti1);

        stringLista = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, stringLista);
        listView.setAdapter(arrayAdapter);

        tietokanta = Room.databaseBuilder(getApplicationContext(),Database.class,Database.NIMI).allowMainThreadQueries().build();

        myTableDao = tietokanta.myTableDao();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyEntity myEntity = new MyEntity();
                myEntity.teksti = editText.getText().toString();
                myEntity.aika = currentTime.toString();
                myTableDao.InsertMyEntity(myEntity);
                List<MyEntity> lista = myTableDao.getAllInDescendingOrder();

                for (MyEntity t : lista){
                    String s = "";
                    s = s + t.teksti + t.aika;
                    arrayAdapter.add(s);
                }

            }
        });




    }
}
