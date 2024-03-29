package com.example.tsaei;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import java.util.Timer;

public class startingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        getSupportActionBar().hide(); //hides the action bar for this activity
        VideoView videoView = (VideoView) findViewById(R.id.logo);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.logo));
        videoView.start();

        Timer t = new java.util.Timer();


        t.schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(startingActivity.this, RegisterActivity.class);
                        startActivity(intent);

                        t.cancel();
                    }
                },
                2750 //delays by 2.75 seconds
        );
    }
}