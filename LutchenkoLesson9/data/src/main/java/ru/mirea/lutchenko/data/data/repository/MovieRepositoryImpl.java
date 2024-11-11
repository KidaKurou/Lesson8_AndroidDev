package ru.mirea.lutchenko.data.data.repository;

import android.annotation.SuppressLint;

import java.time.LocalDate;

import ru.mirea.lutchenko.data.data.storage.MovieStorage;
import ru.mirea.lutchenko.data.data.storage.models.Movie;
import ru.mirea.lutchenko.domain.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {
    private final MovieStorage movieStorage;

    public MovieRepositoryImpl(MovieStorage movieStorage){
        this.movieStorage = movieStorage;
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    public boolean saveMovie(ru.mirea.lutchenko.domain.domain.models.Movie movie) {
        movieStorage.save(mapToStorage(movie));
        return true;
    }

    @Override
    public ru.mirea.lutchenko.domain.domain.models.Movie getMovie() {
        Movie movie = movieStorage.get();
        return mapToDomain(movie);
    }

    private Movie mapToStorage(ru.mirea.lutchenko.domain.domain.models.Movie movie){
        String name = movie.getName();
        return new Movie(2, name, LocalDate.now().toString());
    }

    private ru.mirea.lutchenko.domain.domain.models.Movie mapToDomain(Movie movie){
        return new ru.mirea.lutchenko.domain.domain.models.Movie(movie.getId(), movie.getName());
    }
}
