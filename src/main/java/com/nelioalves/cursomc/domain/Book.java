package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Book implements  Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@ManyToMany
	private List<Author> authors;
	
	public Book() {
		
	}

	public Book(String title, Author author) {
		super();
	
		this.title = title;
		this.authors.add(author);
	} 
	
	
}
