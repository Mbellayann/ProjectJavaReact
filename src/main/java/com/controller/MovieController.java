package com.controller;

import com.datamodel.Movie;
import com.datamodel.Role;
import com.datamodel.User;
import com.dataservice.MovieService;
import com.dto.MovieDto;
import com.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping(value = "/movie")
    public Movie createUsers(@RequestBody MovieDto movieDto) {
        Movie movie = movieDto.MapUser();
        return movieService.createMovie(movie);
    }

    @GetMapping(value = "/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok().body(movieService.getAllMovies());
    }
}
