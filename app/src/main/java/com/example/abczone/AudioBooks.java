package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AudioBooks extends AppCompatActivity implements View.OnClickListener {
    private Button read1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_books);

    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(AudioBooks.this, ListenAudioBooks.class);
        intent.putExtra("intVariableName", v.getId()); //where v is button that is cliked, you will find it as a parameter to onClick method
        startActivity(intent);
    }
}