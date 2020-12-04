package com.example.films.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.films.Adapter.FilmAdapter;
import com.example.films.App;
import com.example.films.R;
import com.example.films.data.Models.FilmModel;
import com.example.films.data.network.GhibliService;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FilmAdapter.OnClick {
    public static final String KEY = "key";
    private   RecyclerView recyclerView;
    private FilmAdapter filmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        filmAdapter = new FilmAdapter(this);
        recyclerView.setAdapter(filmAdapter);


        App.ghibliService.getFilms(new GhibliService.GhibliListCallBack() {
            @Override
            public void onSuccess(ArrayList<FilmModel> filmModels) {
                filmAdapter.SetFilmModel(filmModels);

            }

            @Override
            public void onFailure(Throwable e) {
                Log.d("TAG", "onFailure: " + e.getMessage());

            }
        });

    }

    @Override
    public void onClick(int position) {
        onIntent(position);

    }

    public void onIntent(int position) {
        //Toast.makeText(this,  filmAdapter.filmModelArrayList.get(position).getId(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ActivityNew.class);
//        intent.putExtra(KEY, filmAdapter.filmModelArrayList.get(position).getId());
        intent.putExtra(KEY, filmAdapter.filmModelArrayList.get(position));
        startActivity(intent);
    }
}