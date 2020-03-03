package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.repository.CidadeRepository;
import com.nelioalves.cursomc.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

  @Autowired
  private PedidoRepository repository;


  public Pedido findById(Long id) {

    return repository.findById(id).orElse(null);

  }

  public Pedido save(Pedido object) {

    return repository.save(object);

  }

  public List<Pedido> findAll() {

    return repository.findAll();

  }

  public void delete(Long id) {

    repository.deleteById(id);

  }
}
