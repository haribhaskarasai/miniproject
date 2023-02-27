package com.stg.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stg.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	public Movie findByMvId(int mvId);
	public Movie findByMvNameAndReleaseDate(String mvName,LocalDate releaseDate);
	
	//@Query(value = "update table mv_tbl {where mv_id=?1",nativeQuery = true)
	//public Movie updateMovieById(int mvId);
	
	@Query(value = "select * from movie where mv_rating>=?1",nativeQuery = true)
	public List<Movie> findAllMoviesByRatig(float mvRating);
	
	@Query(value = "select * from movie where mv_gener=?1",nativeQuery = true)
	public List<Movie> findAllMoviesByGener(String mvGener);
}
