package com.Ashutosh.microservice.movie;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ashutosh.microservice.movie.Repository.GenreRepository;
import com.Ashutosh.microservice.movie.Repository.movieRepository;
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
@RequestMapping(path="/hello")
public class Hello {
	
	@Autowired
	private movieService ms;
	
	@Autowired
	private genreService gs;
	
	@Autowired
	private movieRepository mr;
	
	@Autowired
	private GenreRepository gr;
	
	@Autowired
	private directorService ds;
	
	@Autowired
	private writerService ws;
	
	@Autowired
	private ActorService as;
	
	@GetMapping
	public String hello() {
		return "HELLO";
	}
	
	@PostMapping(value="/addmovie")
	public movie addmovie(@RequestBody movie_genre mg) {
		/*
		Genre g=gs.findGenre(mg.getGenre());
		movie m=ms.createMovie(mg, g);
		gs.addMovietoGenre(g, m);
	    ms.saveMovie(m);
	    gs.saveGenre(g);
		return m;
		*/
		/*
		ArrayList<Genre> genrelist=new ArrayList<Genre>();
		for(String g:mg.getGenres()) {
			genrelist.add(gs.findGenre(g));
		}
		movie m=ms.createMoviewithgenrelist(mg, genrelist);
		ms.saveMovie(m);
		for(Genre g:genrelist) {
			g.getMovies().add(m);
			gs.saveGenre(g);
		}
		return m;
		*/
		System.out.println(mg.getDescription());
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
	@GetMapping(value="movie/{movieName}")
	public List<movie> getMovieBymovieName(@PathVariable("movieName") String movieName) {
		return ms.findmovieByName(movieName.toLowerCase());
		
	}
	@GetMapping(value="genre/{genreName}")
	public List<movie> getAllmoviesByGenre(@PathVariable("genreName") String genreName) {
		return gs.findmovies(genreName.toLowerCase());
	}
	
	@GetMapping(value="rating/{rating}")
	public List<movie> getmovieByRating(@PathVariable("rating") Integer rating){
		return ms.findmovieByRating(rating);
	}
	@GetMapping(value="director/{directorName}")
	public Director getDirectorByName(@PathVariable("directorName") String directorName){
		return ds.findDirector(directorName);
	}
	@GetMapping(value="/actor/{actorName}")
	public Actor getActorByName(@PathVariable("actorName") String actorName) {
		return as.findActor(actorName);
	}
}
