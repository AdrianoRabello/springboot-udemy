package com.nelioalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cidade implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;


  @ManyToOne
  @JoinColumn(name = "estado_id")
  private Estado estado;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Cidade)) return false;
    Cidade cidade = (Cidade) o;
    return getId().equals(cidade.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }
}
