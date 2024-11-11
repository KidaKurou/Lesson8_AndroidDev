package ru.mirea.lutchenko.data.data.storage.models;

public class Movie {
    private int id;
    private String name;
    private String localDate;

    public Movie(int id, String name, String localDate){
        this.id = id;
        this.name = name;
        this.localDate = localDate;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLocalDate() {
        return this.localDate;
    }
}