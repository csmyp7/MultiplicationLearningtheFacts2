package com.multiplication.mccullough.multiplicationlearningthefacts;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

    private Button mBeginnerButton;
    private Button mPracticeButton;
    private Button mFlashCardButton;
    private Button mTimedButton;
    private Button mSettingsButton;
    private Button mAchievementsButton;
    private Button mProgressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBeginnerButton = findViewById(R.id.button_beginner);
        mBeginnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, BeginnerActivity.class);
                startActivity(intent);
            }
        });

        mFlashCardButton = findViewById(R.id.button_flashcard);
        mFlashCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, FlashCardActivity.class);
                startActivity(intent);
            }
        });

        mPracticeButton = findViewById(R.id.button_practice);
        mPracticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, PracticeActivity.class);
                startActivity(intent);
            }
        });

        mTimedButton = findViewById(R.id.button_timed);
        mTimedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, TimedTestActivity.class);
                startActivity(intent);
            }
        });

        mSettingsButton = findViewById(R.id.button_setting);
        mSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        mAchievementsButton = findViewById(R.id.button_achievement);
        mAchievementsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, AchievementActivity.class);
                startActivity(intent);
            }
        });

        mProgressButton = findViewById(R.id.button_progress);
        mProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
                startActivity(intent);
            }
        });

//git commit



    }
}
