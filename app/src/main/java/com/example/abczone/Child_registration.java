package com.example.abczone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.ref.Reference;

public class Child_registration extends AppCompatActivity {
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private EditText childName, childAge;
    private CheckBox gender;
    private Button registerChild;
    Child child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_registration);
        childName=findViewById(R.id.childName);
        childAge=findViewById(R.id.childAge);
        gender=findViewById(R.id.gender);
        registerChild=findViewById(R.id.registerChild);
        reference=FirebaseDatabase.getInstance().getReference().child("Childs");
        registerChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = childName.getText().toString().trim();
                String age = childAge.getText().toString().trim();
                child=new Child(name,age);

            }
        });

    }
}