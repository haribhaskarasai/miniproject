package com.stg.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stg.entity.Crew;
@Repository
public interface CrewRepository  extends JpaRepository<Crew, Integer>{
	public Crew findByTechName(String techName);
	
	@Transactional	
	@Modifying	
	@Query(value = "delete  from movie_tech where tech_id =:techId",nativeQuery = true)
	public abstract void deleteTechInJunction(@Param(value="techId") int techId);

	
	@Query(value = "delete  from crew where tech_id =:techId",nativeQuery = true)
	public abstract void deleteTechInTable(@Param(value="techId") int techId);
}
