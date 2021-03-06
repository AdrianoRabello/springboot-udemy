package com.nelioalves.cursomc.exception;

import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){

    StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
    return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(DataIntegrityException.class)
  public ResponseEntity<StandardError> dataIntegreity(DataIntegrityException e, HttpServletRequest request){

    StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }



  @ExceptionHandler(EmptyResultDataAccessException.class)
  public ResponseEntity<StandardError> emptyResultDataException(DataIntegrityException e, HttpServletRequest request){

    StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
    return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){

    ValidationError error = new ValidationError(HttpStatus.NOT_FOUND.value(),"Erro de validação",System.currentTimeMillis());
    for (FieldError x : e.getBindingResult().getFieldErrors()) {
      error.addError(x.getField(),x.getDefaultMessage());
    }
    return ResponseEntity.ok().body(error);
  }


  @ExceptionHandler(AuthorizationException.class)
  public ResponseEntity<StandardError> authorizationException(AuthorizationException e, HttpServletRequest request){

    StandardError error = new StandardError(HttpStatus.FORBIDDEN.value(),e.getMessage(),System.currentTimeMillis());
    return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
  }


}
