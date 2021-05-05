package com.ics26011.memgame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class Scores extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_scores);

        TextView firstPlace = findViewById(R.id.first_place);
        TextView secondPlace = findViewById(R.id.second_place);
        TextView thirdPlace = findViewById(R.id.third_place);

        SharedPreferences preferences = getSharedPreferences("Scores", MODE_PRIVATE);

        int first = preferences.getInt("1st", 0);
        int second = preferences.getInt("2nd", 0);
        int third = preferences.getInt("3rd", 0);

        if (first == 0) {
            firstPlace.setText("-:--");
        } else if (first < 10) {
            firstPlace.setText("0:0" + preferences.getInt("1st", 0));
        } else {
            firstPlace.setText("0:" + preferences.getInt("1st", 0));
        }

        if (second == 0) {
            secondPlace.setText("-:--");
        } else if (second < 10) {
            secondPlace.setText("0:0" + preferences.getInt("2nd", 0));
        } else {
            secondPlace.setText("0:" + preferences.getInt("2nd", 0));
        }

        if (third == 0) {
            thirdPlace.setText("-:--");
        } else if (third < 10) {
            thirdPlace.setText("0:0" + preferences.getInt("3rd", 0));
        } else {
            thirdPlace.setText("0:" + preferences.getInt("3rd", 0));
        }

        findViewById(R.id.exit_score_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}