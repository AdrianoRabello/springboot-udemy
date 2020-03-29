package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Endereco implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String logradouro;
  private String numero;
  private String complemento;
  private  String bairro;
  private String cep;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @ManyToOne
  @JoinColumn(name = "cidade_id")
  private Cidade cidade;

}
