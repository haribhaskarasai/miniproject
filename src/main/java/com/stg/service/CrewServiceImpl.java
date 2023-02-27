package com.stg.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Cast;
import com.stg.entity.Crew;
import com.stg.entity.Movie;
import com.stg.exception.ExceptionClass;
import com.stg.repository.CrewRepository;
import com.stg.repository.MovieRepository;
@Service
public class CrewServiceImpl implements CrewService {
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private CrewRepository crewRepository;

	

	@Override
	public Crew addTechtoNonExistingMovie(Crew technician) throws ExceptionClass {
		Movie movie =technician.getMovies().get(0);
		movie.getTechnicians().add(technician);
		movieRepository.save(movie);
		
		return crewRepository.save(technician);
	}
	
	@Override
	public Crew addTechToExisitingMovie(Crew technician, String mvName, LocalDate releaseDate) throws ExceptionClass {
		Movie movie=movieRepository.findByMvNameAndReleaseDate(mvName, releaseDate);
		
		  movie.getTechnicians().add(technician);
		  technician.getMovies().add(movie);
		 
		
		return crewRepository.save(technician);
	}

	@Override
	public List<Crew> readAllTechnicians() throws ExceptionClass {
		List<Crew> techns =crewRepository.findAll();
		if (techns.size() == 0) {
			throw new ExceptionClass("Technicians do not exist");
		}
		return techns;
	}

	@Override
	public Crew readTechByName(String techName) throws ExceptionClass {
		Crew tempTech=crewRepository.findByTechName(techName);
		if (tempTech == null) {
			throw new ExceptionClass("That Actor does not exist");

		}
		return tempTech;
	}

	
	@Override
	public String updateTechByMvNameAndReleaseDate(Crew tech, String techName, String mvName, LocalDate releaseDate)
			throws ExceptionClass {
		Movie tempMv = movieRepository.findByMvNameAndReleaseDate(mvName, releaseDate);
		boolean found = false;
		List<Crew> technicians = tempMv.getTechnicians();
		for (Crew crew : technicians) {
			if (crew.getTechName().equals(techName)) {
				found = true;
				tech.setTechId(crew.getTechId());
				crewRepository.save(tech);
			}
		}
		if (found) {
			return "Updated successfully";
		} else {
			throw new ExceptionClass("That TEch does not exist");

		}
	}
	
	@Override
	public String deleteTechByMvNameAndReleaseDate(String techName, String mvName, LocalDate releaseDate) {
	Movie tempMv = movieRepository.findByMvNameAndReleaseDate(mvName, releaseDate);
	boolean found = false;
	List<Crew> technicians = tempMv.getTechnicians();
	Crew tempTech = null;
	for (Crew tech : technicians) {
		if (tech.getTechName().equals(techName)) {
			found = true;
			tempTech=tech;
			tempTech.setTechId(tech.getTechId());
		}
	}
	if (found) {
//		castRepository.deleteActorInJunction(tempActor.getActorId());
//		castRepository.deleteActorInTable(tempActor.getActorId());
		crewRepository.deleteTechInJunction(tempTech.getTechId());
		crewRepository.deleteTechInTable(tempTech.getTechId());
		return "deleted successfully";
	} else {
		throw new ExceptionClass("That Tech does not exist");

	}
	}

	

	


	
	 

}
