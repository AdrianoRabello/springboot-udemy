package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.repository.EstadoRepostory;
import com.nelioalves.cursomc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

  @Autowired
  private EstadoRepostory repository;


  public Estado findById(Long id) {

    return repository.findById(id).orElse(null);

  }

  public Estado save(Estado object) {

    return repository.save(object);

  }

  public List<Estado> findAll() {

    return repository.findAll();

  }

  public void delete(Long id) {

    repository.deleteById(id);

  }
}
