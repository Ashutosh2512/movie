package com.Ashutosh.microservice.movie.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashutosh.microservice.movie.Repository.ActorRepository;
import com.Ashutosh.microservice.movie.model.Actor;

@Service
public class ActorService {
	
	@Autowired
	private ActorRepository ar;
	
	public Actor findActor(String a) {
		Actor actor=ar.findByActorNameIgnoreCase(a);
		if(actor==null) {
			actor=new Actor();
			actor.setName(a);
		}
		return actor;
	}
	public void saveActor(Actor a) {
		ar.save(a);
	}
}
