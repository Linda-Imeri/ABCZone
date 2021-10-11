package com.example.abczone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class AboutUs_Fragment extends Fragment {

    EditText edittext;

    public AboutUs_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = getActivity().getIntent().getExtras();
        View view = inflater.inflate(R.layout.fragment_about_us_, container, false);

        edittext = view.findViewById(R.id.hyperlinks);
        edittext.setMovementMethod(LinkMovementMethod.getInstance());

        return view;
    }
}