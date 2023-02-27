package com.stg.service;

import java.time.LocalDate;
import java.util.List;

import com.stg.entity.Cast;
import com.stg.entity.Movie;
import com.stg.exception.ExceptionClass;

public interface CastService {
	public abstract List<Cast> readAllActors() throws ExceptionClass;
	public abstract Cast readActorByName(String actorName) throws ExceptionClass;
	
	public abstract  List<Movie> readMoviesOfActorrByName(String actorName) throws ExceptionClass;
	public abstract Cast addActortoNonExistingMovie(Cast actor) throws ExceptionClass;
	public abstract Cast addActorToExcisitingMovie(Cast actor,String mvName,LocalDate releaseDate) throws ExceptionClass;
	public abstract String updateActorByMvNameAndReleaseDate(Cast actor,String actorName,String mvName,LocalDate releaseDate) throws ExceptionClass;
	
	
	public abstract String deleteActorByMvNameAndReleaseDate(String actorName,String mvName,LocalDate releaseDate) throws ExceptionClass;
}
