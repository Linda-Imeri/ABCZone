package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Music extends AppCompatActivity implements View.OnClickListener{
    private Button song1,song2,song3,song4,song5,song6,song7,song8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
         song1=(Button)findViewById(R.id.song1);
         song1.setOnClickListener(this);

        song2=(Button)findViewById(R.id.song2);
        song2.setOnClickListener(this);

        song3=(Button)findViewById(R.id.song3);
        song3.setOnClickListener(this);

        song4=(Button)findViewById(R.id.song4);
        song4.setOnClickListener(this);

        song5=(Button)findViewById(R.id.song5);
        song5.setOnClickListener(this);

        song6=(Button)findViewById(R.id.song6);
        song6.setOnClickListener(this);

        song7=(Button)findViewById(R.id.song7);
        song7.setOnClickListener(this);

        song8=(Button)findViewById(R.id.song8);
        song8.setOnClickListener(this);

        }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, Listen_Music.class);
        intent.putExtra("intVariableName", v.getId()); //where v is button that is cliked, you will find it as a parameter to onClick method
        startActivity(intent);

        }
}


