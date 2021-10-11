package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Colors extends AppCompatActivity {
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        back = (ImageView) findViewById(R.id.back_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Colors.this, MainZone.class));
            }
        });

        Button click1 = (Button) findViewById(R.id.button);
        Button click2 = (Button) findViewById(R.id.button2);
        Button click3 = (Button) findViewById(R.id.button3);
        Button click4 = (Button) findViewById(R.id.button4);
        Button click5 = (Button) findViewById(R.id.button5);
        Button click6 = (Button) findViewById(R.id.button6);
        Button click7 = (Button) findViewById(R.id.button7);
        Button click8 = (Button) findViewById(R.id.button8);
        Button click9 = (Button) findViewById(R.id.button9);

        final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.sound1);
        final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.sound2);
        final MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(), R.raw.sound3);
        final MediaPlayer mp4 = MediaPlayer.create(getApplicationContext(), R.raw.sound4);
        final MediaPlayer mp5 = MediaPlayer.create(getApplicationContext(), R.raw.sound5);
        final MediaPlayer mp6 = MediaPlayer.create(getApplicationContext(), R.raw.sound6);
        final MediaPlayer mp7 = MediaPlayer.create(getApplicationContext(), R.raw.sound7);
        final MediaPlayer mp8 = MediaPlayer.create(getApplicationContext(), R.raw.sound8);
        final MediaPlayer mp9 = MediaPlayer.create(getApplicationContext(), R.raw.sound9);

        View.OnClickListener elem = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.button:
                        mp1.start();
                        break;
                    case R.id.button2:
                        mp2.start();
                        break;
                    case R.id.button3:
                        mp3.start();
                        break;
                    case R.id.button4:
                        mp4.start();
                        break;
                    case R.id.button5:
                        mp5.start();
                        break;
                    case R.id.button6:
                        mp6.start();
                        break;
                    case R.id.button7:
                        mp7.start();
                        break;
                    case R.id.button8:
                        mp8.start();
                        break;
                    case R.id.button9:
                        mp9.start();
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

    }
}