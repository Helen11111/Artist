package com.example.myartist.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myartist.R;
import com.example.myartist.view.LevelActivity;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    List<Button> buttonList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonList.add((Button)findViewById(R.id.lvl1));
        buttonList.add((Button)findViewById(R.id.lvl2));
        buttonList.add((Button)findViewById(R.id.lvl3));
        buttonList.add((Button)findViewById(R.id.lvl4));
        buttonList.add((Button)findViewById(R.id.lvl5));
        buttonList.add((Button)findViewById(R.id.lvl6));
        buttonList.add((Button)findViewById(R.id.lvl7));
        buttonList.add((Button)findViewById(R.id.lvl8));
        buttonList.add((Button)findViewById(R.id.lvl9));
        buttonList.add((Button)findViewById(R.id.lvl10));
        buttonList.add((Button)findViewById(R.id.lvl11));
        buttonList.add((Button)findViewById(R.id.lvl12));
        buttonList.add((Button)findViewById(R.id.lvl13));
        buttonList.add((Button)findViewById(R.id.lvl14));
        buttonList.add((Button)findViewById(R.id.lvl15));


        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).setOnClickListener(this);
        }

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lvl1:
                Intent i = new Intent(getApplicationContext(), LevelActivity.class);
                startActivity(i);
                break;
            case R.id.lvl2:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl3:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl4:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl5:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl6:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl7:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl8:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl9:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl10:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl11:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl12:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl13:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl14:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
                break;
            case R.id.lvl15:
                startActivity(new Intent(this, LevelActivity.class));
                finish();
            default:
        }
    }
}