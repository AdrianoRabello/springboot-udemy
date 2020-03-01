
package com.nelioalves.cursomc.dtos;

import com.nelioalves.cursomc.domain.Book;


import lombok.Data;


/**
 * AuthorDTO
 */

@Data
public class AuthorDTO {

  private Long id;
  private String nome;
  private java.util.List<Book> books;

  public AuthorDTO(){};

}