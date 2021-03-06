package com.nelioalves.cursomc.dtos;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CredenciaisDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String email;
  private String senha;
}
