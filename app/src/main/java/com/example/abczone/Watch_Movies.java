package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

public class Watch_Movies extends AppCompatActivity {

    String videoPath;
    TextView movie_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch__movies);

        VideoView videoView = findViewById(R.id.video_view);
        movie_name = findViewById(R.id.movie_name);
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);
        if (intValue == 0) {
            // error handling (Will come in this if when button id is invalid)
        } else {
            if (intValue == R.id.movie1) {
                videoPath = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Movies%2Fsheep.mp4?alt=media&token=1bc01ad4-8a7f-459b-828c-f5fcbeff7970";
                movie_name.setText("The Counting Sheep");
            } else if (intValue == R.id.movie2) {
                videoPath = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Movies%2Fpip.mp4?alt=media&token=af2b21be-fd81-4c79-95d7-50ef2272bb5b";
                movie_name.setText("Pip-Pip");
            } else if (intValue == R.id.movie3) {
                videoPath = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Movies%2Ftheegyptian.mp4?alt=media&token=a16f18de-b373-46a5-9345-e07471a72b8f";
                movie_name.setText("The Egyptian Pyramids");
            } else if (intValue == R.id.movie4) {
                videoPath = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Movies%2Foktapodi.mp4?alt=media&token=505c8450-d5bf-4d2a-ac46-462c54a11a0b";
                movie_name.setText("Octopus");
            } else if (intValue == R.id.movie5) {
                videoPath = "https://firebasestorage.googleapis.com/v0/b/abczone-4f172.appspot.com/o/Movies%2Fthecontroller.mp4?alt=media&token=ea1201b4-890b-464b-a049-5a46beaeb6c6";
                movie_name.setText("The Controller");
            }

            videoView.setVideoURI(Uri.parse(videoPath));

            MediaController mediaController = new MediaController(this);
            videoView.setMediaController(mediaController);
            videoView.seekTo(1);
            mediaController.setAnchorView(videoView);

        }
    }
}