package com.nelioalves.cursomc.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.nelioalves.cursomc.dtos.CategoriaDTO;
import com.nelioalves.cursomc.exception.DataIntegrityException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repository.CategoriaRepository;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository repository;

  public Categoria findById(Long id) {

    Optional<Categoria> object = repository.findById(id);

    return object.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado para o id " + id, Categoria.class.getName()));

  }

  public Categoria save(Categoria object) {

    return repository.save(object);

  }

  public List<CategoriaDTO> findAll() {

    List<Categoria> list = repository.findAll();
    List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
    return listDto;
  }

  public void delete(Long id) {

    this.findById(id);
    repository.deleteById(id);
  }

  public Categoria update(Categoria object) {

    this.findById(object.getId());

    return repository.save(object);
  }


}
	
		
	
	

