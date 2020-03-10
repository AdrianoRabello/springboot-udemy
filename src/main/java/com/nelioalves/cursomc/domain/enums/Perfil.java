package com.nelioalves.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Perfil {

  ADMIN(1,"ROLE_ADMIN"),
  CLIENTE(2,"ROLE_CLIENTE");



  private int cod;
  private String descricao;



  public static Perfil toEnum(Integer cod){
    if(cod == null ){
      return null;
    }

    for (Perfil estadoPagamento: Perfil.values()) {
      if(cod.equals(estadoPagamento.getCod()))
        return estadoPagamento;

    }

    throw  new IllegalArgumentException("id invelido para o estado pagament " + cod);

  }
}
