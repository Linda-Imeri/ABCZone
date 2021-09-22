package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Movie extends AppCompatActivity implements View.OnClickListener{
    private Button watch1,watch2,watch3,watch4,watch5;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        back=(ImageView) findViewById(R.id.back_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Movie.this,Watch_Movies.class));
            }
        });

        watch1=(Button)findViewById(R.id.movie1);
        watch1.setOnClickListener(this);
        watch2=(Button)findViewById(R.id.movie2);
        watch2.setOnClickListener(this);
        watch3=(Button)findViewById(R.id.movie3);
        watch3.setOnClickListener(this);
        watch4=(Button)findViewById(R.id.movie4);
        watch4.setOnClickListener(this);
        watch5=(Button)findViewById(R.id.movie5);
        watch5.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        Intent intent = new Intent(this, Watch_Movies.class);
        intent.putExtra("intVariableName", v.getId()); //where v is button that is cliked, you will find it as a parameter to onClick method
        startActivity(intent);

    }
}