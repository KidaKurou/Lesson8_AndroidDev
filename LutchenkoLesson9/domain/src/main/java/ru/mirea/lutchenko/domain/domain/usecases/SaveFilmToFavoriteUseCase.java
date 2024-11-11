package ru.mirea.lutchenko.domain.domain.usecases;

import ru.mirea.lutchenko.domain.domain.models.Movie;
import ru.mirea.lutchenko.domain.domain.repository.MovieRepository;

public class SaveFilmToFavoriteUseCase {
    private MovieRepository movieRepository;

    public SaveFilmToFavoriteUseCase(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public boolean execute(Movie movie){
        return movieRepository.saveMovie(movie);
    }
}
