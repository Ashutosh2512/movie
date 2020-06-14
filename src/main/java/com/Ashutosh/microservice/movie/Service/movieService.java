package com.Ashutosh.microservice.movie.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashutosh.microservice.movie.Repository.movieRepository;
import com.Ashutosh.microservice.movie.model.Director;
import com.Ashutosh.microservice.movie.model.Genre;
import com.Ashutosh.microservice.movie.model.movie;
import com.Ashutosh.microservice.movie.model.movie_genre;
import com.Ashutosh.microservice.movie.model.writer;

@Service
public class movieService {
	
	@Autowired
	private movieRepository mr;
	
	public movie createMovie(movie_genre mg,Genre g) {
		movie m=new movie();
		m.setName(mg.getMovieName());
		m.setRating(Integer.parseInt(mg.getRating()));
		m.getGenres().add(g);
		m.setDescription(mg.getDescription());
		
		return m;
	}
	public movie createMoviewithgenrelistanddirectorlistandwriterlist(movie_genre mg,List<Genre> genrelist,List<Director> directorlist,List<writer> writerlist) {
		movie m=new movie();
		m.setName(mg.getMovieName());
		m.setRating(Integer.parseInt(mg.getRating()));
		m.setDescription(mg.getDescription());
		m.getGenres().addAll(genrelist);
		m.getDirectors().addAll(directorlist);
		m.getWriters().addAll(writerlist);
		return m;
	}
	
	public void saveMovie(movie m) {
		mr.save(m);
	}
	public List<movie> findmovieByRating(int rating){
		return mr.findByRatingGreaterThanEqual(rating);
	}
	public List<movie> findmovieByName(String movieName) {
		return mr.findByNameIgnoreCase(movieName);
	}

}
