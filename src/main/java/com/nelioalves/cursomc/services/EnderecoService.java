package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

  @Autowired
  private EnderecoRepository repository;


  public Endereco findById(Long id) {

    return repository.findById(id).orElse(null);

  }

  public Endereco save(Endereco object) {

    return repository.save(object);

  }

  public List<Endereco> findAll() {

    return repository.findAll();

  }

  public void delete(Long id) {

    repository.deleteById(id);

  }
}
