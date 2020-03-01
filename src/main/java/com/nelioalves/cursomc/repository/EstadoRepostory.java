package com.nelioalves.cursomc.repository;

import com.nelioalves.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepostory extends JpaRepository<Estado,Long> {
}
