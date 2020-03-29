package com.nelioalves.cursomc.dtos;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.enums.TipoCiente;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ClienteDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String nome;
  private String email;
  private String cpfOuCnpj;
  private TipoCiente tipo;
  private String senha;

  ClienteDTO(){

  }

  ClienteDTO(Cliente obj){
     id = obj.getId();
     nome = obj.getNome();
     email = obj.getEmail();
     cpfOuCnpj = obj.getCpfOuCnpj();
     tipo = obj.getTipo();
     senha = obj.getSenha();

  }

}
