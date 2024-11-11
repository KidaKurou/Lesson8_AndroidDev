package ru.mirea.lutchenko.domain.domain.repository;

import ru.mirea.lutchenko.domain.domain.models.Movie;

public interface MovieRepository {
    public boolean saveMovie(Movie movie);
    public Movie getMovie();
}
