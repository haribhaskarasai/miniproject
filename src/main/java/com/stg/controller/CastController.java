package com.stg.controller;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.stg.service.CastServiceImpl;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "Cast")
public class CastController {

	@Autowired
	public CastServiceImpl castServiceImpl;
	
	@GetMapping(value = "readAllActors")
	public List<Cast> readAllActors() {
		return castServiceImpl.readAllActors();
	}
	@GetMapping(value = "readActorByName")
	public Cast readActorByName(@RequestParam String actorName) {
		return castServiceImpl.readActorByName(actorName);
	}
	
	@GetMapping(value = "readMoviesOfActorrByName")
	public List<Movie> readMoviesOfActorrByName(@RequestParam String actorName) {
		return castServiceImpl.readMoviesOfActorrByName(actorName);
	}
	
	@PostMapping(value = "addActorToExistingMovie")
	public Cast addActorToExcisitingMovie(@RequestBody Cast actor,@RequestParam String mvName, @RequestParam
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
    LocalDate releaseDate) {
		return castServiceImpl.addActorToExcisitingMovie(actor, mvName, releaseDate);

	}
	
	@PostMapping(value = "addActorToNewMovie", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cast addActorToNonExcisitingMovie(@RequestBody Cast actor) {
		return castServiceImpl.addActortoNonExistingMovie(actor);

	}
	
	@PutMapping(value = "updateActorByMvNameAndReleaseDate")
	public String updateActorByMvNameAndReleaseDate(@RequestBody Cast actor,@RequestParam String actorName, @RequestParam String mvName, @RequestParam 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate) {
		return castServiceImpl.updateActorByMvNameAndReleaseDate(actor,actorName,mvName,releaseDate);
	}
	
	@DeleteMapping(value = "deleteActorByMvNameAndReleaseDate")
	public String deleteActorByMvNameAndReleaseDate(@RequestParam String actorName,@RequestParam String mvName, @RequestParam 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate) {
		return (castServiceImpl.deleteActorByMvNameAndReleaseDate(actorName,mvName, releaseDate));
	}
	

}
