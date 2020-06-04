package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Produto implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double preco;


	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA",
			   joinColumns = @JoinColumn(name = "produto_id"), 
			   inverseJoinColumns = @JoinColumn(name="categoria_id"))
	private List<Categoria> categorias = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<>();



//	methods

	@JsonIgnore
	public List<Pedido> getPedidos(){

		List<Pedido> lista = new ArrayList<>();
		for (ItemPedido item:itens){
			lista.add(item.getPedido());
		}

		return lista;
	}



	public Produto(String nome, Double preco,Categoria categoria){
		nome = nome;
		categoria = categoria;
		preco = preco;

	}
	
	
	
}
