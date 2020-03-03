package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PagamentoComBoleto extends Pagamento {

  private static final long serialVersionUID = 1L;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dataVencimento;

  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date dataPagamento;

}
