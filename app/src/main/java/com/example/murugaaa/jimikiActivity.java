package com.example.murugaaa;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class jimikiActivity extends AppCompatActivity {

    // Instantiating the MediaPlayer class
    MediaPlayer music;
    private SeekBar seekBar;
    private TextView startTimeTextView, endTimeTextView;

    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jimiki);

        // Initialize MediaPlayer
        music = MediaPlayer.create(this, R.raw.jimiki);

        // Find views
        seekBar = findViewById(R.id.seekBar);
        startTimeTextView = findViewById(R.id.text_start_time);
        endTimeTextView = findViewById(R.id.text_end_time);

        // Set max value of SeekBar to the duration of the audio file
        seekBar.setMax(music.getDuration());

        // Update SeekBar and time TextViews when SeekBar position changes
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    music.seekTo(progress);
                    updateTimeTextViews(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not needed
            }
        });

        // Update SeekBar and time TextViews periodically
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (music != null) {
                    try {
                        // Update SeekBar position
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int currentPosition = music.getCurrentPosition();
                                seekBar.setProgress(currentPosition);
                                updateTimeTextViews(currentPosition);
                            }
                        });
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    // Update time TextViews
    private void updateTimeTextViews(int progress) {
        int duration = music.getDuration();
        int currentPosition = progress;
        int remainingTime = duration - currentPosition;

        startTimeTextView.setText(milliSecondsToTimer(currentPosition));
        endTimeTextView.setText("-" + milliSecondsToTimer(remainingTime));
    }

    // Convert milliseconds to time format (mm:ss)
    private String milliSecondsToTimer(long milliseconds) {
        String finalTimerString = "";
        String secondsString;

        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);

        // Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // Return time in the format
        return finalTimerString;
    }

    // Playing the music
    public void musicplay(View v) {
        music.start();
    }

    // Pausing the music
    public void musicpause(View v) {
        music.pause();
    }

    // Stopping the music
    public void musicstop(View v) {
        music.stop();
        music = MediaPlayer.create(this, R.raw.jimiki);
        seekBar.setProgress(0);
        updateTimeTextViews(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (music != null) {
            music.release();
            music = null;
        }
    }
}