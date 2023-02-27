package com.stg.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.stg.entity.Cast;
import com.stg.entity.Movie;
import com.stg.exception.ExceptionClass;
import com.stg.repository.CastRepository;
import com.stg.repository.MovieRepository;

@Service
public class CastServiceImpl implements CastService {
	@Autowired
	private CastRepository castRepository;
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Cast addActortoNonExistingMovie(Cast actor) throws ExceptionClass {
		// Movie movie = movieRepository.findByMvId(movieId);
		// Cast actorTemp =actorRepository.findByActorId(actor.getActorId());
		Movie movie = actor.getMovies().get(0);
		movie.getActors().add(actor);
		movieRepository.save(movie);
		return castRepository.save(actor);

	}

	@Override
	public Cast addActorToExcisitingMovie(Cast actor, String mvName, LocalDate releaseDate) throws ExceptionClass {
		Movie movie = movieRepository.findByMvNameAndReleaseDate(mvName, releaseDate);
		movie.getActors().add(actor);
		actor.getMovies().add(movie);
		return castRepository.save(actor);
	}

	@Override
	public List<Cast> readAllActors() throws ExceptionClass {
		List<Cast> actors = castRepository.findAll();
		if (actors.size() == 0) {
			throw new ExceptionClass("Actors do not exist");
		}
		return actors;
	}

	@Override
	public Cast readActorByName(String actorName) throws ExceptionClass {
		Cast tempActor = castRepository.findByActorName(actorName);
		if (tempActor == null) {
			throw new ExceptionClass("That Actor does not exist");

		}
		return tempActor;
	}
	

	@Override
	public List<Movie> readMoviesOfActorrByName(String actorName) throws ExceptionClass {
		List<Movie> movies=new ArrayList<>();
		List<Integer>  moviesIds=new ArrayList<>();
		Movie tempMovie =null;
		Cast tempActor = castRepository.findByActorName(actorName);
		if (tempActor == null) {
			throw new ExceptionClass("That Actor does not exist");

		}else {
			moviesIds=castRepository.readMoviesIds(tempActor.getActorId());
			for (Integer mv_id : moviesIds) {
				tempMovie=movieRepository.getById(mv_id);
				movies.add(tempMovie);
			}
			return movies;
		}
		
	}
	
	
	@Override
	public String updateActorByMvNameAndReleaseDate(Cast actor, String actorName, String mvName, LocalDate releaseDate)
			throws ExceptionClass {
		Movie tempMv = movieRepository.findByMvNameAndReleaseDate(mvName, releaseDate);
		boolean found = false;
		List<Cast> actors = tempMv.getActors();
		for (Cast cast : actors) {
			if (cast.getActorName().equals(actorName)) {
				found = true;
				actor.setActorId(cast.getActorId());
				castRepository.save(actor);
			}
		}
		if (found) {
			return "Updated successfully";
		} else {
			throw new ExceptionClass("That Actor does not exist");

		}
	}
	
	@Override
	public String deleteActorByMvNameAndReleaseDate(String actorName, String mvName, LocalDate releaseDate)throws ExceptionClass{
		Movie tempMv = movieRepository.findByMvNameAndReleaseDate(mvName, releaseDate);
		boolean found = false;
		List<Cast> actors = tempMv.getActors();
		Cast tempActor = null;
		for (Cast cast : actors) {
			if (cast.getActorName().equals(actorName)) {
				found = true;
				tempActor=cast;
				tempActor.setActorId(cast.getActorId());
			}
		}
		if (found) {
			castRepository.deleteActorInJunction(tempActor.getActorId());
			castRepository.deleteActorInTable(tempActor.getActorId());
			return "deleted successfully";
		} else {
			throw new ExceptionClass("That Actor does not exist");

		}

	}


	

}

/*
 * if (actorTemp == null ) {
 * 
 * return actorRepository.save(actor); } else { throw new
 * ExceptionClass("That movie already exist"); }
 */