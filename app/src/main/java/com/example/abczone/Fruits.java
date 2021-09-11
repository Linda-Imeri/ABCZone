package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Fruits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        ImageView click1 = (ImageView) findViewById(R.id.apple);
        ImageView click2 = (ImageView) findViewById(R.id.apples);
        ImageView click3 = (ImageView) findViewById(R.id.banana);
        ImageView click4 = (ImageView) findViewById(R.id.bananas);
        ImageView click5 = (ImageView) findViewById(R.id.orange);
        ImageView click6 = (ImageView) findViewById(R.id.oranges);

        final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.apple);
        final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.apples);
        final MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(), R.raw.banana);
        final MediaPlayer mp4 = MediaPlayer.create(getApplicationContext(), R.raw.bananas);
        final MediaPlayer mp5 = MediaPlayer.create(getApplicationContext(), R.raw.orange);
        final MediaPlayer mp6 = MediaPlayer.create(getApplicationContext(), R.raw.oranges);
        View.OnClickListener elem = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.apple:
                        mp1.start();
                        break;
                    case R.id.apples:
                        mp2.start();
                        break;
                    case R.id.banana:
                        mp3.start();
                        break;
                    case R.id.bananas:
                        mp4.start();
                        break;
                    case R.id.orange:
                        mp5.start();
                        break;
                    case R.id.oranges:
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