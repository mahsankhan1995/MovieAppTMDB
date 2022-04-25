package com.example.movie_app.Movie_recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movie_app.R;
import com.example.movie_app.model.MovieResponse;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> implements ItemClickListener {

    private MovieResponse model_movie;
    private ItemClickListener itemClickListener;

    @Override
    public void onMovie_click(int pos) {
        this.itemClickListener.onMovie_click(pos);
    }

    public MovieAdapter(ItemClickListener listener) {
        this.itemClickListener = listener;

    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView, textView_date;// textView_rating;
        private final RatingBar ratingBar;
        private final ImageView imageView;

        ItemClickListener itemClickListener;

        public ViewHolder(View view, ItemClickListener itemClickListener) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.movie_title);
            textView_date = view.findViewById(R.id.movie_releaseDate);
            ratingBar = view.findViewById(R.id.ratingBar_main);
           // textView_rating = view.findViewById(R.id.movie_rating);
            imageView = view.findViewById(R.id.movie_img_poster);
            view.setOnClickListener(this);
            this.itemClickListener = itemClickListener;
        }

        public TextView getTextView() {
            return textView;
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onMovie_click(getAdapterPosition());
        }
    }

    public void setMovieLiveData(MovieResponse model_movie) {
        this.model_movie = model_movie;
        notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_list_main, viewGroup, false);
        return new ViewHolder(view,this.itemClickListener);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.setText(model_movie.getResults().get(position).getTitle());
      //  viewHolder.textView_rating.setText((float) model_movie.getResults().get(position).getVoteAverage());
        viewHolder.textView_date.setText(model_movie.getResults().get(position).getReleaseDate());
        viewHolder.ratingBar.setRating(((float) model_movie.getResults().get(position).getVoteAverage())/2);

        Glide.with(viewHolder.itemView.getContext()).load("https://image.tmdb.org/t/p/w500/" +model_movie.getResults().get(position).getBackdropPath())
                .into((viewHolder).imageView);



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return model_movie.getResults().size();
    }
}
