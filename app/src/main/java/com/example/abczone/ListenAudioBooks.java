package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ListenAudioBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_audio_books);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);
        if(intValue == 0){
        // error handling (Will come in this if when button id is invalid)
            }
        else
        {
            if(intValue == R.id.read1) {
                // Do work related to button 1
            }
            //if(intValue == R.id.button2)
                // Do work related to button 2

           // if(intValue == R.id.button3)
            // Do work related to button 3
        }
    }
}