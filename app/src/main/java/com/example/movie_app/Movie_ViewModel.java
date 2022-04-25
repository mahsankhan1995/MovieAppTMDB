package com.example.movie_app;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movie_app.Movie_Model.Movie_Model_class;
import com.example.movie_app.model.MovieResponse;
import com.example.movie_app.request.MovieRepository;

import java.util.List;

// -----------------------------
// ViewModel of MVVM
//------------------------------
public class Movie_ViewModel extends AndroidViewModel {

    MovieRepository movieRepository;
    private LiveData<MovieResponse> movieResponseLiveData;

    public Movie_ViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        movieRepository = new MovieRepository();
        movieResponseLiveData = movieRepository.getMoviesResponseLiveData();
    }

    public void fetchMovies() {
        movieRepository.GetTendingMovie();
    }

    public LiveData<MovieResponse> getMovieResponseLiveData() {
        return movieResponseLiveData;
    }
}