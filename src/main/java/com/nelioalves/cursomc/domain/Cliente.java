package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nelioalves.cursomc.domain.enums.TipoCiente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cliente implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;
  private String cpfOuCnpj;
  private Integer tipo;

  @OneToMany(mappedBy = "cliente")
  private List<Endereco> enderecos = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "telefone")
  private Set<String> telefones = new HashSet<>();

  @JsonIgnore
  @OneToMany(mappedBy = "cliente")
  private List<Pedido> pedidos = new ArrayList<>();



  public Cliente(Long id, String nome, String email,String cpfOuCnpj, TipoCiente tipo){

    this.id = id;
    this.email = email;
    this.cpfOuCnpj = cpfOuCnpj;
    this.tipo = tipo.getCod();
  }

  public TipoCiente getTipo(){

    return TipoCiente.toEnum(this.tipo);
  }

  public void SetTipo(TipoCiente tipo){
    this.tipo = tipo.getCod();
  }



}
