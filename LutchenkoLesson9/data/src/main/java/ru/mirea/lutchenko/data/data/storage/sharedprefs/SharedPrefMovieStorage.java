package ru.mirea.lutchenko.data.data.storage.sharedprefs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import java.time.LocalDate;

import ru.mirea.lutchenko.data.data.storage.MovieStorage;
import ru.mirea.lutchenko.data.data.storage.models.Movie;

public class SharedPrefMovieStorage implements MovieStorage {
    private static final String PREFS_NAME = "favorite_movie";
    private static final String KEY_MOVIE_NAME = "movie_name";
    private static final String KEY_DATE = "movie_date";
    private static final String KEY_ID = "movie_id";
    private final SharedPreferences sharedPreferences;

    public SharedPrefMovieStorage(Context context){
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public Movie get(){
        String movieName = sharedPreferences.getString(KEY_MOVIE_NAME, null);
        String movieDate = sharedPreferences.getString(KEY_DATE, String.valueOf(LocalDate.now()));
        int movieId = sharedPreferences.getInt(KEY_ID, -1);
        return new Movie(movieId, movieName, movieDate);
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    public boolean save(Movie movie){
        sharedPreferences.edit().putString(KEY_MOVIE_NAME, movie.getName());
        sharedPreferences.edit().putString(KEY_DATE, String.valueOf(LocalDate.now()));
        sharedPreferences.edit().putInt(KEY_ID, 1);
        sharedPreferences.edit().apply(); //commit ???
        return true;
    }
}
