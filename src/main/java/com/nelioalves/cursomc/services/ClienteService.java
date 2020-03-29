package com.nelioalves.cursomc.services;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.dtos.ClienteDTO;
import com.nelioalves.cursomc.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
  @Autowired
  private ClienteRepository repository;

  @Autowired
  private BCryptPasswordEncoder bc;


  public Cliente findById(Long id) {

    return repository.findById(id).orElse(null);

  }

  public Cliente save(Cliente object) {

    object.setSenha(bc.encode(object.getSenha()));
    return repository.save(object);

  }

  public List<Cliente> findAll() {

    return repository.findAll();

  }

  public void delete(Long id) {

    repository.deleteById(id);

  }

  public Cliente fromDTO(ClienteDTO dto){

   return new Cliente(null,dto.getNome(),dto.getEmail(),dto.getCpfOuCnpj(),dto.getTipo(),dto.getSenha());
  }
}
