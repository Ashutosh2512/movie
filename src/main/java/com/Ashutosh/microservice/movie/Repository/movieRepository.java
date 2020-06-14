package com.Ashutosh.microservice.movie.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Ashutosh.microservice.movie.model.Genre;
import com.Ashutosh.microservice.movie.model.movie;

public interface movieRepository extends JpaRepository<movie, Integer> {
	@Query("select m from movie m where m.name like %?1%")
	List<movie> findByNameIgnoreCase(String moviename);
	
	List<movie> findByRatingGreaterThanEqual(Integer rating);
	
	
}
