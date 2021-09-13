package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Music extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        Button click1=(Button)findViewById(R.id.play1);
        Button click2=(Button)findViewById(R.id.play2);
        Button click3=(Button)findViewById(R.id.play3);
        Button click4=(Button)findViewById(R.id.play4);

        final MediaPlayer mp1=MediaPlayer.create(getApplicationContext(), R.raw.sound1);
        final MediaPlayer mp2=MediaPlayer.create(getApplicationContext(), R.raw.sound2);
        final MediaPlayer mp3=MediaPlayer.create(getApplicationContext(), R.raw.sound3);
        final MediaPlayer mp4=MediaPlayer.create(getApplicationContext(), R.raw.sound4);

        View.OnClickListener elem = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.play1:
                        mp1.start();
                        break;
                    case R.id.play2:
                        mp2.start();
                        break;
                    case R.id.play3:
                        mp3.start();
                        break;
                    case R.id.play4:
                        mp4.start();
                        break;

                }
            }
        };
        click1.setOnClickListener(elem);
        click2.setOnClickListener(elem);
        click3.setOnClickListener(elem);
        click4.setOnClickListener(elem);

    }
}