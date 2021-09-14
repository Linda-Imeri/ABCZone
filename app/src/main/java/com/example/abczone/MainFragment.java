package com.example.abczone;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainFragment extends Fragment implements View.OnClickListener{

    private Button audioBook,listenMusic;
    private ImageView letters,animals,fruits,colors,months;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getActivity().getIntent().getExtras();
        View view=inflater.inflate(R.layout.fragment_main, container, false);

        audioBook=view.findViewById(R.id.audio_book);
        audioBook.setOnClickListener(this);
        letters=view.findViewById(R.id.learnabc);
        letters.setOnClickListener(this);
        animals=view.findViewById(R.id.learnanimals);
        animals.setOnClickListener(this);
        fruits=view.findViewById(R.id.learnfruits);
        fruits.setOnClickListener(this);
        colors=view.findViewById(R.id.learncolors);
        colors.setOnClickListener(this);
        months=view.findViewById(R.id.learnmonths);
        months.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.audio_book:
                Intent intentRegister = new Intent(getActivity().getApplicationContext(),AudioBooks.class);
                startActivity(intentRegister);
                break;

            case R.id.listen_music:
                Intent intentMusic= new Intent(getActivity().getApplicationContext(),Music.class);
                startActivity(intentMusic);
                break;



            // case R.id.learnabc:
            //Intent intentColors= new Intent(getActivity().getApplicationContext(),Colors.class);
            // startActivity(intentColors);
            // break;

            case R.id.learncolors:
                Intent intentColors= new Intent(getActivity().getApplicationContext(),Colors.class);
                startActivity(intentColors);
                break;

            case R.id.learnanimals:
                Intent intentAnimals= new Intent(getActivity().getApplicationContext(),Animals.class);
                startActivity(intentAnimals);
                break;

            case R.id.learnfruits:
                Intent intentFruits=new Intent(getActivity().getApplicationContext(),Fruits.class);
                startActivity(intentFruits);
                break;

            case R.id.learnmonths:
                Intent intentMonths=new Intent(getActivity().getApplicationContext(),Months.class);
                startActivity(intentMonths);
                break;
    }
}
}