package com.sd.csgobrasil.infra.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> doNotHaveElementInDatabase(){
        return ResponseEntity.badRequest().body("Invalid Id");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> fieldCanNotBeBlankOrNull(ConstraintViolationException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> sqlDataErrorExecution(DataIntegrityViolationException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


}
