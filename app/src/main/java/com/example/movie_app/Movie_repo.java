package com.example.movie_app;

import androidx.lifecycle.LiveData;

import com.example.movie_app.model.MovieResponse;
import com.example.movie_app.request.MovieRepository;

public class Movie_repo {


    // private MutableLiveData<List<Movie_Model_class>> m_movies; //= new MutableLiveData<>();

    private MovieRepository movie_api_client;

    private static Movie_repo instance;

    public static Movie_repo getInstance() {
        if (instance == null) {
            instance = new Movie_repo();
        }
        return instance;

    }

    //  private Movie_repo(){ movie_api_client= Movie_API_Client.getInstance(); }

    private Movie_repo() {
        //  m_movies = new MutableLiveData<>();
        movie_api_client = MovieRepository.getInstance();
    }

    public LiveData<MovieResponse> getMovies() {
        //return movie_api_client.getMovies();
        return movie_api_client.getMoviesResponseLiveData();
    }

    public void searchMovieApi_trending() {
        movie_api_client.GetTendingMovie();
    }
}
