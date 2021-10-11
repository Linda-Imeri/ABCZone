package com.example.abczone;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {
    private FirebaseUser user;
    private DatabaseReference reference;
    private TextView fullName, email, age;
    private String userID;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        Bundle bundle = getActivity().getIntent().getExtras();
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        fullName = view.findViewById(R.id.nameChild);
        email = view.findViewById(R.id.email);
        age = view.findViewById(R.id.ageChild);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null) {
                    String fullNameProfile = userProfile.name;
                    String Email = userProfile.email;
                    String Age = userProfile.age;

                    fullName.append(": " + fullNameProfile);
                    email.append(": " + Email);
                    age.append(": " + Age);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                fullName.setText("User not found");

            }
        });

        return view;
    }
}