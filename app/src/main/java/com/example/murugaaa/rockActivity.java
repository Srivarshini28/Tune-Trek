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

public class rockActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock);

        ListView listView = findViewById(R.id.listview);
        List<String> list = new ArrayList<>();
        list.add("Naaku mukka");
        list.add("Kanee theevu ponna");
        list.add("Local boys");
        list.add("Uchimandai");
        list.add("Potu thakku");
        list.add("Manmadha Raasa");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.list_item,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0){
                    Intent i = new Intent(getApplicationContext(),naakuActivity.class);
                    startActivity(i);
                }
                else if (position == 1) {
                    Intent i = new Intent(getApplicationContext(),kaneeActivity.class);
                    startActivity(i);
                }
                else if (position == 2) {
                    Intent i = new Intent(getApplicationContext(),localActivity.class);
                    startActivity(i);
                }
                else if (position == 3) {
                    Intent i = new Intent(getApplicationContext(),uchiActivity.class);
                    startActivity(i);
                }
                else if (position == 4) {
                    Intent i = new Intent(getApplicationContext(),potuActivity.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(getApplicationContext(),manActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}