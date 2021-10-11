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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private EditText email, password, age, name;
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

        back = (ImageView) findViewById(R.id.back_icon);
        back.setOnClickListener(this);

        register = (Button) findViewById(R.id.login);
        register.setOnClickListener(this);


        age = (EditText) findViewById(R.id.age);
        name = (EditText) findViewById(R.id.fullName);
        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.Password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                registerUser();
                break;

            case R.id.back_icon:
                startActivity(new Intent(this, Login.class));
                break;


        }
    }

    private void registerUser() {

        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();
        String ChildName = name.getText().toString().trim();
        String ChildAge = age.getText().toString().trim();

        if (Email.isEmpty()) {
            email.setError("Email is required!");
            email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            email.setError("Please write valid email!");
            email.requestFocus();
            return;
        }

        if (Password.isEmpty()) {
            password.setError("Please write valid email!");
            password.requestFocus();
            return;
        }

        if (Password.length() < 6) {
            password.setError("Password length must be more then 6 characters!");
            password.requestFocus();
            return;
        }

        if (ChildAge.isEmpty()) {
            age.setError("Age is required");
            age.requestFocus();
            return;
        }


        if (ChildName.isEmpty()) {
            name.setError("Name is required");
            name.requestFocus();
            return;
        }

        //register user in firebase
        mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(Email, ChildName, ChildAge);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "User Created successfully", Snackbar.LENGTH_LONG);
                                        snackbar.show();
                                        startActivity(new Intent(getApplicationContext(), MainZone.class));
                                    } else {
                                        Toast.makeText(Register.this, "Failed to register" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(Register.this, "Failed to register. " + task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }
}