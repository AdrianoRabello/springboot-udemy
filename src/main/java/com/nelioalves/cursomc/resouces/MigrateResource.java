package com.nelioalves.cursomc.resouces;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.dtos.ClienteDTO;
import com.nelioalves.cursomc.services.CategoriaService;
import com.nelioalves.cursomc.services.CidadeService;
import com.nelioalves.cursomc.services.ClienteService;
import com.nelioalves.cursomc.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "migrate")
public class MigrateResource {

  @Autowired
  private EstadoService estadoService;

  @Autowired
  private CidadeService cidadeService;

  @Autowired
  private CategoriaService categoriaService;

  @Autowired
  private ClienteService clienteService;


  @GetMapping(value = "/cidades")
  public ResponseEntity<?> getCidades() {

    return new ResponseEntity<>(cidadeService.findAll(), HttpStatus.OK);
  }


  @GetMapping(value = "/clientes")
  public ResponseEntity<?> getClientes() {

    return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
  }

  @GetMapping(value = "/clientes/{id}")
  public ResponseEntity<?> findClienteById(@PathVariable("id") Long id) {

    return new ResponseEntity<>(clienteService.findById(id), HttpStatus.OK);
  }

  @PostMapping(value = "/clientes")
  public ResponseEntity<?> saveCliente(@RequestBody ClienteDTO obj){
    return ResponseEntity.ok().body(clienteService.save(clienteService.fromDTO(obj)));
  }

  @PatchMapping(value = "/clientes/{id}")
  public ResponseEntity<?> updateCliente(@RequestBody ClienteDTO obj){
    return ResponseEntity.ok().body(clienteService.save(clienteService.fromDTO(obj)));
  }


  @GetMapping(value = "/categorias")
  public ResponseEntity<?> getCategorias() {

    return new ResponseEntity<>(categoriaService.findAll(), HttpStatus.OK);
  }

  @PostMapping(value = "/categorias")
  public ResponseEntity<?> saveCategoira(@Valid @RequestBody Categoria obj) {

    return new ResponseEntity<>(categoriaService.save(obj), HttpStatus.OK);
  }



  @GetMapping(value = "/categorias/page")
  public ResponseEntity<?> getCategoriasPerPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                @RequestParam(value = "linesPerPage", defaultValue = "2") Integer linesPerPage,
                                                @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
                                                @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

    return ResponseEntity.ok().body(categoriaService.findPage(page, linesPerPage, orderBy, direction));
  }


}
