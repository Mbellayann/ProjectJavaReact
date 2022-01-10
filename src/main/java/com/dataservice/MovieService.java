package com.dataservice;

import com.datamodel.Movie;
import com.dto.MovieDto;
import com.repository.IMovieRepository;
import com.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    IMovieRepository iMovieRepository;

    public List<Movie> getAllMovies(){ return iMovieRepository.findAll(); }

    public Movie findByTitle(String name){return iMovieRepository.findByTitle(name);}

    public Movie createMovie(Movie movie){return iMovieRepository.save(movie);}
}
