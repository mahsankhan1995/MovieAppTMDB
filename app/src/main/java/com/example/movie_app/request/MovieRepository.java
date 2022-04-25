package com.example.movie_app.request;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movie_app.Utilities.Movie_API;
import com.example.movie_app.model.MovieResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private MutableLiveData<MovieResponse> mutableLiveData;
    private static MovieRepository instance;
    MovieResponse movieResponse;

    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }

    public MovieRepository() {
        mutableLiveData = new MutableLiveData<>();
    }

    public void GetTendingMovie() {
        Movie_API movieApi = Movie_Service_class.getClient().create(Movie_API.class);
        Call<MovieResponse> call = movieApi.movie_response_trending_search(1, "c9856d0cb57c3f14bf75bdc6c063b8f3");
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                Log.v("KEKRA", response.body().toString());
                movieResponse = response.body();
                mutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.v("KEKRA", call.toString());
                mutableLiveData.postValue(null);
            }
        });
    }

    public LiveData<MovieResponse> getMoviesResponseLiveData() {
        return mutableLiveData;
    }
}