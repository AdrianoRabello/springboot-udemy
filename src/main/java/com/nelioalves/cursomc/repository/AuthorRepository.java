package com.nelioalves.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Author;

@Repository
public interface  AuthorRepository extends JpaRepository<Author, Long> {

}
