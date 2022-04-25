package com.example.movie_app.Movie_Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie_Model_class implements Parcelable {

    private  String movie_title;
    private  String movie_release_date;
    private int movie_id;
    private float movie_rating;
    private String movie_detail;
    private String movie_poster;
    private int movie_runtime;

// CONSTRUCTORS
    public Movie_Model_class(String movie_title, String movie_release_date, int movie_id, float movie_rating, String movie_detail, String movie_poster) {
        this.movie_title = movie_title;
        this.movie_release_date = movie_release_date;
        this.movie_id = movie_id;
        this.movie_rating = movie_rating;
        this.movie_detail = movie_detail;
        this.movie_poster = movie_poster;
        this.movie_runtime = movie_runtime;
    }

    protected Movie_Model_class(Parcel in) {
        movie_title = in.readString();
        movie_release_date = in.readString();
        movie_id = in.readInt();
        movie_rating = in.readFloat();
        movie_detail = in.readString();
        movie_poster = in.readString();
        movie_runtime = in.readInt();
    }

    public static final Creator<Movie_Model_class> CREATOR = new Creator<Movie_Model_class>() {
        @Override
        public Movie_Model_class createFromParcel(Parcel in) {
            return new Movie_Model_class(in);
        }

        @Override
        public Movie_Model_class[] newArray(int size) {
            return new Movie_Model_class[size];
        }
    };

    //GETTERS
    public String getMovie_title() {
        return movie_title;
    }

    public String getMovie_release_date() {
        return movie_release_date;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public float getMovie_rating() {
        return movie_rating;
    }

    public String getMovie_detail() {
        return movie_detail;
    }

    public String getMovie_poster() {
        return movie_poster;
    }

    public int getMovie_runtime() { return movie_runtime;  }



    @Override
    public  int describeContents(){
        return 0;
    }

    @Override
    public  void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(movie_title);
        parcel.writeString(movie_release_date);
        parcel.writeInt(movie_id);
        parcel.writeFloat(movie_rating);
        parcel.writeString(movie_detail);
        parcel.writeString(movie_poster);
    }
}


/* Sample result API
{
            "backdrop_path": "/5P8SmMzSNYikXpxil6BYzJ16611.jpg",
            "genre_ids": [
                80,
                9648,
                53
            ],
            "original_language": "en",
            "original_title": "The Batman",
            "poster_path": "/74xTEgt7R36Fpooo50r9T25onhq.jpg",
            "video": false,
            "vote_average": 7.9,
            "vote_count": 2924,
            "overview": "In his second year of fighting crime, Batman uncovers corruption in Gotham City that connects to his own family while facing a serial killer known as the Riddler.",
            "release_date": "2022-03-01",
            "title": "The Batman",
            "id": 414906,
            "adult": false,
            "popularity": 3309.044,
            "media_type": "movie"
        },
 */