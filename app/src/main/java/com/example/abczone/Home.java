package com.example.abczone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;


public class Home extends AppCompatActivity implements View.OnClickListener {
    private Button audioBook,listenMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_home);

        Button changeLang=findViewById(R.id.changeLang);

        audioBook=(Button) findViewById(R.id.audio_book);
        audioBook.setOnClickListener(this);

        listenMusic=(Button) findViewById(R.id.listen_music);
        listenMusic.setOnClickListener(this);

        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLanguageDialog();
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.audio_book:
                startActivity(new Intent(this,AudioBooks.class));
                break;
            case R.id.listen_music:
                startActivity(new Intent(this,Music.class));
                break;


        }
    }

    private void showChangeLanguageDialog() {
        final String[] listItems={"En","shqip"};
        AlertDialog.Builder mBuilder=new AlertDialog.Builder(Home.this);
        mBuilder.setTitle("Choose Language");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i==0){
                    setLocale("sq");
                    recreate();
                }
                else if(i==1){
                    setLocale("en");
                    recreate();
                }

                //dismiss alert dialog when language selected
                dialogInterface.dismiss();
            }
        });

        AlertDialog mDialog=mBuilder.create();
        //show alert dialog
        mDialog.show();

    }

    private void setLocale(String s) {
        Locale locale=new Locale(s);
        Locale.setDefault(locale);
        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        //Save to shared preferences
        SharedPreferences.Editor editor=getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",s);
        editor.apply();

    }

    //load language saved in shared preferences
    public void loadLocale(){
        SharedPreferences prefs=getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language=prefs.getString("My_Lang","");
        setLocale(language);
    }
}