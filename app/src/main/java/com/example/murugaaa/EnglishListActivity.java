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

public class EnglishListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_list);

        ListView listView = findViewById(R.id.listview);
        List<String> list = new ArrayList<>();
        list.add("Baby");
        list.add("Closer");
        list.add("Dandelions");
        list.add("Heat Waves");
        list.add("Lover");
        list.add("Rewite The Stars");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.list_item,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0){
                    Intent i = new Intent(getApplicationContext(),babyActivity.class);
                    startActivity(i);
                }
                else if (position == 1) {
                    Intent i = new Intent(getApplicationContext(),closerActivity.class);
                    startActivity(i);
                }
                else if (position == 2) {
                    Intent i = new Intent(getApplicationContext(),dandelionsActivity.class);
                    startActivity(i);
                }
                else if (position == 3) {
                    Intent i = new Intent(getApplicationContext(),heatwavesActivity.class);
                    startActivity(i);
                }
                else if (position == 4) {
                    Intent i = new Intent(getApplicationContext(),loverActivity.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(getApplicationContext(),rewriteActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}