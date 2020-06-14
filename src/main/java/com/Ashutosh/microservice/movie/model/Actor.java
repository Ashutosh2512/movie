package com.Ashutosh.microservice.movie.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {

	@Id
	@GeneratedValue
	private int id;
	
	private String actorName;
	
	@ManyToMany
	private List<movie> movies=new ArrayList<movie>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActorName() {
		return actorName;
	}

	public void setName(String actorName) {
		this.actorName = actorName;
	}

	public List<movie> getMovies() {
		return movies;
	}

	public void setMovies(List<movie> movies) {
		this.movies = movies;
	}
	
	
}
