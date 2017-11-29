package com.kodilla.good.patterns.challenges.Movie;

import com.kodilla.good.patterns.challenges.Movie.MovieStore;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStoreApplication {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        Map<String, List<String> > allMovies = movieStore.getMovies();

        allMovies.entrySet().stream()
                .flatMap( l -> l.getValue().stream())
                .forEach( s -> System.out.print( s +"!"));

        String allTitles = allMovies.entrySet().stream()
                .flatMap( l -> l.getValue().stream())
                .collect(Collectors.joining("!"));
        System.out.println("\n" + allTitles);

    }
}
