package com.Ashutosh.microservice.movie.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class movie {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private Integer rating;
	
	private String Description;
	
	@JsonIgnore
	@ManyToMany(mappedBy="movies", cascade = CascadeType.ALL)
	private List<Genre> genres=new ArrayList<Genre>();
	
	@JsonIgnore
	@ManyToMany(mappedBy="movies", cascade = CascadeType.ALL)
	private List<Director> directors=new ArrayList<Director>();
	
	@JsonIgnore
	@ManyToMany(mappedBy="movies", cascade = CascadeType.ALL)
	private List<writer> writers=new ArrayList<writer>();
	
	@JsonIgnore
	@ManyToMany(mappedBy="movies", cascade = CascadeType.ALL)
	private List<Actor> actors=new ArrayList<Actor>();
	
	
	
	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<writer> getWriters() {
		return writers;
	}

	public void setWriters(List<writer> writers) {
		this.writers = writers;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public void addItem(Genre g) {
		genres.add(g);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	

}
