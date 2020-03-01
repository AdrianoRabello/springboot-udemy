package com.nelioalves.cursomc.resouces;

import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

  @Autowired
  private CidadeService service;


  @GetMapping
  public ResponseEntity<?> get() {

    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);

  }

  @GetMapping(value = "{id}")
  public ResponseEntity<?> find(@PathVariable Long id) {
    return new ResponseEntity<>( service.findById(id), HttpStatus.OK);

  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody Cidade object) {

    return new ResponseEntity<>(service.save(object), HttpStatus.CREATED);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Cidade object) {

    return new ResponseEntity<>(service.save(object), HttpStatus.OK);
  }

  @DeleteMapping(value = "{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {

    service.delete(id);
    return new ResponseEntity<HttpStatus>(HttpStatus.OK);

  }
}
