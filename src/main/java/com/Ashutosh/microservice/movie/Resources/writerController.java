package com.Ashutosh.microservice.movie.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ashutosh.microservice.movie.Service.writerService;
import com.Ashutosh.microservice.movie.model.writer;

@RestController
@RequestMapping(value="/writers")
public class writerController {
	
	@Autowired
	private writerService ws;
	
	@GetMapping(value="/{writerName}")
	public writer getWriter(@PathVariable("writerName") String writerName) {
		return ws.findWriter(writerName);
	}
	
	@PostMapping
	public void createWriter(@RequestParam String writerName) {
		ws.saveWriter(ws.findWriter(writerName));
	}

}
