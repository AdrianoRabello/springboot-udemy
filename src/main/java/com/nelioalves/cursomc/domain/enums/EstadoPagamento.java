package com.nelioalves.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EstadoPagamento {

  PENDENTE(1,"Pendente"),
  QUITADO(2,"Quitado"),
  CANCELADO(3,"Cancelado");


  private int cod;
  private String descricao;



  public static EstadoPagamento toEnum(Integer cod){
    if(cod == null ){
      return null;
    }

    for (EstadoPagamento estadoPagamento:EstadoPagamento.values()) {
      if(cod.equals(estadoPagamento.getCod()))
        return estadoPagamento;

    }

    throw  new IllegalArgumentException("id invelido para o estado pagament " + cod);

  }
}
