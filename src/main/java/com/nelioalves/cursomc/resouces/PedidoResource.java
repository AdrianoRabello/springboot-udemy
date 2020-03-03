package com.nelioalves.cursomc.resouces;

import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

  @Autowired
  private PedidoService service;


  @GetMapping
  public ResponseEntity<?> get() {

    return new ResponseEntity<>(service.findAll(), HttpStatus.OK);

  }

  @GetMapping(value = "{id}")
  public ResponseEntity<?> find(@PathVariable Long id) {
    return new ResponseEntity<>( service.findById(id), HttpStatus.OK);

  }

  @PostMapping
  public ResponseEntity<?> save(@RequestBody Pedido object) {

    System.out.println("teste **************" + object.toString());
    return null;
    //return new ResponseEntity<>(service.save(object), HttpStatus.CREATED);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Pedido object) {

    return new ResponseEntity<>(service.save(object), HttpStatus.OK);
  }

  @DeleteMapping(value = "{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {

    service.delete(id);
    return new ResponseEntity<HttpStatus>(HttpStatus.OK);

  }
}
