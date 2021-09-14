package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ListenAudioBooks extends AppCompatActivity {
    TextView button1;
    ImageView story_image;
    // Create a Cloud Storage reference from the app
    StorageReference storageRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen_audio_books);

        button1=findViewById(R.id.listen_audio);
        story_image=findViewById(R.id.story_image);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);
        if(intValue == 0){
        // error handling (Will come in this if when button id is invalid)
            }
        else
        {
            if(intValue == R.id.read1) {
               button1.setText("Hello");
               storageRef= FirebaseStorage.getInstance().getReference("images/abc.jpg");
            }
            //if(intValue == R.id.button2)
                // Do work related to button 2

           // if(intValue == R.id.button3)
            // Do work related to button 3
        }
    }
}