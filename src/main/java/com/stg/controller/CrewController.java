package com.stg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Cast;
import com.stg.entity.Crew;
import com.stg.entity.Movie;
import com.stg.repository.CrewRepository;
import com.stg.service.CrewServiceImpl;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "Crew")
public class CrewController {
	
	@Autowired
	public CrewServiceImpl crewServiceImpl;
	
	@GetMapping(value = "readAllTechnicians")
	public List<Crew> readAllTechnicians() {
		return crewServiceImpl.readAllTechnicians();
	}
	@GetMapping(value = "readTechByName")
	public Crew readTechByName(@RequestParam String techName) {
		return crewServiceImpl.readTechByName(techName);
	}  
	
	@PostMapping(value = "addTechToExistingMovie")
	public Crew addTechToExcisitingMovie(@RequestBody Crew technician,@RequestParam String mvName, @RequestParam 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
    LocalDate releaseDate) {
		return crewServiceImpl.addTechToExisitingMovie(technician, mvName, releaseDate);

	}
	 
	@PostMapping(value = "addTechToNonExistingMovie", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Crew addTechToNonExistingMovie(@RequestBody Crew technician) {
		return crewServiceImpl.addTechtoNonExistingMovie(technician);

	}
	
	@PutMapping(value = "updateTechByMvNameAndReleaseDate")
	public String updateTechByMvNameAndReleaseDate(@RequestBody Crew tech,@RequestParam String techName, @RequestParam String mvName, @RequestParam 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate) {
		return crewServiceImpl.updateTechByMvNameAndReleaseDate(tech,techName,mvName,releaseDate);
	}
	
	@DeleteMapping(value = "deleteTechByMvNameAndReleaseDate")
	public String deleteTechByMvNameAndReleaseDate(@RequestParam String techName,@RequestParam String mvName, @RequestParam 
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate releaseDate) {
		return (crewServiceImpl.deleteTechByMvNameAndReleaseDate(techName,mvName, releaseDate));
	}
	
}
