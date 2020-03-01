package com.nelioalves.cursomc.resouces;

import com.nelioalves.cursomc.domain.Book;
import com.nelioalves.cursomc.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="books")
@CrossOrigin
public class BookResource {
	@Autowired
	private BookService service; 

	
	@PostMapping
	public ResponseEntity<Book> save(@RequestBody Book object){

		return new ResponseEntity<Book>(service.save(object),HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> get(){
		return new ResponseEntity<List<Book>>(service.findAll(),HttpStatus.OK);
	} 
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Book> update(@PathVariable Long id,@RequestBody Book object) {
			
		
		Book book = service.findById(id);
		book.setTitle(object.getTitle());
		book.getAuthors().addAll(object.getAuthors());
		return new ResponseEntity<Book>(service.save(book),HttpStatus.OK); 		
		
	}
	

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findyId(@PathVariable Long id) {
			
		
		return new ResponseEntity<Book>(service.findById(id),HttpStatus.OK);
		
		
		
		
		
	}
	
}
