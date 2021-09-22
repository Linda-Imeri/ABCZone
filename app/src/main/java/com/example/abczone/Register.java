package com.example.abczone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private EditText email,password,confirmPassword;
    private ImageView back;
    private Button register;
    private TextView login;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        back=(ImageView) findViewById(R.id.back_icon);
        back.setOnClickListener(this);

        register=(Button) findViewById(R.id.login);
        register.setOnClickListener(this);


        email=(EditText) findViewById(R.id.Email);
        password=(EditText) findViewById(R.id.Password);
        confirmPassword=(EditText) findViewById(R.id.ConfirmPassword);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                registerUser();
                break;

            case R.id.back_icon:
                startActivity(new Intent(this,Login.class));
                break;


        }
    }

    private void registerUser() {

        String Email=email.getText().toString().trim();
        String Password=password.getText().toString().trim();
        //String ConfirmPassword=confirmPassword.getText().toString().trim();



        if(Email.isEmpty()){
            email.setError("Email is required!");
            email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            email.setError("Please write valid email!");
            email.requestFocus();
            return;
        }

        if(Password.isEmpty()){
            password.setError("Please write valid email!");
            password.requestFocus();
            return;
        }

        if(Password.length()<6){
            password.setError("Password length must be more then 6 characters!");
            password.requestFocus();
            return;
        }


        //register user in firebase
        mAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainZone.class));
                        }
                        else{
                            Toast.makeText(Register.this,"Failed to register" + task.getException().getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }
}