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

public class hiphopActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiphop);

        ListView listView = findViewById(R.id.listview);
        List<String> list = new ArrayList<>();
        list.add("Vaadi pula vaadi");
        list.add("Vilambara idaiveli");
        list.add("Ethir neechal");
        list.add("Darling Dambakku");
        list.add("Thalli pogathey");
        list.add("Ussum laresey");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.list_item,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0){
                    Intent i = new Intent(getApplicationContext(),vaadiActivity.class);
                    startActivity(i);
                }
                else if (position == 1) {
                    Intent i = new Intent(getApplicationContext(),vilamActivity.class);
                    startActivity(i);
                }
                else if (position == 2) {
                    Intent i = new Intent(getApplicationContext(),ethirActivity.class);
                    startActivity(i);
                }
                else if (position == 3) {
                    Intent i = new Intent(getApplicationContext(),darActivity.class);
                    startActivity(i);
                }
                else if (position == 4) {
                    Intent i = new Intent(getApplicationContext(),thalliActivity.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(getApplicationContext(),ussumActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}