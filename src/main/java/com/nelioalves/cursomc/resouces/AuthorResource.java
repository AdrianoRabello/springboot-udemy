package com.nelioalves.cursomc.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.nelioalves.cursomc.domain.Author;

import com.nelioalves.cursomc.dtos.AuthorDTO;
import com.nelioalves.cursomc.services.AuthorService;


@RestController
@RequestMapping(value = "author")
@CrossOrigin
public class AuthorResource {
	
  @Autowired
  private AuthorService service;

	@PostMapping
	public ResponseEntity<Author> save(@RequestBody Author object){	
		
		return new ResponseEntity<Author>(service.save(object),HttpStatus.OK);	 
		
		
	}
	
	@GetMapping
	public ResponseEntity<List<AuthorDTO>> get(){				
		
		return new ResponseEntity<List<AuthorDTO>>(service.getDTO(),HttpStatus.OK);			
		
	} 
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Author object) {
    
    /*Author author = service.toAuthor(service.findById(id));

    Author response = service.setData(author);

    for (Book b : object.getBooks()) {
      
      Book book = bookService.findById(b.getId());

      System.out.println("################ " + book.getTitle());

      response.getBooks().add(book); 

    }

    service.update(author);

    service.save(response);
    AuthorDTO dto = service.toDTO(author);
    return new ResponseEntity<AuthorDTO>(dto,HttpStatus.OK); 		*/
    
    return new ResponseEntity<AuthorDTO>(service.update(object),HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AuthorDTO> findyId(@PathVariable Long id) {			
		
		return new ResponseEntity<AuthorDTO>(service.findById(id),HttpStatus.OK);		
  }
  

  
	
	

}
