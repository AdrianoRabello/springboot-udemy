package com.nelioalves.cursomc.resouces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
@CrossOrigin
public class ProdutoResource {
	
	@Autowired
	private ProdutoService  service;
		
	@GetMapping
	public ResponseEntity<?> get() {
		
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
				 
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		
		return new ResponseEntity<>( service.findById(id), HttpStatus.OK);
				 
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Produto object){

		return new ResponseEntity<>(service.save(object), HttpStatus.CREATED);
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<?> edit(@PathVariable("id") Long id, @RequestBody Produto object){

		return new ResponseEntity<>(service.save(object), HttpStatus.OK);
	}
	
	
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		service.delete(id);
		
		return new ResponseEntity<>(null, HttpStatus.OK);
				 
	}
	

}
