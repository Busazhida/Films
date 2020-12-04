package com.example.films.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.films.R;
import com.example.films.data.Models.FilmModel;

public class ActivityNew extends AppCompatActivity {

    private TextView deck, director, realDate;
    private String position, position2;
    private FilmModel filmModel1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        deck = findViewById(R.id.deck_two);
        director = findViewById(R.id.director_view);
        realDate = findViewById(R.id.rel_dat);


        if (getIntent() != null) {

            filmModel1 = (FilmModel) getIntent().getSerializableExtra(MainActivity.KEY);
            deck.setText(filmModel1.getDescription());
            director.setText(filmModel1.getDirector());
            realDate.setText(filmModel1.getReleaseDate());
        }
    }
}