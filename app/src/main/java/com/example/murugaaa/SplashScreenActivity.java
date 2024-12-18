package com.example.murugaaa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

import java.time.Instant;

public class SplashScreenActivity extends AppCompatActivity {

    private static final long SPLASH_DISPLAY_LENGTH = 5000; // 5 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView gifImageView = findViewById(R.id.logoImageView);

        // Load the GIF using Glide

        Glide.with(this)
                .asGif()
                .load(R.drawable.splash_screen)
                .into(gifImageView);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                // Create an Intent that will start the signinActivity
                Intent mainIntent = new Intent(SplashScreenActivity.this, login.class);
                startActivity(mainIntent);
                finish(); // Close the splash screen activity so the user won't be able to go back to it
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}