
package com.nelioalves.cursomc.dtos;

import com.nelioalves.cursomc.domain.Book;


import lombok.Data;

import java.io.Serializable;


/**
 * AuthorDTO
 */

@Data
public class AuthorDTO implements Serializable {

  private Long id;
  private String nome;
  private java.util.List<Book> books;

  public AuthorDTO(){};

}