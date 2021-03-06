package com.nelioalves.cursomc.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class AbstractEntity implements Serializable {
	
	/**
	 * 
	 */



	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;


	
	
}
