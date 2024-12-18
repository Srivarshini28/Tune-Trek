package com.example.murugaaa;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    CardView c1, c2, c3, c4, c5, c6,t,te,m,e,h;

    TextView t1,t2;
    private ImageView i1, i2, i3, i4, i5, i6;
    private int[] images1 = {R.drawable.kpop,R.drawable.bts, R.drawable.txt, R.drawable.seventeen}; // Array of images for c1
    private int[] images2 = {R.drawable.melody, R.drawable.ilai_melody, R.drawable.ar_melody, R.drawable.pradeep_melody}; // Array of images for c2
    private int[] images3 = {R.drawable.rock,R.drawable.va_rock, R.drawable.ani_rock, R.drawable.thaman_r}; // Array of images for c3
    private int[] images4 = {R.drawable.lofi, R.drawable.ar_l, R.drawable.harris_l, R.drawable.uone_l}; // Array of images for c4
    private int[] images5 = {R.drawable.hiphop, R.drawable.adhi_hp, R.drawable.ani_hp, R.drawable.uone_hp}; // Array of images for c5
    private int[] images6 = {R.drawable.friendship, R.drawable.ilai_f, R.drawable.ani_f, R.drawable.harris_f}; // Array of images for c6
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        i1 = findViewById(R.id.iv1);
        i2 = findViewById(R.id.iv2);
        i3 = findViewById(R.id.iv3);
        i4 = findViewById(R.id.iv4);
        i5 = findViewById(R.id.iv5);
        i6 = findViewById(R.id.iv6);

        //Find views by ID for genre CardViews
        c1 = findViewById(R.id.card1);
        c2 = findViewById(R.id.card2);
        c3 = findViewById(R.id.card3);
        c4 = findViewById(R.id.card4);
        c5 = findViewById(R.id.card5);
        c6 = findViewById(R.id.card6);

        t = findViewById(R.id.ctamil);
        te = findViewById(R.id.ctelugu);
        m = findViewById(R.id.cmalayalam);
        h = findViewById(R.id.chindi);
        e = findViewById(R.id.ceng);

        t1 = findViewById(R.id.b1);
        t2 = findViewById(R.id.b2);

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HomeActivity.this,TamilListActivity.class);
                startActivity(intent1);
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(HomeActivity.this,EnglishListActivity.class);
                startActivity(intent2);
            }
        });

        te.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(HomeActivity.this,TeluguListActivity.class);
                startActivity(intent3);
            }
        });

        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(HomeActivity.this,MalayalamListActivity.class);
                startActivity(intent4);
            }
        });

        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(HomeActivity.this,HindiListActivity.class);
                startActivity(intent5);
            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(HomeActivity.this,kpopActivity.class);
                startActivity(intent4);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(HomeActivity.this,melodyActivity.class);
                startActivity(intent5);
            }
        });


        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(HomeActivity.this,rockActivity.class);
                startActivity(intent5);
            }
        });

        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(HomeActivity.this,lofiActivity.class);
                startActivity(intent5);
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(HomeActivity.this,hiphopActivity.class);
                startActivity(intent5);
            }
        });


        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(HomeActivity.this,friendActivity.class);
                startActivity(intent5);
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(HomeActivity.this,aboutActivity.class);
                startActivity(intent5);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(HomeActivity.this,helpActivity.class);
                startActivity(intent5);
            }
        });

        //Start handler to change images in ImageView
        startImageChangeHandler();
    }
    private void startImageChangeHandler() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Change the image based on the current index
                i1.setImageResource(images1[currentIndex % images1.length]);
                i2.setImageResource(images2[currentIndex % images2.length]);
                i3.setImageResource(images3[currentIndex % images3.length]);
                i4.setImageResource(images4[currentIndex % images4.length]);
                i5.setImageResource(images5[currentIndex % images5.length]);
                i6.setImageResource(images6[currentIndex % images6.length]);
                currentIndex++;

                // Schedule the handler to run again after 1 second
                handler.postDelayed(this, 2000); // 1000 milliseconds = 1 second
            }
        }, 0); // Initial delay of 1 second before the first run
    }
}
