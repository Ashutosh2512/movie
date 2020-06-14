package com.Ashutosh.microservice.movie.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ashutosh.microservice.movie.Service.genreService;
import com.Ashutosh.microservice.movie.model.Genre;
import com.Ashutosh.microservice.movie.model.movie;

@RestController
@RequestMapping(path="/genres")
public class genreController {

	@Autowired
	private genreService gs;
	
	
	@GetMapping(value="/{genreName}")
	public List<movie> getAllmoviesByGenre(@PathVariable("genreName") String genreName) {
		return gs.findmovies(genreName.toLowerCase());
	}
	
	@PostMapping
	public void createGenre(@RequestParam(value="genreName") String genreName) {
		 gs.saveGenre(gs.findGenre(genreName));
	}
	
}
