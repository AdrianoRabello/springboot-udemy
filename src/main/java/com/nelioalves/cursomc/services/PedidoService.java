package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.exception.AuthorizationException;
import com.nelioalves.cursomc.repository.CidadeRepository;
import com.nelioalves.cursomc.repository.PedidoRepository;
import com.nelioalves.cursomc.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

  @Autowired
  private PedidoRepository repository;

  @Autowired
  private ClienteService clienteService;


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

  public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

    UserSS user = UserService.authenticated();
    if(user == null){

      throw  new AuthorizationException("Acesso negado");
    }

    PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

    Cliente cliente = clienteService.findById(user.getId());

    return repository.findByCliente(cliente,pageRequest);

  }
}
