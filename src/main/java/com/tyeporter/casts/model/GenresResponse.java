package com.tyeporter.casts.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenresResponse {

    @JsonProperty("genres")
    private List<Genre> genres;

    public GenresResponse() {}

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "GenresResponse [genres=" + genres + "]";
    }
    
}
