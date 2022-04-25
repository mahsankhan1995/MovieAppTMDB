package com.example.movie_app.Movie_recyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie_app.R;

public class Movie_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView movie_title_v, movie_releaseDate_v, movie_duration_v, movie_rating_v;
    RatingBar ratingBar;
    ImageView movie_imageView_v;

    ItemClickListener item_clickListener_;



    public Movie_ViewHolder(@NonNull View itemView, ItemClickListener item_clickListener_){
        super(itemView);

        this.item_clickListener_ = item_clickListener_;

        movie_title_v = itemView.findViewById(R.id.movie_title);
        movie_releaseDate_v = itemView.findViewById(R.id.movie_releaseDate);
       // movie_rating_v = itemView.findViewById(R.id.movie_rating);
       // movie_duration_v = itemView.findViewById(R.id.movie_duration);
        movie_imageView_v = itemView.findViewById(R.id.movie_img_poster);
        ratingBar = itemView.findViewById(R.id.ratingBar_main);

        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        item_clickListener_.onMovie_click(getAdapterPosition());
    }
}
