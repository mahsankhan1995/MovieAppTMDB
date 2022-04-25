package com.example.movie_app.Utilities;

import com.example.movie_app.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Movie_API {
// for trending movies
// https://api.themoviedb.org/3/trending/all/day?api_key=c9856d0cb57c3f14bf75bdc6c063b8f3&page=3
// https://api.themoviedb.org/3/movie/popular?page=3&api_key=c9856d0cb57c3f14bf75bdc6c063b8f3


    @GET("movie/popular")
    Call<MovieResponse> movie_response_trending_search(
            @Query("page") int pageNumber,
            @Query("api_key") String Key);


//   for movie detail by id
// https://api.themoviedb.org/3/movie/77?api_key=c9856d0cb57c3f14bf75bdc6c063b8f3&language=en-US
// 77 for momento

    @GET("3/movie/{movie_id}")
    Call<MovieResponse> movie_detail(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );

    //Call<Movie_Response_Trending> movie_response_trending();
}
