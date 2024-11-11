package ru.mirea.lutchenko.domain.domain.usecases;

import ru.mirea.lutchenko.domain.domain.models.Movie;
import ru.mirea.lutchenko.domain.domain.repository.MovieRepository;

public class GetFavoriteFilmUseCase {
    private MovieRepository movieRepository;

    public GetFavoriteFilmUseCase(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie execute(){
        return movieRepository.getMovie();
    }
}
