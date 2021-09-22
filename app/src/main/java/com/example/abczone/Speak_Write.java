package com.example.abczone;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class Speak_Write extends AppCompatActivity {

        private ImageView speak;
        private TextView edittext;
        private ImageView back;

    public static final Integer RESULT_SPEECH = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_speak__write);

            back=(ImageView) findViewById(R.id.back_icon);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Speak_Write.this,MainZone.class));
                }
            });
            edittext = findViewById(R.id.text);
            speak = findViewById(R.id.speak);
            speak.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                    try {
                        someActivityResultLauncher.launch(intent);
                        edittext.setText("");
                    }
                    catch (ActivityNotFoundException e ){
                        Toast.makeText(getApplicationContext(),"Your device doesnt support",Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            });
        }

        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent data = result.getData();
                        if (result.getResultCode() == Activity.RESULT_OK && data!=null) {
                            ArrayList<String> text=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                            edittext.setText(text.get(0));
                        }
                    }
                });
    }

