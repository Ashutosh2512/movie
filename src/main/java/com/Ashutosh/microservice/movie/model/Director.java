package com.Ashutosh.microservice.movie.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Director {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String directorName;
	
	@ManyToMany
	private List<movie> movies=new ArrayList<movie>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public List<movie> getMovies() {
		return movies;
	}

	public void setMovies(List<movie> movies) {
		this.movies = movies;
	}
	
	
	
	

}
