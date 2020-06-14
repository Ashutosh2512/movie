package com.Ashutosh.microservice.movie.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashutosh.microservice.movie.Repository.writerRepository;
import com.Ashutosh.microservice.movie.model.writer;

@Service
public class writerService {

	@Autowired
	private writerRepository wr;
	
	public writer findWriter(String w) {
		writer Writer=wr.findByWriterNameIgnoreCase(w);
		if(Writer==null) {
			Writer=new writer();
			Writer.setWriterName(w);;
		}
		return Writer;
	}
	
	public void saveWriter(writer w) {
		wr.save(w);
	}
}
