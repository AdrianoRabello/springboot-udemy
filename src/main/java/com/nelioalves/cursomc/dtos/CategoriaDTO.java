package com.nelioalves.cursomc.dtos;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private Long id;
  private String nome;
  private boolean ativo;
  private List<Produto> produtos = new ArrayList<>();


  public CategoriaDTO(Categoria obj){

    id = obj.getId();
    nome = obj.getNome();
    ativo = obj.getAtivo();
    produtos = obj.getProdutos();

  }


}
