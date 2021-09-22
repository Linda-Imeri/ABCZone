package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ImageView click1 = (ImageView) findViewById(R.id.one);
        ImageView click2 = (ImageView) findViewById(R.id.two);
        ImageView click3 = (ImageView) findViewById(R.id.three);
        ImageView click4 = (ImageView) findViewById(R.id.four);
        ImageView click5 = (ImageView) findViewById(R.id.five);
        ImageView click6 = (ImageView) findViewById(R.id.six);
        ImageView click7= (ImageView) findViewById(R.id.seven);
        ImageView click8 = (ImageView) findViewById(R.id.eight);
        ImageView click9 = (ImageView) findViewById(R.id.nine);
        ImageView click10 = (ImageView) findViewById(R.id.ten);


        final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.one);
        final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.two);
        final MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(), R.raw.three);
        final MediaPlayer mp4 = MediaPlayer.create(getApplicationContext(), R.raw.four);
        final MediaPlayer mp5 = MediaPlayer.create(getApplicationContext(), R.raw.five);
        final MediaPlayer mp6 = MediaPlayer.create(getApplicationContext(), R.raw.six);
        final MediaPlayer mp7 = MediaPlayer.create(getApplicationContext(), R.raw.seven);
        final MediaPlayer mp8 = MediaPlayer.create(getApplicationContext(), R.raw.eight);
        final MediaPlayer mp9 = MediaPlayer.create(getApplicationContext(), R.raw.nine);
        final MediaPlayer mp10 = MediaPlayer.create(getApplicationContext(), R.raw.ten);
        View.OnClickListener elem = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.one:
                        mp1.start();
                        break;
                    case R.id.two:
                        mp2.start();
                        break;
                    case R.id.three:
                        mp3.start();
                        break;
                    case R.id.four:
                        mp4.start();
                        break;
                    case R.id.five:
                        mp5.start();
                        break;
                    case R.id.six:
                        mp6.start();
                        break;

                    case R.id.seven:
                        mp3.start();
                        break;
                    case R.id.eight:
                        mp4.start();
                        break;
                    case R.id.nine:
                        mp5.start();
                        break;
                    case R.id.ten:
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
        click7.setOnClickListener(elem);
        click8.setOnClickListener(elem);
        click9.setOnClickListener(elem);
        click10.setOnClickListener(elem);
    }
}