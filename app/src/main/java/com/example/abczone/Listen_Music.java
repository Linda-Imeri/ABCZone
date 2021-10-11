package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class Listen_Music extends AppCompatActivity implements View.OnClickListener {
    TextView musicTime, musicDuration, song_name;
    SeekBar seekBarTime, seekBarVolume;
    Button playSong;
    String url;
    MediaPlayer musicPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen__music);

        musicTime = findViewById(R.id.musicTime);
        musicDuration = findViewById(R.id.musicDuration);
        seekBarTime = findViewById(R.id.seekBarTime);
        seekBarVolume = findViewById(R.id.seekBarVolume);
        song_name = findViewById(R.id.song_name);
        playSong = findViewById(R.id.playSong);
        playSong.setOnClickListener(this);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);
        if (intValue == 0) {
            Toast.makeText(Listen_Music.this, "Try again , something wrong happened", Toast.LENGTH_LONG).show();
        } else {
            if (intValue == R.id.song1) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FJohny%20Johny%20Yes%20PapaTHE%20BEST%20Song%20for%20ChildrenLooLoo%20Kids.mp3?alt=media&token=675acc22-0ea2-4c37-84c8-e4af7132ec42";
                song_name.setText("Johnny, Johnny, Yes PAPA");
            } else if (intValue == R.id.song2) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FFive%20Little%20Monkeys.mp3?alt=media&token=e22a0bec-440e-4892-bed1-e2a4f5578a5a";
                song_name.setText("Five Little Monkeys");
            } else if (intValue == R.id.song3) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FBus%20song.mp3?alt=media&token=43104b47-d0c1-4bbb-86eb-b0caa717e7cb";
                song_name.setText("Bus Song");
            } else if (intValue == R.id.song4) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FFive%20Little%20Ducks.mp3?alt=media&token=bebffa89-abed-4365-8952-a174cb0b3e75";
                song_name.setText("Five Little Ducks");
            } else if (intValue == R.id.song5) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FHappy%20and%20you%20know%20it.mp3?alt=media&token=6fa69a52-d295-499b-a1cc-4d29b01de544";
                song_name.setText("Happy and you know it");
            } else if (intValue == R.id.song6) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FJingle%20Bells%20Songs%20for%20Children.mp3?alt=media&token=3ac9e199-ef32-4e8c-b8ad-2c24290809aa";
                song_name.setText("Jingle Bells");
            } else if (intValue == R.id.song7) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FRain%2C%20Rain%2C%20Go%20Away.mp3?alt=media&token=c950aaa1-77ca-4de1-88f6-edd10f666767";
                song_name.setText("Rain,Rain, Go Away");
            } else if (intValue == R.id.song8) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FTwinkle%20Twinkle%20Little%20Star.mp3?alt=media&token=8d75b16f-8603-403a-9b71-2a28fc2b8a5c";
                song_name.setText("Twinkle,Twinkle,Little Star");
            }

        }

        musicPlayer = MediaPlayer.create(this, Uri.parse(url));
        musicPlayer.setLooping(true);
        musicPlayer.seekTo(0);
        musicPlayer.setVolume(0.5f, 0.5f);

        String duration = millisecondsToString(musicPlayer.getDuration());
        musicDuration.setText(duration);

        seekBarVolume.setProgress(50);
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = progress / 100f;
                musicPlayer.setVolume(volume, volume);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarTime.setMax(musicPlayer.getDuration());
        seekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                musicPlayer.seekTo(progress);
                seekBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (musicPlayer != null) {
                    if (musicPlayer.isPlaying()) {
                        try {
                            final double current = musicPlayer.getCurrentPosition();
                            final String elapsedTime = millisecondsToString((int) current);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    musicTime.setText(elapsedTime);
                                    seekBarTime.setProgress((int) current);
                                }
                            });


                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }


    public String millisecondsToString(int time) {
        String elapsedTime = "";
        int minutes = time / 1000 / 60;
        int seconds = time / 1000 % 60;
        elapsedTime = minutes + ":";
        if (seconds < 10) {
            elapsedTime += "0";
        }
        elapsedTime += seconds;

        return elapsedTime;
    }

    @Override
    public void onClick(View v) {

        if (musicPlayer.isPlaying()) {
            musicPlayer.pause();
            playSong.setBackgroundResource(R.drawable.play_icon);
        } else {

            musicPlayer.start();
            playSong.setBackgroundResource(R.drawable.pause);
        }
    }
}