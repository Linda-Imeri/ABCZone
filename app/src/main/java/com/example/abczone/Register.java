package com.example.abczone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private EditText email,password,confirmPassword,childName;
    private ProgressBar progressBar;
    private Button register;
    private TextView login;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        register=(Button) findViewById(R.id.register);
        register.setOnClickListener(this);

        login=(TextView) findViewById(R.id.login);
        login.setOnClickListener(this);

        email=(EditText) findViewById(R.id.Email);
        childName=(EditText) findViewById(R.id.childName);
        password=(EditText) findViewById(R.id.Password);
        confirmPassword=(EditText) findViewById(R.id.ConfirmPassword);

        progressBar=(ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                registerUser();
                break;

            case R.id.login:
                startActivity(new Intent(this,Login.class));
                break;
        }
    }

    private void registerUser() {
        String Name=childName.getText().toString().trim();
        String Email=email.getText().toString().trim();
        String Password=password.getText().toString().trim();
        String ConfirmPassword=confirmPassword.getText().toString().trim();

        if(Name.isEmpty()){
            childName.setError("Name is required!");
            childName.requestFocus();
            return;
        }

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

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            User user = new User(Email,Name);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {


                                    if (task.isSuccessful()) {
                                        Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.VISIBLE);

                                        //Redirect to Main

                                    }
                                    else{
                                        Toast.makeText(Register.this,"Failed",Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }

                            });
                        }
                        else{
                            Toast.makeText(Register.this,"Failed to register",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}