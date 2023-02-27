package com.stg.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stg.entity.Cast;
import com.stg.entity.Movie;
@Repository
public interface CastRepository extends JpaRepository<Cast, Integer>{
	public Cast findByActorName(String actorName);
	
@Transactional	
@Modifying	
@Query(value = "delete  from movie_actor where actor_id =:actorId",nativeQuery = true)
public abstract void deleteActorInJunction(@Param(value="actorId") int actorId);

@Transactional	
@Modifying	
@Query(value = "delete  from cast where actor_id =:actorId",nativeQuery = true)
public abstract void deleteActorInTable(@Param(value="actorId") int actorId);



@Transactional	
@Modifying	
@Query(value = "select movie_id from movie_actor where actor_id =:actorId",nativeQuery = true)
public abstract List<Integer> readMoviesIds(@Param(value="actorId") int actorId);


}
