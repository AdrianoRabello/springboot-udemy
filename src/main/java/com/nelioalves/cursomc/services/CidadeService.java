package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

  @Autowired
  private CidadeRepository repository;


  public Cidade findById(Long id) {

    return repository.findById(id).orElse(null);

  }

  public Cidade save(Cidade object) {

    return repository.save(object);

  }

  public List<Cidade> findAll() {

    return repository.findAll();

  }

  public void delete(Long id) {

    repository.deleteById(id);

  }
}
