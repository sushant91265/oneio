package com.test.oneio.Exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.test.oneio.model.ErrorResponse;

/*
 * CustomExceptionHandler acts as a global exception handler for exceptions thrown by the application and 
 * can be enhanced to handle more exceptions.
 */
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
  @ExceptionHandler(GameException.class)
  protected final ResponseEntity<?> handleGameException(HttpServletRequest request, Throwable ex) {
    return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), 404), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({ Exception.class })
  protected final ResponseEntity<Object> handleAll(HttpServletRequest request, Throwable ex) {
    return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
