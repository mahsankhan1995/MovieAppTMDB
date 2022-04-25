package com.example.movie_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.movie_app.model.ResultsItem;
import com.google.gson.Gson;

public class Movie_details extends AppCompatActivity {

    private ImageView imageViewDetails;
    private TextView titleDetails, discriptionDetails;
    private RatingBar ratingBar;

    ResultsItem resultsItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        imageViewDetails = findViewById(R.id.imageView_details);
        titleDetails = findViewById(R.id.textView_title_detail);
        discriptionDetails =findViewById(R.id.textView_detail_discription);
        ratingBar = findViewById(R.id.ratingBar_detail);

        GetDataFromIntent();

    }

    private void GetDataFromIntent() {

        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("obj");
        ResultsItem obj = gson.fromJson(strObj, ResultsItem.class);

        titleDetails.setText(obj.getTitle());
        discriptionDetails.setText(obj.getOverview() +"\n\n");
        ratingBar.setRating((float) obj.getVoteAverage());
        //Glide.with(viewHolder.itemView.getContext()).load("https://image.tmdb.org/t/p/w500/" +model_movie.getResults().get(position).getBackdropPath())
        //        .into((viewHolder).imageView);

        Glide.with(this).load("https://image.tmdb.org/t/p/w500/" + obj.getPosterPath())
                .into(imageViewDetails);




//        if(getIntent().hasExtra("movie")){
//            Movie_ViewModel movie_viewModel = getIntent().getParcelableExtra("movie");
//
//            titleDetails.setText(resultsItem.getTitle());
//            discriptionDetails.setText(resultsItem.getOverview());
//            ratingBar.setRating((float) resultsItem.getVoteAverage());
//
//            Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+resultsItem.getPosterPath())
//                    .into(imageViewDetails);
//
//
//        }

    }
}