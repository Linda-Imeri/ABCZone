package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AudioBooks extends AppCompatActivity {
    private Button read1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_books);

        read1=(Button) findViewById(R.id.read1);
        read1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AudioBooks.this,MainActivity.class));
            }
        });
    }
}