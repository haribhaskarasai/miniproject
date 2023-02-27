package com.stg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.stg.entity.Movie;

import com.stg.exception.ExceptionClass;
import com.stg.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie addMovie(Movie movie) throws ExceptionClass {
		Movie tempMv = movieRepository.findByMvNameAndReleaseDate(movie.getMvName(), movie.getReleaseDate());
		if (tempMv == null && movie.getMvName().isEmpty() == false) {
			return movieRepository.save(movie);
			
			
		}else {
			throw new ExceptionClass("That movie with id already exist");
		}

	}
	
	@Override
	public List<Movie> readAllMovies() throws ExceptionClass {
		List<Movie> movies = movieRepository.findAll();
		if (movies.size() == 0) {
			throw new ExceptionClass("That movie does not exist");
		}
		return movies;
	}
	
	
	@Override
	public Movie readByMovieId(int mvId) throws ExceptionClass {
		Movie tempMv = movieRepository.findByMvId(mvId);
		if (tempMv == null) {
			throw new ExceptionClass("That movie does not exist");

		}
		return tempMv;

	}

	@Override
	public Movie readByMvNameAndReleaseDate(String mvName, LocalDate releaseDate) throws ExceptionClass {
		Movie movieTemp = movieRepository.findByMvNameAndReleaseDate(mvName, releaseDate);
		Movie returnMovie=null;
		if (movieTemp != null) {
			returnMovie= movieTemp;
			
		} else {
			
			throw new ExceptionClass("That movie does not exist");
		}
		return returnMovie;
	}

	@Override
	public List<Movie> findAllMoviesByRatig(float mvRating) {
		List<Movie> movies = movieRepository.findAllMoviesByRatig(mvRating);
		if (movies.size() == 0) {
			throw new ExceptionClass("movies does not exist");
		}
		return movies;
	}
	
	@Override
	public List<Movie> findAllMoviesByGener(String mvGener) {
		List<Movie> movies = movieRepository.findAllMoviesByGener(mvGener);
		if (movies.size() == 0) {
			throw new ExceptionClass("movies does not exist");
		}
		return movies;
	}
	
	@Override
	public Movie updateByMvNameAndReleaseDate(Movie movie,String mvName,LocalDate releaseDate) throws ExceptionClass {
		Movie tempMv = movieRepository.findByMvNameAndReleaseDate(mvName, releaseDate);
		if (tempMv != null) {
			movie.setMvId(tempMv.getMvId());
			movie.setActors(tempMv.getActors());
			movie.setTechnicians(tempMv.getTechnicians());
			return movieRepository.save(movie);
		} else {
			throw new ExceptionClass(
					"That movie does not exist");
		}
	}
	@Override
	public String deleteByMvNameAndReleaseDate(String mvName,LocalDate releaseDate) throws ExceptionClass {
		Movie tempMv = movieRepository.findByMvNameAndReleaseDate(mvName, releaseDate);
		if (tempMv != null ) {
			movieRepository.delete(tempMv);
			return "deleted successfully";
		} else {
			throw new ExceptionClass("That movie does not exist");

		}
	}

	

	

}
