package com.nelioalves.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoCiente {

  PESSOAFISICA(1,"Pessoa física"),
  PESSOAJURIDICA(2,"Pessoda juridica");

  private int cod;
  private String descricao;



  public static TipoCiente toEnum(Integer cod){
    if(cod == null ){
      return null;
    }

    for (TipoCiente tipoCiente:TipoCiente.values()) {
      if(cod.equals(tipoCiente.getCod()))
        return tipoCiente;

    }

    throw  new IllegalArgumentException("id invelido par atipo cliente  " + cod);

  }
}
