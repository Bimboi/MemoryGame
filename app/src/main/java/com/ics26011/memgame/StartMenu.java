package com.ics26011.memgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StartMenu extends Fragment {

    public static final int GAME_REQUEST = 1;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.start_menu, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Game.class));
            }
        });

        view.findViewById(R.id.button_scores).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), Scores.class));
            }
        });

        view.findViewById(R.id.button_about).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), About.class));
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GAME_REQUEST && resultCode == Activity.RESULT_OK) {
            assert data != null;
            int time = data.getIntExtra(Game.EXTRA_TIME_GAME, 0);

            SharedPreferences prefs = requireActivity().getSharedPreferences("Scores", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            if (time > prefs.getInt("1st", 0)) {
                editor.putInt("1st", time);
            } else if (time > prefs.getInt("2nd", 0)) {
                editor.putInt("2nd", time);
            } else if (time > prefs.getInt("3rd", 0)) {
                editor.putInt("3rd", time);
            }

            editor.apply();
        }
    }
}