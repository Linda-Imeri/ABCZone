package com.example.abczone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private TextView register,forgotPassword;
    private EditText loginEmail,loginPassword;
    private Button Login;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register=(TextView) findViewById(R.id.join);
        register.setOnClickListener(this);

        forgotPassword=(TextView) findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(this);

        Login=(Button) findViewById(R.id.Login);
        Login.setOnClickListener(this);

        loginEmail=(EditText) findViewById(R.id.LoginEmail);
        loginPassword=(EditText) findViewById(R.id.LoginPassword);

        progressBar=(ProgressBar) findViewById(R.id.progressBar);

        mAuth=FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.join:
                startActivity(new Intent(this,Register.class));
                break;
            
            case R.id.Login:
                userLogin();

            case R.id.forgotPassword:
                startActivity(new Intent(this,ForgotPassword.class));
                break;
        }
    }

    private void userLogin() {
        String Email=loginEmail.getText().toString().trim();
        String Password=loginPassword.getText().toString().trim();


        if(Email.isEmpty()){
            loginEmail.setError("Email is required!");
            loginEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            loginEmail.setError("Please write valid email!");
            loginEmail.requestFocus();
            return;
        }

        if(Password.isEmpty()){
            loginPassword.setError("Password is required!");
            loginPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                    if(user.isEmailVerified()){
                        //Redirect to main
                        startActivity(new Intent(Login.this,MainActivity.class));
                    }
                    else{
                        user.sendEmailVerification();
                        Toast.makeText(Login.this,"Check your email to verify your account",Toast.LENGTH_LONG).show();

                    }

                }
                else{
                    Toast.makeText(Login.this,"Failed",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}