package com.example.films;

import android.app.Application;

import com.example.films.data.network.GhibliService;

public class App extends Application {

    public static GhibliService ghibliService;

    @Override
    public void onCreate() {
        super.onCreate();
        ghibliService = new GhibliService();


    }
}
