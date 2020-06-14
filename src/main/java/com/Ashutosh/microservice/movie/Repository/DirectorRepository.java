package com.Ashutosh.microservice.movie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ashutosh.microservice.movie.model.Director;

public interface DirectorRepository extends JpaRepository<Director, Integer> {

	Director findByDirectorName(String name);
	Director findByDirectorNameIgnoreCase(String name);
}
