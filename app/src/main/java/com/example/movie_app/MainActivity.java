package com.example.movie_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.movie_app.Movie_recyclerView.MovieAdapter;
import com.example.movie_app.Movie_recyclerView.ItemClickListener;
import com.example.movie_app.model.MovieResponse;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private MovieAdapter movieAdapter;
    private MovieResponse response;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recycler view
        RecyclerView recyclerView = findViewById(R.id.recyclerView_m);

        // toolbar
        toolbar = findViewById(R.id.appBarLayout);
        setSupportActionBar(toolbar);


        Movie_ViewModel movieViewModel = new ViewModelProvider(this).get(Movie_ViewModel.class);
        movieViewModel.init();
        movieViewModel.fetchMovies();
        movieViewModel.getMovieResponseLiveData().observe(this, new Observer<MovieResponse>() {
            @Override
            public void onChanged(MovieResponse movieResponse) {
                if (movieResponse != null) {

                    movieAdapter.setMovieLiveData(movieResponse);
                    recyclerView.setAdapter(movieAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    response = movieResponse;

                }
            }
        });
        movieAdapter = new MovieAdapter(this);

        //------------------------eree-----------------------------------------------------------------

        // calling observer
        //  ObserverAnyChange();
        // ConfigureRecyclerView();
        //  searchMovieApi_trending();

/*
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // GetRetrofitResponse();
               // GetRetrofitID();
                searchMovieApi_trending();

            }
        });


 */
        //------------------------------------------------------------------------

    }
//
//
//    //data change observer
//    private void ObserverAnyChange(){
//        movie_viewModel.getMovies().observe(this, new Observer<List<Movie_Model_class>>(){
//            @Override
//            public void onChanged(List<Movie_Model_class> movie_model_classes){
//                if(movie_model_classes != null){
//                    for(Movie_Model_class movie_model_class: movie_model_classes){
//                      //  int v = Log.v("Tag", "oncreated",);
//                    Log.v("Tag","oncreated"+movie_model_class.getMovie_title());
//                    movie_adapterAdaptor.setModel_movie(movie_model_classes);
//                    }
//                }
//
//            }
//        });
//    }

//    //----- adding data to recyclerview
//    private void ConfigureRecyclerView() {
//        movie_adapterAdaptor = new MovieAdapter(this);
//        recyclerView.setAdapter(movie_adapterAdaptor);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }

    @Override
    public void onMovie_click(int pos) {
        Toast.makeText(this,"Opening \""+ response.getResults().get(pos).getTitle() +"\"", Toast.LENGTH_SHORT).show();

        Gson gson = new Gson();
        Intent intent = new Intent(this, Movie_details.class);
        intent.putExtra("obj", gson.toJson(response.getResults().get(pos)));
        startActivity(intent);
    }

}

/*

 <RatingBar
            android:id="@+id/ratingBar_detail"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="15dp"
            android:layout_marginTop="4dp"
            android:numStars="10"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/textView_title_detail" />

 */