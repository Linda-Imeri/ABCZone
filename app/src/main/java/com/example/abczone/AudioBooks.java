package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AudioBooks extends AppCompatActivity implements View.OnClickListener {
    private Button read1,read2,read3,read4,read5;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_books);

        back=(ImageView) findViewById(R.id.back_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AudioBooks.this,MainZone.class));
            }
        });

        read1=(Button)findViewById(R.id.read1);
        read1.setOnClickListener(this);
        read2=(Button)findViewById(R.id.read2);
        read2.setOnClickListener(this);
        read3=(Button)findViewById(R.id.read3);
        read3.setOnClickListener(this);
        read4=(Button)findViewById(R.id.read4);
        read4.setOnClickListener(this);
        read5=(Button)findViewById(R.id.read5);
        read5.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){
                   Intent intent = new Intent(this, ListenAudioBooks.class);
                   intent.putExtra("intVariableName", v.getId());
                   startActivity(intent);
        }
}
