package com.example.movie.service;
/*
 * You can use the following import statements
 * 
 * 
 *
 */

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.stereotype.Service;
 import org.springframework.web.server.ResponseStatusException;
 import java.util.*;

 import com.example.movie.model.*;
 import com.example.movie.repository.*;

// Write your code here
@Service
public class MovieJpaService implements MovieRepository {
    @Autowired
    public MovieJpaRepository movieRepository;

    @Override
    public ArrayList<Movie> getMovies() {
        List<Movie> movieList = movieRepository.findAll();
        ArrayList<Movie> movies = new ArrayList<>(movieList);
      
        return movies;
    }

    @Override
    public Movie getMovieById(int movieId) {
        try {
            Movie movie = movieRepository.findById(movieId).get();
            return movie;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Movie addMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {
        try {
            Movie movies = movieRepository.findById(movieId).get();
            if (movie.getMovieName() != null) {
                movies.setMovieName(movie.getMovieName());
            }
            if (movie.getLeadActor() != null) {
                movies.setLeadActor(movie.getLeadActor());
            }

            return movieRepository.save(movies);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteMovie(int movieId) {
        try {
            movieRepository.deleteById(movieId);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}