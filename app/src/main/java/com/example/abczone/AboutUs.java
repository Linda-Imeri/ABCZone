package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.EditText;

public class AboutUs extends AppCompatActivity {
EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        edittext=findViewById(R.id.hyperlinks);
        edittext.setMovementMethod(LinkMovementMethod.getInstance());
    }
}