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
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.services.CategoriaService;


import error.ResourceNotFoundException;

@RestController
@RequestMapping(value="/categorias")
@CrossOrigin
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;

		
    @GetMapping
    public ResponseEntity<?> get() {

        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
      return new ResponseEntity<>( service.findById(id), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Categoria object) {

      return new ResponseEntity<>(service.save(object), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Categoria object) {

      return new ResponseEntity<>(service.save(object), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

      service.delete(id);
		  return  ResponseEntity.noContent().build();
	  }
	

}
