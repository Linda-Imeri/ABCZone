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
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ListenAudioBooks extends AppCompatActivity implements View.OnClickListener {

    TextView audioTime, audioDuration, audio_book_name;
    ImageView cover;
    SeekBar seekBarTime, seekBarVolume;
    Button playBook;
    String url;
    MediaPlayer bookPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_audio_books);

        audioTime = findViewById(R.id.audioTime);
        audioDuration = findViewById(R.id.audioDuration);
        seekBarTime = findViewById(R.id.seekBarTime);
        seekBarVolume = findViewById(R.id.seekBarVolume);
        audio_book_name = findViewById(R.id.audio_book_name);
        playBook = findViewById(R.id.playBook);
        playBook.setOnClickListener(this);
        cover = findViewById(R.id.audio_book_cover);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);
        if (intValue == 0) {
            Toast.makeText(ListenAudioBooks.this, "Try again , something wrong happened", Toast.LENGTH_LONG).show();
        } else {
            if (intValue == R.id.read1) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Audio_Books%2Fcowboy.mp3?alt=media&token=23d47b58-ac0b-4b67-b6d4-103a92aa20aa";
                audio_book_name.setText("Cowboy");
                cover.setImageResource(R.drawable.cowboy);

            } else if (intValue == R.id.read2) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Audio_Books%2Ftheantanddove.mp3?alt=media&token=fbe08a47-a9a6-439b-a67b-b4d433a82c73";
                audio_book_name.setText("The Ant and The Dove");
                cover.setImageResource(R.drawable.theantanddove);
            } else if (intValue == R.id.read3) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Audio_Books%2Ftheonion.mp3?alt=media&token=e42bf904-ae4f-47c9-bbcd-e3acd402582f";
                audio_book_name.setText("The Onion");
                cover.setImageResource(R.drawable.theonion);
            } else if (intValue == R.id.read4) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Audio_Books%2Fspeakfirst.mp3?alt=media&token=c155d8de-3c35-47c5-9a90-7ae3441c9de8";
                audio_book_name.setText("Speak first and lose");
                cover.setImageResource(R.drawable.speakfirst);
            } else if (intValue == R.id.read5) {
                url = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Audio_Books%2Ftheants.mp3?alt=media&token=15d69ff3-02f9-45ea-b2a0-370d6598efd2";
                audio_book_name.setText("The Ants and The Pen");
                cover.setImageResource(R.drawable.theants);
            }

        }

        bookPlayer = MediaPlayer.create(this, Uri.parse(url));
        bookPlayer.setLooping(true);
        bookPlayer.seekTo(0);
        bookPlayer.setVolume(0.5f, 0.5f);

        String duration = millisecondsToString(bookPlayer.getDuration());
        audioDuration.setText(duration);

        seekBarVolume.setProgress(50);
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volume = progress / 100f;
                bookPlayer.setVolume(volume, volume);
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
                while (bookPlayer != null) {
                    if (bookPlayer.isPlaying()) {
                        try {
                            final double current = bookPlayer.getCurrentPosition();
                            final String elapsedTime = millisecondsToString((int) current);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    audioTime.setText(elapsedTime);
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

        if (bookPlayer.isPlaying()) {
            bookPlayer.pause();
            playBook.setBackgroundResource(R.drawable.play_icon);
        } else {

            bookPlayer.start();
            playBook.setBackgroundResource(R.drawable.pause);
        }
    }
}