package com.Ashutosh.microservice.movie.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashutosh.microservice.movie.Repository.GenreRepository;
import com.Ashutosh.microservice.movie.model.Genre;
import com.Ashutosh.microservice.movie.model.movie;

@Service
public class genreService {
	
	@Autowired
	private GenreRepository gr;
	
	public Genre findGenre(String genreName) {
		Genre g=gr.findByGenreNameIgnoreCase(genreName);
		if(g==null) {
			g=new Genre();
			g.setGenreName(genreName);
		}
		return g;
	}
	public void saveGenre(Genre g) {
		gr.save(g);
	}
	public void addMovietoGenre(Genre g,movie m) {
		g.getMovies().add(m);
	}
	public List<movie> findmovies(String genreName){
		Genre g=gr.findByGenreNameIgnoreCase(genreName);
		return g.getMovies();
	}
	

}
