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

public class lofiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lofi);

        ListView listView = findViewById(R.id.listview);
        List<String> list = new ArrayList<>();
        list.add("Unakul Naane");
        list.add("Pal");
        list.add("Snehidhane");
        list.add("Ranjhaana");
        list.add("Manipayaa");
        list.add("Tum Tak");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.list_item,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0){
                    Intent i = new Intent(getApplicationContext(),unakulActivity.class);
                    startActivity(i);
                }
                else if (position == 1) {
                    Intent i = new Intent(getApplicationContext(),palActivity.class);
                    startActivity(i);
                }
                else if (position == 2) {
                    Intent i = new Intent(getApplicationContext(),snehActivity.class);
                    startActivity(i);
                }
                else if (position == 3) {
                    Intent i = new Intent(getApplicationContext(),raanjActivity.class);
                    startActivity(i);
                }
                else if (position == 4) {
                    Intent i = new Intent(getApplicationContext(),lmaniActivity.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(getApplicationContext(),tumtakActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}