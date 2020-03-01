package com.nelioalves.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Book;

@Repository
public interface  BookRepository  extends JpaRepository<Book, Long>{

}
