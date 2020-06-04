package com.nelioalves.cursomc.exception;


import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



@Data
public class ValidationError extends StandardError {


  private  static final long serialVersionUID = 1L;

  private List<FieldMessage> erros = new ArrayList<>();

  public ValidationError(Integer status, String msg, Long timeStamp){

    super(status,msg,timeStamp);

  }


  public void addError(String fieldName, String message){
    erros.add(new FieldMessage(fieldName,message));
  }

  public List<FieldMessage> getErros(){
    return erros;
  }


}
