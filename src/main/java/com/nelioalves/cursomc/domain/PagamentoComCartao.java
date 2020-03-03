package com.nelioalves.cursomc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PagamentoComCartao  extends Pagamento{

  private static final long serialVersionUID = 1L;
  private Integer numeroDeParcelas;
}
