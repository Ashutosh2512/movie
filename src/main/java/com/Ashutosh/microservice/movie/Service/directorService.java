package com.Ashutosh.microservice.movie.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashutosh.microservice.movie.Repository.DirectorRepository;
import com.Ashutosh.microservice.movie.model.Director;

@Service
public class directorService {
	
	@Autowired
	private DirectorRepository dr;
	
	public Director findDirector(String d) {
		Director director=dr.findByDirectorNameIgnoreCase(d);
		if(director==null) {
			director=new Director();
			director.setDirectorName(d);
		}
		return director;
	}
	public void saveDirector(Director d) {
		dr.save(d);
	}
	

}
