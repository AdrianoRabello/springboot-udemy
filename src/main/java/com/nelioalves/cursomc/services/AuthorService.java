package com.nelioalves.cursomc.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

import com.nelioalves.cursomc.domain.Author;
import com.nelioalves.cursomc.domain.Book;
import com.nelioalves.cursomc.dtos.AuthorDTO;
import com.nelioalves.cursomc.repository.AuthorRepository;

@Service

@Data
public class AuthorService {

  @Autowired
  private AuthorRepository repository;

  @Autowired
  private BookService bookService;

  private Author author = new Author();

  public Author save(final Author object) {
    return repository.save(object);

  }

  public AuthorDTO findById(final Long id) {

    final Optional<Author> object = repository.findById(id);

    final AuthorDTO dto = this.toDTO(object.orElse(null));
    return dto;
  }

  public List<Author> get() {

    return repository.findAll();
  }






  public AuthorDTO update(Author obj) {

    List<Book> books = new ArrayList<>();

    /* tranformando a lsita de ids em objetos Book */
    for (Book book : obj.getBooks()) {

      Book b = bookService.findById(book.getId());
      books.add(b);
    }

    Optional<Author> authorResponse = this.repository.findById(obj.getId());

    authorResponse.orElse(null);

    for (Book book : authorResponse.get().getBooks()) {

     

        System.out.println("dentro do if " + Arrays.asList(books.contains(book)) );
        //authorResponse.get().getBooks().add(book);
   

      // System.out.println(" nome do livro no service " + book.getTitle());
    }

    Author response = this.repository.save(authorResponse.orElse(null));

    return this.toDTO(response);

  }





  

  /* Metodos auxiliares */

  public List<AuthorDTO> getDTO() {
     List<Author> authors = repository.findAll();

     List<AuthorDTO> dtos = new ArrayList<>();

    for ( Author author : authors) {
      dtos.add(this.toDTO(author));
    }

    return dtos;
  }

  public AuthorDTO toDTO(final Author object) {

    final AuthorDTO dto = new AuthorDTO();

    dto.setNome(object.getNome());
    dto.setId(object.getId());
    dto.setBooks(object.getBooks());

    return dto;
  }

  public Author toAuthor(final AuthorDTO object) {

    final Author author = new Author();

    author.setNome(object.getNome());
    author.setId(object.getId());
    author.setBooks(object.getBooks());

    return author;
  }

  public Author setData(final Author author) {
    this.author.setNome(author.getNome());
    this.author.setBooks(author.getBooks());
    this.author.setId(author.getId());

    return author;
  }

}
