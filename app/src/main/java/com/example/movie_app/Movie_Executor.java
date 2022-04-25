package com.example.movie_app;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Movie_Executor {

    private static Movie_Executor instance;

    public static Movie_Executor getInstance(){
        if (instance==null){
            instance = new Movie_Executor();
        }
        return instance;
    }

    private final ScheduledExecutorService networkIO = Executors.newScheduledThreadPool(3);

    public ScheduledExecutorService getNetworkIO() {
        return networkIO;
    }
}

