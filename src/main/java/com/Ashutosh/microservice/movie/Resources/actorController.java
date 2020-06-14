package com.Ashutosh.microservice.movie.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ashutosh.microservice.movie.Service.ActorService;
import com.Ashutosh.microservice.movie.model.Actor;

@RestController
@RequestMapping(value="/actors")
public class actorController {
	
	@Autowired
	private ActorService as;
	
	@GetMapping(value="/{actorName}")
	public Actor getActorByName(@PathVariable("actorName") String actorName) {
		
		return as.findActor(actorName);
	}
	
	@PostMapping
	public void createActor(@RequestParam(value="actorName") String actorName) {
		as.saveActor(as.findActor(actorName));
	}

}
