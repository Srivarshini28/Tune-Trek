package com.example.murugaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class friendActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        ListView listView = findViewById(R.id.listview);
        List<String> list = new ArrayList<>();
        list.add("Mustafa");
        list.add("Kaatukuyile");
        list.add("Yen friend ah pola yaaru machan");
        list.add("Yele yele");
        list.add("Taxi taxi");
        list.add("Nalla nanban");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.list_item,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0){
                    Intent i = new Intent(getApplicationContext(),mustafaActivity.class);
                    startActivity(i);
                }
                else if (position == 1) {
                    Intent i = new Intent(getApplicationContext(),kaatuActivity.class);
                    startActivity(i);
                }
                else if (position == 2) {
                    Intent i = new Intent(getApplicationContext(),yenActivity.class);
                    startActivity(i);
                }
                else if (position == 3) {
                    Intent i = new Intent(getApplicationContext(),yeleActivity.class);
                    startActivity(i);
                }
                else if (position == 4) {
                    Intent i = new Intent(getApplicationContext(),taxiActivity.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(getApplicationContext(),nallaActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}