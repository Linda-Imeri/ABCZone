package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Music extends AppCompatActivity implements View.OnClickListener{
    private Button click1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
         click1=(Button)findViewById(R.id.play1);
         click1.setOnClickListener(this);

        }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.play1:
                startActivity(new Intent(this,Listen_Music.class));
                break;


        }
    }

}
