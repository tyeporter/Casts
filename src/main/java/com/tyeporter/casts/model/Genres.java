package com.tyeporter.casts.model;

import java.util.HashMap;
import java.util.List;

public class Genres {
    
    private static List<Genre> res;
    private static HashMap<Integer, String> genreLocator = new HashMap<>();
    
    private Genres() {}

    public static List<Genre> getGenres() {
        return res;
    }

    public static String getGenre(Integer id) {
        return genreLocator.get(id);
    }

    public static void setGenres(List<Genre> genres) {
        res = genres;

        for (Genre genre : res) {
            genreLocator.put(genre.getId(), genre.getName());
        }
    }

}
