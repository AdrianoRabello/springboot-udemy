package com.nelioalves.cursomc.resouces;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.services.CategoriaService;
import com.nelioalves.cursomc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/estados")
public class EstadoRerosource {

  @Autowired
  private EstadoService service;


  @GetMapping
  public ResponseEntity<?> get() {

    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);

  }

  @GetMapping(value = "{id}")
  public ResponseEntity<?> find(@PathVariable Long id) {
    return new ResponseEntity<>( service.findById(id), HttpStatus.OK);

  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody Estado object) {

    return new ResponseEntity<>(service.save(object), HttpStatus.CREATED);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Estado object) {

    return new ResponseEntity<>(service.save(object), HttpStatus.OK);
  }

  @DeleteMapping(value = "{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {

    service.delete(id);
    return new ResponseEntity<HttpStatus>(HttpStatus.OK);

  }


}
