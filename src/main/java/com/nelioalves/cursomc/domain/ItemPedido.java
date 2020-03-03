package com.nelioalves.cursomc.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity
public class ItemPedido {

  @JsonIgnore
  @EmbeddedId
  private ItemPedidoPK id = new ItemPedidoPK();
  private Double desconto;
  private Integer quantidade;
  private Double preco;


  ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {

    this.id.setPedido(pedido);
    this.id.setProduto(produto);
    this.desconto = desconto;
    this.quantidade = quantidade;
    this.preco = preco;
  }

  @JsonIgnore
  public Pedido getPedido() {
    return id.getPedido();
  }


  public Produto getProduto(){
    return id.getProduto();
  }


}
