package com.nelioalves.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Book;
import com.nelioalves.cursomc.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public Book save(Book object) {
			
		return repository.save(object);
	}
	
	public List<Book> findAll(){
		
		return repository.findAll();
	}
	
	public Book findById(Long id) {
		
		Optional<Book> object = repository.findById(id);
		
		return object.orElse(null); 
	}
}
