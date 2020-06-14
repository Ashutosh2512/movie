package com.Ashutosh.microservice.movie.Resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ashutosh.microservice.movie.Service.ActorService;
import com.Ashutosh.microservice.movie.Service.directorService;
import com.Ashutosh.microservice.movie.Service.genreService;
import com.Ashutosh.microservice.movie.Service.movieService;
import com.Ashutosh.microservice.movie.Service.writerService;
import com.Ashutosh.microservice.movie.model.Actor;
import com.Ashutosh.microservice.movie.model.Director;
import com.Ashutosh.microservice.movie.model.Genre;
import com.Ashutosh.microservice.movie.model.movie;
import com.Ashutosh.microservice.movie.model.movie_genre;
import com.Ashutosh.microservice.movie.model.writer;

@RestController
@RequestMapping(path="/movies")
public class movieController {
	
	@Autowired
	private genreService gs;
	
	@Autowired
	private movieService ms;
	
	
	@Autowired
	private directorService ds;
	
	@Autowired
	private writerService ws;
	
	@Autowired
	private ActorService as;

	@PostMapping
	public movie addmovie(@RequestBody movie_genre mg) {
		ArrayList<Genre> genrelist=new ArrayList<Genre>();
		ArrayList<Director> directorlist=new ArrayList<Director>();
		ArrayList<writer> writerlist=new ArrayList<writer>();
		ArrayList<Actor> actorlist=new ArrayList<Actor>();
		for(String g:mg.getGenres()) {
			genrelist.add(gs.findGenre(g));
		}
		for(String d:mg.getDirectors()) {
			directorlist.add(ds.findDirector(d));
		}
		for(String w:mg.getWriters()) {
			writerlist.add(ws.findWriter(w));
		}
		for(String a:mg.getActors()) {
			actorlist.add(as.findActor(a));
		}
		movie m=ms.createMoviewithgenrelistanddirectorlistandwriterlist(mg, genrelist, directorlist, writerlist);
		ms.saveMovie(m);
		
		for(Genre g:genrelist) {
			g.getMovies().add(m);
			gs.saveGenre(g);
		}
		for(Director d:directorlist) {
			d.getMovies().add(m);
			ds.saveDirector(d);
		}
		for(writer w:writerlist) {
			w.getMovies().add(m);
			ws.saveWriter(w);
		}
		for(Actor a:actorlist) {
			a.getMovies().add(m);
			as.saveActor(a);
		}
		return m;
		
	}
	
	@GetMapping(value="/{movieName}")
	public List<movie> getMovieBymovieName(@PathVariable("movieName") String movieName) {
		return ms.findmovieByName(movieName.toLowerCase());
		
	}
}
