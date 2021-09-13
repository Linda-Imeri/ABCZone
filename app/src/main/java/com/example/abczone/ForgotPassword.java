package com.example.abczone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {

    private EditText emailReset;
    private Button resetPassword;
    private ImageView back;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        back=(ImageView) findViewById(R.id.back_icon);
        back.setOnClickListener(this);

        emailReset=(EditText) findViewById(R.id.emailReset);
        resetPassword=(Button) findViewById(R.id.reset);

        auth=FirebaseAuth.getInstance();


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_icon:
                startActivity(new Intent(this,Login.class));
                break;

            case R.id.reset:
                resetPassword();
                break;

        }
    }

    private void resetPassword() {
        String email=emailReset.getText().toString().trim();

        if(email.isEmpty()){
            emailReset.setError("Email is required!");
            emailReset.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
           emailReset.setError("Please write valid email!");
            emailReset.requestFocus();
            return;
        }

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this,"Check your email",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(ForgotPassword.this,"Try again , something wrong happened",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}