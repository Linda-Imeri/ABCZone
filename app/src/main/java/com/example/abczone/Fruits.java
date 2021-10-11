package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Fruits extends AppCompatActivity {
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        back = (ImageView) findViewById(R.id.back_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fruits.this, MainZone.class));
            }
        });

        ImageView click1 = (ImageView) findViewById(R.id.apple);
        ImageView click2 = (ImageView) findViewById(R.id.apples);
        ImageView click3 = (ImageView) findViewById(R.id.banana);
        ImageView click4 = (ImageView) findViewById(R.id.bananas);
        ImageView click5 = (ImageView) findViewById(R.id.orange);
        ImageView click6 = (ImageView) findViewById(R.id.oranges);

        ImageView click7 = (ImageView) findViewById(R.id.carrot);
        ImageView click8 = (ImageView) findViewById(R.id.carrots);
        ImageView click9 = (ImageView) findViewById(R.id.tomato);
        ImageView click10 = (ImageView) findViewById(R.id.tomatos);
        ImageView click11 = (ImageView) findViewById(R.id.peper);
        ImageView click12 = (ImageView) findViewById(R.id.peppers);

        final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.apple);
        final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.apples);
        final MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(), R.raw.banana);
        final MediaPlayer mp4 = MediaPlayer.create(getApplicationContext(), R.raw.bananas);
        final MediaPlayer mp5 = MediaPlayer.create(getApplicationContext(), R.raw.orange);
        final MediaPlayer mp6 = MediaPlayer.create(getApplicationContext(), R.raw.oranges);

        final MediaPlayer mp7 = MediaPlayer.create(getApplicationContext(), R.raw.carrot);
        final MediaPlayer mp8 = MediaPlayer.create(getApplicationContext(), R.raw.carrots);
        final MediaPlayer mp9 = MediaPlayer.create(getApplicationContext(), R.raw.tomato);
        final MediaPlayer mp10 = MediaPlayer.create(getApplicationContext(), R.raw.tomates);
        final MediaPlayer mp11 = MediaPlayer.create(getApplicationContext(), R.raw.peper);
        final MediaPlayer mp12 = MediaPlayer.create(getApplicationContext(), R.raw.peppers);
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
                        break;

                    case R.id.carrot:
                        mp1.start();
                        break;
                    case R.id.carrots:
                        mp2.start();
                        break;
                    case R.id.tomato:
                        mp3.start();
                        break;
                    case R.id.tomatos:
                        mp4.start();
                        break;
                    case R.id.peper:
                        mp5.start();
                        break;
                    case R.id.peppers:
                        mp6.start();
                        break;
                }

            }
        };
        click1.setOnClickListener(elem);
        click2.setOnClickListener(elem);
        click3.setOnClickListener(elem);
        click4.setOnClickListener(elem);
        click5.setOnClickListener(elem);
        click6.setOnClickListener(elem);
        click7.setOnClickListener(elem);
        click8.setOnClickListener(elem);
        click9.setOnClickListener(elem);
        click10.setOnClickListener(elem);
        click11.setOnClickListener(elem);
        click12.setOnClickListener(elem);


    }
}