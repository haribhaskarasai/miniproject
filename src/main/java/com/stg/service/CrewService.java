package com.stg.service;


import java.time.LocalDate;
import java.util.List;

import com.stg.entity.Cast;
import com.stg.entity.Crew;
import com.stg.entity.Movie;
import com.stg.exception.ExceptionClass;

public interface CrewService {
	public abstract List<Crew> readAllTechnicians() throws ExceptionClass;
	public abstract Crew readTechByName(String techName) throws ExceptionClass;
	public abstract Crew addTechToExisitingMovie(Crew technician,String mvName,LocalDate releaseDate) throws ExceptionClass;
	
	public abstract Crew addTechtoNonExistingMovie(Crew technician) throws ExceptionClass;
	
	public abstract String updateTechByMvNameAndReleaseDate(Crew tech,String techName,String mvName,LocalDate releaseDate) throws ExceptionClass;
	
	
	public abstract String deleteTechByMvNameAndReleaseDate(String techName,String mvName,LocalDate releaseDate) throws ExceptionClass;

	
}
