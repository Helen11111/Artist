package com.example.myartist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myartist.view.AboutArtist;
import com.example.myartist.view.MenuActivity;
import com.example.myartist.view.SettingsActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button start;
    Button settings;
    Button aboutApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        settings = findViewById(R.id.settings);
        start = findViewById(R.id.start);
        aboutApp = findViewById(R.id.credits);

        start.setOnClickListener(this);
        settings.setOnClickListener(this);
        aboutApp.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                Intent i = new Intent(this, MenuActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.settings:
                Intent i2 = new Intent(this, SettingsActivity.class);
                startActivity(i2);
                finish();
                break;
            case R.id.credits:
                Intent i3 = new Intent(this, AboutArtist.class);
                startActivity(i3);
                finish();
                break;
        }
    }
}