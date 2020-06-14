package com.Ashutosh.microservice.movie.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue
	
	private Integer id;
	
	
	private String genreName;
	
	@ManyToMany
	private List<movie> movies=new ArrayList<movie>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<movie> getMovies() {
		return movies;
	}

	public void setMovies(List<movie> movies) {
		this.movies = movies;
	}
	
	
	

}
