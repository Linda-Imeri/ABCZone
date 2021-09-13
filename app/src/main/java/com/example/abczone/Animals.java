package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Animals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);


        ImageView click1 = (ImageView) findViewById(R.id.Cat);
        ImageView click2 = (ImageView) findViewById(R.id.Dog);
        ImageView click3 = (ImageView) findViewById(R.id.cow); // nje ndryshim
        ImageView click4 = (ImageView) findViewById(R.id.Lion);
        ImageView click5 = (ImageView) findViewById(R.id.Tiger);
        ImageView click6 = (ImageView) findViewById(R.id.Elephant);

        final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.cataudio);
        final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.dogaudio);
        final MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(), R.raw.cowaudio);
        final MediaPlayer mp4 = MediaPlayer.create(getApplicationContext(), R.raw.lionaudio);
        final MediaPlayer mp5 = MediaPlayer.create(getApplicationContext(), R.raw.tigeraudio);
        final MediaPlayer mp6 = MediaPlayer.create(getApplicationContext(), R.raw.elephantaudio);
        View.OnClickListener elem = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.Cat:
                        mp1.start();
                        break;
                    case R.id.Dog:
                        mp2.start();
                        break;
                    case R.id.cow:
                        mp3.start();
                        break;
                    case R.id.Lion:
                        mp4.start();
                        break;
                    case R.id.Tiger:
                        mp5.start();
                        break;
                    case R.id.Elephant:
                        mp6.start();
                        break;}
            }
        };
        click1.setOnClickListener(elem);
        click2.setOnClickListener(elem);
        click3.setOnClickListener(elem);
        click4.setOnClickListener(elem);
        click5.setOnClickListener(elem);
        click6.setOnClickListener(elem);


    }
}