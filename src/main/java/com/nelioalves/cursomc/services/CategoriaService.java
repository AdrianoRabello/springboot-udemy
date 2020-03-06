package com.nelioalves.cursomc.services;

import java.util.List;
import java.util.Optional;

import com.nelioalves.cursomc.exception.DataIntegrityException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Long id) {

		Optional<Categoria> object = repository.findById(id);

		return object.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado para o id " + id , Categoria.class.getName()));
						
	}	
	
	public Categoria save(Categoria object) {
		
		return repository.save(object);
		
	}

	public List<Categoria> findAll() {
		
		return repository.findAll();
	}

	public void delete(Long id) {

		try {
			repository.deleteById(id);
		}catch (DataIntegrityException e){
			throw  new DataIntegrityException("Não é possivel excluir uma categoria que não tem psodutos");
		}

		
	}
	
		
	
	
}
