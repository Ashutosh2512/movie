package com.Ashutosh.microservice.movie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ashutosh.microservice.movie.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
	
	Actor findByActorName(String name);
	Actor findByActorNameIgnoreCase(String name);
}
