package com.stg.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Cast;
import com.stg.entity.Movie;
import com.stg.exception.ExceptionClass;
import com.stg.service.MovieService;
import com.stg.service.MovieServiceImpl;

@RestController
@RequestMapping(value = "Movie")
@CrossOrigin(value = "http://localhost:4200")
public class MovieController {
	@Autowired
	public MovieServiceImpl movieServiceImpl;

	@PostMapping(value = "addMv")
	public Movie addMovie(@RequestBody Movie movie) {
		return movieServiceImpl.addMovie(movie);

	}
	
	@GetMapping(value = "readAllMovies")
	public List<Movie> readAllMovies() {
		return movieServiceImpl.readAllMovies();
	}
	
	@GetMapping(value = "readByMvId/{mvId}")
	public Movie readByMvId(@PathVariable int mvId) {
		return movieServiceImpl.readByMovieId(mvId);
	}
	
	
	@GetMapping(value = "readByMvNameAndReleaseDate")
	public Movie readByMvNameAndReleaseDate(@RequestParam String mvName, @RequestParam
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
    LocalDate releaseDate) {
		return movieServiceImpl.readByMvNameAndReleaseDate(mvName, releaseDate);
	}
	
	@GetMapping(value = "readAllMoviesByMvRating")
	public List<Movie> readByMvRating(@RequestParam float mvRating) {
		return movieServiceImpl.findAllMoviesByRatig(mvRating);
	}
	@GetMapping(value = "readAllMoviesByMvGener")
	public List<Movie> readByMvGener(@RequestParam String mvGener) {
		return movieServiceImpl.findAllMoviesByGener(mvGener);
	}
	
	
	@PutMapping(value = "updateByMvNameAndReleaseDate")
	public Movie updateMvByMvNameAndReleaseDate(@RequestBody Movie movie, @RequestParam String mvName, @RequestParam 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate) {
		return movieServiceImpl.updateByMvNameAndReleaseDate(movie,mvName,releaseDate);
	}

	@DeleteMapping(value = "deleteByMvNameAndReleaseDate")
	public String deleteByMvNameAndReleaseDate(@RequestParam String mvName, @RequestParam 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate) {
		return (movieServiceImpl.deleteByMvNameAndReleaseDate(mvName, releaseDate));
	}

	@ExceptionHandler(value = com.stg.exception.ExceptionClass.class)
	public String handleException(ExceptionClass exceptionClass) {
		return exceptionClass.getMessage();
	}

}
