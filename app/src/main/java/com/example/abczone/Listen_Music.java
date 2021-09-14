package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Listen_Music extends AppCompatActivity implements View.OnClickListener {
    TextView musicTime,musicDuration;
    SeekBar seekBarTime,seekBarVolume;
    Button playSong;

    MediaPlayer musicPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen__music);

        musicTime=findViewById(R.id.musicTime);
        musicDuration=findViewById(R.id.musicDuration);
        seekBarTime=findViewById(R.id.seekBarTime);
        seekBarVolume=findViewById(R.id.seekBarVolume);
        playSong=findViewById(R.id.playSong);
        playSong.setOnClickListener(this);
        musicPlayer=MediaPlayer.create(this,R.raw.apple);
        musicPlayer.setLooping(true);
        musicPlayer.seekTo(0);
        musicPlayer.setVolume(0.5f,0.5f);

        String duration=millisecondsToString(musicPlayer.getDuration());
        musicDuration.setText(duration);

        seekBarVolume.setProgress(50);
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume=progress/100f;
                musicPlayer.setVolume(volume,volume);
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
                while (musicPlayer!=null){
                    if(musicPlayer.isPlaying()){
                        try {
                            final double current=musicPlayer.getCurrentPosition();
                            final String elapsedTime=millisecondsToString((int)current);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    musicTime.setText(elapsedTime);
                                    seekBarTime.setProgress((int)current);
                                }
                            });


                            Thread.sleep(1000);
                        }
                       catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }


    public String millisecondsToString(int time){
        String elapsedTime="";
        int minutes=time/1000/60;
        int seconds=time/1000%60;
        elapsedTime=minutes+":";
        if(seconds<10){
            elapsedTime+="0";
        }
        elapsedTime+=seconds;

        return elapsedTime;
    }

    @Override
    public void onClick(View v) {
        if(musicPlayer.isPlaying()){
            musicPlayer.pause();
            playSong.setBackgroundResource(R.drawable.play_icon);
        }
        else{
            musicPlayer.start();
            playSong.setBackgroundResource(R.drawable.pause);
        }
    }
}