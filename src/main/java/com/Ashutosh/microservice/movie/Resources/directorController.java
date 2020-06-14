package com.Ashutosh.microservice.movie.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ashutosh.microservice.movie.Service.directorService;
import com.Ashutosh.microservice.movie.model.Director;

@RestController
@RequestMapping(value="/directors")
public class directorController {
	
	@Autowired
	private directorService ds;
	
	@GetMapping(value="/{directorName}")
	public Director getDirectorByName(@PathVariable("directorName") String directorName){
		return ds.findDirector(directorName);
	} 
	
	@PostMapping
	public void createDirector(@RequestParam(value="directorName") String directorName) {
		ds.saveDirector(ds.findDirector(directorName));
	}

}
