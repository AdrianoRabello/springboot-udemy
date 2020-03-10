package com.nelioalves.cursomc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nelioalves.cursomc.exception.DataIntegrityException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

		Optional<Produto> object = repository.findById(id);

		return object.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado para o id " + id, Produto.class.getName()));
	}	
	
	public Produto save(Produto object) {
		
		return repository.save(object);
	}

	public List<Produto> findAll() {
	
		List<Produto> list = repository.findAll();
		return list;
	}

	public void delete(Long id) {
	
		try {

			repository.deleteById(id);
		}catch (EmptyResultDataAccessException e){

			throw new DataIntegrityException("Não é possivel delete o produto com o id "+ id );
		}
		
	}
	
}
