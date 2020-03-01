package com.nelioalves.cursomc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.domain.Produto;
import com.nelioalves.cursomc.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;

	@Autowired
	private CategoriaService categoriaService;
	
	public Produto findById(Long id) {
		
		Optional<Produto> reponse = this.repository.findById(id);
		
		return reponse.orElse(null);
						
	}	
	
	public Produto save(Produto object) {
		
		return repository.save(object);
		
	}

	public List<Produto> findAll() {
	
		List<Produto> list = repository.findAll();
		
		return list;
		
	}

	public void delete(Long id) {
	
		
		repository.deleteById(id);
		
	}
	
	/*public List<Produto> findByIdCategoria(Categoria id){
		
		return this.repository.findByCategoria(id);
	}*/
	
		
	
	
}
