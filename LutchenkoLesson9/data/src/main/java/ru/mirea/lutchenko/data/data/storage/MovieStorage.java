package ru.mirea.lutchenko.data.data.storage;

import ru.mirea.lutchenko.data.data.storage.models.Movie;

public interface MovieStorage {
    public Movie get();
    public boolean save(Movie movie);
}
