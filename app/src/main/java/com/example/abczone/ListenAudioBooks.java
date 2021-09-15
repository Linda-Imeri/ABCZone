package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ListenAudioBooks extends AppCompatActivity implements View.OnClickListener{

        TextView audioTime,audioDuration,audio_book_name;
        ImageView cover;
        SeekBar seekBarTime,seekBarVolume;
        Button playBook;
        String url;
        MediaPlayer bookPlayer;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listen_audio_books);

            audioTime=findViewById(R.id.audioTime);
            audioDuration=findViewById(R.id.audioDuration);
            seekBarTime=findViewById(R.id.seekBarTime);
            seekBarVolume=findViewById(R.id.seekBarVolume);
            audio_book_name=findViewById(R.id.audio_book_name);
            playBook=findViewById(R.id.playBook);
            playBook.setOnClickListener(this);

            Intent mIntent = getIntent();
            int intValue = mIntent.getIntExtra("intVariableName", 0);
            if(intValue == 0){
                // error handling (Will come in this if when button id is invalid)
            }
            else
            {
                if(intValue == R.id.read1) {
                    url="https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FJohny%20Johny%20Yes%20PapaTHE%20BEST%20Song%20for%20ChildrenLooLoo%20Kids.mp3?alt=media&token=675acc22-0ea2-4c37-84c8-e4af7132ec42";
                    audio_book_name.setText("Twinkle,Twinkle,Little Star");                }
                else if(intValue == R.id.read2) {
                    url="https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FFive%20Little%20Monkeys.mp3?alt=media&token=e22a0bec-440e-4892-bed1-e2a4f5578a5a";
                    audio_book_name.setText("Twinkle,Twinkle,Little Star");
                }
                else if(intValue == R.id.read3) {
                    url="https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FBus%20song.mp3?alt=media&token=43104b47-d0c1-4bbb-86eb-b0caa717e7cb";
                    audio_book_name.setText("Twinkle,Twinkle,Little Star");
                }
                else if(intValue == R.id.read4) {
                    url="https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FFive%20Little%20Ducks.mp3?alt=media&token=bebffa89-abed-4365-8952-a174cb0b3e75";
                    audio_book_name.setText("Twinkle,Twinkle,Little Star");
                }
                else if(intValue == R.id.read5) {
                    url="https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FHappy%20and%20you%20know%20it.mp3?alt=media&token=6fa69a52-d295-499b-a1cc-4d29b01de544";
                    audio_book_name.setText("Twinkle,Twinkle,Little Star");
                }
                else if(intValue == R.id.read6) {
                    url="https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Songs%2FJingle%20Bells%20Songs%20for%20Children.mp3?alt=media&token=3ac9e199-ef32-4e8c-b8ad-2c24290809aa";
                    audio_book_name.setText("Twinkle,Twinkle,Little Star");                }
            }

            bookPlayer=MediaPlayer.create(this, Uri.parse(url));
            bookPlayer.setLooping(true);
            bookPlayer.seekTo(0);
            bookPlayer.setVolume(0.5f,0.5f);

            String duration=millisecondsToString(bookPlayer.getDuration());
            audioDuration.setText(duration);

            seekBarVolume.setProgress(50);
            seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    float volume=progress/100f;
                    bookPlayer.setVolume(volume,volume);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            seekBarTime.setMax(bookPlayer.getDuration());
            seekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    bookPlayer.seekTo(progress);
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
                    while (bookPlayer!=null){
                        if(bookPlayer.isPlaying()){
                            try {
                                final double current=bookPlayer.getCurrentPosition();
                                final String elapsedTime=millisecondsToString((int)current);

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        audioTime.setText(elapsedTime);
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

            if(bookPlayer.isPlaying()){
                bookPlayer.pause();
                playBook.setBackgroundResource(R.drawable.play_icon);
            }
            else{

                bookPlayer.start();
                playBook.setBackgroundResource(R.drawable.pause);
            }
        }
}