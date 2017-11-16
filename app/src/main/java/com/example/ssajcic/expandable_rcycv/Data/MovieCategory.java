package com.example.ssajcic.expandable_rcycv.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssajcic on 15.11.17..
 */

public class MovieCategory {
    private String categoryName;
    private List<Movie> movies = null;

    public MovieCategory(String categoryName, List<Movie> movies) {
        this.categoryName = categoryName;
        this.movies = movies;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
