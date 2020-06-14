package com.Ashutosh.microservice.movie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ashutosh.microservice.movie.model.writer;

public interface writerRepository extends JpaRepository<writer, Integer> {

	writer findByWriterName(String name);
	writer findByWriterNameIgnoreCase(String name);
}
