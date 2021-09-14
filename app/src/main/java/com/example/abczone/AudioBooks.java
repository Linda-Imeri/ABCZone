package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AudioBooks extends AppCompatActivity implements View.OnClickListener {
    private Button read1;
    private ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_books);

        back=(ImageView) findViewById(R.id.back_icon);
        back.setOnClickListener(this);

        read1=(Button)findViewById(R.id.read1);
        read1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.read1:

                   Intent intent = new Intent(this, ListenAudioBooks.class);
                   intent.putExtra("intVariableName", v.getId()); //where v is button that is cliked, you will find it as a parameter to onClick method
                   startActivity(intent);
                    break;
            case R.id.back_icon:
                startActivity(new Intent(this,MainZone.class));
                break;


        }
    }
}