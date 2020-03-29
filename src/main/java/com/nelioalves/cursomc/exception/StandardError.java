package com.nelioalves.cursomc.exception;


import lombok.*;

import java.io.Serializable;
@Getter
@Setter

public class StandardError implements Serializable {

  private  static final long serialVersionUID = 1L;


  private Integer status;
  private String msg;
  private Long timeStamp;

  public StandardError(){

  }

  public StandardError(Integer status, String msg, Long timeStamp) {

    this.status = status;
    this.msg = msg;
    this.timeStamp = timeStamp;
  }

  public  void StandardError(Integer status, String msg, Long timeStamp){
    this.status = status;
    this.msg = msg;
    this.timeStamp = timeStamp;
  }

}
