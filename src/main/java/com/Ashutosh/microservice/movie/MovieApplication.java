package com.Ashutosh.microservice.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Ashutosh.microservice.movie.Service.genreService;
import com.Ashutosh.microservice.movie.Service.movieService;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}
	
	

}
