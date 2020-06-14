package com.Ashutosh.microservice.movie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ashutosh.microservice.movie.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

	Genre findByGenreName(String name);
	Genre findByGenreNameIgnoreCase(String name);
}
